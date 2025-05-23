import arc.*;
	public class repotest{
		public static void main(String[] args){
			Console con = new Console();
			
			con.println("hello world");
			con.println("thank god its friday");
			con.println("never get the blackberry yuzu at timmies = tylenol");
			
			String strname;	
			String strinitials;
			
			con.println("Enter your name");
			strname = con.readLine();
			
			strinitials = strname.substring(0,1);
			 // ^^ you are doing (0,1) because you are capturing what is in between those two numbers 
			con.println("The first initial of the name is: "+strinitials);
			
			if(strinitials.equals("A") || strinitials.equals("B") || strinitials.equals("C") || strinitials.equals("D") || strinitials.equals("E") || strinitials.equals("F") || strinitials.equals("G") || strinitials.equals("H") || strinitials.equals("I")){
				con.println("You are in TEAM 1");
			}else if(strinitials.equals("J") || strinitials.equals("K") || strinitials.equals("L") || strinitials.equals("M") || strinitials.equals("N") || strinitials.equals("O") || strinitials.equals("P")){
					con.println("You are in TEAM 2");
			}else{
				con.println("you are TEAM 3");
		
				}
		}
	}
