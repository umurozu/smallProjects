
public class Main {

	public static void main(String[] args) {
		
		
		
		Game g = new Game("A","B");
		
		g.play("d5", "e5");
		g.play("h8", "h5");
		g.play("e5", "f5");
		g.play("h5", "f5");
		g.play("c8", "i8");
		g.play("j9", "i9");
		g.play("a8", "c7");
		g.play("i9", "i8");
		g.play("a9", "c9");
		g.play("h2", "h5");
		g.play("d3", "e3");
		g.play("f5", "f1"); 
		
	//	System.out.println(g.order);
		//g.play("a4", "b5"); 
		
		//g.play("e3", "f3");
		//g.play("d1", "e1");
		//g.play("a8", "b6");
		//g.save_text("text"); 
		//g.load_binary("binary");
		
		//g.load_text("text");
		
		
		
		
		g.getBoard().print();
		//System.out.println('c'-'a');
		//System.out.println((int)'ş' + "  " + (int)'Ş');
	}

}
