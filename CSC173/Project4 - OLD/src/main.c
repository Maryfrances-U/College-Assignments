#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "HashMap.h"


Table CSG(){
    Table t = new_Table();
    t->width = 3;

    t->headers = (char**) calloc(3, sizeof(char*));

    t->headers[0] = "Course";
    t->headers[1] = "StudentId";
    t->headers[2] = "Grade";

    t->keyArray = calloc(2, sizeof(int));
    t->keyArray[0] = 1;
    t->keyArray[1]= 2;
    t->keyArraySize = 2;

    return  t;
}

Table SNAP()    {
    Table t = new_Table();
    t->width = 4;

    t->headers = (char**) calloc(4, sizeof(char*));

    t->headers[0] = "StudentId";
    t->headers[1] = "Name";
    t->headers[2] = "Address";
    t->headers[3] = "Phone";

    t->keyArray = calloc(1, sizeof(int));
    t->keyArray[0] = 1;
    t->keyArraySize = 1;

    return t;
}

Table CP()  {
    Table t = new_Table();
    t->width = 2;

    t->headers = (char**) calloc(2, sizeof(char*));

    t->headers[0] = "Course";
    t->headers[1] = "Prerequisite";

    t->keyArray = calloc(1, sizeof(int));
    t->keyArray[0] = 1;
    t->keyArraySize = 1;

    return t;
}

Table CDH()  {
    Table t = new_Table();
    t->width = 3;

    t->headers = (char**) calloc(3, sizeof(char*));

    t->headers[0] = "Course";
    t->headers[1] = "Day";
    t->headers[2] = "Hour";

    t->keyArray = calloc(1, sizeof(int));
    t->keyArray[0] = 1;
    t->keyArraySize = 1;

    return t;
}

Table CR()  {
    Table t = new_Table();
    t->width = 2;

    t->headers = (char**) calloc(2, sizeof(char*));

    t->headers[0] = "Course";
    t->headers[1] = "Room";

    t->keyArray = calloc(1, sizeof(int));
    t->keyArray[0] = 1;
    t->keyArraySize = 1;

    return t;
}


void NCGQueryHelper(Table CSGHash, Table SNAPHash,char* name, char* course,int csgAttSize,int snapAttSize)
{
    //Find ID(s) of student(s) in SNAP database
    TupleInstance searchTuple1 = new_Tuple();
    char** st1Att = callocedAtt(snapAttSize);
    st1Att[0] = "*";
    st1Att[1] = name;
    st1Att[2] = "*";
    st1Att[3]= "*";
    addAttributes(searchTuple1, st1Att, snapAttSize);
    LinkedList Lookup = lookup(SNAPHash, searchTuple1);

    LinkedListIterator itr = LinkedList_iterator(Lookup);
    TupleInstance next = LinkedListIterator_next(itr);

    if(next==NULL){
        printf("The student %s does not exist.\n",name);
    }else{
        while (next != NULL){
            TupleInstance t = next;
            char* id= t->attributes[0]; //C. Brown's ID

            //Look for grade using ID & course name
            TupleInstance searchTuple2 = new_Tuple();
            char** st2Att = callocedAtt(csgAttSize);
            st2Att[0] = course;
            st2Att[1] = id;
            st2Att[2] = "*";
            printf("Course is:%s \t ID is:%s\n",course,id);
            addAttributes(searchTuple2, st2Att, csgAttSize);
            LinkedList Lookup2 = lookup(CSGHash, searchTuple2);

            //Print out grade(s) for student(s)
            LinkedListIterator itr2 = LinkedList_iterator(Lookup2);
            TupleInstance next2 = LinkedListIterator_next(itr2);

            if(next2==NULL)
            {
                printf("The student %s with ID %s is not a student in %s.\n",name, id, course);
                break;
            }else{
                while(next2!=NULL){
                    printf("Entered\n");
                    TupleInstance t2=next2;
                    char* grade=t2->attributes[2];
                    printf("The student %s with ID %s received a(n) %s in %s.\n",name,id,grade,course);
                    next2 = LinkedListIterator_next(itr2);
                }
            }

            next = LinkedListIterator_next(itr);
        }
    }

}

