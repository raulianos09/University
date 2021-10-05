#include "Headers/Bag.h"
#include "Headers/BagIterator.h"
#include <exception>
#include <iostream>
using namespace std;

//Theta(1)
Bag::Bag() {
    this -> bag = new SLL();
    this -> bag ->head = NULL;
}

//Best case: Theta(1)
//Worst case: Theta(n)
//avg case: O(n)
void Bag::add(TElem elem) {
	if(isEmpty())
    {
	    Node *newNode = new Node();
	    newNode->data = elem;
	    newNode->frequency = 1;
	    newNode->next = NULL;
	    this->bag->head = newNode;
    }
	else
    {
	    Node *currentNode = this->bag->head;
        while (currentNode ->next != NULL)
        {
            if(currentNode->data == elem)
            {
                currentNode->frequency++;
                return;
            }
            currentNode = currentNode->next;
        }
        if(currentNode->data == elem)
        {
            currentNode->frequency++;
            return;
        }
        Node *newNode = new Node();
        newNode->data = elem;
        newNode->frequency = 1;
        newNode->next = NULL;
        currentNode->next = newNode;
    }
}

//Best case: Theta(1)
//Worst case: Theta(n)
//avg case: O(n)
bool Bag::remove(TElem elem) {
    if (isEmpty())
        return false;
    else
    {
        Node *currentNode = this->bag->head;
        Node *previousNode = this->bag->head;
        while( currentNode != NULL && currentNode->data != elem )
        {
            previousNode = currentNode;
            currentNode = currentNode->next;
        }
        if(currentNode == NULL)
            return false;
        else
            if(currentNode->frequency > 1)
            {
                currentNode->frequency--;
                return true;
            }
            else if(currentNode == previousNode)
            {
                this->bag->head = this->bag->head->next;
                delete currentNode;
                return true;
            }
            else
            {
                previousNode->next = currentNode->next;
                delete currentNode;
                return true;
            }
    }
}

//Best case: Theta(1)
//Worst case: Theta(n)
//avg case: O(n)
bool Bag::search(TElem elem) const {
	Node *currentNode = this->bag->head;
    while (currentNode != NULL)
    {
        if(currentNode->data == elem)
            return true;
        currentNode = currentNode->next;
    }
    return false;
}

//Best case: Theta(1)
//Worst case: Theta(n)
//avg case: O(n)
int Bag::nrOccurrences(TElem elem) const {
    Node *currentNode = this->bag->head;
    while (currentNode != NULL)
    {
        if(currentNode->data == elem)
            return currentNode->frequency;
        currentNode = currentNode->next;
    }
    return 0;
}


//Theta(numberOfElements)
int Bag::size() const {
    int size = 0;
    Node *currentNode = this->bag->head;
    while (currentNode != NULL)
    {
        size += currentNode->frequency;
        currentNode = currentNode->next;
    }
    return size;
}

//Theta(1)
bool Bag::isEmpty() const {
    if(this->bag->head == NULL)
        return true;
    return false;
}

//Theta(1)
BagIterator Bag::iterator() const {
	return BagIterator(*this);
}


Bag::~Bag() {
    Node *currentNode = this->bag->head;
    Node *previousNode = currentNode;
    while (currentNode != NULL)
    {
        previousNode = currentNode;
        currentNode = currentNode->next;
        delete previousNode;
    }
    delete currentNode;
    delete this->bag;

}

int Bag::removeAllOccurrences(TElem elem) {
    if (isEmpty())
        return 0;
    else
    {
        Node *currentNode = this->bag->head;
        Node *previousNode = this->bag->head;
        while( currentNode != NULL && currentNode->data != elem )
        {
            previousNode = currentNode;
            currentNode = currentNode->next;
        }
        if(currentNode == NULL)
            return 0;
        else if(currentNode == previousNode)
        {
            this->bag->head = this->bag->head->next;
            int numberOfOccurrences = currentNode->frequency;
            delete currentNode;
            return numberOfOccurrences;
        }
        else
        {
            previousNode->next = currentNode->next;
            int numberOfOccurrences = currentNode->frequency;
            delete currentNode;
            return numberOfOccurrences;
        }
    }

}

