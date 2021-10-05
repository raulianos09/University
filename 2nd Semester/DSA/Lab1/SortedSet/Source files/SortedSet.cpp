#include "../Headers/SortedSet.h"
#include "../Headers/SortedSetIterator.h"
#include <exception>
#include <iostream>

//Theta(1)
SortedSet::SortedSet(Relation r) {
	//TODO - Implementation

	this->relation = r;
	this->capacity = 10;
	this->nrElements = 0;
	this->elements = new TComp[this->capacity];
}

//Best Case: Theta(1)
//Worst Case: Theta(nrElements)
//Total Complexity: O(nrElements)
bool SortedSet::add(TComp elem) {
	//TODO - Implementation
    if(this->search(elem))
        return false;

	if(this->nrElements  == capacity)
        this->resize();

	if(this->isEmpty())
        {
            this->elements[0] = elem;
            this->nrElements++;
            return true;
        }
	else {
        int index = 0;
        while (index < this->nrElements && this->relation(this->elements[index], elem))
            index++;

        for (int i = this->nrElements ; i > index; i--)
            this->elements[i] = this->elements[i - 1];
        this->elements[index] = elem;
        this->nrElements++;
    }


/*	for (int i = 0 ; i<this->nrElements;i++)
	    std::cout<< this->elements[i]<<" ";
	std::cout<<"\n";*/
	return true;

}

//Best Case: Theta(1)
//Worst Case: Theta(nrElements)
//Total Complexity: O(nrElements)
bool SortedSet::remove(TComp elem) {
	//TODO - Implementation
    for (int i = 0; i < this->nrElements; i++) {
        if(this->elements[i] == elem) {
            for (int j = i; j < this->nrElements - 1; j++)
                this->elements[j] = this->elements[j + 1];
            this->nrElements--;
            return true;
        }
    }
    return false;
}

//Best Case: Theta(1)
//Worst Case: Theta(nrElements)
//Total Complexity: O(nrElements)
bool SortedSet::search(TComp elem) const {
    //TODO - Implementation
    for(int i = 0 ; i< this->nrElements ; i++)
        if(this->elements[i] == elem)
            return true;
    return false;
}

//Theta(1)
int SortedSet::size() const {
	//TODO - Implementation
    return this->nrElements;
}


//Theta(1)
bool SortedSet::isEmpty() const {
	//TODO - Implementation
	//done
	if(this->nrElements == 0)
        return true;
	return false;
}

//Theta(1)
SortedSetIterator SortedSet::iterator() const {
	return SortedSetIterator(*this);
}

//Theta(1)
SortedSet::~SortedSet() {
	//TODO - Implementation
    delete[] this->elements;
}

//Theta(NrElements)
void SortedSet::resize() {
    this->capacity *= 2;
    auto *NewArray = new TComp [this->capacity];
    for (int i = 0; i < this->nrElements; i++)
        NewArray[i] = this->elements[i];
    delete[] this->elements;
    this->elements = NewArray;
}

//Best Case: Theta(this.size())
//Worst Case: Theta(s.size())
//Total Complexity: O(s.size())
bool SortedSet::isSubsetOf(SortedSet &s) {
    int i = 0;
    int j = 0;
    while( i < this->size() && j < s.size())
    {
        if(this->elements[i] > s.elements[j]){
            j++;
        }
        else
            if(this->elements[i] == s.elements[j])
                i++;
    }
    if(i == this->size())
        return true;
    return false;
}




