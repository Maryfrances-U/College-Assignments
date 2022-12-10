#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "HashMap.h"


//constructor
Table new_Table(){
    Table this = (Table) calloc(1, sizeof(struct Relation));
    this->Tuples = (LinkedList *) calloc(1009, sizeof(LinkedList));

    //TODO: Initialize everything to null
    return this;

}


char** callocedAtt(int n){
    char** strings = (char**)calloc(n, sizeof(char*));
    for(int i = 0;i<n;i++){
        strings[i] = (char*) calloc(256, sizeof(char));
    }
    return strings;
}


void addAttributes(TupleInstance t, char** strings, int attSize)    {
    t->attSize = attSize;
    t->attributes = calloc(attSize, sizeof(char *));
    for (int i = 0; i < attSize; i++) {
        t->attributes[i] = calloc(256, sizeof(char));
        strcpy(t->attributes[i], strings[i]);
    }
}


void printTable(Table table){
    for (int i = 0; i < 1009; i++)  {
        if (table->Tuples[i] != NULL){
            LinkedListIterator itr = LinkedList_iterator(table->Tuples[i]);
            TupleInstance next = LinkedListIterator_next(itr);
            while (next != NULL){
                TupleInstance t = next;
                for (int i = 0; i < t->attSize; i++){
                    printf("%s \t", t->attributes[i]);
                }
                printf("\n");
                next = LinkedListIterator_next(itr);
            }
        }
    }
}


/*Adds all tuples to CSG hashtable*/
void populateCSG(Table CSGHash,int csgAttSize)
{
    TupleInstance CSG1 = new_Tuple();
    char** csg1att = callocedAtt(csgAttSize);
    csg1att[0] = "CS101";
    csg1att[1] = "12345";
    csg1att[2] = "A";
    addAttributes(CSG1, csg1att, csgAttSize);

    TupleInstance CSG2 = new_Tuple();
    char** csg2att = callocedAtt(csgAttSize);
    csg2att[0] = "CS101";
    csg2att[1] = "67890";
    csg2att[2] = "B";
    addAttributes(CSG2, csg2att, csgAttSize);

    TupleInstance CSG3 = new_Tuple();
    char** csg3att = callocedAtt(csgAttSize);
    csg3att[0] = "EE200";
    csg3att[1] = "12345";
    csg3att[2] = "C";
    addAttributes(CSG3, csg3att, csgAttSize);

    TupleInstance CSG4 = new_Tuple();
    char** csg4att = callocedAtt(csgAttSize);
    csg4att[0] = "EE200";
    csg4att[1] = "22222";
    csg4att[2] = "B+";
    addAttributes(CSG4, csg4att, csgAttSize);

    TupleInstance CSG5 = new_Tuple();
    char** csg5att = callocedAtt(csgAttSize);
    csg5att[0] = "CS101";
    csg5att[1] = "33333";
    csg5att[2] = "A-";
    addAttributes(CSG5, csg5att, csgAttSize);

    TupleInstance CSG6 = new_Tuple();
    char** csg6att = callocedAtt(csgAttSize);
    csg6att[0] = "PH100";
    csg6att[1] = "67890";
    csg6att[2] = "C+";
    addAttributes(CSG6, csg6att, csgAttSize);

    //insert all these tuples into a relation (table)
    insert(CSGHash, CSG1);
    insert(CSGHash, CSG2);
    insert(CSGHash, CSG3);
    insert(CSGHash, CSG4);
    insert(CSGHash, CSG5);
    insert(CSGHash, CSG6);
}

