cmake_minimum_required(VERSION 3.17)
project(Bag)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(Bag
        "Source Files/App.cpp"
        "Source Files/Bag.cpp"
        Headers/Bag.h
        "Source Files/BagIterator.cpp"
        Headers/BagIterator.h
        "Source Files/ExtendedTest.cpp"
        Headers/ExtendedTest.h
        "Source Files/ShortTest.cpp"
        Headers/ShortTest.h)
