#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "dfa.h"
#include "nfa.h"
#include "IntHashSet.h"
#include "LinkedList.h"

void DFA_Tester(char * msg, DFA dfa);
void NFA_Tester(char * msg, NFA nfa);



int main(int argc, char** argv) {
    
    //PART 1
    //Create a DFA object, along with its transition table & set of accepting states
    DFA mydfa1 = new_DFA(7, 1);
    IntHashSet_insert(mydfa1->accep, 6);
    
    //Fill the transition table with -1s first to represent null
    for (int i = 0; i < mydfa1->nstates; i++)    {
        for (int j = 0; j < 128; j++)   {
            mydfa1->trans[i][j] = (int)-1;
        }
    }
    
    //Set the transitions
    DFA_set_transition(mydfa1, 0, 'c', 1);
    DFA_set_transition(mydfa1, 1, 's', 2);
    DFA_set_transition(mydfa1, 2, 'c', 3);
    DFA_set_transition(mydfa1, 3, '1', 4);
    DFA_set_transition(mydfa1, 4, '7', 5);
    DFA_set_transition(mydfa1, 5, '3', 6);
    
    
    //Now do the process: the hard part
    DFA_Tester("Testing DFA that recognizes exactly \"csc173\"...", mydfa1);
    
    
    //DFA2
    DFA mydfa2 = new_DFA(4, 1);
    IntHashSet_insert(mydfa2->accep, 3);
    for (int i = 0; i < mydfa2->nstates; i++)    {
        for (int j = 0; j < 128; j++)   {
            mydfa2->trans[i][j] = (int)-1;
        }
    }
    DFA_set_transition(mydfa2, 0, 'c', 1);
    DFA_set_transition(mydfa2, 1, 'a', 2);
    DFA_set_transition(mydfa2, 2, 't', 3);
    DFA_set_transition_all(mydfa2, 3, 3);
    
    
    //DFA3
    DFA mydfa3 = new_DFA(2, 1);
    IntHashSet_insert(mydfa3->accep, 0);
    for (int i = 0; i < mydfa3->nstates; i++)    {
        for (int j = 0; j < 128; j++)   {
            mydfa3->trans[i][j] = (int)-1;
        }
    }
    DFA_set_transition(mydfa3, 0, '0', 1);
    DFA_set_transition(mydfa3, 0, '1', 0);
    DFA_set_transition(mydfa3, 1, '1', 1);
    DFA_set_transition(mydfa3, 1, '0', 0);
    
    
    //DFA4
    DFA mydfa4 = new_DFA(4, 1);
    IntHashSet_insert(mydfa4->accep, 0);
    for (int i = 0; i < mydfa4->nstates; i++)    {
        for (int j = 0; j < 128; j++)   {
            mydfa4->trans[i][j] = (int)-1;
        }
    }
    DFA_set_transition(mydfa4, 0, '0', 1);
    DFA_set_transition(mydfa4, 0, '1', 2);
    DFA_set_transition(mydfa4, 1, '0', 0);
    DFA_set_transition(mydfa4, 1, '1', 3);
    DFA_set_transition(mydfa4, 2, '0', 3);
    DFA_set_transition(mydfa4, 2, '1', 0);
    DFA_set_transition(mydfa4, 3, '0', 2);
    DFA_set_transition(mydfa4, 3, '1', 1);
    
    
    //DFA5
    DFA mydfa5 = new_DFA(4, 1);
    IntHashSet_insert(mydfa5->accep, 1);
    for (int i = 0; i < mydfa5->nstates; i++)    {
        for (int j = 0; j < 128; j++)   {
            mydfa5->trans[i][j] = (int)-1;
        }
    }
    DFA_set_transition(mydfa5, 0, '0', 3);
    DFA_set_transition(mydfa5, 0, '1', 1);
    DFA_set_transition(mydfa5, 1, '0', 2);
    DFA_set_transition(mydfa5, 1, '1', 0);
    DFA_set_transition(mydfa5, 2, '0', 1);
    DFA_set_transition(mydfa5, 2, '1', 3);
    DFA_set_transition(mydfa5, 3, '0', 0);
    DFA_set_transition(mydfa5, 3, '1', 2);
    
    
    //Send them one by one into DFA_Tester
    DFA_Tester("Testing DFA that recognizes any string starting with \"cat\"", mydfa2);
    DFA_Tester("Testing DFA that recognizes any binary input with an even number of 0's", mydfa3);
    DFA_Tester("Testing DFA that recognizes any binary input with an even number of 1's and 0's", mydfa4);
    DFA_Tester("Testing DFA that recognizes any binary input with an even number of 0's and an odd number of 1's", mydfa5);
    
    
    
    
    
    
    //PART 2
    printf("\n");
    NFA mynfa1 = new_NFA(5, 1);
    IntHashSet_insert(mynfa1->accep, 4);
    NFA_add_transition(mynfa1, 0, 'c', 1);
    NFA_add_transition(mynfa1, 1, 'o', 2);
    NFA_add_transition(mynfa1, 2, 'd', 3);
    NFA_add_transition(mynfa1, 3, 'e', 4);
    NFA_add_transition_all(mynfa1, 0, 0);
    NFA_Tester("Testing NFA that accepts strings ending in \"code\"", mynfa1);
    
    
    NFA mynfa2 = new_NFA(5, 1);
    IntHashSet_insert(mynfa2->accep, 4);
    NFA_add_transition_all(mynfa2, 0, 0);
    NFA_add_transition(mynfa2, 0, 'c', 1);
    NFA_add_transition(mynfa2, 1, 'o', 2);
    NFA_add_transition(mynfa2, 2, 'd', 3);
    NFA_add_transition(mynfa2, 3, 'e', 4);
    NFA_add_transition_all(mynfa2, 4, 4);
    NFA_Tester("Testing NFA that accepts strings containing \"code\"", mynfa2);
    
    
    NFA mynfa3 = new_NFA(20, 9);
    IntHashSet_insert(mynfa3->accep, 2);
    IntHashSet_insert(mynfa3->accep, 4);
    IntHashSet_insert(mynfa3->accep, 6);
    IntHashSet_insert(mynfa3->accep, 8);
    IntHashSet_insert(mynfa3->accep, 10);
    IntHashSet_insert(mynfa3->accep, 12);
    IntHashSet_insert(mynfa3->accep, 14);
    IntHashSet_insert(mynfa3->accep, 16);
    IntHashSet_insert(mynfa3->accep, 19);
    
    NFA_add_transition_all(mynfa3, 0, 0);
    
    NFA_add_transition(mynfa3, 0, 'w', 1);
    NFA_add_transition_all(mynfa3, 1, 1);
    IntHashSet remW = new_IntHashSet(mynfa3->nstates);
    mynfa3->trans[1]['w'] = remW;
    NFA_add_transition(mynfa3, 1, 'w', 2);
    NFA_add_transition_all(mynfa3, 2, 2);
    
    NFA_add_transition(mynfa3, 0, 'a', 3);
    NFA_add_transition_all(mynfa3, 3, 3);
    IntHashSet remA = new_IntHashSet(mynfa3->nstates);
    mynfa3->trans[3]['a'] = remA;
    NFA_add_transition(mynfa3, 3, 'a', 4);
    NFA_add_transition_all(mynfa3, 4, 4);
    
    NFA_add_transition(mynfa3, 0, 's', 5);
    NFA_add_transition_all(mynfa3, 5, 5);
    IntHashSet remS = new_IntHashSet(mynfa3->nstates);
    mynfa3->trans[5]['s'] = remS;
    NFA_add_transition(mynfa3, 5, 's', 6);
    NFA_add_transition_all(mynfa3, 6, 6);
    
    NFA_add_transition(mynfa3, 0, 'h', 7);
    NFA_add_transition_all(mynfa3, 7, 7);
    IntHashSet remH = new_IntHashSet(mynfa3->nstates);
    mynfa3->trans[7]['h'] = remH;
    NFA_add_transition(mynfa3, 7, 'h', 8);
    NFA_add_transition_all(mynfa3, 8, 8);
    
    NFA_add_transition(mynfa3, 0, 'i', 9);
    NFA_add_transition_all(mynfa3, 9, 9);
    IntHashSet remI = new_IntHashSet(mynfa3->nstates);
    mynfa3->trans[9]['i'] = remI;
    NFA_add_transition(mynfa3, 9, 'i', 10);
    NFA_add_transition_all(mynfa3, 10, 10);
    
    NFA_add_transition(mynfa3, 0, 'g', 11);
    NFA_add_transition_all(mynfa3, 11, 11);
    IntHashSet remG = new_IntHashSet(mynfa3->nstates);
    mynfa3->trans[11]['g'] = remG;
    NFA_add_transition(mynfa3, 11, 'g', 12);
    NFA_add_transition_all(mynfa3, 12, 12);
    
    NFA_add_transition(mynfa3, 0, 't', 13);
    NFA_add_transition_all(mynfa3, 13, 13);
    IntHashSet remT = new_IntHashSet(mynfa3->nstates);
    mynfa3->trans[13]['t'] = remT;
    NFA_add_transition(mynfa3, 13, 't', 14);
    NFA_add_transition_all(mynfa3, 14, 14);
    
    NFA_add_transition(mynfa3, 0, 'o', 15);
    NFA_add_transition_all(mynfa3, 15, 15);
    IntHashSet remO = new_IntHashSet(mynfa3->nstates);
    mynfa3->trans[15]['o'] = remO;
    NFA_add_transition(mynfa3, 15, '0', 16);
    NFA_add_transition_all(mynfa3, 16, 16);
    
    NFA_add_transition(mynfa3, 0, 'n', 17);
    NFA_add_transition_all(mynfa3, 17, 17);
    IntHashSet remN1 = new_IntHashSet(mynfa3->nstates);
    mynfa3->trans[17]['n'] = remN1;
    NFA_add_transition(mynfa3, 17, 'n', 18);
    NFA_add_transition_all(mynfa3, 18, 18);
    IntHashSet remN2 = new_IntHashSet(mynfa3->nstates);
    mynfa3->trans[18]['n'] = remN2;
    NFA_add_transition(mynfa3, 18, 'n', 19);
    NFA_add_transition_all(mynfa3, 19, 19);
    NFA_Tester("Testing NFA that accepts strings containing more than one 'w,' 'a,' 's,' 'h,' 'i,' 'g,' 't,' or 'o', or more than two 'n.'", mynfa3);
    
    
    NFA mynfa4 = new_NFA(6, 2);
    IntHashSet_insert(mynfa4->accep, 3);
    IntHashSet_insert(mynfa4->accep, 5);
    NFA_add_transition(mynfa4, 0, 't', 1);
    NFA_add_transition(mynfa4, 1, 'a', 2);
    NFA_add_transition(mynfa4, 1, 'a', 4);
    NFA_add_transition(mynfa4, 2, 'n', 3);
    NFA_add_transition(mynfa4, 4, 'r', 5);
    NFA_add_transition_all(mynfa4, 3, 3);
    NFA_add_transition_all(mynfa4, 5, 5);
    NFA_Tester("Testing NFA that accepts strings starting in \"tan\" or \"tar\"", mynfa4);
    
    
    
    
    
    
    //PART 3
    printf("\nThe conversion of NFA 1 to a DFA will now begin. \n");
    DFA d1 = convert(mynfa1);
    printf("\nThis DFA will now be run through the DFA tester.");
    DFA_Tester("Testing derived DFA -- should accept strings ending in \"code\"", d1);
    
    printf("\n\nThe conversion of NFA 2 to a DFA will now begin. \n");
    DFA d2 = convert(mynfa2);
    printf("\nThis DFA will now be run through the DFA tester.");
    DFA_Tester("Testing derived DFA -- should accept strings containing \"code\"", d2);
    
    
    
    
    //TODO: free all DFAs and NFAs here
    free(mydfa1);
    free(mydfa2);
    free(mydfa3);
    free(mydfa4);
    free(mydfa5);
    free(mynfa1);
    free(mynfa2);
    free(mynfa3);
    free(mynfa4);
    

    return (EXIT_SUCCESS);
}//end of main