/*Adds all tuples to SNAP hashtable*/
void populateSNAP(Table SNAPHash,int snapAttSize)
{
    TupleInstance SNAP1=new_Tuple();
    char** snap1att = callocedAtt(snapAttSize);
    snap1att[0]="12345";
    snap1att[1]="C. Brown";
    snap1att[2]="12 Apple St.";
    snap1att[3]="555-1234";
    addAttributes(SNAP1,snap1att,snapAttSize);

    TupleInstance SNAP2=new_Tuple();
    char** snap2att = callocedAtt(snapAttSize);
    snap2att[0]="67890";
    snap2att[1]="L. Van Pelt";
    snap2att[2]="34 Pear Ave.";
    snap2att[3]="555-5678";
    addAttributes(SNAP2,snap2att,snapAttSize);

    TupleInstance SNAP3=new_Tuple();
    char** snap3att = callocedAtt(snapAttSize);
    snap3att[0]="22222";
    snap3att[1]="P. Patty";
    snap3att[2]="56 Grape Blvd.";
    snap3att[3]="555-9999";
    addAttributes(SNAP3,snap3att,snapAttSize);

    //Insert tuples in relation (table)
    insert(SNAPHash,SNAP1);
    insert(SNAPHash,SNAP2);
    insert(SNAPHash,SNAP3);
}

/*Adds all tuples to CP hashtable*/
void populateCP(Table CPHash, int CPAttSize)
{
    TupleInstance CP1= new_Tuple();
    char** cp1att = callocedAtt(CPAttSize);
    cp1att[0]="CS101";
    cp1att[1]="CS100";
    addAttributes(CP1,cp1att,CPAttSize);

    TupleInstance CP2= new_Tuple();
    char** cp2att = callocedAtt(CPAttSize);
    cp2att[0]="EE200";
    cp2att[1]="EE005";
    addAttributes(CP2,cp2att,CPAttSize);

    TupleInstance CP3= new_Tuple();
    char** cp3att = callocedAtt(CPAttSize);
    cp3att[0]="EE200";
    cp3att[1]="CS100";
    addAttributes(CP3,cp3att,CPAttSize);

    TupleInstance CP4= new_Tuple();
    char** cp4att = callocedAtt(CPAttSize);
    cp4att[0]="CS120";
    cp4att[1]="CS101";
    addAttributes(CP4,cp4att,CPAttSize);

    TupleInstance CP5= new_Tuple();
    char** cp5att = callocedAtt(CPAttSize);
    cp5att[0]="CS121";
    cp5att[1]="CS120";
    addAttributes(CP5,cp5att,CPAttSize);

    TupleInstance CP6= new_Tuple();
    char** cp6att = callocedAtt(CPAttSize);
    cp6att[0]="CS205";
    cp6att[1]="CS101";
    addAttributes(CP6,cp6att,CPAttSize);

    TupleInstance CP7= new_Tuple();
    char** cp7att = callocedAtt(CPAttSize);
    cp7att[0]="CS206";
    cp7att[1]="CS121";
    addAttributes(CP7,cp7att,CPAttSize);

    TupleInstance CP8= new_Tuple();
    char** cp8att = callocedAtt(CPAttSize);
    cp8att[0]="CS206";
    cp8att[1]="CS205";
    addAttributes(CP8,cp8att,CPAttSize);

    //Insert tuples in hashtable
    insert(CPHash,CP1);
    insert(CPHash,CP2);
    insert(CPHash,CP3);
    insert(CPHash,CP4);
    insert(CPHash,CP5);
    insert(CPHash,CP6);
    insert(CPHash,CP7);
    insert(CPHash,CP8);
}

/*Adds all tuples to CDH hashtable*/
void populateCDH(Table CDHHash,int CDHAttSize)
{
    TupleInstance CDH1= new_Tuple();
    char** cdh1att = callocedAtt(CDHAttSize);
    cdh1att[0]="CS101";
    cdh1att[1]="M";
    cdh1att[2]="9AM";
    addAttributes(CDH1,cdh1att,CDHAttSize);

    TupleInstance CDH2= new_Tuple();
    char** cdh2att = callocedAtt(CDHAttSize);
    cdh2att[0]="CS101";
    cdh2att[1]="W";
    cdh2att[2]="9AM";
    addAttributes(CDH2,cdh2att,CDHAttSize);

    TupleInstance CDH3= new_Tuple();
    char** cdh3att = callocedAtt(CDHAttSize);
    cdh3att[0]="CS101";
    cdh3att[1]="F";
    cdh3att[2]="9AM";
    addAttributes(CDH3,cdh3att,CDHAttSize);

    TupleInstance CDH4= new_Tuple();
    char** cdh4att = callocedAtt(CDHAttSize);
    cdh4att[0]="EE200";
    cdh4att[1]="Tu";
    cdh4att[2]="10AM";
    addAttributes(CDH4,cdh4att,CDHAttSize);

    TupleInstance CDH5= new_Tuple();
    char** cdh5att = callocedAtt(CDHAttSize);
    cdh5att[0]="EE200";
    cdh5att[1]="W";
    cdh5att[2]="1PM";
    addAttributes(CDH5,cdh5att,CDHAttSize);

    TupleInstance CDH6= new_Tuple();
    char** cdh6att = callocedAtt(CDHAttSize);
    cdh6att[0]="EE200";
    cdh6att[1]="Th";
    cdh6att[2]="10AM";
    addAttributes(CDH6,cdh6att,CDHAttSize);

    //Insert tuples in hashtable
    insert(CDHHash,CDH1);
    insert(CDHHash,CDH2);
    insert(CDHHash,CDH3);
    insert(CDHHash,CDH4);
    insert(CDHHash,CDH5);
    insert(CDHHash,CDH6);
}

