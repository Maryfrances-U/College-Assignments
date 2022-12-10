cmake_minimum_required(VERSION 3.15)
project(Proj4 C)

set(CMAKE_C_STANDARD 99)

include_directories(src)

add_executable(Proj4
        src/HashMap.c
        src/HashMap.h
        src/LinkedList.c
        src/LinkedList.h
        src/main.c
        src/Tuple.c
        src/Tuple.h)
