#include <stdio.h>
#include <stdlib.h>
#include "nfa.h"
#include "dfa.h"
#include "LinkedList.h"
#include "IntHashSet.h"



NFA new_NFA(int nstates, int accepSize)  {
    NFA this = malloc(sizeof(struct NFA));
    
    this->nstates = nstates; 
    this->accepSize = accepSize;
    this->accep = new_IntHashSet(accepSize);
    
    //malloc the transtable
    IntHashSet** transTable = (IntHashSet**)malloc(nstates * sizeof(IntHashSet*));
    for (int i = 0; i < nstates; i++)   {
        transTable[i] = (IntHashSet*)malloc(128 * sizeof(IntHashSet));
        for (int j = 0; j < 128; j++) {
            transTable[i][j] = new_IntHashSet(this->nstates);
        }
    }         
    this->trans = transTable;
    
    return this;
}


void NFA_free(NFA nfa)   {
    free(nfa);
    free(nfa->trans);
}


int NFA_get_size(NFA nfa)   {
    return nfa->nstates;
}

//Return the set of next states from the given state on input symbol sym.
IntHashSet NFA_get_transitions(NFA nfa, int state, char sym)    {
    int isym = sym;
    return nfa->trans[state][isym];
}


//For the given NFA, set the transition from state src on input symbol sym to be the state dst.
void NFA_add_transition(NFA nfa, int src, char sym, int dst)    {
    IntHashSet_insert(nfa->trans[src][(int)sym], dst);
}


//Add a transition for the given NFA for each symbol in the given str.
//void NFA_add_transition_str(NFA nfa, int src, char *str, int dst)   {
//    
//}


//Add a transition for the given NFA for each input symbol.
void NFA_add_transition_all(NFA nfa, int src, int dst)  {
    //given source, every character will go to dest
    for(int i = 0; i < 128; i++)    {
        IntHashSet_insert(nfa->trans[src][i], dst);
    } 
}


//Set whether the given NFA's state is accepting or not.
//void NFA_set_accepting(NFA nfa, int state, bool value)  {
//    
//}

//Return true if the given NFA's state is an accepting state.
//bool NFA_get_accepting(NFA nfa, int state)  {
//    
//}


//Run the given NFA on the given input string, and return 1 if it accepts the input
int NFA_execute(NFA nfa, int inputlen, char input[inputlen])   {
    //set of current states
    IntHashSet currSet = new_IntHashSet(nfa->nstates);
    IntHashSet_insert(currSet, 0);
    
    //Lets get to the final set of possible states
    for (int i = 0; i < inputlen; i++) {
        
        IntHashSet tempNextStates = new_IntHashSet(nfa->nstates);
        
        //for each currState in currSet
        IntHashSetIterator itr1 = IntHashSet_iterator(currSet);
        while(IntHashSetIterator_hasNext(itr1)) {
            int currState = IntHashSetIterator_next(itr1);
        
            //Create a which represents the hash set at the currState (source) on input[i]
            IntHashSet a = NFA_get_transitions(nfa, currState, input[i]);

            //As long as a is not empty, union tempNextStates and a
            if(!IntHashSet_isEmpty(a))  {
                IntHashSet_union(tempNextStates, a);
            }
        }
        
        free(itr1);
        
        currSet = tempNextStates;
        
    }//done looping through input
    
    
    //Check if anything in our final set of possible states in an accepting state
    IntHashSetIterator itr2 = IntHashSet_iterator(currSet);
    while (IntHashSetIterator_hasNext(itr2)) {
        int temp = IntHashSetIterator_next(itr2);
        if (IntHashSet_lookup(nfa->accep, temp) )   {
            return 1;
        }
    }
    return 0;
}


//Print the given NFA to System.out.
//void NFA_print(NFA nfa) {
//}


