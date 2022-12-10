#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "Tuple.h"


//constructor
TupleInstance new_Tuple() {
    TupleInstance this = (TupleInstance) calloc(1, sizeof(struct Tuple));
    return this;
}


bool matchTuple(TupleInstance pattern, TupleInstance toMatch){
    for (int i = 0; i < pattern->attSize; i++){
        if ( strcmp(pattern->attributes[i], "*") != 0)   {
            if ( strcmp(pattern->attributes[i], toMatch->attributes[i]) != 0){
                return false;
            }
        }
    }
    return true;
}
