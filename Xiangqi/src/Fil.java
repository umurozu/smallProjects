
public class Fil extends Item {
	
	public Fil(String position, String player) {
		
		this.setPosition(position);
		this.setName(player);
		this.puan = 2;
		
	}
	
	public void move(String destination) {
		
		if(canMove(destination) && behindRiver(destination)) {
			super.move(destination);
		}
		
		
	}
	
	public boolean canMove(String destination) {
		
		if(this.behindRiver(destination)) {
		
		if (((int)destination.charAt(0) == (int)this.getPosition().charAt(0) + 2) && ((int)destination.charAt(1) == (int)this.getPosition().charAt(1) + 2))
			return true;
		else if (((int)destination.charAt(0) == (int)this.getPosition().charAt(0) + 2) && ((int)destination.charAt(1) == (int)this.getPosition().charAt(1) - 2))
			return true;

		if (((int)destination.charAt(0) == (int)this.getPosition().charAt(0) - 2) && ((int)destination.charAt(1) == (int)this.getPosition().charAt(1) + 2))
			return true;
		else if (((int)destination.charAt(0) == (int)this.getPosition().charAt(0) - 2) && ((int)destination.charAt(1) == (int)this.getPosition().charAt(1) - 2))
			return true;
		else
			return false;
		}
		else return false;
	}
	
	public boolean behindRiver(String destination) {
		
		char name = this.getName().charAt(0);
		
		if((int)name >= 97 && (int)name <=122)  // if team is red
			if((int)destination.charAt(0) <= (int)'e')//behind river
				return true;
			
		
				
				
		if((int)name >= 65 && (int)name <=90)  // if team is black
			if((int)destination.charAt(0) >= (int)'f')//behind river
				return true;
			
		
		return false;
	}
	
	
	public boolean legalMove(Item[] items,String from, String to) {
		
		if (this.canMove(to)) {
		
			int rowDiff = to.charAt(0) - from.charAt(0);
			int colDiff = to.charAt(1) - from.charAt(1);
		
			String checkForPosition = null;
			int temp = 0,temp2 = 0;
		
			if (rowDiff > 0 && colDiff > 0) {
			
				temp = (int)from.charAt(0) + 1;
				temp2 = (int)from.charAt(1) + 1;
			
				checkForPosition = (char)temp + "" + (char)temp2;
			
				if (findItem(checkForPosition,items) == null)
					return true;
				else
					return false;
			
			}
			
			
			else if (rowDiff > 0 && colDiff < 0 ) {
			
				temp = (int)from.charAt(0) + 1;
				temp2 = (int)from.charAt(1) - 1;
			
				checkForPosition = (char)temp + "" + (char)temp2;
			
				if (findItem(checkForPosition,items) == null)
					return true;
				else
					return false;
			
			}
			
			
			else if (rowDiff < 0 && colDiff < 0 ) {
			
				temp = (int)from.charAt(1) - 1;
				temp2 = (int)from.charAt(1) - 1;
			
				checkForPosition = (char)temp + "" + (char)temp2;
			
				if (findItem(checkForPosition,items) == null)
					return true;
				else
					return false;
			}
			else if (rowDiff < 0 && colDiff > 0 ) {
			
				temp = (int)from.charAt(1) - 1;
				temp2 = (int)from.charAt(1) + 1;
			
				checkForPosition = (char)temp + "" + (char)temp2;
			
				if (findItem(checkForPosition,items) == null)
					return true;
				else
					return false;
			}
		
			else
				return false;
			
			}
		
		else	
			return false;
	}
}