DFA convert(NFA nfa)   {
    
    LinkedList S = new_LinkedList();
    LinkedList checkedStates = new_LinkedList();
    int numOfStatesInDfa = 1;
    
    
    //Add {0} to S
    IntHashSet first = new_IntHashSet(nfa->nstates);
    IntHashSet_insert(first, 0);
    LinkedList_add_at_end(S, first);
    
    //Iterate through S
    while(!LinkedList_isEmpty(S)) {
        
        //get the sets in S and iterate through them
        IntHashSet currSet = LinkedList_pop(S);
        LinkedList_add_at_end(checkedStates, currSet);
        
        //iterate through the input
        for(int i = 0; i < 128; i++)   {
            IntHashSet unionStates = new_IntHashSet(100);
            
            //iterate through the states in current Set
            IntHashSetIterator itr = IntHashSet_iterator(currSet);
            while(IntHashSetIterator_hasNext(itr)) {
                int currState = IntHashSetIterator_next(itr);
                
                //represents the transitions of the currently testing states
                IntHashSet transChar = new_IntHashSet(nfa->nstates);
                transChar = nfa->trans[currState][i];
                
                //union the set of states we are moving to with the currently testing state's transitions
                IntHashSet_union(unionStates, transChar);
            }//end of iterator while loop
            
            //is the set empty? If it is, insert 0
            if(IntHashSet_isEmpty(unionStates))  {
                IntHashSet_insert(unionStates, 0);
            }
            
            //see if set of union states is in set of checked states
            //if not, add to S and checkedStates
            int inCheck = 0;    //represents boolean that checks if unionState is in checkedStates
            LinkedListIterator listItr = LinkedList_iterator(checkedStates);
            while(LinkedListIterator_hasNext(listItr)) {
                IntHashSet setInCheckedStates = LinkedListIterator_next(listItr);
                if(IntHashSet_equals(setInCheckedStates, unionStates))    {
                    inCheck = 1;
                    break;
                }
            }
            if (inCheck == 0)   {
                numOfStatesInDfa+=1;
                LinkedList_add_at_end(S, unionStates);
                //LinkedList_add_at_end(checkedStates, unionStates);
            }
            
        }//end of for loop for input
        
    }//end of while loop for S
    
    
    printf("\nConversion complete. The number of states is %d", numOfStatesInDfa);
    
    
    
    //Now run through subset construction again
    
    int** dfaTable;
    int** transtable = (int**)calloc(  numOfStatesInDfa,sizeof(int *) );
    for (int i = 0; i < numOfStatesInDfa; i++)
        transtable[i] = (int *) calloc ( 128,sizeof(int));
    dfaTable = transtable;
    
    S = new_LinkedList();
    LinkedList checkedStates2 = new_LinkedList();
    first = new_IntHashSet(nfa->nstates);
    IntHashSet_insert(first, 0);
    LinkedList_add_at_end(checkedStates2, first);
    int srce = 0;
    
    LinkedListIterator Itr = LinkedList_iterator(checkedStates); 
    while (LinkedListIterator_hasNext(Itr))    {
        IntHashSet s = LinkedListIterator_next(Itr);
        
        for(int i = 0; i < 128; i++)    {
            IntHashSet unionStates = new_IntHashSet(100);
            
            //iterate through the states in current Set
            IntHashSetIterator itr = IntHashSet_iterator(s);
            while(IntHashSetIterator_hasNext(itr)) {
                int currState = IntHashSetIterator_next(itr);
               
                //union the set of states we are moving to with the currently testing state's transitions
                IntHashSet_union(unionStates, nfa->trans[currState][i]);
            }//end of iterator while loop
            
            //is the set empty? If it is, insert 0
            if(IntHashSet_isEmpty(unionStates))  {
                IntHashSet_insert(unionStates, 0);
                dfaTable[srce][i] = -1;
                continue;
            }
            
            int dest = 0;
            LinkedListIterator listItr = LinkedList_iterator(checkedStates);
            while(LinkedListIterator_hasNext(listItr)) {
                IntHashSet setInCheckedStates = LinkedListIterator_next(listItr);
                if(IntHashSet_equals(setInCheckedStates, unionStates))    {
                    break;
                }
                dest+=1;
            }
            dfaTable[srce][i] = dest;
        }
        srce +=1;
    }
    
    
    
    //Okay, now time to create the accepting for this 
    IntHashSet dfaAccept = new_IntHashSet(numOfStatesInDfa);
    IntHashSet tempAccep = new_IntHashSet(20);
    
    LinkedListIterator checkedItr = LinkedList_iterator(checkedStates);
    int index = 0;
    while(LinkedListIterator_hasNext(checkedItr)) {
        IntHashSet currSet = LinkedListIterator_next(checkedItr);
        int found = 0;
        
        IntHashSetIterator accepItr = IntHashSet_iterator(nfa->accep);
        while(IntHashSetIterator_hasNext(accepItr)) {
            int s2 = IntHashSetIterator_next(accepItr);
            
            //if s2 is in currSet
            if(IntHashSet_lookup(currSet, s2)) {
                found = 1;
            }
            
            if (found == 1){
                IntHashSet_insert(tempAccep, index);
            }
            index += 1;
            
        }
    }
    dfaAccept = tempAccep;
    
    return new_DFAfromNFA (dfaTable, numOfStatesInDfa, dfaAccept);
    
    
    
}//end of NFA Converter*/


