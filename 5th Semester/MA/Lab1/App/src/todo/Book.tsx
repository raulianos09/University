import React from 'react';
import { IonItem} from '@ionic/react';
import {BookProps} from './BookProps';

interface BookPropsExt extends BookProps {
    onEdit: (id?: string) => void;
}

const Book: React.FC<BookPropsExt> = ({id, imageURL, onEdit}) => {
    return (
        <IonItem onClick={() => onEdit(id)}>
                <img src ={imageURL} width={"300px"} height={"300px"}/>
        </IonItem>
    );
};

export default Book;
