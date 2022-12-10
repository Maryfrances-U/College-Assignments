/* Maryfrances Umeora
	mumeora
	HW 07
	Lab Times: TR 11:05-12:20
	I did not collaborate with anyone on this assignment.
		   
	This is the parent class License.
*/
import java.time.LocalDate;
public class License {
	
	String licNum;
	LocalDate exp;
	
	//constructor
	public License (String l, LocalDate e)	{
		licNum = l;
		exp = e;
	}
	
	
	//set and get license number
	public void setLicNum(String newLicNum) {
		licNum = newLicNum;
	}
	public String getLicNum() {
		return licNum;
	}

	//set and get expiry date
	public void setExp(LocalDate newExp) {
		exp = newExp;
	}
	public LocalDate getExp() {
		return exp;
	}
	
	
	//Are these licenses equal?
	//Two licenses are te same of they have the same licence number and expiration date
	public boolean equals(License l) {
		if ((this.licNum.equals(l.getLicNum())) && (this.exp.equals(l.getExp()))) {
			return true;
		}
		else
			return false;
	}
	
	//Is this license expired?
	public boolean expired() {
		if (exp.isBefore(LocalDate.now()))	{
			return true;
		}
		else
			return false;
	}
	
	//toString
	public String toString()	{
		return "This is a license. Its license number is " + licNum + ". It expires/expired on " + exp + ".";
	}

}