void populateCR(Table CRHash,int CRAttSize)
{
    TupleInstance CR1= new_Tuple();
    char** cr1att = callocedAtt(CRAttSize);
    cr1att[0]="CS101";
    cr1att[1]="Turing Aud.";
    addAttributes(CR1,cr1att,CRAttSize);

    TupleInstance CR2= new_Tuple();
    char** cr2att = callocedAtt(CRAttSize);
    cr2att[0]="EE200";
    cr2att[1]="25 Ohm Hall";
    addAttributes(CR2,cr2att,CRAttSize);

    TupleInstance CR3= new_Tuple();
    char** cr3att = callocedAtt(CRAttSize);
    cr3att[0]="PH100";
    cr3att[1]="Newton Lab.";
    addAttributes(CR3,cr3att,CRAttSize);

    //Insert tuples in hashtable
    insert(CRHash,CR1);
    insert(CRHash,CR2);
    insert(CRHash,CR3);
}


int hashingFunction(Table HashMap, TupleInstance tuple) {
    int k = 0;
    int* keyArray = HashMap->keyArray;

    //for every i in key array
    //loop through the attribute, add everything, then add to k
    for (int i = 0; i < HashMap->keyArraySize; i++) {

        char* temp = tuple->attributes[keyArray[i]-1];
        if (temp != NULL) {
            while (*temp != '\0') {//\0
                k = k + *temp;
                temp++;
            }
        }
    }

    int finalKey = k%1009;
    return finalKey;
}



void insert(Table HashMap, TupleInstance tuple)    {
    int finalKey = hashingFunction(HashMap, tuple);

    LinkedList l = HashMap->Tuples[finalKey];
    if (l == NULL) {
        //make new Linkedlist
        //insert at finalKey
        LinkedList n = new_LinkedList();
        HashMap->Tuples[finalKey] = n;
        l = n;
    }

    //check for duplicate
    LinkedListIterator itr = LinkedList_iterator(l);
    while (LinkedListIterator_hasNext(itr)){
        TupleInstance next = LinkedListIterator_next(itr);
        if(matchTuple(next, tuple))    {
            return;
        }
    }
    LinkedList_add_at_end(l, tuple);
}



