# Book Store

## App features:
- visualise the list of all available books from the server
- expand detailed view for each book
- edit a certain book and save the changes
- add a new book and save it

## Book structure:
- id?: string;
- title: string;
- author: string;
- description: string;
- published: Date;
- imageURL: string;

    - All books are fetched from Google Book API using axios
    
## Master view:
- shows a IonList with the images coresponding to each book from the database
- the list is scrollable
- when any of the images is clicked the detail view for that book is shown

## Detail view:
- shows details which can be modified for each book: title, author, description, publishing date
- allows saving the changes for the above mentioned fields
