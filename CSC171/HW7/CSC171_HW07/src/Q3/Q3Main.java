import java.time.LocalDate;
public class Q3Main {

	public static void main(String[] args) {
		/* Maryfrances Umeora
		   mumeora
		   HW 07
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		   
		   This Main program implements and tests the classes License, DriversLicense, TruckDriversLicense and FishingLicense.
		 */
		
		LocalDate exp1 = LocalDate.now().plusYears(1);
		LocalDate exp2 = LocalDate.now().plusMonths(5);
		LocalDate exp3 = LocalDate.now().plusDays(3);
		LocalDate exp4 = LocalDate.now().minusDays(2);
		
		
		//create new license
		License myLic1 = new License("155X-2344", exp1);
		System.out.println(myLic1);	//for writer's discretion: this infers that you're calling the toString() method
		
		System.out.println(" ");
		
		
		//create new license that is a driver's license
		License myLic2 = new DriversLicense("34BJ-4592", exp1, "Arizona");
		System.out.println(myLic2.toString());
		
		System.out.println(" ");
		
		
		//create new driver's license
		DriversLicense myLic3 = new DriversLicense("34I5-3809", exp4, "Washington");
		System.out.println(myLic3.toString());
			//check if expired
			if (myLic3.expired())	{
				System.out.println("This license is expired.");
			}
			else
				System.out.println("This license is still valid.");
		
		System.out.println(" ");
		
		
		//create new driver's license that is a truck driving license and check if equal with previous license, myLic3
		DriversLicense myLic4 = new TruckDriversLicense("5782-09Q2", exp3, "South Dakota");
		System.out.println(myLic4.toString());
			//check if equal
			if (myLic4.equals(myLic3)){
				System.out.println("This license is equal to the previous one.");
			}
			else 
				System.out.println("This license isn't equal to the previous one.");
		
		System.out.println(" ");
		
		
		//create new fishing license and check if expired (no)
		FishingLicense myLic5 = new FishingLicense("0087-W345", exp2, "trout");
		System.out.println(myLic5.toString());
			//check if expired
			if (myLic5.expired())	{
				System.out.println("This license is expired.");
			}
			else
				System.out.println("This license is still valid.");
			
	}

}