//lookup(X, r) returns a set (LinkedList) of matching tuples
LinkedList lookup(Table HashMap, TupleInstance pattern)    {
    LinkedList returnSet = new_LinkedList();
    bool hashable = true;   //represents whether or not both keys are present
    //bool found = false;     //represents whether or not we found something


    //see if pattern has values in the key positions
    for (int i = 0; i < HashMap->keyArraySize; i++){
        if (strcmp("*", pattern->attributes[i]) == 0){
            hashable = false;
        }
    }


    //if we have the key values, then send it to hash function and get the index
    if (hashable == true)   {
        //printf("Lookup - Hashable is true.\n");
        int key = hashingFunction(HashMap, pattern);

        //go to the index in the table and see if there are tuples existing
        if (HashMap->Tuples[key] == NULL){
            return returnSet;   //cos if there's nothing there, there's nothing there
        }
        else{
            //if not null, then go through the bucket and see which one matches and return that
            LinkedListIterator itr = LinkedList_iterator(HashMap->Tuples[key]);
            TupleInstance next = LinkedListIterator_next(itr);
            while (next != NULL){
                TupleInstance t = next;
                if (matchTuple(pattern, t)){
                    //found = true;
                    LinkedList_add_at_end(returnSet, t);
                }
                next = LinkedListIterator_next(itr);
            }
        }
    }

        //else if there are asterisks where there should be keys
    else{
        //printf("Lookup - Hashable is false\n");

        for (int i = 0; i < 1009; i++){
            if(HashMap->Tuples[i] != NULL){
                LinkedList current = HashMap->Tuples[i];
                LinkedListIterator itr = LinkedList_iterator(current);

                TupleInstance next = LinkedListIterator_next(itr);
                while (next != NULL){
                    TupleInstance t = next;
                    if (matchTuple(pattern, t)){
                        //found = true;
                        LinkedList_add_at_end(returnSet, t);
                    }
                    next = LinkedListIterator_next(itr);
                }

            }
        }
    }

    //return the linkedList
    return returnSet;

}//end of lookup


void lookup_print(LinkedList Lookup){
    printf("\n");
    LinkedListIterator itr = LinkedList_iterator(Lookup);
    TupleInstance next = LinkedListIterator_next(itr);
    while (next != NULL){
        TupleInstance t = next;
        for (int i = 0; i < t->attSize; i++){
            printf("%s \t", t->attributes[i]);
        }
        printf("\n");
        next = LinkedListIterator_next(itr);
    }
}



//do lookup again but remove from linked list in the table
void delete(Table HashMap, TupleInstance pattern)    {
    bool hashable = true;   //represents whether or not both keys are present
    //bool found = false;     //represents whether or not something to delete was found


    //see if pattern has values in the key positions
    for (int i = 0; i < HashMap->keyArraySize; i++){
        if (strcmp("*", pattern->attributes[i]) == 0){
            hashable = false;
        }
    }


    //if we have the key values, then send it to hash function and get the index
    if (hashable == true)   {
        //printf("Delete - Hashable is true.\n");
        int key = hashingFunction(HashMap, pattern);

        //go to the index in the table and see if there are tuples existing
        if (HashMap->Tuples[key] == NULL){
            printf("There was no matching pattern to delete.\n");
            return;
        }

        else{
            //if not null, then go through the bucket and see which one matches and return that
            LinkedListIterator itr = LinkedList_iterator(HashMap->Tuples[key]);
            TupleInstance next = LinkedListIterator_next(itr);
            while (next != NULL){
                TupleInstance t = next;
                if (matchTuple(pattern, t)){
                    //found = true;
                    LinkedList_removeTuple(HashMap->Tuples[key], t);
                }
                next = LinkedListIterator_next(itr);
            }
        }
    }


        //else if there are asterisks where there should be keys
    else {
        //printf("Delete - Hashable is false\n");

        for (int i = 0; i < 1009; i++) {
            if (HashMap->Tuples[i] != NULL) {
                LinkedList current = HashMap->Tuples[i];
                LinkedListIterator itr = LinkedList_iterator(current);

                TupleInstance next = LinkedListIterator_next(itr);
                while (next != NULL) {
                    TupleInstance t = next;
                    if (matchTuple(pattern, t)) {
                        //found = true;
                        LinkedList_removeTuple(current, t);
                    }
                    next = LinkedListIterator_next(itr);
                }

            }
        }
    }


}//end of delete


Table Selection(Table table, char** headers, char** selectOnArr, int selectArrSize){
    Table returnTable = new_Table();

    for(int i = 0; i < selectArrSize; i++){
        returnTable = SelectionHelper(table, headers[i], selectOnArr[i]);
    }

    printTable(returnTable);
    return returnTable;
}





