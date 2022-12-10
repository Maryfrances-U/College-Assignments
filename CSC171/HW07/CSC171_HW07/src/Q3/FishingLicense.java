import java.time.LocalDate;

/* Maryfrances Umeora
	mumeora
	HW 07
	Lab Times: TR 11:05-12:20
	I did not collaborate with anyone on this assignment.
		   
	This is a child class of License, FishingLicense.
*/
	public class FishingLicense extends License {
		
		String type;
		
		public FishingLicense(String l, LocalDate e, String t) {
			super(l,e);
			type = t;
		}
		
		//toString
		@Override
		public String toString()	{
			return "This is a fishing license. It has the license number " + licNum + 
					". It permits you to catch " + type + ", and expires/expired " + exp + ".";
		}
}
