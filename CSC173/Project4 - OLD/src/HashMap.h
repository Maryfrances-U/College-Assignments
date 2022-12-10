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
bool matchTuple(TupleInstance pattern, TupleInstance toMatch);
LinkedList lookup(Table HashMap, TupleInstance pattern);
void lookup_print(LinkedList Lookup);
void delete(Table HashMap, TupleInstance pattern);
Table Selection(Table table, char** headers, char** selectOnArr, int selectArrSize);
void printTable(Table table);
Table SelectionHelper(Table table, char* header, char* selectOn);
Table Projection(Table table, char** projectOn, int posize);
Table Join (Table t1, Table t2, char* att);
void joinHelper(TupleInstance tu1,TupleInstance tu2, int t2attr, Table returnTable);
Table SelectProjectJoin (Table t1, Table t2, char* attr, char** SelectionHeaders, char** selectOnArray,int selectionNum,char** projectionHeaders,int projectionNum);
#endif //PROJ4_HASHMAP_H