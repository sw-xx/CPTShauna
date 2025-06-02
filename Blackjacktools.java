import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Blackjacktools{
	public static char playtime(Console con){
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
	

