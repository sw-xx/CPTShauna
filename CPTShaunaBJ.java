import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

	public class CPTShaunaBJ{
		public static void main(String[] args){
			Console con = new Console("Let's play Blackjack", 1280, 720);
			
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
		    
			con.println("                                             Enter a Key Letter to begin: ");
			                                                          // setting up the singular character 
			                                                          char charkey = con.getChar();
			System.out.println("you entered: "+charkey);
			
		
		
		if(charkey == 'P' || charkey == 'p'){ // PLAYTIMETOOLS
			con.clear();
			con.setBackgroundColor(Color.BLACK);
			charkey = Blackjacktools.playtime(con);
			
		}else if(charkey == 'L' || charkey == 'l'){ // LEADERBAORD TOOLS 
			con.clear();
			con.setBackgroundColor(Color.BLACK);
			charkey = Blackjacktools.leaderboard(con);
		
		}else if(charkey == 'Q' || charkey == 'q'){ // QUIT TOOLS
			con.clear();
			con.setBackgroundColor(Color.BLACK);
			charkey = Blackjacktools.quit(con);
			
		}else if(charkey == 'H' || charkey == 'h'){ //HELP TOOLS
			con.clear();
			con.setBackgroundColor(Color.BLACK);
			charkey = Blackjacktools.help(con);	
			
		}
			
			
		}
	}

			
		
		
		
		
	
	
