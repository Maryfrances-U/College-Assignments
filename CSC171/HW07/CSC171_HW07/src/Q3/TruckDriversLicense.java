import java.time.LocalDate;

/* Maryfrances Umeora
	mumeora
	HW 07
	Lab Times: TR 11:05-12:20
	I did not collaborate with anyone on this assignment.
		   
	This is a child class of DriversLicense, TruckDriversLicense.
*/
public class TruckDriversLicense extends DriversLicense {
	
	public TruckDriversLicense (String l, LocalDate e, String s)	{
		super (l,e,s);
	}
	
	@Override
	//toString
		public String toString()	{
			return "This truck driver's license has the license number " + licNum + 
					", was issued in " + stateIssue + ", and expires/expired " + exp + ".";
		}

}
