import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

	public class CPTShaunaBJ{
		public static void main(String[] args){
			Console con = new Console("Let's play Blackjack", 1280, 720);
			
			//Shauna Wong 
			//BlackJack 
			//Last Modification Date: 6/12/2025
			// V.10.8
			
			BufferedImage imgbj = con.loadImage("blackjacklogo.png");
			con.drawImage(imgbj, 100, 150);
			con.repaint();
			
			
			con.println("                                                                          ");
			con.println("                                                                          ");
			con.println("                                                                          ");
			con.println("                                                                          ");
			con.println("                                                                          ");
			con.println("                                                                          ");
			con.println("                                                                          ");
			con.println("                                                                          ");
			con.println("                                                                          ");
			
		
			con.println("                                             WELCOME TO BLACKJACK '25");
		    con.println("                                                                          ");

			con.println("                                                         (P) Play");
			con.println("                                                  (L) Leaderboard");
			con.println("                                                         (Q) Quit");
			con.println("                                                         (H) Help");
		    con.println("                                                                          ");
		    con.println("                                              MAX Betting amount: $1000");
		    con.print("                                                     Enter a name: "); //con.print because we want it to be after the colon
		    
		    String strname = con.readLine();
		    
			con.println("                                                     Enter a Key Letter to begin: ");
		

                                                          // setting up the singular character 
			                                                          char charkey = con.getChar();
			System.out.println("you entered: "+charkey);
			con.setDrawColor(Color.BLACK);
			con.fillRect(0, 0, 1280, 720);
			con.clear();
			con.repaint();
			if(charkey == 'p'){ // PLAYTIMETOOL
			
			boolean blnplayagain = true;
			double dblbetamount = 1000;
			boolean blnquit = false;
			while(blnplayagain){
				dblbetamount = Blackjacktools.playtime(con, strname, dblbetamount);
			con.println("\nWould you like to play another round?");
			con.println("(P) Play again");
			con.println("(N) No thank you");
			char charreplay = Character.toLowerCase(con.getChar());

			if(charreplay == 'n'){
				blnplayagain = false;
				blnquit = true;
				con.clear();
				con.setBackgroundColor(Color.BLACK);
				con.fillRect(0, 0, 1280, 720); // black screen
				con.repaint();
	
			}else{
				con.clear(); // replay again
			}
		}	
				
		if(blnquit){
			Blackjacktools.quit(con);
			return;
		}	
			con.clear();

		 charkey = Character.toLowerCase(con.getChar());
		 con.clear();
		 con.setBackgroundColor(Color.BLACK);
		
	
		}else if(charkey == 'l'){ // LEADERBAORD TOOLS 
			con.clear();
			con.setBackgroundColor(Color.BLACK);
			charkey = Blackjacktools.leaderboard(con);
		
		}else if(charkey == 'q'){ // QUIT TOOLS
			con.clear();
			con.setBackgroundColor(Color.BLACK);
			charkey = Blackjacktools.quit(con);
			
		}else if(charkey == 'h'){ //HELP TOOLS
			con.clear();
			con.setBackgroundColor(Color.BLACK);
			charkey = Blackjacktools.help(con);	
			
		}
		
		con.clear();
			
		}
	}

			
		
		
		
		
	
	
