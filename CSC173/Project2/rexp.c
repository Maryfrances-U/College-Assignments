#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "Tree.h"
#include "RDP.h"
#include "TDP.h"


void startExplore(Tree rooty);
char* explore(Tree rooty);


void startExplore(Tree rooty) {
    char* exp = explore(rooty);
    printf("%s", exp);
    free(exp);
}


char* explore(Tree rooty) {
    char* subsection = malloc(sizeof(char));
    subsection[0] = '\0';
    int join = 0;

    //call explore recursively on all children
    if(rooty->leftChild != NULL)    {
        Tree lchild = rooty->leftChild;
        char* result = explore(lchild);

        //if the child returns a string, then we do something
        if(strlen(result) >= 1)
            join++;

        //now we change the size of our string so concatenation can happen
        int new_size = strlen(subsection) + strlen(result) + 1;
        subsection = realloc(subsection, new_size * sizeof(char*));

        strcat(subsection, result);
        free(result);
    }

    if(rooty->midChild != NULL)    {
        Tree child = rooty->midChild;
        char* result = explore(child);

        //if the child returns a string, then we do something
        if(strlen(result) >= 1)
            join++;

        //now we change the size of our string so concatenation can happen
        int new_size = strlen(subsection) + strlen(result) + 1;
        subsection = realloc(subsection, new_size * sizeof(char*));

        strcat(subsection, result);
        free(result);
    }

    if(rooty->rightChild != NULL)    {
        Tree child = rooty->rightChild;
        char* result = explore(child);

        //if the child returns a string, then we do something
        if(strlen(result) >= 1)
            join++;

        //now we change the size of our string so concatenation can happen
        int new_size = strlen(subsection) + strlen(result) + 1;
        subsection = realloc(subsection, new_size * sizeof(char*));

        strcat(subsection, result);
        free(result);
    }


    //this handles the operations
    //concatenation only happens on C and union only on E OR
    //closure on S: if the mid child of the current node's midchild exists
    if( ( (strcmp((rooty->label), "C") == 0 || strcmp((rooty->label), "E") == 0) && join > 1)
     ||
     (strcmp((rooty->label), "S") == 0 && (rooty->midChild)->midChild != NULL) )    {
        //make space for more letters
        int size = strlen(subsection);
        int diff = 0;

        switch(rooty->label[0])    {
            case 'C':
                size = size + 10;
                diff = 8;
                break;
            case 'E':
                size = size + 9;
                diff = 7;
                break;
            case 'S':
                size = size + 11;
                diff = 9;
                break;
            default:
                break;
        }

        subsection = realloc(subsection, size * sizeof(char*));
        for(int i = size-3; i >= diff; i--)   {
            subsection[i] = subsection[i-diff];
        }

        subsection[0] = '(';
        subsection[size - 1] = '\0';
        subsection[size-2] = ')';

        switch(rooty->label[0])    {
            case 'C':
                subsection[1] = 'C';
                subsection[2] = 'O';
                subsection[3] = 'N';
                subsection[4] = 'C';
                subsection[5] = 'A';
                subsection[6] = 'T';
                subsection[7] = ' ';
                break;
            case 'E':
                subsection[1] = 'U';
                subsection[2] = 'N';
                subsection[3] = 'I';
                subsection[4] = 'O';
                subsection[5] = 'N';
                subsection[6] = ' ';
                break;
            case 'S':
                subsection[1] = 'C';
                subsection[2] = 'L';
                subsection[3] = 'O';
                subsection[4] = 'S';
                subsection[5] = 'U';
                subsection[6] = 'R';
                subsection[7] = 'E';
                subsection[8] = ' ';
                break;
            default:
                break;
        }

    }//end of complicated if statement


    //now to handle base cases
    if(rooty->label[0] >= 'a' && rooty->label[0] <= 'z'){
        if(!(strcmp(rooty->label, "ep") == 0))    {
            subsection = realloc(subsection, 11* sizeof(char*));

            subsection[0] = '(';
            subsection[1] = 'A';
            subsection[2] = 'T';
            subsection[3] = 'O';
            subsection[4] = 'M';
            subsection[5] = 'I';
            subsection[6] = 'C';
            subsection[7] = ' ';
            subsection[8] = rooty->label[0];
            subsection[9] = ')';
            subsection[10] = '\0';
        }
    }



    return subsection;
}//end of explore




int main(int argc, char** argv) {
    printf("We will now parse regular expressions using Recursive Descent Parsing.\n\n");
    
    int i = 0;
    char input[200];
    unsigned int inputlen;
    printf("\nEnter a regular expression (\"quit\" to quit): ");
    fgets(input, 200, stdin);
    while(i == 0) {
        //in case they type quit right away
        if(strcmp(input, "quit\n")==0) {break;}
        
        //Get rid of that pesky new line
        inputlen = strlen(input);
        input[--inputlen] = '\0';
        
        //processing
        RDP(input);
        
        //Now do it again
        printf("Enter a regular expression ('quit' to quit): ");
        fgets(input, 200, stdin);
        if(strcmp(input, "quit\n")==0) {break;}
    }
    
    printf("\n\nWe will now parse regular expressions using Table Driven Parsing.\n\n");
    
    int j = 0;
    char input2[200];
    unsigned int inputlen2;
    printf("\nEnter a regular expression (\"quit\" to quit): ");
    fgets(input2, 200, stdin);
    while(j == 0) {
        //in case they type quit right away
        if(strcmp(input2, "quit\n")==0) {break;}
        
        //Get rid of that pesky new line
        inputlen2 = strlen(input2);
        input2[--inputlen2] = '\0';
        
        //processing
        TDP(input2);
        
        //Now do it again
        printf("Enter a regular expression ('quit' to quit): ");
        fgets(input2, 200, stdin);
        if(strcmp(input2, "quit\n")==0) {break;}
    }


    printf("\n\nWe will now parse regular expressions using TDP again.");
    printf("\nThis time, we will also print out the expression string (Part 3 of this project) after printing the tree. \n\n");

    int k = 0;
    char input3[200];
    unsigned int inputlen3;
    printf("\nEnter a regular expression (\"quit\" to quit): ");
    fgets(input3, 200, stdin);
    while(k == 0) {
        //in case they type quit right away
        if(strcmp(input3, "quit\n")==0) {break;}

        //Get rid of that pesky new line
        inputlen3 = strlen(input3);
        input3[--inputlen3] = '\0';

        //processing
        Tree var = TDP(input3);
        if (var != NULL)   {
            printf("The expression string for %s is \n", input3);
            startExplore(var);
            printf("\n");
        }

        //Now do it again
        printf("Enter a regular expression ('quit' to quit): ");
        fgets(input3, 200, stdin);
        if(strcmp(input3, "quit\n")==0) {break;}
    }

    return (EXIT_SUCCESS);
}

