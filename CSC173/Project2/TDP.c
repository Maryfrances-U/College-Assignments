//This source file contains methods for Table Driven Parsing
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Tree.h"
#include "RDP.h"
#include "TDP.h"
#include "LinkedList.h"


Tree result;
int temp = 0;
int treeable = 1;
char* Productions[13];

char* nextInputCharT;  //String for user's input


int** returnTable()   {
    int ** tt = (int**)calloc(8, sizeof(int*));
    for (int i = 0; i < 8; i++) {
        tt[i] = (int*)calloc(7, sizeof(int));
    }


    //Hardwiring Row <E>
    tt[0][0] = -1;
    tt[0][1] = -1;
    tt[0][2] = -1;
    tt[0][3] = 1;
    tt[0][4] = -1;
    tt[0][5] = 1;
    tt[0][6] = -1;

    //Hardwiring Row <ET>
    tt[1][0] = 2;
    tt[1][1] = 3;
    tt[1][2] = 3;
    tt[1][3] = 3;
    tt[1][4] = 3;
    tt[1][5] = 3;
    tt[1][6] = 3;

    //Hardwiring Row <C>
    tt[2][0] = -1;
    tt[2][1] = -1;
    tt[2][2] = -1;
    tt[2][3] = 4;
    tt[2][4] = -1;
    tt[2][5] = 4;
    tt[2][6] = -1;

    //Hardwiring Row <CT>
    tt[3][0] = 6;
    tt[3][1] = 5;
    tt[3][2] = 6;
    tt[3][3] = 6;
    tt[3][4] = 6;
    tt[3][5] = 6;
    tt[3][6] = 6;

    //Hardwiring Row <S>
    tt[4][0] = -1;
    tt[4][1] = -1;
    tt[4][2] = -1;
    tt[4][3] = 7;
    tt[4][4] = -1;
    tt[4][5] = 7;
    tt[4][6] = -1;

    //Hardwiring Row <ST>
    tt[5][0] = 9;
    tt[5][1] = 9;
    tt[5][2] = 8;
    tt[5][3] = 9;
    tt[5][4] = 9;
    tt[5][5] = 9;
    tt[5][6] = 9;

    //Hardwiring Row <A>
    tt[6][0] = -1;
    tt[6][1] = -1;
    tt[6][2] = -1;
    tt[6][3] = 10;
    tt[6][4] = -1;
    tt[6][5] = 11;
    tt[6][6] = -1;

    //Hardwiring Row <X>
    tt[7][0] = -1;
    tt[7][1] = -1;
    tt[7][2] = -1;
    tt[7][3] = -1;
    tt[7][4] = -1;
    tt[7][5] = 12;
    tt[7][6] = -1;

    return tt;
}


//check if string (or char) is a terminal
int isTerminal(char c)    {
    if (c >= 97 && c <= 122)   {
        return 1;
    }
    switch(c)   {
        case '|':
            return 1;
        case '.':
            return 1;
        case '*':
            return 1;
        case '(':
            return 1;
        case ')':
            return 1;
    }
    return 0;
}



//get the number of the row in the table associated with the production head c
int getHeadRowNumber(char* c) {
    if (strcmp(c,"E") == 0)   {
        return 0;
    }
    else if (strcmp(c, "ET") == 0)  {
        return 1;
    }
    else if (strcmp(c, "C") == 0)  {
        return 2;
    }
    else if (strcmp(c, "CT") == 0)  {
        return 3;
    }
    else if (strcmp(c, "S") == 0)  {
        return 4;
    }
    else if (strcmp(c, "ST") == 0)  {
        return 5;
    }
    else if (strcmp(c, "A") == 0)  {
        return 6;
    }
    else if (strcmp(c, "X") == 0)  {
        return 7;
    }
    else
        return -1;
}


//get the number of the column associated with the current input char
int getInputColNumber(char* c) {

    char focus = c[0];
    switch (focus) {
        case '|':
            return 0;
        case '.':
            return 1;
        case '*':
            return 2;
        case '(':
            return 3;
        case ')':
            return 4;
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            return 5;
        default:
            return 6;
    }

}


//return a string that represent production associated with integer
char* getProduction(int i)    {
    if (i == 1)   {
        return Productions[1];
    }
    else if (i == 2)    {
        return Productions[2];
    }
    else if (i == 3)    {
        return Productions[3];
    }
    else if (i == 4)    {
        return Productions[4];
    }
    else if (i == 5)    {
        return Productions[5];
    }
    else if (i == 6)    {
        return Productions[6];
    }
    else if (i == 7)    {
        return Productions[7];
    }
    else if (i == 8)    {
        return Productions[8];
    }
    else if (i == 9)    {
        return Productions[9];
    }
    else if (i == 10)    {
        return Productions[10];
    }
    else if (i == 11)    {
        return Productions[11];
    }
    else if (i == 12)    {
        return Productions[12];
    }
    else
        return "INVALID";
}


