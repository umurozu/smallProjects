
public class Sah extends Item {

	
	public Sah(String position, String player) {
		
		this.setPosition(position);
		this.setName(player);
		this.puan = 0;
		
	}
	
	public void move(String destination) {
		
		if(canMove(destination)) {
			super.move(destination);
		}
		
		
	}
	
	public boolean canMove(String destination) {
		
		
		
		if(this.insidePalace(destination)) {
			
		
			
				if((destination.charAt(0) == this.getPosition().charAt(0)) && destination.charAt(1) == this.getPosition().charAt(1) + 1) //
				return true;
				else if((destination.charAt(0) == this.getPosition().charAt(0)) && destination.charAt(1) == this.getPosition().charAt(1) - 1) //
					return true;
				else if((destination.charAt(0) == this.getPosition().charAt(0) - 1) && destination.charAt(1) == this.getPosition().charAt(1)) //
					return true;																				
				else if((destination.charAt(0) == this.getPosition().charAt(0) + 1) && destination.charAt(1) == this.getPosition().charAt(1)) //
					return true;
				else 
					return false;
		}
			
		
		return false;
	}
	
	public boolean insidePalace(String destination) {
		
		char name = this.getName().charAt(0);
		
		if(((int)name >= 97 && (int)name <=122) || (int)name == 351)  // if team is red
			if((int)destination.charAt(0) >= (int)'a' && (int)destination.charAt(0) <= (int)'c')
				if((int)destination.charAt(1) - '0' >= (int)4 && (int)destination.charAt(1) - '0' <= (int)6)
				return true;
			
		
				
				
		if(((int)name >= 97 && (int)name <=122) || (int)name == 350)  // if team is black
			if((int)destination.charAt(0) >= (int)'h' && (int)destination.charAt(0) <= (int)'j')
				if((int)destination.charAt(1)-'0' >= (int)4 && (int)destination.charAt(1)-'0' <= (int)6)
				return true;
			
		
		return false;
		
		
	}
	
	public boolean legalMove(Item[] items,String from, String to) {
		if(this.canMove(to))
		return true;
		
		return false;
	}
	
	
}
