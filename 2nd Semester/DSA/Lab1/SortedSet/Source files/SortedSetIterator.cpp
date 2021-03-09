#include "../Headers/SortedSetIterator.h"
#include <exception>

using namespace std;

//Theta(1)
SortedSetIterator::SortedSetIterator(const SortedSet& m) : multime(m)
{
	//TODO - Implementation
	this->index = 0;
}

//Theta(1)
void SortedSetIterator::first() {
	//TODO - Implementation
	this->index = 0;
}

//Theta(1)
void SortedSetIterator::next() {
	//TODO - Implementation
	if(!this->valid())
        throw exception();
	index ++;
}

//Theta(1)
TElem SortedSetIterator::getCurrent()
{
	//TODO - Implementation
	if(!this->valid())
        throw exception();
    return this->multime.elements[index];
}

//Theta(1)
bool SortedSetIterator::valid() const {
	//TODO - Implementation
	if(this->index < this->multime.nrElements)
        return true;
    return false;
}

