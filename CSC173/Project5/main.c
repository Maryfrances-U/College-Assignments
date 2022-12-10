/*
 * File: main.c
 * Creator: George Ferguson
 * Editor: Maryfrances Umeora
 * Created: Mon Nov 28 14:11:17 2016
 * Time-stamp: <Tue Jul 17 16:02:29 EDT 2018 ferguson>
 */
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "Circuit.h"


/**
 * Two AND gates connected to make a 3-input AND circuit.
 */
static Circuit* and3_Circuit() {
    Boolean* x = new_Boolean(false);
    Boolean* y = new_Boolean(false);
    Boolean* z = new_Boolean(false);
    Boolean** inputs = new_Boolean_array(3);
    inputs[0] = x;
    inputs[1] = y;
    inputs[2] = z;

    Boolean* out = new_Boolean(false);
    Boolean** outputs = new_Boolean_array(1);
    outputs[0] = out;

    Gate* A1 = new_AndGate();
    Gate* A2 = new_AndGate();
    Gate** gates = new_Gate_array(2);
    gates[0] = A1;
    gates[1] = A2;

    Circuit *circuit = new_Circuit(3, inputs, 1, outputs, 2, gates);
    Circuit_connect(circuit, x, Gate_getInput(A1, 0));
    Circuit_connect(circuit, y, Gate_getInput(A1, 1));
    Circuit_connect(circuit, Gate_getOutput(A1), Gate_getInput(A2, 0));
    Circuit_connect(circuit, z, Gate_getInput(A2, 1));
    Circuit_connect(circuit, Gate_getOutput(A2), out);
    return circuit;
}

/**
 * The First Circuit
 */
static Circuit* circuitA(){
    //set up the inputs
    Boolean* x = new_Boolean(false);
    Boolean* y = new_Boolean(false);
    Boolean* z = new_Boolean(false);
    Boolean** inputs = new_Boolean_array(3);
    inputs[0] = x;
    inputs[1] = y;
    inputs[2] = z;

    //set up the output
    Boolean* out = new_Boolean(false);
    Boolean** outputs = new_Boolean_array(1);
    outputs[0] = out;

    //create gates
    Gate* NOT = new_Inverter();
    Gate* A1 = new_AndGate();
    Gate* A2 = new_AndGate();
    Gate* OR = new_OrGate();
    Gate** gates = new_Gate_array(4);
    gates[0] = NOT;
    gates[1] = A1;
    gates[2] = A2;
    gates[3] = OR;

    //Create the circuit
    Circuit *circuit = new_Circuit(3, inputs, 1, outputs, 4, gates);
    Circuit_connect(circuit, x, Gate_getInput(A1, 0));
    Circuit_connect(circuit, y, Gate_getInput(NOT, 0));
    Circuit_connect(circuit, Gate_getOutput(NOT), Gate_getInput(A1, 1));
    Circuit_connect(circuit, y, Gate_getInput(A2, 0));
    Circuit_connect(circuit, z, Gate_getInput(A2, 1));
    Circuit_connect(circuit, Gate_getOutput(A1), Gate_getInput(OR, 0));
    Circuit_connect(circuit, Gate_getOutput(A2), Gate_getInput(OR, 1));
    Circuit_connect(circuit, Gate_getOutput(OR), out);

    return circuit;
}


