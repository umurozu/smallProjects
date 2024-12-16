import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;




public class Paint extends JFrame implements MouseInputListener,ActionListener {

	JButton brush;
	JButton rect;
	JButton oval;
	JButton move;
	boolean isdragging = false;
	boolean withinshape = false;
	boolean inborder = true;
	
	JPanel Buttons;
	JPanel Colors;
	JPanel yellow,red,green,blue,purple,black,orange;
	JPanel border;
	Color c = Color.black;
	
	

	LinkedList<Shape> shape = new LinkedList<>();
	
	int x = 0;
	int y = 0;
	int old_x = 0;
	int old_y = 0;
	int item;
	
	
	boolean drawbrush = false;
	boolean drawrect = false;
	boolean drawoval = false;
	boolean moveshape = false;
	
	public Paint() {
		
		
		
		super("Paint Brush");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		brush = new JButton("Kalemle Çiz");
		rect = new JButton("Dikdörtgen Çiz");
		oval = new JButton("Oval Çiz");
		move  = new JButton("Taşı");
		
		orange = new JPanel();    
		orange.setBackground(Color.orange); 
		orange.setPreferredSize(new Dimension(50,50));
		black = new JPanel();	 
		black.setBackground(Color.black);  
		black.setPreferredSize(new Dimension(50,50));
		green = new JPanel();    
		green.setBackground(Color.green);   
		green.setPreferredSize(new Dimension(50,50));
		blue = new JPanel();     
		blue.setBackground(Color.blue);    
		blue.setPreferredSize(new Dimension(50,50));
		purple = new JPanel();   
		purple.setBackground(Color.magenta);
		purple.setPreferredSize(new Dimension(50,50));
		red = new JPanel();      
		red.setBackground(Color.red);       
		red.setPreferredSize(new Dimension(50,50));
		yellow = new JPanel();   
		yellow.setBackground(Color.yellow); 
		yellow.setPreferredSize(new Dimension(50,50));
		
		Buttons = new JPanel();
		
		
		
		Colors = new JPanel();
		
		
		border = new JPanel();
		border.setBackground(Color.BLUE);
		
		
		Colors.add(blue);
		Colors.add(red);
		Colors.add(green);
		Colors.add(yellow);
		Colors.add(orange);
		Colors.add(purple);
		Colors.add(black);
		
		brush.addActionListener(this);
		rect.addActionListener(this);
		oval.addActionListener(this);
		move.addActionListener(this);
		
		
		Buttons.add(brush);
	   	Buttons.add(rect);
		Buttons.add(oval);
		Buttons.add(move);
		
		
		JPanel borderline = new JPanel();
		
		
		
		borderline.setLayout(new BorderLayout());
		
		borderline.add(Colors, BorderLayout.NORTH);
		borderline.add(Buttons, BorderLayout.CENTER);
		borderline.add(border, BorderLayout.SOUTH);
		
		
		add(borderline, BorderLayout.NORTH);
		
		
		
		
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Dikdörtgen Çiz")) {
			
			drawrect = true;
			drawbrush = false;
			drawoval = false;
			moveshape = false;
		}
		else if (e.getActionCommand().equals("Oval Çiz")) {
			
			drawrect = false;
			drawbrush = false;
			drawoval = true;
			moveshape = false;
		}
		else if (e.getActionCommand().equals("Taşı")) {
		
			drawrect = false;
			drawbrush = false;
			drawoval = false;
			moveshape = true;
		}
		else {
			drawrect = false;
			drawbrush = true;
			drawoval = false;
			moveshape = false;
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		
		
	
		
		
		if(drawbrush) {
		
		
			g.setColor(c);
			g.fillRect(x,y,20,20);
		}
		
		if(drawrect&&inborder) {
		
			
			if((old_x - x) > 0 && (old_y - y) > 0 && old_y - Math.abs(old_y - y) > border.getY() + border.getHeight()+29) {
				g.setColor(c);
				g.fillRect(old_x - Math.abs(old_x - x) , old_y - Math.abs(old_y - y), Math.abs(old_x - x), Math.abs(old_y - y));
				
			}
			else if ((old_y - y) > 0 && old_y - Math.abs(old_y - y) > border.getY() + border.getHeight()+29) {
				g.setColor(c);
				g.fillRect(old_x , old_y - Math.abs(old_y - y), Math.abs(old_x - x), Math.abs(old_y - y));
				
			}
			else if((old_x - x) > 0 && old_y > border.getY() + border.getHeight()+29) {
				g.setColor(c);
				g.fillRect(old_x - Math.abs(old_x - x) , old_y, Math.abs(old_x - x), Math.abs(old_y - y));
				
			}
			else if (old_y > border.getY() + border.getHeight()+29)
			{
				g.setColor(c);
				g.fillRect(old_x, old_y, Math.abs(old_x - x), Math.abs(old_y - y)); 
				
			}
			else {}
			
			
		
		}
		
		if(drawoval&&inborder) {
			
			if((old_x - x) > 0 && (old_y - y) > 0 && old_y - Math.abs(old_y - y) > border.getY() + border.getHeight()+29) {
				g.setColor(c);
				g.fillOval(old_x - Math.abs(old_x - x) , old_y - Math.abs(old_y - y), Math.abs(old_x - x), Math.abs(old_y - y));
				
			}
			else if ((old_y - y) > 0 && old_y - Math.abs(old_y - y) > border.getY() + border.getHeight()+29) {
				g.setColor(c);
				g.fillOval(old_x , old_y - Math.abs(old_y - y), Math.abs(old_x - x), Math.abs(old_y - y));
				
			}
			else if((old_x - x) > 0 && old_y > border.getY() + border.getHeight()+29) {
				g.setColor(c);
				g.fillOval(old_x - Math.abs(old_x - x) , old_y, Math.abs(old_x - x), Math.abs(old_y - y));
				
			}
			else if (old_y > border.getY() + border.getHeight()+29)
			{
				g.setColor(c);
				g.fillOval(old_x, old_y, Math.abs(old_x - x), Math.abs(old_y - y)); 
				
			}
			else {}
						
			
			
		}
		

		
		for(int i = 0; i < shape.size();i++) {
			
			
			
			if(shape.get(i).getClass().getName().equals("Paint$Point")) {
				
				Point tmp = (Point) shape.get(i);
				
					g.setColor(tmp.color);
					g.fillRect(tmp.x, tmp.y, 20, 20);
					
			
			}
			else if(shape.get(i).getClass().getName().equals("Paint$Rectangle")) {
				
				Rectangle tmp = (Rectangle) shape.get(i);
				
				g.setColor(tmp.color);
				g.fillRect(tmp.x, tmp.y, tmp.xwidth, tmp.ywidth);
					
				
				
			}
			else {
				
				Oval tmp = (Oval)shape.get(i);
				
				g.setColor(tmp.color);
				g.fillOval(tmp.x, tmp.y, tmp.xwidth, tmp.ywidth);
					
				
				
			}
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		new Paint();
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		if (e.getX() <= blue.getX()+7 + blue.getWidth() && e.getX()+7 >= blue.getX() && e.getY() <= blue.getY()+30 + 50 && e.getY() >= blue.getY()+30 ) {
			c = Color.blue;
			
		}
		else if (e.getX() <= red.getX()+7 + 50 && e.getX() >= red.getX()+7 && e.getY() <= red.getY()+30 + 50 && e.getY() >= red.getY()+30 ) {
			
			c = Color.red;
		}
		else if (e.getX() <= green.getX()+7 + 50 && e.getX() >= green.getX()+7 && e.getY() <= green.getY()+30 + 50 && e.getY() >= green.getY()+30 ) {
			c = Color.green;
			
		}	
		else if (e.getX() <= yellow.getX()+7 + 50 && e.getX() >= yellow.getX()+7 && e.getY() <= yellow.getY()+30 + 50 && e.getY() >= yellow.getY()+30 ) {
			c = Color.yellow;
		}	
		else if (e.getX() <= orange.getX()+7 + 50 && e.getX() >= orange.getX()+7 && e.getY() <= orange.getY()+30 + 50 && e.getY() >= orange.getY()+30 ) {
			c = Color.orange;
		}	
		else if (e.getX() <= purple.getX()+7 + 50 && e.getX() >= purple.getX()+7 && e.getY() <= purple.getY()+30 + 50 && e.getY() >= purple.getY()+30 ) {
			c = Color.magenta;
		}	
		else if (e.getX() <= black.getX()+7 + 50 && e.getX() >= black.getX()+7 && e.getY() <= black.getY()+30 + 50 && e.getY() >= black.getY()+30 ) {
			c = Color.black;
		}	
		else {
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if(drawrect && inborder) {
			
			old_x = e.getX();
			old_y = e.getY();
		}
		
		if(drawoval && inborder) {
			old_x = e.getX();
			old_y = e.getY();
		}
		
		
			if(moveshape) {
				
				for(int i = 0; i < shape.size(); i++) {
					
					if(shape.get(i).getClass().getName().equals("Paint$Rectangle")) {
						
						Rectangle tmp = (Rectangle) shape.get(i);
						
						if(e.getX() >= tmp.x  && e.getX() <= (tmp.x+tmp.xwidth) && e.getY() >= tmp.y && e.getY() <= (tmp.y+tmp.ywidth) ) {
							withinshape = true;
							item = i;
							
						}
					}
					
					else if(shape.get(i).getClass().getName().equals("Paint$Oval")) {
						
						Oval tmp = (Oval) shape.get(i);
						
						double covertex = tmp.ywidth/2;
						double vertex = tmp.xwidth/2;
						
						double x = e.getX() - (tmp.x + vertex);
						double y = e.getY() - (tmp.y + covertex);
						
						double formula = ((Math.pow(x, 2)) / Math.pow(vertex, 2))
								+((Math.pow(y, 2)) / Math.pow(covertex, 2));
						
						
						
						if(formula <= 1) {
							withinshape = true;
							item = i;
							
						}
						
				}
								
			}
			}
		
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
		
		
		if(drawrect && isdragging) {
			
			
			
			
			if((old_x - x) > 0 && (old_y - y) > 0 && old_y - Math.abs(old_y - y) > border.getY() + border.getHeight()+29) {
				
				
				shape.add(new Rectangle(old_x - Math.abs(old_x - x), old_y - Math.abs(old_y - y), Math.abs(old_x - x), Math.abs(old_y - y), this.c));
				
			}
			else if ((old_y - y) > 0 && old_y - Math.abs(old_y - y) > border.getY() + border.getHeight()+29) {
				
			
				shape.add(new Rectangle(old_x, old_y - Math.abs(old_y - y), Math.abs(old_x - x), Math.abs(old_y - y), this.c));
			}
			else if((old_x - x) > 0 && old_y > border.getY() + border.getHeight()+29) {
				
				
				shape.add(new Rectangle(old_x - Math.abs(old_x - x), old_y, Math.abs(old_x - x), Math.abs(old_y - y), this.c));

			}
			else if (old_y > border.getY() + border.getHeight()+29) {
						
				
		
				shape.add(new Rectangle(old_x, old_y, Math.abs(old_x - x), Math.abs(old_y - y), this.c));

			}
			else {}
			
			
			isdragging = false;
			
			
			repaint();
		}
		
		
		if(drawoval&&isdragging) {
			
			if((old_x - x) > 0 && (old_y - y) > 0 && old_y - Math.abs(old_y - y) > border.getY() + border.getHeight()+29) {
				
				
				shape.add(new Oval(old_x - Math.abs(old_x - x), old_y - Math.abs(old_y - y), Math.abs(old_x - x), Math.abs(old_y - y), this.c));
				
			}
			else if ((old_y - y) > 0 && old_y - Math.abs(old_y - y) > border.getY() + border.getHeight()+29) {
				
			
				shape.add(new Oval(old_x, old_y - Math.abs(old_y - y), Math.abs(old_x - x), Math.abs(old_y - y), this.c));
			}
			else if((old_x - x) > 0 && old_y > border.getY() + border.getHeight()+29) {
				
				
				shape.add(new Oval(old_x - Math.abs(old_x - x), old_y, Math.abs(old_x - x), Math.abs(old_y - y), this.c));

			}
			else if (old_y > border.getY() + border.getHeight()+29) {
						
				
		
				shape.add(new Oval(old_x, old_y, Math.abs(old_x - x), Math.abs(old_y - y), this.c));

			}
			else {}
			
			
			isdragging = false;
			
			
			repaint();
			
		}
		
		if(moveshape && withinshape) {
			withinshape = false;
			
			if(!inborder)
				return;
			
			if(shape.get(item).getClass().getName().equals("Paint$Rectangle")) {
				
				Rectangle tmp = (Rectangle)shape.get(item);
				tmp.x = e.getX();
				tmp.y = e.getY();
				
				shape.remove(item);
				shape.add(tmp);
			}
			else if (shape.get(item).getClass().getName().equals("Paint$Oval")) {
				
				Oval tmp = (Oval)shape.get(item);
				tmp.x = e.getX();
				tmp.y = e.getY();
				
				shape.remove(item);
				shape.add(tmp);
			}
			else {
				
			}
			
			repaint();
		}
		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
		
		if(e.getY() >= border.getY() + border.getHeight()+29)
			inborder = true;
		else
			inborder = false;
		
		
		
	if(!inborder)
		return;
		
	
		
	if(drawbrush) {
		
		x = e.getX();
		y = e.getY();
		
		Point p = new Point(e.getX(), e.getY(),this.c);
		
		shape.add(p);
		
		
		
		repaint();
	}
	
	if(drawrect) {
		
		isdragging = true;
		x = e.getX();
		y = e.getY();
		
		
		
		repaint();
	}
	
	if(drawoval) {
		
		isdragging = true;
		x = e.getX();
		y = e.getY();
		
		
		
		repaint();
	}
	
	if(moveshape) {
		if(withinshape) {
			
			if(shape.get(item).getClass().getName().equals("Paint$Rectangle")) {
				
				Rectangle tmp = (Rectangle)shape.get(item);
				tmp.x = e.getX();
				tmp.y = e.getY();
				
			}
			else if (shape.get(item).getClass().getName().equals("Paint$Oval")) {
				
				Oval tmp = (Oval)shape.get(item);
				tmp.x = e.getX();
				tmp.y = e.getY();
				
			}
			else {
				
			}
			
			
			repaint();
		}
		
		
	}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		

		
		
	}
	
	
	class Point extends Shape{
		
		int x;
		int y;
		
		Color color;
		
		public Point(int x, int y, Color color) {
			
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
	
	class Rectangle extends Shape{
		
		int x;
		int y;
		int xwidth;
		int ywidth;
		Color color;
		
		public Rectangle(int x, int y, int xwidth, int ywidth, Color color) {
			
			this.x = x;
			this.y = y;
			this.xwidth = xwidth;
			this.ywidth = ywidth;
			this.color = color;
		}
	}
	
	class Oval extends Shape{
		
		int x;
		int y;
		int xwidth;
		int ywidth;
		Color color;
		
		public Oval(int x, int y, int xwidth, int ywidth, Color color) {
			
			this.x = x;
			this.y = y;
			this.xwidth = xwidth;
			this.ywidth = ywidth;
			this.color = color;
		}
	}

	abstract class Shape{
		
	}
}
