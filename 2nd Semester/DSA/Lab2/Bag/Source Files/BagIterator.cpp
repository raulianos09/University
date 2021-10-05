#include <exception>
#include "Headers/BagIterator.h"
#include "Headers/Bag.h"

using namespace std;

//Theta(1)
BagIterator::BagIterator(const Bag& c): bag(c)
{
    this->currentNode = c.bag->head;
    this->frequency = 1;
}

//Theta(1)
void BagIterator::first() {
    this->currentNode = bag.bag->head;
    this->frequency = 1;
}

//Theta(1)
void BagIterator::next() {
	if(!valid())
	    throw exception();
	if(this->frequency < this->currentNode->frequency)
    {
	    this->frequency ++;
        return;
    }
	this->currentNode = this->currentNode->next;
	this->frequency = 1;
}

//Theta(1)
bool BagIterator::valid() const {
    if(currentNode == NULL)
        return false;
    return true;
}


//Theta(1)
TElem BagIterator::getCurrent() const
{
    if(valid())
        return currentNode->data;
    throw exception();
}
