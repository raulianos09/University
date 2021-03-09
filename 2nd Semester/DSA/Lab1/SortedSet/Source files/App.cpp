#include "../Headers/ShortTest.h"
#include "../Headers/ExtendedTest.h"
#include "../Headers/SortedSet.h"
#include "../Headers/SortedSetIterator.h"
#include <iostream>

using namespace std;

int main() {
	testAll();
	testAllExtended();

	cout << "Test end" << endl;
	system("pause");
}