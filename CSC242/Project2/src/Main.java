import java.io.FileNotFoundException;

/*
Maryfrances Umeora, Kharissa King
mumeora, kking33
CSC 242 Project 2
*/


public class Main {
	
	public static void PartTwo1() {
		//name problem one
		System.out.println("1. {P,P ⇒ Q} |= Q");
		
		//convert problem to conjunctive normal form
		Clause a1 = new Clause();	//p
		a1.addSymbol(1);
		Clause a2 = new Clause();	//NOT p OR q
		a2.addSymbol(-1);
		a2.addSymbol(2);
		Clause aq = new Clause();	//Query
		aq.addSymbol(2);
		
		//The knowledge base a cnf, ie is a1 AND a2
		KnowledgeBase kb1 = new KnowledgeBase();
		kb1.addClause(a1);
		kb1.addClause(a2);
		boolean answer1 = ModelChecker.TTEntails(kb1, aq);
		System.out.println(answer1);
	}
	
	
	public static void PartTwo2() {
		System.out.println("\n\n");
		System.out.println("2. Our background knowledge is: \n"
				+ "¬P1,1 \n"
				+ "B1,1 ⇔ P1,2 ∨ P2,1 \n"
				+ "B2,1 ⇔ P1,1 ∨ P2,2 ∨ P3,1 \n"
				+ "B1,2 ⇔ P1,1 ∨ P2,2 ∨ P1,3 \n"
				+ "The agent starts at [1,1] so ¬B1,1 \n\n");
		
		KnowledgeBase kb = new KnowledgeBase();
		/*P11 -> 1	P12 -> 2	P13 -> 3	P21 -> 4	P22 -> 5	P31 -> 6
		B11 -> 10	B12 -> 11	B21 -> 12	*/
		
		
		/*create all the clauses*/
		//¬P1,1
		Clause a1 = new Clause();	
		a1.addSymbol(-1);
		
		//B1,1 ⇔ P1,2 ∨ P2,1
		Clause a2c1 = new Clause();	//¬B11 ∨ P12 ∨ P21
		a2c1.addSymbol(-10);
		a2c1.addSymbol(2);
		a2c1.addSymbol(4);
		Clause a2c2 = new Clause();	//B11 ∨ ¬P12
		a2c2.addSymbol(10);
		a2c2.addSymbol(-2);
		Clause a2c3 = new Clause();	//B11 ∨ ¬P21
		a2c3.addSymbol(10);
		a2c3.addSymbol(-4);
		
		//B2,1 ⇔ P1,1 ∨ P2,2 ∨ P3,1
		Clause a3c1 = new Clause();	//¬B21 ∨ P11 ∨ P22 ∨ P31
		a3c1.addSymbol(-12);
		a3c1.addSymbol(1);
		a3c1.addSymbol(5);
		a3c1.addSymbol(6);
		Clause a3c2 = new Clause();	//B21 ∨ ¬P11
		a3c2.addSymbol(12);
		a3c2.addSymbol(-1);
		Clause a3c3 = new Clause();	//B21 ∨ ¬P22
		a3c3.addSymbol(12);
		a3c3.addSymbol(-5);
		Clause a3c4 = new Clause();	//B21 ∨ ¬P31
		a3c4.addSymbol(12);
		a3c4.addSymbol(-6);
		
		//B1,2 ⇔ P1,1 ∨ P2,2 ∨ P1,3
		Clause a4c1 = new Clause();	//¬B12 ∨ P11 ∨ P22 ∨ P13
		a4c1.addSymbol(-11);
		a4c1.addSymbol(1);
		a4c1.addSymbol(5);
		a4c1.addSymbol(3);
		Clause a4c2 = new Clause();	//B12 ∨ ¬P11
		a4c2.addSymbol(11);
		a4c2.addSymbol(-1);
		Clause a4c3 = new Clause();	//B12 ∨ ¬P22
		a4c3.addSymbol(11);
		a4c3.addSymbol(-5);
		Clause a4c4 = new Clause();	//B12 ∨ ¬P13
		a4c4.addSymbol(11);
		a4c4.addSymbol(-3);
		
		Clause L11 = new Clause();
		L11.addSymbol(-10);
		
		
		
		
		/*add everything to knowledge base*/
		kb.addClause(a1);
		kb.addClause(a2c1);
		kb.addClause(a2c2);
		kb.addClause(a2c3);
		kb.addClause(a3c1);
		kb.addClause(a3c2);
		kb.addClause(a3c3);
		kb.addClause(a3c4);
		kb.addClause(a4c1);
		kb.addClause(a4c2);
		kb.addClause(a4c3);
		kb.addClause(a4c4);
		kb.addClause(L11);
		
		
		
		System.out.println("Does this knowledge entail ¬P1,2?");	//should be true
		Clause query1 = new Clause();
		query1.addSymbol(-2);
		System.out.println(ModelChecker.TTEntails(kb, query1));
		
		System.out.println("Does this knowledge entail ¬P2,1?");	//should be true
		Clause query2 = new Clause();
		query2.addSymbol(-4);
		System.out.println(ModelChecker.TTEntails(kb, query2));
		
		System.out.println("Does this knowledge entail P2,2?");		//should be false
		Clause query3 = new Clause();
		query3.addSymbol(5);
		System.out.println(ModelChecker.TTEntails(kb, query3));
		
		System.out.println("Does this knowledge entail ¬P2,2?");	//should be false
		Clause query4 = new Clause();
		query4.addSymbol(-5);
		System.out.println(ModelChecker.TTEntails(kb, query4));
		
		
		System.out.println("\n\nThe agent moves to [2,1] so add B2,1");
		Clause L21 = new Clause();
		L21.addSymbol(12);
		kb.addClause(L21);
		
		System.out.println("Does this knowledge entail P2,2 ∨ P3,1?");	//should be true
		Clause query5 = new Clause();
		query5.addSymbol(5);
		query5.addSymbol(6);
		System.out.println(ModelChecker.TTEntails(kb, query5));
		
		System.out.println("Does this knowledge entail P2,2?");		//should be false
		Clause query6 = new Clause();
		query6.addSymbol(5);
		System.out.println(ModelChecker.TTEntails(kb, query6));
		
		System.out.println("Does this knowledge entail ¬P2,2?");	//should be false
		Clause query7 = new Clause();
		query7.addSymbol(-5);
		System.out.println(ModelChecker.TTEntails(kb, query7));
		
		System.out.println("Does this knowledge entail P3,1?");		//should be false
		Clause query8 = new Clause();
		query8.addSymbol(6);
		System.out.println(ModelChecker.TTEntails(kb, query8));
		
		System.out.println("Does this knowledge entail ¬P3,1?");	//should be false
		Clause query9 = new Clause();
		query9.addSymbol(-6);
		System.out.println(ModelChecker.TTEntails(kb, query9));
		
		
		System.out.println("\n\nThe agent moves to [1,2] so add ¬B1,2");
		Clause L12 = new Clause();
		L12.addSymbol(-11);
		kb.addClause(L12);
		
		System.out.println("Does this knowledge entail ¬P2,2?"); //should be true
		Clause query10 = new Clause();
		query10.addSymbol(-5);
		System.out.println(ModelChecker.TTEntails(kb, query10));
		
		System.out.println("Does this knowledge entail P3,1"); //should be true
		Clause query11 = new Clause();
		query11.addSymbol(6);
		System.out.println(ModelChecker.TTEntails(kb, query11));
		
	}
	
	
	public static void PartTwo3() {
		System.out.println("\n\n");
		System.out.println("3. Our background knowledge is: \n"
				+ "Mythicial ⇒ Immortal \n"
				+ "¬Mythical ⇒ ¬Immortal AND Mammal \n"
				+ "(Immortal ∨ Mammal) ⇒ Horned \n"
				+ "Horned ⇒ Magical \n\n");
		
		
		/*M-> Mythical(1)	A-> Magical(2)	 I-> Immortal(3)	J-> Mammal(4)	H->Horned(5)*/
		KnowledgeBase kb = new KnowledgeBase();
		
		
		/*create all the clauses*/
		//M ⇒ I becomes ¬M ∨ I
		Clause a1 = new Clause();	
		a1.addSymbol(-1);
		a1.addSymbol(3);
		
		//¬M ⇒ (¬I ∧ J) becomes (M ∨¬I) ∧ (M∨J)
		Clause a2c1 = new Clause();	//M ∨¬I
		a2c1.addSymbol(1);
		a2c1.addSymbol(-3);
		Clause a2c2 = new Clause();	//M ∨ J
		a2c2.addSymbol(1);
		a2c2.addSymbol(4);
		
		//(I ∨ J) ⇒ H becomes (¬I ∨ H) ∧  (¬J ∨ H)
		Clause a3c1 = new Clause();	//¬I ∨ H
		a3c1.addSymbol(-3);
		a3c1.addSymbol(5);
		Clause a3c2 = new Clause();	//¬J ∨ H
		a3c2.addSymbol(-4);
		a3c2.addSymbol(5);
		
		//H ⇒ A becomes ¬H ∨ A
		Clause a4c1 = new Clause();
		a4c1.addSymbol(-5);
		a4c1.addSymbol(2);
		
		
		/*add all to knowledge base*/
		kb.addClause(a1);
		kb.addClause(a2c1);
		kb.addClause(a2c2);
		kb.addClause(a3c1);
		kb.addClause(a3c2);
		kb.addClause(a4c1);
		
		
		System.out.println("Can we prove that the unicorn is mythical?");	//should be false
		Clause query1 = new Clause();
		query1.addSymbol(1);
		System.out.println(ModelChecker.TTEntails(kb, query1));
		
		System.out.println("Can we prove that the unicorn is magical?");	//should be true
		Clause query2 = new Clause();
		query2.addSymbol(2);
		System.out.println(ModelChecker.TTEntails(kb, query2));
		
		System.out.println("Can we prove that the unicorn is horned?");		//should be true
		Clause query3 = new Clause();
		query3.addSymbol(5);
		System.out.println(ModelChecker.TTEntails(kb, query3));
	}


