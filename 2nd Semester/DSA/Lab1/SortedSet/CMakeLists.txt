cmake_minimum_required(VERSION 3.17)
project(SortedSet)

set(CMAKE_CXX_STANDARD 14)

include_directories(Headers)
include_directories("Source files")

add_executable(SortedSet
        Headers/ExtendedTest.h
        Headers/ShortTest.h
        Headers/SortedSet.h
        Headers/SortedSetIterator.h
        "Source files/App.cpp"
        "Source files/ExtendedTest.cpp"
        "Source files/ShortTest.cpp"
        "Source files/SortedSet.cpp"
        "Source files/SortedSetIterator.cpp")
