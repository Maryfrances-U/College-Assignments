#include <stdio.h>
#include <stdlib.h>
#include "dfa.h"
#include "IntHashSet.h"



//DFA constructor
DFA new_DFA(int nstates, int accepSize)  {
    DFA this = malloc(sizeof(struct DFA));
    this->nstates = nstates;
    this->accepSize = accepSize;
    this->accep = new_IntHashSet(accepSize);
    
    int** transtable = (int**)malloc(sizeof(int *) * nstates );  //mallocs the first pointer, which would be the rows
    for (int i = 0; i < nstates; i++)
        transtable[i] = (int *) malloc (sizeof(int) * 128);
    
    this->trans = transtable; 
    return this;
}


//another constructor for if you are creating a DFA from an NFA
DFA new_DFAfromNFA (int** trans, int nstates, IntHashSet accept)    {
    DFA this = (DFA)malloc(sizeof(struct DFA));
    this->trans = trans;
    this->nstates = nstates;
    this->accep = accept;
    return this;
}



void DFA_free(DFA dfa)   {
    free(dfa);
    free(dfa->trans);
}


//Return the number of states in the given DFA
int DFA_get_size(DFA dfa)   {
    return dfa->nstates;
}


//Return the state specified by the given DFA's transition function from state src on input symbol sym
int DFA_get_transition(DFA dfa, int src, char sym)  {
    //printf("The item in Source %d  for symbol %c is %d", src, sym, trans[src][isym]);
    return dfa->trans[src][(int)sym];
}


//For the given DFA, set the transition from state src on input symbol sym to be the state dst.
//void DFA_set_transition(DFA dfa, int trans[dfa->nstates][128], int src, char sym, int dst){
void DFA_set_transition(DFA dfa, int src, char sym, int dst){
    int isym = sym;
    dfa->trans[src][isym] = dst;
}


// Set the transitions of the given DFA for each symbol in the given str.
// This is a nice shortcut when you have multiple labels on an edge between two states.
void DFA_set_transition_str(DFA dfa, int src, char *str, int dst){
    //this will divide the string into characters
    //then call transition for each character
}


//Set the transitions of the given DFA for all input symbols. Another shortcut method.
void DFA_set_transition_all(DFA dfa, int src, int dst){
    //given source, every character will go to dest
    for(int i = 0; i < 128; i++)    {
        dfa->trans[src][i] = dst;
    }
}


////Set whether the given DFA's state is accepting or not
//void DFA_set_accepting(DFA dfa, int state, bool value) {
//    
//}


////Return true if the given DFA's state is an accepting state.
//bool DFA_get_accepting(DFA dfa, int state)  {
//    
//}


//Run the given DFA on the given input string, and return 1 if it accepts the input
int DFA_execute(DFA dfa, int inputlen, char input[inputlen]){
    
    //represent current state
    int curr = 0;
    
    for (int i = 0; i < inputlen; i++) {
        int a = DFA_get_transition(dfa, curr, input[i]);
        
        if (a >= 0)  {
            curr = a;
        } 
        else
            return 0;
    }
    
        if (IntHashSet_lookup(dfa->accep, curr) )   {
            return 1;
        }
    
    return 0;
}


//Print the given DFA to console
//void DFA_print(DFA dfa) {
//    
//}