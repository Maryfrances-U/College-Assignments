#include <stdlib.h>
#include <stdio.h>
#include "Tree.h"


//make node with no children
Tree makeNode0(char* x){
    Tree root;
    root = (Tree) malloc(sizeof (struct Node));
    
    root->label = (char*) malloc (3 * sizeof(char));
    root->label = x;
    
    root->leftChild = NULL;
    root->midChild = NULL;
    root->rightChild = NULL;
    return root;
}

//make node with one child
Tree makeNode1(char * x, Tree t){
    Tree root;
    root = makeNode0(x);
    
    root->label = (char*) malloc (2 * sizeof(char));
    root->label = x;
    
    root->leftChild = t;
    
    return root;
}

//make node with two children
Tree makeNode2(char * x, Tree t1, Tree t2){
    Tree root;
    root = makeNode1(x, t1);
    
    root->label = (char*) malloc (2 * sizeof(char));
    root->label = x;
             
    root->leftChild = t1;
    root->midChild = t2;
    
    return root;
}

//make node with three children
Tree makeNode3(char * x, Tree t1, Tree t2, Tree t3){
    Tree root;
    root = makeNode1(x, t1);
    
    root->label = (char*) malloc (2 * sizeof(char));
    root->label = x;
    
    root->leftChild = t1;
    root->midChild = t2;
    root->rightChild = t3;
    
    return root;
}