/**
 * The Second Circuit
*/
Circuit* circuitB(){
    Boolean* x = new_Boolean(false);
    Boolean* y = new_Boolean(false);
    Boolean* z = new_Boolean(false);
    Boolean** inputs = new_Boolean_array(3);
    inputs[0] = x;
    inputs[1] = y;
    inputs[2] = z;

    Boolean* out = new_Boolean(false);
    Boolean** outputs = new_Boolean_array(1);
    outputs[0] = out;

    Gate* NOT = new_Inverter();
    Gate* NAND1_And = new_AndGate();
    Gate* NAND1_Not = new_Inverter();
    Gate* NAND2_And = new_AndGate();
    Gate* NAND2_Not = new_Inverter();
    Gate* NOR_Or = new_OrGate();
    Gate* NOR_Not = new_Inverter();
    Gate** gates = new_Gate_array(7);
    gates[0] = NOT;
    gates[1] = NAND1_And;
    gates[2] = NAND1_Not;
    gates[3] = NAND2_And;
    gates[4] = NAND2_Not;
    gates[5] = NOR_Or;
    gates[6] = NOR_Not;


    //Create the circuit
    Circuit *circuit = new_Circuit(3, inputs, 1, outputs, 7, gates);

    //x to NAND1
    Circuit_connect(circuit, x, Gate_getInput(NAND1_And, 0));

    //y to NOT, then NAND1
    Circuit_connect(circuit, y, Gate_getInput(NOT, 0));
    Circuit_connect(circuit, Gate_getOutput(NOT), Gate_getInput(NAND1_And, 1));
    Circuit_connect(circuit, Gate_getOutput(NAND1_And), Gate_getInput(NAND1_Not, 0));

    //y also to NAND2
    Circuit_connect(circuit, y, Gate_getInput(NAND2_And, 0));

    //z to NAND2
    Circuit_connect(circuit, z, Gate_getInput(NAND2_And, 1));
    Circuit_connect(circuit, Gate_getOutput(NAND2_And), Gate_getInput(NAND2_Not, 0));

    //NAND1_Not and NAND2_Not to NOR
    Circuit_connect(circuit, Gate_getOutput(NAND1_Not), Gate_getInput(NOR_Or, 0));
    Circuit_connect(circuit, Gate_getOutput(NAND2_Not), Gate_getInput(NOR_Or, 1));
    Circuit_connect(circuit, Gate_getOutput(NOR_Or), Gate_getInput(NOR_Not, 0));

    //NOR to output
    Circuit_connect(circuit, Gate_getOutput(NOR_Not), out);

    return circuit;

}


/**
 * The Third Circuit
*/
Circuit* circuitC(){
    Boolean* x = new_Boolean(false);
    Boolean* y = new_Boolean(false);
    Boolean** inputs = new_Boolean_array(2);
    inputs[0] = x;
    inputs[1] = y;

    Boolean* out = new_Boolean(false);
    Boolean** outputs = new_Boolean_array(1);
    outputs[0] = out;

    Gate* AND1 = new_AndGate();
    Gate* NOT1 = new_Inverter();
    Gate* NOT2 = new_Inverter();
    Gate* AND2 = new_AndGate();
    Gate* OR = new_OrGate();
    Gate** gates = new_Gate_array(5);
    gates[0] = AND1;
    gates[1] = NOT1;
    gates[2] = NOT2;
    gates[3] = AND2;
    gates[4] = OR;


    //return circuit;
    Circuit *circuit = new_Circuit(2, inputs, 1, outputs, 5, gates);

    //y to AND1(A) and NOT2(C)
    Circuit_connect(circuit, y, Gate_getInput(AND1, 0));
    Circuit_connect(circuit, y, Gate_getInput(NOT2, 0));

    //x to AND1(A) and NOT1(B)
    Circuit_connect(circuit, x, Gate_getInput(AND1, 1));
    Circuit_connect(circuit, x, Gate_getInput(NOT1, 0));

    //NOT1(B) and NOT2(C) to AND2(D)
    Circuit_connect(circuit, Gate_getOutput(NOT1), Gate_getInput(AND2, 0));
    Circuit_connect(circuit, Gate_getOutput(NOT2), Gate_getInput(AND2, 1));

    //AND1(A) and AND2(D) to OR(E)
    Circuit_connect(circuit, Gate_getOutput(AND1), Gate_getInput(OR, 0));
    Circuit_connect(circuit, Gate_getOutput(AND2), Gate_getInput(OR, 1));

    //OR to output(z)
    Circuit_connect(circuit, Gate_getOutput(OR), out);

    return circuit;
}


