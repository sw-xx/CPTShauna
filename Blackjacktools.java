import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Blackjacktools{
	public static char playtime(Console con){	
	// Setting up 2D Array
	String strcards[][];
	strcards = new String[52][3];
	
	String[] suits = {"diamonds", "clubs", "hearts", "spades"};
	String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
	
	int intcount;
	
	for(intcount = 0; intcount < 52; intcount++){
		strcards[intcount][0] = ranks[intcount % 13];
		strcards[intcount][1] = suits[intcount / 13];
	}
	for(intcount = 0; intcount < 52; intcount++){
		System.out.println(strcards[intcount][0] + " - " + strcards[intcount][1]);

	// Another 2D Array - one for DEALER, one for PLAYER 
	
	



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
	

