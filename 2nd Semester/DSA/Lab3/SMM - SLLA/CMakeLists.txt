cmake_minimum_required(VERSION 3.17)
project(SMM___SLLA)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)
include_directories(Headers)
include_directories("Source Files")

add_executable(SMM___SLLA
        Headers/ExtendedTest.h
        Headers/ShortTest.h
        Headers/SMMIterator.h
        Headers/SortedMultiMap.h
        "Source Files/ExtendedTest.cpp"
        "Source Files/ShortTest.cpp"
        "Source Files/SMMIterator.cpp"
        "Source Files/SortedMultiMap.cpp"
        App.cpp "Source Files/ValueIterator.cpp" "Headers/ValueIterator.h")