/**
 * BONUS
*/
Circuit* oneBitAdder(){
    Boolean* x = new_Boolean(false);
    Boolean* y = new_Boolean(false);
    Boolean* c = new_Boolean(false);
    Boolean** inputs = new_Boolean_array(3);
    inputs[0] = x;
    inputs[1] = y;
    inputs[2] = c;


    Boolean* z = new_Boolean(false);
    Boolean* d = new_Boolean(false);
    Boolean** outputs = new_Boolean_array(2);
    //make sure to print d before z
    outputs[0] = d;
    outputs[1] = z;


    Gate* NOT1 = new_Inverter();
   	Gate* NOT2 = new_Inverter();
    Gate* NOT3 = new_Inverter();
    Gate* AND1 = new_And3Gate();
    Gate* AND2 = new_And3Gate();
    Gate* AND3 = new_And3Gate();
    Gate* AND4 = new_And3Gate();
    Gate* AND5 = new_And3Gate();
    Gate* AND6 = new_And3Gate();
    Gate* AND7 = new_And3Gate();
    Gate* OR1 = new_Or4Gate();
    Gate* OR2 = new_Or4Gate();
    Gate** gates = new_Gate_array(12);	//Sets up 12 gates
    gates[0] = NOT1;
    gates[1] = NOT2;
    gates[2] = NOT3;
    gates[3] = AND1;
    gates[4] = AND2;
    gates[5] = AND3;
    gates[6] = AND4;
    gates[7] = AND5;
    gates[8] = AND6;
    gates[9] = AND7;
    gates[10] = OR1;
    gates[11] = OR2;

	Circuit *circuit = new_Circuit(3, inputs, 2, outputs, 12, gates);

	 //x to NOT1, y to NOT2, c to NOT3
	Circuit_connect(circuit, x, Gate_getInput(NOT1, 0));
	Circuit_connect(circuit, y, Gate_getInput(NOT2, 0));
	Circuit_connect(circuit, c, Gate_getInput(NOT3, 0));

	//everything going into AND1
	Circuit_connect(circuit, Gate_getOutput(NOT1), Gate_getInput(AND1, 0));
	Circuit_connect(circuit, Gate_getOutput(NOT2), Gate_getInput(AND1, 1));
	Circuit_connect(circuit, c, Gate_getInput(AND1, 2));

	//everything going into AND2
	Circuit_connect(circuit, Gate_getOutput(NOT1), Gate_getInput(AND2, 0));
	Circuit_connect(circuit, y, Gate_getInput(AND2, 1));
	Circuit_connect(circuit, Gate_getOutput(NOT3), Gate_getInput(AND2, 2));

	//everything going into AND3
	Circuit_connect(circuit, Gate_getOutput(NOT1), Gate_getInput(AND3, 0));
	Circuit_connect(circuit, y, Gate_getInput(AND3, 1));
	Circuit_connect(circuit, c, Gate_getInput(AND3, 2));

	//everything going into AND4
	Circuit_connect(circuit, x, Gate_getInput(AND4, 0));
	Circuit_connect(circuit, Gate_getOutput(NOT2), Gate_getInput(AND4, 1));
	Circuit_connect(circuit, Gate_getOutput(NOT3), Gate_getInput(AND4, 2));

	//everything going into AND5
	Circuit_connect(circuit, x, Gate_getInput(AND5, 0));
	Circuit_connect(circuit, Gate_getOutput(NOT2), Gate_getInput(AND5, 1));
	Circuit_connect(circuit, c, Gate_getInput(AND5, 2));

	//everything going into AND6
	Circuit_connect(circuit, x, Gate_getInput(AND6, 0));
	Circuit_connect(circuit, y, Gate_getInput(AND6, 1));
	Circuit_connect(circuit, Gate_getOutput(NOT3), Gate_getInput(AND6, 2));

	//everything going into AND7
	Circuit_connect(circuit, x, Gate_getInput(AND7, 0));
	Circuit_connect(circuit, y, Gate_getInput(AND7, 1));
	Circuit_connect(circuit, c, Gate_getInput(AND7, 2));

	//AND1,2,4,7 to OR1
	Circuit_connect(circuit, Gate_getOutput(AND1), Gate_getInput(OR1, 0));
	Circuit_connect(circuit, Gate_getOutput(AND2), Gate_getInput(OR1, 1));
	Circuit_connect(circuit, Gate_getOutput(AND4), Gate_getInput(OR1, 2));
	Circuit_connect(circuit, Gate_getOutput(AND7), Gate_getInput(OR1, 3));

	//AND3,5,6,7 to OR2
	Circuit_connect(circuit, Gate_getOutput(AND3), Gate_getInput(OR2, 0));
	Circuit_connect(circuit, Gate_getOutput(AND5), Gate_getInput(OR2, 1));
	Circuit_connect(circuit, Gate_getOutput(AND6), Gate_getInput(OR2, 2));
	Circuit_connect(circuit, Gate_getOutput(AND7), Gate_getInput(OR2, 3));


	//OR1 to z and OR2 to d
	Circuit_connect(circuit, Gate_getOutput(OR1), z);
	Circuit_connect(circuit, Gate_getOutput(OR2), d);

	return circuit;


}



