#ifndef TREE_H

#define FAILED NULL

#define TREE_H


struct Node {
    char* label;
    struct Node* leftChild;
    struct Node* midChild;
    struct Node* rightChild;
};

typedef struct Node* Tree;

extern Tree makeNode0(char* x);
extern Tree makeNode1(char * x, Tree t);
extern Tree makeNode2(char * x, Tree t1, Tree t2);
extern Tree makeNode3(char * x, Tree t1, Tree t2, Tree t3);


#endif /* TREE_H */