void NCGQuery(Table CSGHash, Table SNAPHash,int csgAttSize,int snapAttSize)
{
    char sname[256], cname[256];

    printf("Enter a student's name and a course name to find out what grade they got in the course.\n");
    printf("Enter 'null' for one or both of the parameters to stop querying.\n\n");

    printf("Student's Name: ");
    fflush(stdin);
    fgets(sname, 255, stdin);
    fflush(stdin);
    printf("Course Name: ");
    fflush(stdin);
    fgets(cname, 255, stdin);
    fflush(stdin);

    while((strncmp(sname,"null",strlen(sname)-1)!=0) && (strncmp(cname,"null",strlen(cname)-1)!=0))
    {
        sname[strlen(sname)-1]='\0';
        cname[strlen(cname)-1]='\0';

        NCGQueryHelper(CSGHash,SNAPHash,sname,cname,csgAttSize,snapAttSize);

        printf("\nEnter a student's name and a course name to find out what grade they got in the course.\n");
        printf("Enter 'null' for both parameters to stop querying.\n\n");

        printf("Student's Name: ");
        fflush(stdin);
        fgets(sname, 255, stdin);
        fflush(stdin);
        printf("Course Name: ");
        fflush(stdin);
        fgets(cname, 255, stdin);
    }
}


void WSTDQueryHelper(char* name, char* day, char* time, Table CSGHash, Table SNAPHash, Table CDHHash, Table CRHash, int csgAttSize,int snapAttSize, int cdhAttSize, int crAttSize)
{
    printf("Ya got here.\n");

    TupleInstance search1 = new_Tuple();
    char** st1Att = callocedAtt(snapAttSize);
    st1Att[0] = "*";
    st1Att[1] = name;
    st1Att[2] = "*";
    st1Att[3]= "*";
    addAttributes(search1, st1Att, snapAttSize);
    LinkedList Lookup = lookup(SNAPHash, search1);

    LinkedListIterator itr = LinkedList_iterator(Lookup);
    TupleInstance next = LinkedListIterator_next(itr);
    if(next==NULL){
        printf("The student %s does not exist.\n",name);
    }
    else {
        while (next != NULL) {
            //printf("The student %s exists! \n", name);

            //Get ID
            TupleInstance t1 = next;
            char* id= t1->attributes[0];


            //Search CSG for courses of the student using ID
            TupleInstance search2 = new_Tuple();
            char** st2Att = callocedAtt(csgAttSize);
            st2Att[0] = "*";
            st2Att[1] = id;
            st2Att[2] = "*";
            addAttributes(search2, st2Att, csgAttSize);
            LinkedList Lookup2 = lookup(CSGHash, search2);

            LinkedListIterator itr2 = LinkedList_iterator(Lookup2);
            TupleInstance next2 = LinkedListIterator_next(itr2);

            if(next2 == NULL)
            {
                printf("The student %s with ID %s is not taking any courses.",name, id);
            }
            else {
                while (next2 != NULL){
                    //Get course
                    TupleInstance t2 = next2;
                    char* course = t2->attributes[0];
                    //printf("The student %s is taking course %s! \n", name, course);


                    //Using CDH, get only the courses he is taking offered on day and time
                    TupleInstance search3 = new_Tuple();
                    char** st3Att = callocedAtt(cdhAttSize);
                    st3Att[0] = course;
                    st3Att[1] = day;
                    st3Att[2] = time;
                    addAttributes(search3, st3Att, cdhAttSize);
                    LinkedList Lookup3 = lookup(CDHHash, search3);

                    LinkedListIterator itr3 = LinkedList_iterator(Lookup3);
                    TupleInstance next3 = LinkedListIterator_next(itr3);

                    if (next3 == NULL)  {
                        printf("The student %s is not taking any courses on %s at %s\n", name, day, time);
                        break;
                    }
                    else{
                        while (next3 != NULL){

                            //Get the course(s) offered on day at time
                            TupleInstance t3 = next3;
                            char* fcourse = t3->attributes[0];
                            //printf("The student %s is taking course %s on %s and %s! \n", name, fcourse, day, time);


                            //Using CR, get the rooms
                            TupleInstance search4 = new_Tuple();
                            char** st4Att = callocedAtt(crAttSize);
                            st4Att[0] = fcourse;
                            st4Att[1] = "*";
                            addAttributes(search4, st4Att, crAttSize);
                            LinkedList Lookup4 = lookup(CRHash, search4);

                            LinkedListIterator itr4 = LinkedList_iterator(Lookup4);
                            TupleInstance next4 = LinkedListIterator_next(itr4);

                            if (next4 == NULL){
                                printf("We do not have the information for where the course %s in which %s is enrolled in takes place.\n", fcourse, name);
                            }
                            else{
                                while (next4 != NULL){
                                    //finally get the room
                                    TupleInstance t4 = next4;
                                    char* room = t4->attributes[1];
                                    printf("The student %s is in %s at %s on %s.\n", name, room, time, day);
                                    next4 = LinkedListIterator_next(itr4);
                                }
                            }
                            next3 = LinkedListIterator_next(itr3);
                        }
                    }
                    next2 = LinkedListIterator_next(itr2);
                }
            }
            next = LinkedListIterator_next(itr);
        }
    }


}//end of WSTDQueryHelper

