import java.time.LocalDate;

/* Maryfrances Umeora
	mumeora
	HW 07
	Lab Times: TR 11:05-12:20
	I did not collaborate with anyone on this assignment.
		   
	This is a child class of License, DriversLicense.
*/
public class DriversLicense extends License{
	
	//instance variable
	String stateIssue;
	
	//constructor
	public DriversLicense(String l, LocalDate e, String s)	{
		super(l,e);
		stateIssue = s;
	}
	
	
	//setters and getters
	public void setStateIssue(String newStateIssue)	{
		stateIssue = newStateIssue;
	}
	public String getStateIssue()	{
		return stateIssue;
	}
	
	
	//driver's licenses rules differ from state to state, so they are only equal if they have the same lic#, exp date & state of issue
	@Override
	public boolean equals(License d) {
		DriversLicense d2 = (DriversLicense) d;
		if ((licNum.equals(d2.getLicNum())) && (exp.equals(d2.getExp())) && (stateIssue.equals(d2.getStateIssue()))) {
			return true;
		}
		else
			return false;
	}
	
	@Override
	//toString
	public String toString()	{
			return "This driver's license has the license number " + licNum + 
					", was issued in " + stateIssue + ", and expires/expired " + exp + ".";
		}
	

}
