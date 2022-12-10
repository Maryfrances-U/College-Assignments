/* Maryfrances Umeora
   mumeora
   HW 09
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment... unfortunately
*/

package bankAccount;

import java.text.DecimalFormat;
public class Account {
	
	//just creating decimal format over here
	DecimalFormat df = new DecimalFormat("0.00");
	
	//instance variables
	String owner;
	String acctNum;
	double balance;
	
	
	//constructor
	public Account(String o, String a, double b)	{
		owner = o;
		acctNum = a;
		balance = b;
	}
	
	
	//setters and getters
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	//toString
	public String toString()	{
		return "This bank account belongs to " + owner + ". The account number is " + acctNum + " and there is $" + df.format(balance) + " left in the account.";
	}

}
