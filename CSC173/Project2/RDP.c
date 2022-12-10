//This source file contains methods for Recursive Descent Parsing
#include <stdio.h>
#include <stdlib.h>
#include "Tree.h"
#include "RDP.h"


char* nextInputChar;

int matchTerminal(char c) {
    if (*nextInputChar == c) {
        nextInputChar++;
        return 1;
    } else {
        return 0;
    }
}


void RDP(char* input){
    nextInputChar = input;
    Tree res = E();
    // is nextInputChar fully consumed?
    if (*nextInputChar != '\0') {
        printf("Invalid string.\n");
    }
    else {
        printTree(res, 0);
    }
}

int lookahead(char c) {
    return *nextInputChar == c;
}


//E for expression
Tree E()    {
    Tree c;
    Tree et;
    
    c = C();
    et = ET();
    
    if (c == FAILED || et == FAILED)   {
        return FAILED;
    }
    
    return makeNode2("E", c, et);
}


//C for concatenation
Tree C()  {
    Tree s;
    Tree ct;
    
    s = S();
    ct = CT();
    
    if (s == FAILED || ct == FAILED)   {
        return FAILED;
    }
    
    return makeNode2("C", s, ct);
}


//ET for Expression Tail
//<ET>-> |<E> | ep
Tree ET()  {
    if (lookahead('|'))   {
        matchTerminal('|');
        
        Tree e = E();
        if (e == FAILED)   {
            return FAILED;
        }
        return makeNode2("ET", makeNode0("|"), e);
    }
    else
        return makeNode1("ET", makeNode0("ep"));
}


//S is for star(closure)
Tree S()  {
    Tree a;
    Tree st;
    
    a = A();
    st = ST();
    
    if (a == FAILED || st == FAILED)   {
        return FAILED;
    }
    
    return makeNode2("S", a, st);
}


//CT for Concatenation Tail
Tree CT(){
    if (lookahead('.'))   {
        matchTerminal('.');
        
        Tree c = C();
        if (c == FAILED)   {
            return FAILED;
        }
        return makeNode2("CT", makeNode0("."), c);
    }
    else
        return makeNode1("CT", makeNode0("ep"));
    
}


//A for Atomic Expression
Tree A(){
    //<A> -> (<E>)|<X>
    if (lookahead('('))   {
        matchTerminal('(');
        
        Tree e = E();
        if (e == FAILED)   {
            return FAILED;
        }
        
        if(lookahead(')'))    {
            matchTerminal(')');
        }
        else    {
            return FAILED;
        }
        
        return makeNode3("A", makeNode0("("), e, makeNode0(")"));
    }
    
    else    {
        Tree x = X();
        if (x == FAILED)   {
            return FAILED;
        }
        else
            return makeNode1("A", x);
    }
    
    return FAILED; 
}


//ST for Star Tail
Tree ST(){
    if (lookahead('*'))   {
        matchTerminal('*');
        
        Tree st = ST();
        if (st == FAILED)   {
            return FAILED;
        }
        return makeNode2("ST", makeNode0("*"), st);
    }
    else
        return makeNode1("ST", makeNode0("ep"));
}


//X for input symbol
//<X> -> a|b|...|z
Tree X(){
    //a to z in ASCII is 97(a) to 122(z)
    for (int i = 97; i <= 122; i++)  {
        if (lookahead((char)i))   {
            matchTerminal((char)i);
            char* sym = (char*) calloc(2, sizeof(char));
            sym[0] = (char)i;
            sym[1] = '\0';
            return makeNode1("X", makeNode0(sym));
        }
    }
    return FAILED;
    
}


void printTree(Tree root, int depth)    {
    if (root != NULL)   {
        //printf("Depth: %d", depth);
        for (int i = 0; i < depth; i++) {
            printf("\t");
        }
        printf("%s", root->label);
        printf("\n");

        if (root->leftChild != NULL)   {
            printTree(root->leftChild, depth+1);
        }

        if (root->midChild != NULL)   {
            printTree(root->midChild, depth+1);
        }

        if (root->rightChild != NULL)   {
            printTree(root->rightChild, depth+1);
        }
    }
    else
        printf("Invalid input.\n");
}

