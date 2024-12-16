
public class Kale extends Item {
	
	
	
	public Kale(String position, String player) {
		
		this.setPosition(position);
		this.setName(player);
		this.puan = 9;
		
	}
	
	public void move(String destination) {
		
		if(canMove(destination)) {
			super.move(destination);
		}
		
		
	}
	
	public boolean canMove(String destination) {
		
		if(destination.charAt(0) == this.getPosition().charAt(0))
			return true;
		else if (destination.charAt(1) == this.getPosition().charAt(1))
			return true;
		else
			return false;
		
	}
	
	public boolean legalMove(Item[] items,String from, String to) {
		
		if(this.canMove(to)) {
			
			int rowDiff = to.charAt(0) - from.charAt(0);
			int colDiff = to.charAt(1) - from.charAt(1);
			
			String checkForPosition = null;
			int temp = 0;
			
			if (rowDiff > 0) {
				
				for (int i = 1; i < rowDiff; i++) {
					
					temp = (int)from.charAt(0) + i;
					checkForPosition = (char)temp + "" + from.charAt(1);
					
					if(findItem(checkForPosition,items) != null)
						return false;
					
				}
				
				return true;
				
			}
			else if (rowDiff < 0) {
				
				for (int i = -1; i > rowDiff; i--) {
					
					temp = (int)from.charAt(0) + i;
					checkForPosition = (char)temp + "" + from.charAt(1);
					
					if(findItem(checkForPosition,items) != null)
						return false;
					
				}
				
				return true;
				
			}
			else if (colDiff > 0) {
				
				for (int i = 1; i < colDiff; i++) {
					
					temp = (int)from.charAt(1) + i;
					checkForPosition = from.charAt(0) + "" + (char)temp ;
					
					if(findItem(checkForPosition,items) != null)
						return false;
					
				}
				
				return true;
				
			}
			else if (colDiff < 0) {
				
				for (int i = -1; i > colDiff; i--) {
					
					temp = (int)from.charAt(1) + i;
					checkForPosition = from.charAt(0) + "" + (char)temp ;
					
					if(findItem(checkForPosition,items) != null)
						return false;
					
				}
				return true;
				
			}
			else return false;
		}
		
		return false;
	}
	
	
}
