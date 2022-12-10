/* Maryfrances Umeora
   mumeora
   HW 09
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment... unfortunately
*/

//import packages
import bankAccount.*;
import userAccount.*;

public class Q4Main {

	public static void main(String[] args) {
		// Write a main method in the default package that creates and prints an
		// instance of Account each class.

		// bankAccount instance
		bankAccount.Account ba = new bankAccount.Account("Ethan Yang", "\"256 085 999\"", 25);
		System.out.println(ba.toString());

		// computer user account instance
		userAccount.Account cua = new userAccount.Account("doggie", "Eyang33", "********");
		System.out.println(cua.toString());

	}

}
