import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Blackjacktools{
	public static char playtime(Console con){	
		
	// Setting up 2D Array
	String[][] deck = new String[52][3];
	String[] suits = {"diamonds", "clubs", "hearts", "spades"};
	
	// creating desk 
	int intcount;
	for(intcount = 0; intcount < 52; intcount++){
		deck[intcount][0] = "" + ((intcount % 13) + 1); // this would make the value 1 to 13 
		deck[intcount][1] = suits[intcount / 13]; // 13 of each suit 
		deck[intcount][2] = "" + (Math.random()); // random number for shuffling 
		System.out.println("Card "+(intcount + 1) + ": " + deck[intcount][0] + " of " + deck[intcount][1]);
	}
	
	//bubble sorting 
	
		// temporary values 
			String strtempvalue;
			String strtempsuit;
			String strtemprandom;
		
	for(int pass = 0; pass < 52 - 1; pass++){
		for(intcount = 0; intcount < 52 - 1; intcount++){
			if(Double.parseDouble(deck[intcount][2]) > Double.parseDouble(deck[intcount + 1][2])){
				// swapping value 
				strtempvalue = deck[intcount][0];
				deck[intcount][0] = deck[intcount + 1][0];
				deck[intcount+1][0] = strtempvalue;
				
				// swapping suits
				strtempsuit = deck[intcount][1];
				deck[intcount][1] = deck[intcount+1][1];
				deck[intcount+1][1] = strtempsuit;
				
				//swap random number 
				strtemprandom = deck[intcount][2];
				deck[intcount][2] = deck[intcount+1][2];
				deck[intcount+1][2] = strtemprandom; 
			}
		}
	}

	System.out.println("\nAfter Sorting (shuffled): " );
	for(intcount = 0; intcount < 52; intcount++){
		System.out.println("card " + (intcount + 1) + ": " + deck[intcount][0] + " of " + deck[intcount][1] + " - " + deck[intcount][2]);
	}	
	
	// setting up the player and dealer hand 
	String[][] playerhand = new String[5][2];
	String[][] dealerhand = new String[5][2];
	
	for(intcount = 0; intcount < 5; intcount++){
		playerhand[intcount][0] = deck[intcount][0];
		playerhand[intcount][1] = deck[intcount][1];
		
		dealerhand[intcount][0] = deck[intcount + 5][0];
		dealerhand[intcount][1] = deck[intcount + 5][1];
	}
		 
	con.println("PLAYER hand: ");
	for(intcount = 0; intcount < 5; intcount++){
		con.println(" ");
		con.println(playerhand[intcount][0] + " of " + playerhand[intcount][1]);
	}
	con.println(" ");
	con.println(" ");
	con.println(" ");

	con.println("DEALER hand: ");
	for(intcount = 0; intcount < 5; intcount++){
		con.println(" ");
		con.println(dealerhand[intcount][0] + " of " + dealerhand[intcount][1]);
		
		}
		
		char charkey = con.getChar();
		return charkey;

	}
	
	public static char leaderboard(Console con){
		char charl = con.getChar();
		return charl;
	}
	
	public static char help(Console con){
		
		con.println("Here are some of the special features that make the game called BlackJack");
		con.println(" ");
		con.println(" ");
		con.println("1. Double Down -- if the first two cards add up to 9, 10, 11 you x2 your bet and you hit again");
		con.println("2. Five Card -- if you bust at five , you get x3 the amount of money even if you don't hit 21");
		con.println("   a) BUT if the dealer does it to you - you lose your money");
		con.println("3. If your first two cards equals to 21, you multiply 3x your original bet");
	
			char charkeyhelp = con.getChar();

			return charkeyhelp;

	}

	public static char quit(Console con){
		char charq = con.getChar();
		return charq;
	}

}

	

	
	
	
	

