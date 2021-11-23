const Koa = require('koa');
const app = new Koa();
const server = require('http').createServer(app.callback());
const WebSocket = require('ws');
const wss = new WebSocket.Server({server});
const Router = require('koa-router');
const cors = require('koa-cors');
const bodyparser = require('koa-bodyparser');

app.use(bodyparser());
app.use(cors());
app.use(async (ctx, next) => {
    const start = new Date();
    await next();
    const ms = new Date() - start;
    console.log(`${ctx.method} ${ctx.url} ${ctx.response.status} - ${ms}ms`);
});

app.use(async (ctx, next) => {
    await new Promise(resolve => setTimeout(resolve, 2000));
    await next();
});

app.use(async (ctx, next) => {
    try {
        await next();
    } catch (err) {
        ctx.response.body = {issue: [{error: err.message || 'Unexpected error'}]};
        ctx.response.status = 500;
    }
});

class Book {
    constructor({id, title, author, description, published, imageURL}) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.published = published;
        this.imageURL = imageURL;
    }
}

const books = [];

var axios = require("axios").default;
var options = {
    method: 'GET',
    url: 'https://google-books.p.rapidapi.com/volumes',
    params: {key: 'AIzaSyAOsteuaW5ifVvA_RkLXh0mYs6GLAD6ykc'},
    headers: {
        'x-rapidapi-host': 'google-books.p.rapidapi.com',
        'x-rapidapi-key': '47937a1e6cmsh4e29f4ee3741a66p1a7456jsnc5da209788a1'
    }
};
let lastUpdated = new Date();
let lastId = 0;
axios.request(options).then(function (response) {
    const numberOfItems = response.data.items.length;
    for (let i = 0; i < numberOfItems; i++) {
        let title = response.data.items[i].volumeInfo.title;
        let author = response.data.items[i].volumeInfo.authors;
        let description = response.data.items[i].volumeInfo.description;
        let publishingDate = response.data.items[i].volumeInfo.publishedDate;
        let imageURL = response.data.items[i].volumeInfo.imageLinks.thumbnail;
        if (title && author && description && publishingDate && imageURL) {
            books.push(new Book({
                id: `${i}`,
                title: `${title}`,
                author: `${author}`,
                description: `${description}`,
                published: `${publishingDate}`,
                imageURL: `${imageURL}`
            }));
            lastId = lastId + 1;
        }
    }
    console.log("Data fetched")
}).catch(function (error) {
    console.error(error);
});


const broadcast = data =>
    wss.clients.forEach(client => {
        if (client.readyState === WebSocket.OPEN) {
            client.send(JSON.stringify(data));
        }
    });

const router = new Router();

router.get('/book', ctx => {
    const ifModifiedSince = ctx.request.get('If-Modified-Since');
    if (ifModifiedSince && new Date(ifModifiedSince).getTime() >= lastUpdated.getTime() - lastUpdated.getMilliseconds()) {
        ctx.response.status = 304; // NOT MODIFIED
        return;
    }
    ctx.response.set('Last-Modified', lastUpdated.toUTCString());
    ctx.response.body = books;
    ctx.response.status = 200;
});

router.get('/book/:id', async (ctx) => {
    const bookId = ctx.request.params.id;
    const book = books.find(book => bookId === book.id);
    if (book) {
        ctx.response.body = book;
        ctx.response.status = 200; // ok
    } else {
        ctx.response.body = {issue: [{warning: `book with id ${bookId} not found`}]};
        ctx.response.status = 404; // NOT FOUND (if you know the resource was deleted, then return 410 GONE)
    }
});

const createBook = async (ctx) => {
    const book = ctx.request.body;
    if (!book.title) { // validation
        ctx.response.body = {issue: [{error: 'Text is missing'}]};
        ctx.response.status = 400; //  BAD REQUEST
        return;
    }
    book.id = `${parseInt(lastId) + 1}`;
    lastId = book.id;
    book.published = new Date();
    books.push(book);
    ctx.response.body = book;
    ctx.response.status = 201; // CREATED
    broadcast({event: 'created', payload: {book}});
};

router.post('/book', async (ctx) => {
    await createBook(ctx);
});

router.put('/book/:id', async (ctx) => {
    const id = ctx.params.id;
    const book = ctx.request.body;
    const bookId = book.id;
    if (bookId && id !== book.id) {
        ctx.response.body = {issue: [{error: `Param id and book id should be the same`}]};
        ctx.response.status = 400; // BAD REQUEST
        return;
    }
    if (!bookId) {
        await createBook(ctx);
        return;
    }
    const index = books.findIndex(book => book.id === id);
    if (index === -1) {
        ctx.response.body = {issue: [{error: `book with id ${id} not found`}]};
        ctx.response.status = 400; // BAD REQUEST
        return;
    }
    books[index] = book;
    lastUpdated = new Date();
    ctx.response.body = book;
    ctx.response.status = 200; // OK
    broadcast({event: 'updated', payload: {book}});
});

setInterval(() => {
    lastUpdated = new Date();
    lastId = `${parseInt(lastId) + 1}`;
    //const book = new Book({ id: lastId, title: `Book ${lastId}`, author: `Author ${lastId}`, description: `Description ${lastId}`, published: lastUpdated });
    //books.push(book);
    //console.log(`${book.title}`);
    //broadcast({ event: 'created', payload: { book }});
}, 15000);

app.use(router.routes());
app.use(router.allowedMethods());

server.listen(3000);