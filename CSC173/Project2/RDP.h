#include <stdio.h>
#include <stdlib.h>
#include "Tree.h"

#ifndef RDP_H
#define RDP_H

extern int matchTerminal(char c);
extern void RDP(char* input);
extern int lookahead(char c);

extern Tree E();
extern Tree C();
extern Tree ET();
extern Tree S();
extern Tree CT();
extern Tree A();
extern Tree ST();
extern Tree X();

extern void printTree(Tree root, int depth);

#endif /* RDP_H */