Table SelectionHelper(Table table, char* header, char* selectOn)   {
    int i = 0;

    //get index i on headers
    for (int a = 0; a < table->width; a++)    {
        if (strcmp(table->headers[a], header) == 0)   {
            i = a;
        }
    }

    TupleInstance t = new_Tuple();
    char** call = callocedAtt(table->width);
    for (int b = 0; b < table->width; b++){
        call[b] = "*";
    }
    call[i] = selectOn;
    addAttributes(t, call, table->width);

    Table result = new_Table();
    result->width = table->width;
    result->headers = table->headers;
    result->keyArray = table->keyArray;
    result->keyArraySize = table->keyArraySize;

    LinkedList selection = lookup(table, t);

    //loop through linked list and add each tuple to result
    LinkedListIterator itr = LinkedList_iterator(selection);
    while (LinkedListIterator_hasNext(itr)){
        TupleInstance t = LinkedListIterator_next(itr);
        insert(result, t);
    }

    return result;

}


Table Projection(Table table, char** projectOn, int posize){
    //initialize an int array to store the indexes of the headers
    int a[posize];
    int index = 0;

    //loop through table schema to get the indexes of the headers
    for (int i = 0; i < posize; i++){
        for (int j = 0; j < table->width; j++){
            if (strcmp(table->headers[j], projectOn[i]) == 0) {
                if (index == posize)    {
                    break;
                }
                else{
                    a[index] = j;
                    index++;
                }
            }
        }
    }

    //Create return table
    Table returnTable = new_Table();
    returnTable->width = index;

    //malloc headers
    returnTable->headers = (char**) calloc(returnTable->width, sizeof(char*));
    for (int i = 0; i < returnTable->width; i++){
        returnTable->headers[i] = (char*) calloc(256, sizeof(char));
    }

    //set headers
    for (int i = 0; i < posize; i++){
        strcpy(returnTable->headers[i], projectOn[i]);
    }

    //set keys  //the entire result is the key
    returnTable->keyArraySize = posize;
    returnTable->keyArray = calloc(posize, sizeof(int));
    for (int i = 0; i < posize; i++)    {
        returnTable->keyArray[i] = i+1;
    }


    //loop through the given table
    for (int i = 0; i < 1009; i++){

        if (table->Tuples[i] != NULL){
            LinkedList currList = table->Tuples[i];

            //iterate through all the tuples in the current linked list
            LinkedListIterator itr = LinkedList_iterator(currList);
            TupleInstance next = LinkedListIterator_next(itr);

            while (next != NULL){

                //get the current tuple
                TupleInstance tuple = next;

                char** strings = callocedAtt(index);
                for (int i = 0; i < index; i++){
                    strings[i] = tuple->attributes[a[i]];
                }

                TupleInstance  new = new_Tuple();
                addAttributes(new, strings, posize);
                insert(returnTable, new);

                next = LinkedListIterator_next(itr);
            }
        }
    }//end of table for
    printTable(returnTable);
    return returnTable;
}


