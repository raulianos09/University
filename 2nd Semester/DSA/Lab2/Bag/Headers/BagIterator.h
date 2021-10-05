#include "Bag.h"

class BagIterator
{
	//DO NOT CHANGE THIS PART
	friend class Bag;
	
private:
	const Bag& bag;
	Node * currentNode;
	int frequency = 1;

	BagIterator(const Bag& c);

public:
	void first();
	void next();
	TElem getCurrent() const;
	bool valid() const;
};
