import React, { useContext } from 'react';
import { RouteComponentProps } from 'react-router';
import {
  IonContent,
  IonFab,
  IonFabButton,
  IonHeader,
  IonIcon,
  IonList, IonLoading,
  IonPage,
  IonTitle,
  IonToolbar
} from '@ionic/react';
import { add } from 'ionicons/icons';
import Book from './Book';
import { getLogger } from '../core';
import { BookContext } from './BookProvider';

const log = getLogger('BookList');

const BookList: React.FC<RouteComponentProps> = ({ history }) => {
  const { books, fetching, fetchingError } = useContext(BookContext);
  log('render');
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Book Store</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent scrollEvents={true}>
        <IonLoading isOpen={fetching} message="Fetching books" />
        {books && (
            <IonList>
              {books.map(({ id, title, author, description, published,imageURL}) =>
                  <Book key={id} id={id} title={title} author={author} description={description} published={published} imageURL={imageURL}
                        onEdit={id => history.push(`/book/${id}`)}/>)}
            </IonList>
        )}
        {fetchingError && (
          <div>{fetchingError.message || 'Failed to fetch books'}</div>
        )}
        <IonFab vertical="bottom" horizontal="end" slot="fixed">
          <IonFabButton onClick={() => history.push('/book')}>
            <IonIcon icon={add} />
          </IonFabButton>
        </IonFab>
      </IonContent>
    </IonPage>
  );
};

export default BookList;