//WHERE is STUDENT at TIME on DAY
void WSTDQuery(Table CSGHash, Table SNAPHash, Table CDHHash, Table CRHash, int csgAttSize,int snapAttSize, int cdhAttSize, int crAttSize)
{
    char name[255], day[255], time[255];

    printf("\nEnter a student's name, a day and a time to find out where they are at that time on that day.\n");
    printf("Enter 'null' for all or one parameter to stop querying.\n\n");

    printf("Student's Name: ");
    fflush(stdin);
    fgets(name, 255, stdin);
    fflush(stdin);
    printf("Day: ");
    fflush(stdin);
    fgets(day, 255, stdin);
    fflush(stdin);
    printf("Time: ");
    fflush(stdin);
    fgets(time, 255, stdin);
    fflush(stdin);

    while((strncmp(name,"null",strlen(name)-1)!=0) && (strncmp(day,"null",strlen(day)-1)!=0) && (strncmp(time,"null",strlen(time)-1)!=0))
    {
        name[strlen(name)-1]='\0';
        day[strlen(day)-1]='\0';
        time[strlen(time)-1]='\0';

        WSTDQueryHelper(name, day, time, CSGHash,SNAPHash, CDHHash, CRHash, csgAttSize,snapAttSize, cdhAttSize, crAttSize);

        printf("\nEnter a student's name, a day and a time to find out where they are at that time on that day.\n");
        printf("Enter 'null' for one or all parameters to stop querying.\n\n");

        printf("Student's Name: ");
        fflush(stdin);
        fgets(name, 255, stdin);
        fflush(stdin);
        printf("Day: ");
        fflush(stdin);
        fgets(day, 255, stdin);
        fflush(stdin);
        printf("Time: ");
        fflush(stdin);
        fgets(time, 255, stdin);
        fflush(stdin);

    }
}

/*Saves relation to a file
  rel is an integer indicating which relation is being written to file
  1- CSG, 2- SNAP, 3-CP, 4-CDH, 5-CR

*/
void writeToFile(Table t, char* filename, int rel)
{
    FILE *f;

    //Create file to store data
    if((f =fopen(filename,"w"))==NULL)
    {
        printf("%s could not be opened.",filename);
    }
    else
    {
        //Write attributes of relation to file
        fwrite(&rel,sizeof(int),1,f);

        //Traverse hashmap of relation and save each tuple to file
        for (int i = 0; i < 1009; i++){
            if(t->Tuples[i] != NULL){
                LinkedList current = t->Tuples[i];
                LinkedListIterator itr = LinkedList_iterator(current);

                TupleInstance next = LinkedListIterator_next(itr);
                while (next != NULL){
                    TupleInstance tu = next;
                    fwrite(&tu,sizeof(struct Tuple),1,f);
                    next = LinkedListIterator_next(itr);
                }
            }
        }
        fclose(f);
    }
}

/*Reads relation information from file into tables*/
Table loadFromFile(char* filename)
{
    FILE *f;
    int rel;//Type of relation being read
    Table t=new_Table();

    //Open file storing data
    if((f =fopen(filename,"r"))==NULL)
    {
        printf("%s could not be opened.",filename);
    }
    else
    {
        if(!feof(f))//If file is not empty
        {
            fread(&rel,sizeof(int),1,f);//Read type of relation from file

            //Create hashtable based on type of information being read
            switch(rel)
            {
                case 1:
                    t=CSG();
                    break;
                case 2:
                    t=SNAP();
                    break;
                case 3:
                    t=CP();
                    break;
                case 4:
                    t=CDH();
                    break;
                case 5:
                    t=CR();
                    break;
            }

            while(!feof(f)) //Read tuples from file
            {
                TupleInstance tu= new_Tuple();
                fread(&tu,sizeof(struct Tuple),1,f);//Read tuple from file

                //Sometimes an error might occur when reading files if you don't have this if statement.
                //I don't remember what causes the error or what the error is but we need this if statement.
                if(!feof(f)){
                    insert(t,tu); //Insert tuple in hashtable
                }
            }
        }
        fclose(f);
    }
    return t;

}

