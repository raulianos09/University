cmake_minimum_required(VERSION 3.17)
project(SortedSet)

set(CMAKE_CXX_STANDARD 14)

include_directories(Headers)

add_executable(SortedSet
        Headers/ExtendedTest.h
        Headers/ShortTest.h
        Headers/SortedSet.h
        Headers/SortedSetIterator.h
        "Source Files/ExtendedTest.cpp"
        "Source Files/ShortTest.cpp"
        "Source Files/SortedSet.cpp"
        "Source Files/SortedSetIterator.cpp"
        App.cpp)
