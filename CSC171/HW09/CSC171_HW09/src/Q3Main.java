
/* Maryfrances Umeora
   mumeora
   HW 09
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment... unfortunately
*/

import my.players.*; //import package

public class Q3Main {

	public static void main(String[] args) {

		// soccer player instance
		soccerPlayer soc = new soccerPlayer("Dwayne Johnson", "London Socks", "midfielder", "6\'1\"", 240);
		System.out.println(soc.toString());

		System.out.println("");

		// saxophone player instance
		saxPlayer saxp = new saxPlayer("Scarlet Witch", "Old Tubby", "The Screechers", 6);
		System.out.println(saxp.toString("her"));

		System.out.println("");

		// mp3 player instance
		mp3Player mp31 = new mp3Player(32, "red", "Darren", 4);
		mp31.fillSongs();
		System.out.println(mp31.toString());

	}

}
