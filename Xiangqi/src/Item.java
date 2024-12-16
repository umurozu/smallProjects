
public class Item extends AbstractItem{
	
	float puan;
	int count = 0;

	@Override
	public void move(String destination) {
		
		this.setPosition(destination);
		
	}

	@Override
	public String getPosition() {
		// TODO Auto-generated method stub
		return super.getPosition();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
		
	}

	
	public void setPosition() {
		// TODO Auto-generated method stub
		super.setPosition(getPosition());
		
	}
	
	public boolean legalMove(Item[] items,String from, String to) {
		
		return true;
	}
	
	public boolean isEnemy(String name) {
		
		if (Character.isUpperCase((char)this.getName().charAt(0)) && Character.isLowerCase(name.charAt(0)))
				return true;
		else if (Character.isLowerCase((char)this.getName().charAt(0)) && Character.isUpperCase(name.charAt(0)))
				return true;
		else
			return false;
	}
	
	public Item findItem(String position,Item[] items) {
		
		for (int i = 0; i < items.length; i++) {
			if (items[i].getPosition().equals(position))
				return items[i];
		}
		
		return null;
	}

}
