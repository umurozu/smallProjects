
public class Piyon extends Item {
	
	
	public Piyon(String position, String player) {
		
		this.setPosition(position);
		this.setName(player);
		this.puan = 1;
		
	}
	
	public void move(String destination) {
		
		if(canMove(destination)) {
			super.move(destination);
		}
		
		
	}
	
	public boolean canMove(String destination) {
		
		char name = this.getName().charAt(0);
		
		if((int)name >= 97 && (int)name <=122) {
		if (behindRiver(this.getPosition())) {
			if(destination.charAt(1) == this.getPosition().charAt(1))
				if((int)destination.charAt(0) == (int)this.getPosition().charAt(0) + 1)
				return true;
		}
		else {
			if(destination.charAt(1) == this.getPosition().charAt(1))
				if((int)destination.charAt(0) == (int)this.getPosition().charAt(0) + 1)
				return true;
			
			if((int)destination.charAt(1) == (int)this.getPosition().charAt(1) + 1)
				if((int)destination.charAt(0) == (int)this.getPosition().charAt(0))
				return true;
			
			if((int)destination.charAt(1) == (int)this.getPosition().charAt(1) - 1)
				if((int)destination.charAt(0) == (int)this.getPosition().charAt(0))
				return true;
			
		}
		}
		
		if((int)name >= 65 && (int)name <=90) {
			
			if (behindRiver(this.getPosition())) {
				if(destination.charAt(1) == this.getPosition().charAt(1))
					if((int)destination.charAt(0) == (int)this.getPosition().charAt(0) - 1)
					return true;
			}
			else {
				if(destination.charAt(1) == this.getPosition().charAt(1))
					if((int)destination.charAt(0) == (int)this.getPosition().charAt(0) - 1)
					return true;
				
				if((int)destination.charAt(1) == (int)this.getPosition().charAt(1) + 1)
					if((int)destination.charAt(0) == (int)this.getPosition().charAt(0))
					return true;
				
				if((int)destination.charAt(1) == (int)this.getPosition().charAt(1) - 1)
					if((int)destination.charAt(0) == (int)this.getPosition().charAt(0))
					return true;
				
			}
			
		}
		
		return false;
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
		
		if(this.canMove(to))
			return true;
		
		return false;
	}

}
