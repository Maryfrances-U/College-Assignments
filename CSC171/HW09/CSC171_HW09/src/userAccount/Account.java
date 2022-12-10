/* Maryfrances Umeora
   mumeora
   HW 09
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment... unfortunately
*/

package userAccount;

public class Account {
	
	//instance variables
	String profIm;
	String username;
	String password;
	
	
	//constructor
	public Account (String p, String u, String pass)	{
		profIm = p;
		username = u;
		password = pass;
	}


	//Setters and Getters
	public String getProfIm() {
		return profIm;
	}
	public void setProfIm(String profIm) {
		this.profIm = profIm;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//toString
	public String toString()	{
		return "This computer user account is identified by the " + profIm + " profile picture." +
				" The user's username is " + username + " and the password is represented by " + password;
	}
	
	
	

}
