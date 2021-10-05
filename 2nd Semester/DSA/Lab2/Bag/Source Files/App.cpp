#include "Headers/Bag.h"
#include "Headers/ShortTest.h"
#include "Headers/ExtendedTest.h"
#include <iostream>
#include <ctime>

using namespace std;

int main() {

    time_t currentTime = time(NULL);
	testAll();
	cout << "Short tests over" << endl;
	cout << "The short tests were executed in " << time(NULL) - currentTime << " seconds.\n";

	currentTime = time(NULL);
	testAllExtended();
    cout << "Extended tests over" << endl;
    cout << "The extended tests were executed in " << time(NULL) - currentTime << " seconds.\n";

	cout << "All test over" << endl;
}