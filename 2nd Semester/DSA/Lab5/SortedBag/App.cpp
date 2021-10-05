#include "Headers/SortedBag.h"
#include "Headers/SortedBagIterator.h"
#include <iostream>
#include "Headers/ShortTest.h"
#include "Headers/ExtendedTest.h"

using namespace std;

int main() {
	testAll();
	testAllExtended();
	
	cout << "Test over" << endl;
	system("pause");
}