	//Part 3 #1
	public static void PartThree1()
	{
		System.out.println("1. P1: (x1 v x3 v ¬x4) ^ (x4) ^ (x2 v ¬x3)\n");
		
		//Read in clauses from file
		System.out.println("Reading clauses from the file p1.cnf...");
		
		KnowledgeBase p1 = new KnowledgeBase();
		try {
			p1.readCNFFile("p1.cnf");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		//Conduct satisfiability check
		System.out.println();
		System.out.println("Calling satisfiability checker on P1 with MAXTRIES = 10 and MAXFLIPS = 16.\n");
		SatisfiabilityChecker p1Checker=new SatisfiabilityChecker(p1);
		
		p1Checker.satChecker(10, 16);
		System.out.println();
	}
	
	
	//Part 3 #2
	public static void PartThree2() {
		System.out.println("2. N-Queens for N = 4\n");
		
		//Read in clauses from file
		System.out.println("Testing N=4\n");
		System.out.println("Reading clauses from the file nqueens_4.cnf...");
		
		KnowledgeBase nqueens4 = new KnowledgeBase();
		try {
			nqueens4.readCNFFile("nqueens_4.cnf");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		//Conduct satisfiability check
		System.out.println();
		System.out.println("Calling satisfiability checker on NQueens4 with MAXTRIES = 10 and MAXFLIPS = 16.\n");
		SatisfiabilityChecker nQueens4Checker=new SatisfiabilityChecker(nqueens4);
		
		nQueens4Checker.satChecker(10, 16);
		System.out.println();
		
		/*//Read in clauses from file
		System.out.println("Testing N=12\n");
		System.out.println("Reading clauses from the file nqueens_12.cnf...");
		
		KnowledgeBase nqueens12 = new KnowledgeBase();
		try {
			nqueens12.readCNFFile("nqueens_12.cnf");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		//Conduct satisfiability check
		System.out.println();
		System.out.println("Calling satisfiability checker on NQueens12 with MAXTRIES = 30 and MAXFLIPS = 350.\n"
				+ "This might take a little while...\n");
		SatisfiabilityChecker nQueens12Checker=new SatisfiabilityChecker(nqueens12);
		
		nQueens12Checker.satChecker(30, 350);*/
		System.out.println();
	}
	
	
	//Part 3 #3
	public static void PartThree3() {
		System.out.println("3. Quinn\n");
		
		//Read in clauses from file
		System.out.println("Reading clauses from the file quinn.cnf...");
		
		KnowledgeBase quinn = new KnowledgeBase();
		try {
			quinn.readCNFFile("quinn.cnf");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		//Conduct satisfiability check
		System.out.println();
		System.out.println("Calling satisfiability checker on Quinn with MAXTRIES = 20 and MAXFLIPS = 105.\n");
		SatisfiabilityChecker quinnChecker=new SatisfiabilityChecker(quinn);
		
		quinnChecker.satChecker(20, 105);
		System.out.println();
	}
	
	
	//Part 3 #4
	public static void PartThree4() {
		System.out.println("4. par8-1-c\n");
		
		//Read in clauses from file
		System.out.println("Reading clauses from the file par8-1-c.cnf...");
		
		KnowledgeBase par8_1_c = new KnowledgeBase();
		try {
			par8_1_c .readCNFFile("par8-1-c.cnf");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		
		//Conduct satisfiability check
		System.out.println();
		System.out.println("Calling satisfiability checker on par8-1-c with MAXTRIES = 320 and MAXFLIPS = 2000.\n"
				+ "This might take a little while...\n");
		SatisfiabilityChecker par8_1_cChecker=new SatisfiabilityChecker(par8_1_c);
		
		par8_1_cChecker.satChecker(320, 2000);
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("-----------------------------------");
		System.out.println(" | PART I Representing Clauses |");
		System.out.println("-----------------------------------");
		System.out.println("Done");
		
		
		/*~~~~~~~~~~~~~~~*/
		
		
		System.out.print("\n\n\n");
		System.out.println("----------------------------");
		System.out.println(" | PART II Model Checking|");
		System.out.println("----------------------------");
		System.out.println("");
		
		PartTwo1();
		PartTwo2();
		PartTwo3();
		
		
		/*~~~~~~~~~~~~~~~*/
		
		System.out.print("\n\n\n");
		System.out.println("-------------------------------------");
		System.out.println(" | PART III Satisfiability Testing|");
		System.out.println("-------------------------------------");
		System.out.println("");
		
		//Number 1
		PartThree1();
		
		//N-Queens
		PartThree2();
	
		//Quinn
		PartThree3();
		
		//par8-1-c
		PartThree4();
	}
}