import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Blackjacktools{
	public static double playtime(Console con, String strname, double dblbetamount){	
	
	double dblamount = 1000;
	con.print("Enter your bet amount: ");
	double dblbet = con.readDouble();
	
	
	boolean blndoubledown = false;
	boolean blnfivecardbonus = false;
		
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
	
	// special rules 
	if(intplayer2 == 9 || intplayer2 == 10 || intplayer2 == 11){
		con.println("\nYou have " + intplayer2 + ". Would you like to double your bet and draw one card only? (Y/N)");
		char chardouble = con.getChar();
		if(chardouble == 'y' || chardouble == 'Y'){
			blndoubledown = true;
			dblbetamount  = dblbet * 2;
			con.println("You doubled your bet to $" + dblbetamount);

			// one more card 
			con.println("\nYour draw: " + deck[intcardsused][0] + " of " + deck[intcardsused][1]);
			int intcardvalue = Integer.parseInt(deck[intcardsused][0]);
			if(intcardvalue > 10){
				intcardvalue = 10;
			}else if(intcardvalue == 1){
				intcardvalue = 11;
			}
			
			intplayer2 += intcardvalue;
			intcardsused++;

			con.println("New Total: " + intplayer2);
			
		}
	}

	// Bonus
	if(intplayer2 == 21 && !blndoubledown){
		con.println("\nBLACKJACK! You win 3x your bet.");
		dblbetamount = dblbet * 3;
		con.println("Player wins against dealer.");
	}else if(Integer.parseInt(deck[5][0]) + Integer.parseInt(deck[6][0]) == 21){
		con.println("\nDealer hits blackjack. You lose. Dealer wins against Player");
		dblbet = dblamount - dblbet;
		con.println("You have now no money");

	}

	// Regular Player turn 
	boolean blnstandings = false;
	if(!blndoubledown && intplayer2 < 21){
		while(intplayer2 < 21 && !blnstandings && intcardsused < 5){
			con.println("\n(H)Hit or (S)Stand");
			char charchoice = con.getChar();
			if(charchoice == 'H' || charchoice == 'h'){
				con.println("\nCard: " + deck[intcardsused][0] + " of " + deck[intcardsused][1]);
				int intcardvalue = Integer.parseInt(deck[intcardsused][0]);
				if(intcardvalue > 10){
					intcardvalue = 10;
				}else if(intcardvalue == 1){
					intcardvalue = 11;
				}
				intplayer2 += intcardvalue;
				intcardsused++;
				con.println("New Total: " + intplayer2);

				if(intplayer2 > 21){
					con.println("\nBust! You lose.");
					dblamount = 0;
					con.println("Dealer wins against player.");
					con.println("you have now no money: $"+dblamount);

				}
			}else if(charchoice == 'S' || charchoice == 's'){
				blnstandings = true;
			}
		}
	}

	if(intcardsused == 5 && intplayer2 <= 21){
		con.println("\nFIVE CARD RULE! You win 3x your bet.");
		dblbetamount = dblbet * 3;
		blnfivecardbonus = true;
		con.println("Player wins against dealer.");
	

	}

	con.println("\nDealer's Turn:");
	int intdealer = 0;
	int intdealercardsused = 2;

	for(int i = 0; i < 2; i++){
		con.println(deck[5 + i][0] + " of " + deck[5 + i][1]);
		int intcardvalue = Integer.parseInt(deck[5 + i][0]);
		if(intcardvalue > 10){
			intcardvalue = 10;
		}else if(intcardvalue == 1){
			intcardvalue = 11;
		}
		intdealer += intcardvalue;
	}
	con.println("Dealer total: " + intdealer);

	while(intdealer < 17 && intdealercardsused < 5){
		con.println("\nDealer draws...");
		con.println(deck[5 + intdealercardsused][0] + " of " + deck[5 + intdealercardsused][1]);
		int intcardvalue = Integer.parseInt(deck[5 + intdealercardsused][0]);
		if(intcardvalue > 10){
			intcardvalue = 10;
		}else if(intcardvalue == 1){
			intcardvalue = 11;
		}
		intdealer += intcardvalue;
		intdealercardsused++;
		con.println("Dealer total: " + intdealer);
	}

	// Therefore...
	if(dblbetamount > 0 && !blndoubledown && !blnfivecardbonus){
		if(intdealer > 21){
			con.println("\nDealer busts! You win.");
			con.println("Player wins against dealer.");
			dblbetamount = dblbet * 2;
			con.println("you won: " +dblbetamount);

		}else if(intdealer >= intplayer2){
			con.println("\nDealer wins with " + intdealer + " vs your " + intplayer2);
			dblbetamount = 0;
			con.println("Dealer wins against player.");
			con.println("you have now: $"+dblbetamount);

		}else{
			con.println("\nYou win with " + intplayer2 + " vs dealer's " + intdealer);
			con.println("Player wins against dealer.");

		}
	}

	// Leaderboard output 
	TextOutputFile leaderboardout = new TextOutputFile("leaderboardredo.txt", true);
	leaderboardout.println(strname);
	leaderboardout.println(dblbetamount);
	leaderboardout.close();

	
	
	return dblbetamount;
}		
		
	

	
	


	
	public static char leaderboard(Console con){
		 con.clear();
    con.setBackgroundColor(Color.BLACK);

    TextInputFile leaderboardin = new TextInputFile("leaderboardredo.txt");
    
    
    String[] strnames = new String[100];
	double[] dblamounts = new double[100];
    int intcount = 0;
    
     while (!leaderboardin.eof() && intcount < 100) {
        strnames[intcount] = leaderboardin.readLine();
        if (!leaderboardin.eof()) {
            dblamounts[intcount] = leaderboardin.readDouble();
            intcount++;
        }
    }
    leaderboardin.close();
    
    String strtempname;
	double dbltempamount;

	for (int intpass = 0; intpass < intcount - 1; intpass++) {
		for (int intcount2 = 0; intcount2 < intcount - 1 - intpass; intcount2++) {
			if (dblamounts[intcount2] < dblamounts[intcount2 + 1]) {
            // swap amounts
            dbltempamount = dblamounts[intcount2];
            dblamounts[intcount2] = dblamounts[intcount2 + 1];
            dblamounts[intcount2 + 1] = dbltempamount;

            // swap corresponding names
            strtempname = strnames[intcount2];
            strnames[intcount2] = strnames[intcount2 + 1];
            strnames[intcount2 + 1] = strtempname;
        }
    }
}
		if (intcount == 0) {
        con.println("Nothing Found");
		} else {
        con.println("Leaderboard (Highest to Lowest):");
        for (int i = 0; i < intcount; i++) {
            con.println(strnames[i] + " has won $ " + dblamounts[i]);
        }
    }


    return con.getChar();
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
		
		con.println("Thanks for playing!");
		return con.getChar();
	}
}



	

	
	
	
	

