cmake_minimum_required(VERSION 3.17)
project(FixedCapBiMap)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(FixedCapBiMap
        "Source Files/App.cpp"
        "Source Files/ExtendedTest.cpp"
        Headers/ExtendedTest.h
        "Source Files/FixedCapBiMap.cpp"
        Headers/FixedCapBiMap.h
        "Source Files/FixedCapBiMapIterator.cpp"
        Headers/FixedCapBiMapIterator.h
        "Source Files/ShortTest.cpp"
        Headers/ShortTest.h)
