#include "Headers/ExtendedTest.h"
#include "Headers/ShortTest.h"

#include "Headers/FixedCapBiMap.h"


#include <iostream>
using namespace std;


int main() {
	testAll();
	testAllExtended();

	cout << "That's all!" << endl;
	system("pause");
	return 0;
}


