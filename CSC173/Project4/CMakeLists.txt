cmake_minimum_required(VERSION 3.15)
project(Project4 C)

set(CMAKE_C_STANDARD 99)

add_executable(Project4 main.c HashMap.c Tuple.c LinkedList.c LinkedList.h Tuple.h HashMap.h)