import java.time.LocalDate;

public class ArticleMain {

	public static void main(String[] args) {
		/* Maryfrances Umeora
		   mumeora
		   HW 06
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		   
		   This Main program creates two instances of the Article class, then uses the class' methods to change at least one of them.
		*/
		
		
		//Instance 1
		Article myArticle1 = new Article("Rainbow Sunshine");
		myArticle1.setLikes(203);
		myArticle1.setText("\"Rainbows and unicorns will take over the world!\"");
		System.out.println(myArticle1.toString());
		
		//Changing my instance with the unlike method with Instance 1
		myArticle1.Unlike();
		System.out.println("You have unliked " + myArticle1.getName() + "'s article. She now has " + myArticle1.getLikes() + " likes.");
		System.out.println(myArticle1.toString());
		
		
		System.out.println("");
		
		
		//Instance 2
		Article myArticle2 = new Article("I. M. Magnificent", LocalDate.now());
		myArticle2.setLikes(1244);
		myArticle2.setText("\"Computer Science is the best thing that's ever happened to the world.\"");
		System.out.println(myArticle2.toString());
		
		//Changing another one of my instances
		myArticle2.setName("I. M. Marvelous");
		System.out.println(myArticle2.toString());
		

	}

}
