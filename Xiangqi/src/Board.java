
public class Board extends AbstractBoard{

	String letter_axis = "j i h g f e d c b a";
	
	String[][] empty_board = {{"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							  {"|","  ","|","  ","|","  ","|","\\"," ","|"," ","/","|","  ","|","  ","|","  ","|"},
							  {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							  {"|","  ","|","  ","|","  ","|","/"," ","|"," ","\\","|","  ","|","  ","|","  ","|"},
							  {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							  {"|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|"},
							  {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							  {"|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|"},
							  {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							  {"|","                       ","|"},
							  {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							  {"|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|"},
							  {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							  {"|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|","  ","|"},
							  {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							  {"|","  ","|","  ","|","  ","|","\\"," ","|"," ","/","|","  ","|","  ","|","  ","|"},
							  {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							  {"|","  ","|","  ","|","  ","|","/"," ","|"," ","\\","|","  ","|","  ","|","  ","|"},
							  {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"}};
	
	 String number_axis = "1--2--3--4--5--6--7--8--9";
	
	
	public Board() {
		//taşların sınıflarını oluşturup nesne nesne tanımla constructorlarını başlangıc konumu olarak parametre ver
		
		this.items = new Item[32];
		
		this.items[0] = new Kale("a1", "k");           
		this.items[1] = new Kale("a9", "k");
		this.items[2] = new At("a2", "a");
		this.items[3] = new At("a8", "a");
		this.items[4] = new Fil("a3", "f");
		this.items[5] = new Fil("a7", "f");
		this.items[6] = new Vezir("a4", "v");
		this.items[7] = new Vezir("a6", "v");
		this.items[8] = new Sah("a5", "ş");
		this.items[9] = new Piyon("d1", "p");
		this.items[10] = new Piyon("d3", "p");
		this.items[11] = new Piyon("d5", "p");
		this.items[12] = new Piyon("d7", "p");
		this.items[13] = new Piyon("d9", "p");
		this.items[14] = new Top("c2", "t");
		this.items[15] = new Top("c8", "t");
		//-------------------0-----------------
		this.items[16] = new Kale("j1", "K");
		this.items[17] = new Kale("j9", "K");
		this.items[18] = new At("j2", "A");
		this.items[19] = new At("j8", "A");
		this.items[20] = new Fil("j3", "F");
		this.items[21] = new Fil("j7", "F");
		this.items[22] = new Vezir("j4", "V");
		this.items[23] = new Vezir("j6", "V");
		this.items[24] = new Sah("j5", "Ş");
		this.items[25] = new Piyon("g1", "P");
		this.items[26] = new Piyon("g3", "P");
		this.items[27] = new Piyon("g5", "P");
		this.items[28] = new Piyon("g7", "P");
		this.items[29] = new Piyon("g9", "P");
		this.items[30] = new Top("h2", "T");
		this.items[31] = new Top("h8", "T");
		
	}
	
	
	private int[] row_col_indexer(String position) {
		
		if(position.equals("xx"))
			return null;
		
		int[] rc = new int[2];
		
		rc[0] = letter_axis.indexOf(position.charAt(0));
		rc[1] = number_axis.indexOf(position.charAt(1));
		
		
		return rc;
		
	}
	
	private void setCurrentBoard() {
		
		int[] tmp;
		
		for (int i = 0; i < items.length; i++) {
			tmp = row_col_indexer(items[i].getPosition());
			if(tmp == null) continue;
			
			empty_board[tmp[0]][tmp[1]] = items[i].getName();
			//System.out.println(tmp[0] + "  " + tmp[1]);
		}
	}
	
	
	@Override
	public void print() {	
		
		//---------------------------------------------------
		setCurrentBoard();
		
		for(int i = 0; i < empty_board.length;i++) {
				System.out.print(letter_axis.charAt(i));
				System.out.print("\t");
			for (int j = 0; j < empty_board[i].length; j++) {
				
				System.out.print(empty_board[i][j]);
				
			}
			System.out.println();
		}
		
		System.out.println(" ");
		System.out.println("\t" + number_axis);
		//--------------------------------------------------- farklı bi metoda al bunu
		
	} 
	
	public static void main(String[]args) {
		
		
		
		
		
		//for(int i = 0; i <= items.length; i++ );
		//System.out.println("HOCA TEMPLATE --------------------------------------------------");
		
		
	}

}
		