void DFA_Tester(char * msg, DFA dfa) {
    int i = 0;
    char input[200];
    unsigned int inputlen;
    int myBool; //0 = false, 1=true
    
    printf("%s", msg);
    
    printf("\n\tEnter an input (\"quit\" to quit): ");
    fgets(input, 200, stdin);
    
    while(i == 0) {
        //in case they type quit right away
        if(strcmp(input, "quit\n")==0) {break;}
        
        //Get rid of that pesky new line
        inputlen = strlen(input);
        input[--inputlen] = '\0';
        
        //processing
        myBool = DFA_execute(dfa, inputlen, input);
        printf("\tResult for input: '%s' : %s\n", input, myBool ? "true": "false");
        
        //Now do it again
        printf("\tEnter an input ('quit' to quit): ");
        fgets(input, 200, stdin);
        if(strcmp(input, "quit\n")==0) {break;}
    }
    
}//end of DFA tester




void NFA_Tester(char * msg, NFA nfa) {
    int i = 0;
    char input[200];
    unsigned int inputlen;
    int myBool; //0 = false, 1=true
    
    printf("%s", msg);
    
    printf("\n\tEnter an input (\"quit\" to quit): ");
    fgets(input, 200, stdin);
    
    while(i == 0) {
        //in case they type quit right away
        if(strcmp(input, "quit\n")==0) {break;}
        
        //Get rid of that new line
        inputlen = strlen(input);
        input[--inputlen] = '\0';
        
        //processing
        //myBool = 0; //placeholder
        myBool = NFA_execute(nfa, inputlen, input);
        printf("\tResult for input: '%s' : %s\n", input, myBool ? "true": "false");
                
        //Now do it again
        printf("\tEnter an input ('quit' to quit): ");
        fgets(input, 200, stdin);
        if(strcmp(input, "quit\n")==0) {break;}
    } 
}//end of NFA Tester