//Testing Stuff
static char* b2s(bool b) {
    return b ? "T" : "F";
}


static void test3In1Out(Circuit* circuit, bool in0, bool in1, bool in2) {
    Circuit_setInput(circuit, 0, in0);
    Circuit_setInput(circuit, 1, in1);
    Circuit_setInput(circuit, 2, in2);
    Circuit_update(circuit);
    bool out0 = Circuit_getOutput(circuit, 0);
    printf("%s %s %s -> %s\n", b2s(in0), b2s(in1), b2s(in2), b2s(out0));
}


int toBinary(int n){
    if (n < 2){
        return n;
    }
    return toBinary(n/2) * 10 + n%2;
}


void tester(Circuit* circuit);
void testerHelper(Circuit* circuit, int i);

//this is the one we call first
void tester(Circuit* circuit){
    int num = Circuit_numInputs(circuit);

    for(int i = 0; i < 1<< num; i++){
        testerHelper(circuit, toBinary(i));
    }
}

void testerHelper(Circuit* circuit, int inputBinary){
    int num = Circuit_numInputs(circuit);
    int temp = inputBinary;

    //how we're sending in the input
    for (int i = 0; i < num; i++){
        //Circuit_setInput(Circuit* this, int index, bool value)
        Circuit_setInput(circuit, i, inputBinary%10);
        inputBinary = inputBinary/10;
    }

    //save our changes
    Circuit_update(circuit);

    //now print out exactly what we're testing
    for (int i = 0; i < num; i++){
        printf("%s ",b2s(temp % 10));
        temp = temp/10;
    }
    printf("->");

    //then print out the answer (for any number of outputs)
    for(int j = 0; j < Circuit_numOutputs(circuit); j++)    {
        printf("%s", b2s(Circuit_getOutput(circuit, j)));
    }
    printf("\n");
}




int main(int argc, char **argv) {
    Circuit* and3 = and3_Circuit();
    printf("The and3 and3 (AND of three inputs):\n");
    //Circuit_dump(and3);
    printf("\n");
    printf("Testing: Some input(s) false: should be false\n");
    test3In1Out(and3, true, true, false);
    printf("Testing: All inputs true: should be true\n");
    test3In1Out(and3, true, true, true);
    printf("Note: Your program needs to test all possible combinations of input values,\nin order from all false to all true, using a single function.\n");
    Circuit_free(and3);


    printf("\n\n");
    Circuit* circA = circuitA();
    printf("Part A:\n");
    //Circuit_dump(circA);
    printf("\n");
    tester(circA);
    Circuit_free(circA);


    printf("\n\n");
    Circuit* circB = circuitB();
    printf("Part B:\n");
    tester(circB);
    Circuit_free(circB);


    printf("\n\n");
    Circuit* circC = circuitC();
    printf("Part C:\n");
    tester(circC);
    Circuit_free(circC);


    printf("\n\n");
    Circuit* oba = oneBitAdder();
    printf("BONUS - One Bit Adder:\n");
    tester(oba);
    Circuit_free(oba);
}
