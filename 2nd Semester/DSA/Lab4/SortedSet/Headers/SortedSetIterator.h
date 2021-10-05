//#pragma once
//#include "SortedSet.h"
//
////DO NOT CHANGE THIS PART

#pragma once
#include "SortedSet.h"

//DO NOT CHANGE THIS PART
class SortedSetIterator
{
    friend class SortedSet;
private:
    SortedSet& multime;
    explicit SortedSetIterator(SortedSet& m);

    TElem currentElement = NULL_TELEM;
    Node** itHashTable;

public:
    void first();
    void next();
    TElem getCurrent() const;
    bool valid() const;
};