/*Function used to test writing of database to files and loading from file*/
void testFileIO(Table CSGHash,Table SNAPHash, Table CPHash, Table CDHHash, Table CRHash)
{
    //Write to file
    printf("Writing CSG to the file \"csghash.txt\"\n\n");
    writeToFile(CSGHash,"csghash.txt",1);

    printf("Writing SNAP to the file \"snaphash.txt\"\n\n");
    writeToFile(SNAPHash,"snaphash.txt",2);

    printf("Writing CP to the file \"cphash.txt\"\n\n");
    writeToFile(CPHash,"cphash.txt",3);

    printf("Writing CDH to the file \"cdhhash.txt\"\n\n");
    writeToFile(CDHHash,"cdhhash.txt",4);

    printf("Writing CR to the file \"crhash.txt\"\n\n");
    writeToFile(CRHash,"crhash.txt",1);

    //Load from file
    printf("Loading CSG from file\n");
    Table CSGcpy=CSG();
    CSGcpy=loadFromFile("csghash.txt");

    printf("Loading SNAP from file\n");
    Table SNAPcpy=SNAP();
    SNAPcpy=loadFromFile("snaphash.txt");

    printf("Loading CP from file\n");
    Table CPcpy=CP();
    CPcpy=loadFromFile("cphash.txt");

    printf("Loading CDH from file\n");
    Table CDHcpy=CDH();
    CDHcpy=loadFromFile("cdhhash.txt");

    printf("Loading CR from file\n");
    Table CRcpy=CR();
    CRcpy=loadFromFile("crhash.txt");

    //Print tuples from each table
    printf("Printing tuples for each relation obtained by reading from file\n\n");

    printf("CSG\n\n");
    printTable(CSGcpy);
    printf("\nSNAP\n\n");
    printTable(SNAPcpy);
    printf("\nCP\n\n");
    printTable(CPcpy);
    printf("\nCDH\n\n");
    printTable(CDHcpy);
    printf("\nCR\n\n");
    printTable(CRcpy);

}

