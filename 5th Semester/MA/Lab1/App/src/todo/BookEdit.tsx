import React, {useContext, useEffect, useState} from 'react';
import {
    IonButton,
    IonButtons,
    IonContent, IonDatetime,
    IonHeader,
    IonInput, IonItem, IonLabel,
    IonLoading,
    IonPage, IonTextarea,
    IonTitle,
    IonToolbar
} from '@ionic/react';
import {getLogger} from '../core';
import {BookContext} from './BookProvider';
import {RouteComponentProps} from 'react-router';
import {BookProps} from './BookProps';

const log = getLogger('Book');

interface BookEditProps extends RouteComponentProps<{
    id?: string;
}> {
}

const Book: React.FC<BookEditProps> = ({history, match}) => {
    const {books, saving, savingError, saveBook} = useContext(BookContext);
    const [title, setTitle] = useState<string>('');
    const [author, setAuthor] = useState<string>('');
    const [description, setDescription] = useState<string>('');
    const [imageURL, setImageURL] = useState<string>('');
    const [published, setPublished] = useState<Date>(new Date());
    const [book, setBook] = useState<BookProps>();

    useEffect(() => {
        const routeId = match.params.id || 0;
        const book = books?.find(it => it.id === routeId);
        setBook(book);
        if (book) {
            setTitle(book.title);
            setAuthor(book.author);
            setDescription(book.description);
            setPublished(book.published);
            setImageURL(book.imageURL);
        }
    }, [match.params.id, books]);


    const handleSave = () => {
        const editedBook = book ? {
            ...book,
            title,
            author,
            description,
            published,
            imageURL
        } : {title, author, description, published,imageURL};
        saveBook && saveBook(editedBook).then(() => history.goBack());
    };
    log('render');
    return (
        <IonPage>
            <IonHeader>
                <IonToolbar>
                    <IonTitle>Edit Book</IonTitle>
                    <IonButtons slot="end">
                        <IonButton onClick={handleSave}>
                            Save
                        </IonButton>
                    </IonButtons>
                </IonToolbar>
            </IonHeader>
            <IonContent>
                    <IonItem>
                        <IonLabel>Title: </IonLabel>
                        <IonInput value={title} onIonChange={e => setTitle(e.detail.value || '')}/>
                    </IonItem>

                    <IonItem>
                        <IonLabel>Author: </IonLabel>
                        <IonInput value={author} onIonChange={e => setAuthor(e.detail.value || '')}/>
                    </IonItem>

                    <IonItem >
                        <IonLabel>Description: </IonLabel>
                        <IonTextarea rows={10} value={description} onIonChange={e => setDescription(e.detail.value || '')}/>
                    </IonItem>

                    <IonItem>
                        <IonLabel>Publishing date:
                        <IonDatetime displayFormat={"DD-MM-YYYY"} value={published.toLocaleString()}
                                     onIonChange={e => setPublished(new Date(e.detail.value || new Date()))}/>
                        </IonLabel>
                    </IonItem>
                <IonLoading isOpen={saving}/>
                {savingError && (
                    <div>{savingError.message || 'Failed to save book !'}</div>
                )}
            </IonContent>
        </IonPage>
    );
};

export default Book;
