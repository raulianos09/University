cmake_minimum_required(VERSION 3.17)
project(SortedBag)

set(CMAKE_CXX_STANDARD 14)

include_directories(Headers)

add_executable(SortedBag
        Headers/ExtendedTest.h
        Headers/ShortTest.h
        Headers/SortedBag.h
        Headers/SortedBagIterator.h
        "Source Files/ExtendedTest.cpp"
        "Source Files/ShortTest.cpp"
        "Source Files/SortedBag.cpp"
        "Source Files/SortedBagIterator.cpp"
        App.cpp)