void pushToStack(LinkedList S, LinkedList Snodes, char* toPush)  {
    if (strcmp(toPush, "<C><ET>") == 0)   {
        push(S, "ET");
        push(S, "C");
        result->leftChild = makeNode0("C");
        result->midChild = makeNode0("ET");
        push(Snodes, result->midChild);
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, "|<E>") == 0) {
        push(S, "E");
        push(S, "|");
        result->leftChild = makeNode0("|");
        result->midChild = makeNode0("E");
        push(Snodes, result->midChild);
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, "ep") == 0) {
        push(S, "ep");
        result->leftChild = makeNode0("ep");
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, "<S><CT>") == 0) {
        push(S, "CT");
        push(S, "S");
        result->leftChild = makeNode0("S");
        result->midChild = makeNode0("CT");
        push(Snodes, result->midChild);
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, ".<C>") == 0) {
        push(S, "C");
        push(S, ".");
        result->leftChild = makeNode0(".");
        result->midChild = makeNode0("C");
        push(Snodes, result->midChild);
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, "ep") == 0) {
        push(S, "ep");
        result->leftChild = makeNode0("ep");
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, "<A><ST>") == 0) {
        push(S, "ST");
        push(S, "A");
        result->leftChild = makeNode0("A");
        result->midChild = makeNode0("ST");
        push(Snodes, result->midChild);
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, "*<ST>") == 0) {
        push(S, "ST");
        push(S, "*");
        result->leftChild = makeNode0("*");
        result->midChild = makeNode0("ST");
        push(Snodes, result->midChild);
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, "ep") == 0) {
        push(S, "ep");
        result->leftChild = makeNode0("ep");
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, "(<E>)") == 0) {
        push(S, ")");
        push(S, "E");
        push(S, "(");
        result->leftChild = makeNode0("(");
        result->midChild = makeNode0("E");
        result->rightChild = makeNode0(")");
        push(Snodes, result->rightChild);
        push(Snodes, result->midChild);
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, "<X>") == 0) {
        push(S, "X");
        result->leftChild = makeNode0("X");
        push(Snodes, result->leftChild);
    }
    else if (strcmp(toPush, "a..z") == 0) {
        push(S, nextInputCharT);
        char* sym = (char*) calloc(2, sizeof(char));
        sym[0] = nextInputCharT[0];
        sym[1] = '\0';
        result->leftChild = makeNode0(sym);
        push(Snodes, result->leftChild);
    }
}


Tree TDP(char* input) {
    nextInputCharT = input;

    int **tt = returnTable();


    //adding productions to our array
    Productions[1] = "<C><ET>";
    Productions[2] = "|<E>";
    Productions[3] = "ep";
    Productions[4] = "<S><CT>";
    Productions[5] = ".<C>";
    Productions[6] = "ep";
    Productions[7] = "<A><ST>";
    Productions[8] = "*<ST>";
    Productions[9] = "ep";
    Productions[10] = "(<E>)";
    Productions[11] = "<X>";
    Productions[12] = "a..z";

    //Our end tree is going to be...
    Tree rooty = makeNode0("E");

    //Initialize our Stack
    LinkedList S = new_LinkedList();
    LinkedList Snodes = new_LinkedList(); //of nodes
    push(S, "E");
    push(Snodes, rooty);

    while (!LinkedList_isEmpty(S)) {
        //printf("nextInputCharT is: %s\n", nextInputCharT);

        treeable = 1;

        char *stackTop = pop(S);
        result = pop(Snodes);
        //printf("Parsing tree...\n");
        //printTree(result, 0);


        //if stackTop is epsilon, continue
        if (strcmp(stackTop, "ep") == 0) {
            continue;
        }

        //if stackTop is a terminal, match it
        if (isTerminal(stackTop[0]) == 1) {
            if (stackTop[0] == nextInputCharT[0]) {
                nextInputCharT++;
            } else {
                //printf("Failing\n");
            }
        }

            //else, get production associated with syntactic category and curr input
        else {
            if (tt[getHeadRowNumber(stackTop)][getInputColNumber(nextInputCharT)] == -1) {
                treeable = 0;
                break;
            }
            char *toPush = getProduction(tt[getHeadRowNumber(stackTop)][getInputColNumber(nextInputCharT)]);
            pushToStack(S, Snodes, toPush);
        }

    }

    if (treeable == 1 && *nextInputCharT == '\0') {
        printf("\nOur tree is:\n");
        printTree(rooty, 0);
        printf("\n");
    } else  {
        printf("Your string is invalid.\n");
        return NULL;
    }


    return rooty;
}