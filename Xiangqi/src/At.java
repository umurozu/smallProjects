
public class At extends Item {
	
	public At(String position, String player) {
		
		this.setPosition(position);
		this.setName(player);
		this.puan = 4;
		
	}
	
	public void move(String destination) {
		
		if(canMove(destination)) {
			super.move(destination);
		}
		
		
	}
	
	public boolean canMove(String destination) {
		
		//System.out.println(destination.charAt(0) + " " + (char)(this.getPosition().charAt(0) + 1) + " " + destination.charAt(1) + " " +(char)(this.getPosition().charAt(1) - 2) );
		
		
		if((destination.charAt(0) == this.getPosition().charAt(0) + 2) && destination.charAt(1) == this.getPosition().charAt(1) + 1) //
		return true;
		else if((destination.charAt(0) == this.getPosition().charAt(0) + 2) && destination.charAt(1) == this.getPosition().charAt(1) - 1) //
			return true;
		else if((destination.charAt(0) == this.getPosition().charAt(0) - 2) && destination.charAt(1) == this.getPosition().charAt(1) + 1) //
			return true;																				
		else if((destination.charAt(0) == this.getPosition().charAt(0) - 2) && destination.charAt(1) == this.getPosition().charAt(1) - 1) //
			return true;
		else if((destination.charAt(0) == this.getPosition().charAt(0) + 1) && destination.charAt(1) == this.getPosition().charAt(1) - 2) //
			return true;																				
		else if((destination.charAt(0) == this.getPosition().charAt(0) + 1) && destination.charAt(1) == this.getPosition().charAt(1) + 2) //
			return true;
		else if((destination.charAt(0) == this.getPosition().charAt(0) - 1) && destination.charAt(1) == this.getPosition().charAt(1) + 2) //
			return true;																				
		else if((destination.charAt(0) == this.getPosition().charAt(0) - 1) && destination.charAt(1) == this.getPosition().charAt(1) - 2) //
			return true;
		else 
			return false;
		
		
	}
	
	public boolean legalMove(Item[] items,String from, String to) {
		
		if (this.canMove(to)) {
		
		int rowDiff = to.charAt(0) - from.charAt(0);
		int colDiff = to.charAt(1) - from.charAt(1);
		
		String checkForPosition = null;
		int temp = 0;
		
		if (rowDiff > 1) {
			
			temp = (int)from.charAt(0) + 1;
			
			checkForPosition = (char)temp + "" + from.charAt(1);
			
			if (findItem(checkForPosition,items) == null)
				return true;
			else
				return false;
			
		}
			
			
		else if (rowDiff < -1 ) {
			
			temp = (int)from.charAt(0) - 1;
			
			checkForPosition = (char)temp + "" + from.charAt(1);
			
			if (findItem(checkForPosition,items) == null)
				return true;
			else
				return false;
			
		}
			
			
		else if (colDiff > 1 ) {
			
			temp = (int)from.charAt(1) + 1;
			
			checkForPosition = from.charAt(1) + "" + (char)temp ;
			
			if (findItem(checkForPosition,items) == null)
				return true;
			else
				return false;
		}
		else if (colDiff < -1 ) {
			
			temp = (int)from.charAt(1) - 1;
			
			checkForPosition = from.charAt(1) + "" + (char)temp ;
			
			if (findItem(checkForPosition,items) == null)
				return true;
			else {
				
				return false;
			}
				
		}
		
		else
			return false;
		
		}
		
		else
			
			return false;
	}

}
