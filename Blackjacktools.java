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
		 
	System.out.println("\nPLAYER hand: ");
	for(intcount = 0; intcount < 5; intcount++){
		con.println(" ");
		System.out.println(playerhand[intcount][0] + " of " + playerhand[intcount][1]);
	}
	con.println(" ");
	con.println(" ");
	con.println(" ");

	System.out.println("\nDEALER hand: ");
	for(intcount = 0; intcount < 5; intcount++){
		con.println(" ");
		System.out.println(dealerhand[intcount][0] + " of " + dealerhand[intcount][1]);
		
		}
		
		con.clear();
	//note for players 
	con.println("**Try not to get confused with the total. Remember that 11, 12, 13 = 10 and that a 1 is sometimes = 11");	
	
	// player first two cards
	int intplayer2 = 0;
	int intcardsused = 2;
	
	con.println("\nDealers Hand");
	con.println(deck[5][0] + " of " + deck[5][1]); // dealers first card 
	con.println("next card - hidden");
	
	con.println("\nPlayers Hand");
	for(intcount = 0; intcount < 2; intcount++){
		con.println(deck[intcount][0] + " of " + deck[intcount][1]);
		int intcardvalue = Integer.parseInt(deck[intcount][0]);
			
		if(intcardvalue > 10){
			intcardvalue = 10;
		}
		else if(intcardvalue == 1){
			intcardvalue = 11;
		}
					intplayer2 += intcardvalue; // totalling the first two cards

	}
	
	con.println("Total: " + intplayer2);
	
	// Players turn 
	boolean blnstandings = false;
	while(intplayer2 < 21 && !blnstandings && intcardsused < 5){
		con.println("\n(H)Hit or (S)Stand");
		char charchoice = con.getChar();
		
	if(charchoice == 'H' || charchoice == 'h'){ // if they press hit 
		
		
		//drawing after two given cards -- still player round 
		con.println("\nThird card: " + deck[intcardsused][0] + " of " + deck[intcardsused][1]);
		int intcardvalue  = Integer.parseInt(deck[intcardsused][0]);
		
		if(intcardvalue > 10){
			intcardvalue = 10;
		}else if(intcardvalue == 1){
			intcardvalue = 11;
		}
		intplayer2 += intcardvalue;
		intcardsused++;
		con.println("New Total: " + intplayer2);
		
		if(intplayer2 > 21){
			con.println("\nBust! You lose");
			return con.getChar();
		}
		
	}else if(charchoice == 's' || charchoice == 'S'){
		blnstandings = true;
	}
}
	// Dealers turn whether bust or hit 
	con.println("\nDealer Round");
	int intdealer = 0;
	
	for(intcount = 0; intcount < 2; intcount++){
		con.println(deck[5 + intcount][0] + " of " + deck[ 5 + intcount][1]);
		
		int intcardvalue = Integer.parseInt(deck[intcount + 1][0]);
		if(intcardvalue > 10){
			intcardvalue = 10;
		}else if(intcardvalue == 1){
			intcardvalue = 11;
		}
		
		intdealer += intcardvalue;
	}
	
	int intdealercardsused = 2;
	
	con.println("Dealers Total: "+intdealer);
	
	// more cards after > 17 
	while(intdealer < 17 && intdealercardsused < 5){
		con.println("\nDrawing...");
		
		String strcard = deck[5 + intdealercardsused][0];
		String strsuit = deck[5 + intdealercardsused][1];
		
		con.println(strcard + " of " + strsuit);
		
		int intcardvalue = Integer.parseInt(strcard);
		if(intcardvalue > 10){
			intcardvalue = 10;
		}else if(intcardvalue == 1){
			intcardvalue = 11;
		}
		intdealer += intcardvalue;
		intdealercardsused++;
	
		con.println("Dealer total: " + intdealer);
		
		if(intdealer > 21){
			con.println("\nDealer busts! Player wins");
			return con.getChar();
		}
	}
	
	if(intdealer >= intplayer2){
		con.println("Dealer wins with " + intdealer + " vs yours " + intplayer2);
	}else{
		con.println("You win with "  + intplayer2 + " vs dealers " + intdealer);
	}
	return con.getChar();	
		
		
	

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



	

	
	
	
	

