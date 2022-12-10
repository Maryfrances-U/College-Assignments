#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#ifndef PROJ4_TUPLE_H
#define PROJ4_TUPLE_H


struct Tuple{
    char** attributes;
    int attSize;
};


typedef struct Tuple* TupleInstance;


TupleInstance new_Tuple();
bool matchTuple(TupleInstance pattern, TupleInstance toMatch);

#endif //PROJ4_TUPLE_H
