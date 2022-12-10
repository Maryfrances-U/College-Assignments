#include <stdio.h>
#include <stdlib.h>
#include "Tree.h"
#include "LinkedList.h"

#ifndef TDP_H
#define TDP_H


extern int matchTerminal(char c);
extern int isTerminal(char c);
extern int getHeadRowNumber(char* c);
int getInputColNumber(char* c);
extern char* getProduction(int i);
extern void pushToStack(LinkedList S, LinkedList Snodes, char* toPush);
//extern void pushToStack(LinkedList S, char* toPush);

extern Tree TDP(char* input);


#endif /* TDP_H */

