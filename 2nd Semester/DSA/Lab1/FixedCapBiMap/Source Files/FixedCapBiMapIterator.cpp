#include "Headers/FixedCapBiMap.h"
#include "Headers/FixedCapBiMapIterator.h"
#include <exception>
using namespace std;

//Theta(1)
FixedCapBiMapIterator::FixedCapBiMapIterator(const FixedCapBiMap& d) : map(d)
{
	//TODO - Implementation
	//done
	this->current = 0;
}


//Theta (1)
void FixedCapBiMapIterator::first() {
	//TODO - Implementation
	//done
	this->current = 0;
}

//Theta(1)
void FixedCapBiMapIterator::next() {
	//TODO - Implementation
    //done
    if( !this->valid() )
        throw exception();
    else
        this->current++;
}

//Theta(1)
TElem FixedCapBiMapIterator::getCurrent(){
	//TODO - Implementation
	//done
	if( !this->valid())
	    throw exception();
	else
        return this->map.elements[this->current];
}

//Theta(1)
bool FixedCapBiMapIterator::valid() const {
	//TODO - Implementation
	//done

	if(this->current < this->map.nrElements)
        return true;
    return false;
}



