import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game extends AbstractGame{
	
	String message = "hatali hareket";
	String data_access;
	int moveCount;
	
	
	
	
	public Game(String red, String black) {
		
		
		this.board = new Board();
		this.red = new Player(red);
		this.black = new Player(black);
		this.order = 0;
		this.moveCount = 0;
	}

	@Override
	void play(String from, String to) {
		
		
		
		if(from.length() != 2 || to.length() != 2) {
			System.out.println(message);
			return;
		}
		if((!(board.letter_axis.contains(from.charAt(0) +"")) || (!(board.number_axis.contains(from.charAt(1) + "")))
				|| (!(board.letter_axis.contains(to.charAt(0) + ""))) || (!(board.number_axis.contains(to.charAt(1) + ""))))) {
			System.out.println(message);
			return;
		}
		
		if(this.moveCount >= 60) {
			
			if(red.puan == black.puan && black.puan == 0) {
			System.out.println("berabere");
			System.exit(0);
			}
		}
			
		
		Item piece = findItem(from);
		Item maybePiece = findItem(to);
		
		if(piece == null)
		{
			System.out.println(message);
			return;
		}
		
		if(check()) {
			
			if (order == 0) {
				
				if (piece.legalMove(board.items, from, to)) {
					piece.move(to);
					if(check()) {
						System.out.println(message);
						
						piece.move(from);
						
						return;
					}
					else {
						piece.move(from);
						
					}
				}
				else {
					System.out.println(message);
					
					return;
				}
					
			}
			else {
				if (piece.legalMove(board.items, from, to)) {
					piece.move(to);
					if(check()) {
						System.out.println(message);
						piece.move(from);
						moveCount++;
						return;
					}
					else { piece.move(from);
							moveCount++;
					}
				}
				else {
					System.out.println(message);
					return;
				}
					
			}
		}
		
		
		if(piece != null) {
		
			if (this.checkOrder(piece)) {
				if (piece.legalMove(board.items, from, to)) {
				
					if(maybePiece != null) { 
					
						if(piece.isEnemy(maybePiece.getName())) {
							maybePiece.setPosition("xx");
							piece.count++;
							piece.move(to);
							this.setPlayerPuan(piece.puan);
							//this.setOrder();
						}
						else {
							System.out.println(message);
							return;
							}
					
					}
					else {
						piece.move(to);
						//this.setOrder();
						}
				}
				else
					{
					System.out.println(message);
					return;
					}
			
				
			}
			else {
				System.out.println(message);
				return;
			}
		}
		
		
		if(check()) {
			
			if(mate()) {
				if(order == 0) // red team
				System.out.println("ŞAH MAT! " + red.name + " oyunu kazandı. " +red.name+"'in puanı: " + red.puan +","+ black.name+"'nin puanı: " + black.puan);
				
				else
					System.out.println("ŞAH MAT! " + black.name + " oyunu kazandı. "+ black.name+"'in puanı: " + black.puan +", "+red.name+"'nin puanı: " + red.puan);
			}
		}
		else
			this.setOrder();
			
	}

	@Override
	void save_binary(String address) { // writes items' positions in an order
		
		String filename = address;
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(new FileOutputStream(filename));

			for(int i = 0; i < board.items.length; i++) {
				
				o.writeUTF(board.items[i].getPosition());
				
			}
			
			for(int i = 0; i < board.items.length; i++) {
				
				o.writeInt(board.items[i].count);
				
			}
			
			o.writeInt(this.order);
			
			o.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	void save_text(String address) {
		
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(new FileOutputStream(address));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < board.items.length; i++) {
			
			out.print(board.items[i].getPosition() + " ");
			
		}
		
		for(int i = 0; i < board.items.length; i++) {
			
			out.print(board.items[i].count + " ");
			
		}
		
		out.print(this.order);
		
		out.close();
		
		
	}

	@Override
	void load_text(String address) {
		
		Scanner s = null;
		
		try {
			s = new Scanner(new FileInputStream(address));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < board.items.length; i++) {
			
			board.items[i].setPosition(s.next());
			
		}
		
		for(int i = 0; i < board.items.length; i++) {
			
			board.items[i].count = s.nextInt();			
		}
		
		this.order = s.nextInt();
		s.close();
		
		
		
	}

	@Override
	void load_binary(String address) {
		
		ObjectInputStream s = null;
		try {
			s = new ObjectInputStream(new FileInputStream(address));

			while(true) {
				
				for(int j = 0; j < board.items.length; j++) {
					
					board.items[j].setPosition(s.readUTF());
					
				}
				
				for(int j = 0; j < board.items.length; j++) {
					
					board.items[j].count = s.readInt();			
				}
				
				this.order = s.readInt();
			}
		} 
		catch(EOFException e) {
			try {
				s.close();
			} catch (IOException e1) {
			}
		}
		catch (IOException e) {
		}
		
		
	}
	
	public Board getBoard() {
		
		return board;
		
	}
	
	public boolean rules() {
		
		return false;
	}
	
	public void checkMove(Item[] items) {   // it controls path is blocked or can eat or can move think like it is a access point to item subclasses
		
	}
	
	public Item findItem(String position) {
		
		for (int i = 0; i < board.items.length; i++) {
			if (board.items[i].getPosition().equals(position))
				return board.items[i];
		}
		
		return null;
	}
	
	public boolean checkOrder(Item item) {
		
		if(item != null) {
		
			char name = item.getName().charAt(0);
		
			if((((int)name >= 97 && (int)name <=122) || (int)name == 351) && this.order == 0)  // if team is red
				return true;
				
			
			else if((((int)name >= 65 && (int)name <= 90) || (int)name == 350) && this.order == 1)  // if team is black
				return true;
			
			else return false;
		
		}
		else return false;
	}
	
	public void setOrder() {
		
		if(this.order == 0)
			this.order = 1;
		else
			this.order = 0;
			
		
	}
	
	public boolean check() {
		
		
		
		if (order == 1) {     
			
			
			for(int i = 16; i < board.items.length; i++) {
				
				if(board.items[i].legalMove(board.items, board.items[i].getPosition(), board.items[8].getPosition())) {
					//System.out.println("red için kontrol" );
					data_access = board.items[i].getPosition();
					return true;
					}
				}
			}
		
		else {
			
			for(int i = 0; i < 16; i++) {
				
				if(board.items[i].legalMove(board.items, board.items[i].getPosition(), board.items[8].getPosition())) {
					data_access = board.items[i].getPosition();
					return true;
					}
				}
		}
		return false;
	}
		
		
		
	
	
	public boolean mate() {
		
		if(order == 1) {
		
		String down = (board.items[8].getPosition().charAt(0)-1) + "" + board.items[8].getPosition().charAt(1);
		String up = (board.items[8].getPosition().charAt(0)+1) + "" + board.items[8].getPosition().charAt(1);
		String left = (board.items[8].getPosition().charAt(0)) + "" + (board.items[8].getPosition().charAt(1)-1);
		String right = (board.items[8].getPosition().charAt(0)) + "" + (board.items[8].getPosition().charAt(1)+1);
		
		
		for(int j = 16; j < board.items.length; j++) {
			for(int i = 0; i < 16; i++)
			if(board.items[j].legalMove(board.items, board.items[j].getPosition(), up) && ((board.items[8].legalMove(board.items, board.items[8].getPosition(), up)))) {
				return false;
			}
		}
		
		for(int j = 16; j < board.items.length; j++) {
			for(int i = 0; i < 16; i++)
			if(board.items[j].legalMove(board.items, board.items[j].getPosition(), down) && ((board.items[8].legalMove(board.items, board.items[8].getPosition(), down)))) {
				return false;
			}
		}
		
		for(int j = 16; j < board.items.length; j++) {
			for(int i = 0; i < 16; i++)
			if(board.items[j].legalMove(board.items, board.items[j].getPosition(), left) && ((board.items[8].legalMove(board.items, board.items[8].getPosition(), left)))) {
				return false;
			}
		}
		
		for(int j = 16; j < board.items.length; j++) {
			for(int i = 0; i < 16; i++)
			if(board.items[j].legalMove(board.items, board.items[j].getPosition(), right) && ((board.items[8].legalMove(board.items, board.items[8].getPosition(), right)))) {
				return false;
			}
		}
		return true;
	}
		
		else {
			String down = (board.items[24].getPosition().charAt(0)-1) + "" + board.items[8].getPosition().charAt(1);
			String up = (board.items[24].getPosition().charAt(0)+1) + "" + board.items[8].getPosition().charAt(1);
			String left = (board.items[24].getPosition().charAt(0)) + "" + (board.items[8].getPosition().charAt(1)-1);
			String right = (board.items[24].getPosition().charAt(0)) + "" + (board.items[8].getPosition().charAt(1)+1);
			
			
			for(int j = 16; j < board.items.length; j++) {
				if(board.items[j].legalMove(board.items, board.items[j].getPosition(), up) && (!(board.items[24].legalMove(board.items, board.items[24].getPosition(), board.items[j].getPosition())))) {
					return true;
				}
			}
			
			for(int j = 16; j < board.items.length; j++) {
				if(board.items[j].legalMove(board.items, board.items[j].getPosition(), down) && (!(board.items[24].legalMove(board.items, board.items[24].getPosition(), board.items[j].getPosition())))) {
					return true;
				}
			}
			
			for(int j = 16; j < board.items.length; j++) {
				if(board.items[j].legalMove(board.items, board.items[j].getPosition(), left) && (!(board.items[24].legalMove(board.items, board.items[24].getPosition(), board.items[j].getPosition())))) {
					return true;
				}
			}
			
			for(int j = 16; j < board.items.length; j++) {
				if(board.items[j].legalMove(board.items, board.items[j].getPosition(), right) && (!(board.items[24].legalMove(board.items, board.items[24].getPosition(), board.items[j].getPosition())))) {
					return true;
				}
			}
			return false;
		}
	}
	

	public void setPlayerPuan(float puan) {
		
		if(order == 0)
			red.puan += puan;
		
		else
			black.puan += puan;
		
	}
	
}