/*Joins 2 tables on a specified attribute*/
Table Join (Table t1, Table t2, char* att)
{
    Table returnTable=new_Table();

    //Set width of return table
    //Ensure that attribute being joined on is not counted more than once
    //This method of calculation works because in this database, the only attribute that could possibly be repeated is the one being joined on
    returnTable->width = t1->width + t2->width - 1;
    returnTable->headers = (char**) calloc(returnTable->width, sizeof(char*));

    for(int i=0;i<returnTable->width;i++){//Alocate memory for each header index to prevent crashing when headers are set later on
        returnTable->headers[i]=(char*) calloc(256,sizeof(char));
    }

    //Set attribute values for return table

    int found=0;

    //Place all attributes from table 1 in the return table's headers
    for(int i=0;i<t1->width;i++)
    {
        strcpy(returnTable->headers[i],t1->headers[i]);
    }

    //Place rest of attributes from table 2 in return table's headers
    int j=t1->width; //Index of return table header;
    for(int i=0;i<t2->width;i++)
    {
        found=0;
        for(int k=0;k<t1->width;k++){ //Ensure that attribute from second table is not already in the return table
            if(strcmp(returnTable->headers[k],t2->headers[i])==0){
                found=1;
                break;
            }
        }
        if(found==0){
            strcpy(returnTable->headers[j],t2->headers[i]);
            j++;
        }
    }

    //Set keys for return table
    int numkeys=0;
    int t2KeysToAdd[2];//Keys from second table which will to be added to return table. These tables have at most 2 keys

    numkeys=t1->keyArraySize;
    j=0;
    for(int i=0;i<t2->keyArraySize;i++){
        if((strcmp(att, (t2->headers[t2->keyArray[i]-1]))!=0) && t2->keyArray[i]==(i+1)){ //If the second table has a key on an attribute that is not being eliminaed
            numkeys++;
            //Find the index in the return array for the key in the second table
            for(int k=0;k<returnTable->width;k++){

                if(strcmp(returnTable->headers[k],t2->headers[t2->keyArray[i]-1])==0){
                    t2KeysToAdd[j]=k+1;//Add position in return table to key array
                    j++;

                }
            }
        }
    }

    //Set up key array for return table
    returnTable->keyArraySize=numkeys;
    returnTable->keyArray = calloc(numkeys, sizeof(int));

    returnTable->keyArray= calloc(returnTable->keyArraySize,sizeof(int));


    //Add keys from table 1
    for(int i=0;i<t1->keyArraySize;i++){
        returnTable->keyArray[i]=t1->keyArray[i];
    }

    //Add keys from table 2
    j=0;
    for(int i=t1->keyArraySize;i<returnTable->keyArraySize;i++){
        if (t2KeysToAdd[j]!='\0')
        {
            returnTable->keyArray[i]=t2KeysToAdd[j];
            j++;
        }
    }

    //Determine which attribute index for second relation is to be used for the join opertion (will be excluded in return table)
    int t1attr, t2attr;

    for(int i=0;i<t1->width;i++){
        if(strcmp(t1->headers[i],att)==0){
            t1attr=i;
        }
    }

    for(int i=0;i<t2->width;i++){
        if(strcmp(t2->headers[i],att)==0){
            t2attr=i;
        }
    }

    //Join tables on attributes
    for(int i=0;i<1009;i++){//For all elements in first table
        if (t1->Tuples[i] != NULL){
            LinkedListIterator itr = LinkedList_iterator(t1->Tuples[i]);
            TupleInstance next = LinkedListIterator_next(itr);
            while (next!=NULL){
                TupleInstance tu1=next;
                for(int j=0;j<1009;j++){ //For all elements in second table
                    if(t2->Tuples[j]!=NULL){
                        LinkedListIterator itr2 = LinkedList_iterator(t2->Tuples[j]);
                        TupleInstance next2 = LinkedListIterator_next(itr2);
                        while(next2!=NULL){
                            TupleInstance tu2=next2;
                            if(strcmp(tu1->attributes[t1attr],tu2->attributes[t2attr])==0) {
                                joinHelper(tu1,tu2,t2attr,returnTable);
                            }
                            next2=LinkedListIterator_next(itr2);
                        }
                    }
                }
                next=LinkedListIterator_next(itr);
            }
        }
    }

    return returnTable;
}

void joinHelper(TupleInstance tu1,TupleInstance tu2, int t2attr, Table returnTable)
{
    int j=0; //Index of attribute in return table
    TupleInstance tu=new_Tuple();
    char** att = callocedAtt(returnTable->width);

    //Add all tuples from first table's tuples to return tuple
    for(int i=0;i<tu1->attSize;i++){
        att[j]=tu1->attributes[i];
        j++;
    }

    //Add necessary tuples from second table's tuples to return tuple
    for(int i=0;i<tu2->attSize;i++){
        if(i!=t2attr){ //If this isn't an attribute to be excluded
            att[j]=tu2->attributes[i];
            j++;
        }
    }

    addAttributes(tu,att,returnTable->width);
    insert(returnTable,tu);
}



/*Function to demonstrate Example 8.15*/
Table SelectProjectJoin (Table t1, Table t2, char* attr, char** SelectionHeaders, char** selectOnArray,int selectionNum,char** projectionHeaders,int projectionNum)
{
    //Join two tables
    printf("\nJoining tables together\n");
    Table tab1= Join(t1,t2,attr);
    printTable(tab1);

    //Perform selection on specified attributes
    printf("Performing selection\n");
    Table tab2 = Selection(tab1, SelectionHeaders, selectOnArray, selectionNum);

    printf("Performing Projection\n");
    Table final= Projection(tab2,projectionHeaders,projectionNum);



    return final;
}