int main() {
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~PART ONE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    printf("~~~~~~PART ONE~~~~~~\n\n\n\n");


    /*=========== CSG ==========*/
    Table CSGHash = CSG();
    int csgAttSize = 3;
    populateCSG(CSGHash,csgAttSize);
    printf("Six CSG tuples have been inserted! \n");



    /*=========== SNAP ==========*/
    Table SNAPHash=SNAP();
    int snapAttSize=4;
    populateSNAP(SNAPHash,snapAttSize);
    printf("Three SNAP tuples have been inserted! \n");



    /*=========== CP ==========*/
    Table CPHash=CP();
    int cpAttSize=2;
    populateCP(CPHash,cpAttSize);
    printf("Eight CP tuples have been inserted! \n");



    /*=========== CDH ==========*/
    Table CDHHash=CDH();
    int cdhAttSize=3;
    populateCDH(CDHHash,cdhAttSize);
    printf("Six CDH tuples have been inserted! \n");



    /*=========== CR ==========*/
    Table CRHash = CR();
    int crAttSize=2;
    populateCR(CRHash,crAttSize);
    printf("Three CR tuples have been inserted! \n");






    /*=========== EXAMPLE 8.2 ==========*/
    printf("\n\n\nWe will now demonstrate all three operations (insert, lookup, delete)"
           "by performing the operations shown in Example 8.2, as per the teacher's instruction.\n\n");


    printf("8.2(a) lookup((\"CS101\",12345,∗),Course-StudentId-Grade)");
    TupleInstance csgSearch = new_Tuple();
    char** stAtt = callocedAtt(csgAttSize);
    stAtt[0] = "CS101";
    stAtt[1] = "12345";
    stAtt[2] = "*";
    addAttributes(csgSearch, stAtt, csgAttSize);
    lookup_print(lookup(CSGHash, csgSearch));


    printf("\n\n8.2(b) lookup((\"CS205\", \"CS120\"),Course-Prerequisite)");
    TupleInstance cpSearch = new_Tuple();
    char** stAtt2 = callocedAtt(cpAttSize);
    stAtt2[0] = "CS205";
    stAtt2[1] = "CS120";
    addAttributes(cpSearch, stAtt2, cpAttSize);
    lookup_print(lookup(CPHash, cpSearch));
    printf("\nAs you can see, nothing is returned as such a tuple does not exist in CP.\n");


    printf("\n\n8.2(c) delete((\"CS101\",∗),Course-Room)\n");
    TupleInstance crSearchTuple = new_Tuple();
    char** st5Att = callocedAtt(crAttSize);
    st5Att[0] = "CS101";
    st5Att[1] = "*";
    addAttributes(crSearchTuple, st5Att, crAttSize);
    delete(CRHash, crSearchTuple);
    printf("We will now print out the entire CR Table to show that the deletion has indeed occured.\n");
    printTable(CRHash);


    printf("\n\n8.2(d) insert((\"CS205\", \"CS120\"),Course-Prerequisite)\n");
    TupleInstance CP1= new_Tuple();
    char** cpatt = callocedAtt(cpAttSize);
    cpatt[0]="CS205";
    cpatt[1]="CS120";
    addAttributes(CP1,cpatt,cpAttSize);
    insert(CPHash,CP1);
    printf("We will now print out the entire CP Table to show that the insertion has indeed occured.\n");
    printTable(CPHash);


    printf("\n\n8.2(e) insert((\"CS205\", \"CS101\"),Course-Prerequisite)\n");
    TupleInstance CP2= new_Tuple();
    char** cpatt2 = callocedAtt(cpAttSize);
    cpatt2[0]="CS205";
    cpatt2[1]="CS101";
    addAttributes(CP2, cpatt2, cpAttSize);
    insert(CPHash,CP2);
    printf("We will now print out the entire CP Table to show that the insertion has indeed occured.\n");
    printTable(CPHash);




    /*=========== FILE READING & WRITING ==========*/
    printf("\n\nWe will now save the database to files and load from these files.\n");
    //testFileIO(CSGHash,SNAPHash,CPHash,CDHHash,CRHash);


    printf("\n\n\nPress enter to continue to Part 2 (make sure your cursor is here).");
    char enter = 0;
    while (enter != '\r' && enter != '\n') {
        enter = getchar();
    }




    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~PART TWO~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    printf("\n\n\n~~~~~~PART TWO~~~~~~\n\n\n\n");

    printf("Repopulating relations with all data...\n\n");
    populateCSG(CSGHash,csgAttSize);
    populateSNAP(SNAPHash,snapAttSize);
    populateCR(CRHash,crAttSize);
    populateCDH(CDHHash,cdhAttSize);
    populateCP(CPHash,cpAttSize);

    //Querying
    printf("Starting NGC query\n");
    NCGQuery(CSGHash,SNAPHash,csgAttSize,snapAttSize);

    printf("\n\n");

    printf("Starting WSTD query\n");
    WSTDQuery(CSGHash,SNAPHash, CDHHash, CRHash, csgAttSize,snapAttSize, cdhAttSize, crAttSize);


    printf("\n\n\nPress enter to continue to Part 3 (make sure your cursor is here).");
    enter = 0;
    while (enter != '\r' && enter != '\n') {
        enter = getchar();
    }




    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~PART THREE~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    printf("\n\n\n~~~~~~PART THREE~~~~~~\n\n\n\n");


    //Selection
    printf("We will now execute Selection by doing Example 8.12."
           " We will be selecting on CSG and the conditions is Course = \"CS101\" \n");
    char** headers = callocedAtt(csgAttSize);
    headers[0] = "Course";
    char** selectOn2 = callocedAtt(csgAttSize);
    selectOn2[0] = "CS101";
    Table hi = Selection(CSGHash, headers, selectOn2, 1);


    //Projection
    printf("\nWe will now execute Projection by doing Example 8.13."
           " We will be projecting \"StudentId\" from the previously returned table. \n");
    populateSNAP(SNAPHash, snapAttSize);
    char** headers3 = callocedAtt(1);
    headers3[0] = "StudentId";
    Projection(hi, headers3, 1);


    //Join
    printf("\nWe will now execute Join on CR and CDH, as in Example 8.14\n");
    printf("We are joining on the attribute \"Course\".\n");
    Table joined= Join(CRHash,CDHHash, "Course");
    printTable(joined);


    //Select, Project, Join
    populateCR(CRHash, 2);
    populateCDH(CDHHash, 3);
    printf("\n\nExample 8.15: Performing selection, projection and joining on CR and CDH\n"
           "Selecting on Room=\"Turing Aud.\" and Projecting on \"Day\" and \"Hour\"");
    char** headers4 = callocedAtt(1);
    headers4[0]="Room";
    char** selectOn3 = callocedAtt(1);
    selectOn3[0] = "Turing Aud.";

    char** headers5=callocedAtt(2);
    headers5[0] = "Day";
    headers5[1] = "Hour";

    SelectProjectJoin(CRHash,CDHHash,"Course", headers4,selectOn3,1,headers5,2);

    return 0;
}
