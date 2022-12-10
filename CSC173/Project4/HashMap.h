#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "LinkedList.h"

#ifndef PROJ4_HASHMAP_H
#define PROJ4_HASHMAP_H


struct Relation{
    //Headers, with/size, keyArray, array of Tupples (linked lists with tupples)
    char** headers;
    int* keyArray;
    int keyArraySize;
    int width;
    LinkedList* Tuples; //every table has an array of linked lists
};


typedef struct Relation* Table;


Table new_Table();
char** callocedAtt(int n);
void addAttributes(TupleInstance t, char** strings, int attSize);
void populateCSG(Table CSGHash,int csgAttSize);
void populateSNAP(Table SNAPHash,int snapAttSize);
void populateCP(Table CPHash, int CPAttSize);
void populateCDH(Table CDHHash,int CDHAttSize);
void populateCR(Table CRHash,int CRAttSize);
int hashingFunction(Table HashMap, TupleInstance tuple);
void insert(Table HashMap, TupleInstance tuple);
void insertHelper(int finalKey, Table HashMap,  TupleInstance tuple);
bool matchTuple(TupleInstance pattern, TupleInstance toMatch);
LinkedList lookup(Table HashMap, TupleInstance pattern);
void lookup_print(LinkedList Lookup);
void delete(Table HashMap, TupleInstance pattern);
Table Selection(Table table, char** headers, char** selectOnArr, int selectArrSize);
void printSelection(Table table);
Table SelectionHelper(Table table, char* header, char* selectOn);

#endif //PROJ4_HASHMAP_H
