#include "Headers/FixedCapBiMap.h"
#include "Headers/FixedCapBiMapIterator.h"
#include <exception>

using namespace std;

//Theta(1)
FixedCapBiMap::FixedCapBiMap(int capacity) {
	//TODO - Implementation
	//done
	if(capacity <= 0)
        throw exception();
	this->capacity = capacity;
	this->nrElements = 0;
	this->elements = new TElem[capacity];
}

//Theta(1)
FixedCapBiMap::~FixedCapBiMap() {
	//TODO - Implementation
	//done
	delete[] this->elements;
}

//Best Case: Theta(1)
//Worst Case: Theta(nrElements)
//Total Complexity: O(nrElements)
bool FixedCapBiMap::add(TKey c, TValue v){
	//TODO - Implementation
	//done

	if(this->nrElements == capacity)
	    throw exception();

	int index = 0;
	int count = 0;
	while (count < 2 && index < this->nrElements) {
        if (this->elements[index].first == c)
            count++;
        index++;
    }

    if (count == 2)
        return false;
    else {
        this->elements[this->nrElements].first = c;
        this->elements[this->nrElements].second = v;
        this->nrElements++;
        return true;
    }

}

//Best Case: Theta(1)
//Worst Case: Theta(nrElements)
//Total Complexity: O(nrElements)
ValuePair FixedCapBiMap::search(TKey c) const {
    //TODO - Implementation

    ValuePair returnedValue;
    returnedValue.first = NULL_TVALUE;
    returnedValue.second = NULL_TVALUE;

    int count = 0;
    int index = 0;
    while (count < 2 && index < this->nrElements)
    {
        if (this->elements[index].first == c) {
            if(count == 0)
                {
                returnedValue.first = this->elements[index].second;
                }
            else
            {
                returnedValue.second = this->elements[index].second;
            }
            count ++;
        }
        index ++;
    }
    return  returnedValue;
}

//Best Case: Theta(1)
//Worst Case: Theta(nrElements)
//Total Complexity: O(nrElements)
bool FixedCapBiMap::remove(TKey c, TValue v){
	//TODO - Implementation
	//done

	int index = 0;
	bool found = false;
    while ( index < this->nrElements && found == false)
    {
        if(this->elements[index].first == c && this->elements[index].second == v)
            found = true;
        else
            index++;
    }

    if (found == false)
        return false;
    else {
        this->elements[index] = this->elements[this->nrElements - 1];
        this->nrElements--;
        return true;
    }
}

//Theta(1)
int FixedCapBiMap::size() const {
	//TODO - Implementation
	//done
    return  this->nrElements;
}

//Theta(1)
bool FixedCapBiMap::isEmpty() const{
	//TODO - Implementation
	//done
	if(this->nrElements == 0)
        return true;
	else
        return false;
}

//Theta(1)
bool FixedCapBiMap::isFull() const {
	//TODO - Implementation
	//done

	if(this->nrElements == this->capacity)
	    return true;
	else
        return false;
}

//Best Case: Theta(1)
//Worst Case: Theta(nrElements)
//Total Complexity: O(nrElements)
ValuePair FixedCapBiMap::removeKey(TKey k)
{
    ValuePair returnedValue;
    returnedValue.first = NULL_TVALUE;
    returnedValue.second = NULL_TVALUE;

    int index = 0;
    int count = 0;
    while ( index < this->nrElements && count < 2)
    {
        if(this->elements[index].first == k )
        {
            if(count == 0)
            {
                returnedValue.first = this->elements[index].second;
            }
            else
            {
                returnedValue.second = this->elements[index].second;
            }
            count++;
            this->elements[index] = this->elements[this->nrElements - 1];
            this->nrElements--;
        }
        else
            index++;
    }
    return returnedValue;
}

//Theta(1)
FixedCapBiMapIterator FixedCapBiMap::iterator() const {
	return FixedCapBiMapIterator(*this);
}



