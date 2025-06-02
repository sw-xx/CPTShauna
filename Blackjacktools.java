import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Blackjacktools{
	public static char playtime(Console con){	
	// Setting up 2D Array
	String strcards[][];
	strcards = new String[15][3];
	
	                                                                  // Hard-coding 
	// making the value of the cards
	
	strcards[0][0] = "1";
	strcards[1][0] = "2";
	strcards[2][0] = "3";
	strcards[3][0] = "4";
	strcards[4][0] = "5";
	strcards[5][0] = "6";
	strcards[6][0] = "7";
	strcards[7][0] = "8";
	strcards[8][0] = "9";
	strcards[9][0] = "10";
	strcards[10][0] = "11";
	strcards[11][0] = "12";
	strcards[12][0] = "13";
	strcards[13][0] = "1";
	strcards[14][0] = "2";
	
	
	
	// making the suits of the cards 
		// diamonds suits 
				strcards[0][1] = "diamonds";
				strcards[1][1] = "diamonds";
				strcards[2][1] = "diamonds";
				strcards[3][1] = "diamonds";
				strcards[4][1] = "diamonds";
				strcards[5][1] = "diamonds";
				strcards[6][1] = "diamonds";
				strcards[7][1] = "diamonds";
				strcards[8][1] = "diamonds";
				strcards[9][1] = "diamonds";
				strcards[10][1] = "diamonds";
				strcards[11][1] = "diamonds";
				strcards[12][1] = "diamonds";
		
		// clubs suits 
				strcards[13][1] = "clubs";
				strcards[14][1] = "clubs";
				
	// print out array
	int intcount;
	con.println("test of desk");
	for(intcount = 0; intcount < 15; intcount++){
		con.println(strcards[intcount][0] + " - " + strcards[intcount][1] + " - ");
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
	

