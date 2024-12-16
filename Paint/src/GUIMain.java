

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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





class PanelDemo extends JFrame implements ActionListener{
	
	private JPanel mavi_panel;
	private JPanel sari_panel;
	private JPanel yesil_panel;

	class MaviTusHareketi implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			mavi_panel.setBackground(Color.blue);
		}
		
	}
	
	
	
	public PanelDemo() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JPanel tus_paneli = new JPanel();
		tus_paneli.setLayout(new FlowLayout());
		tus_paneli.setBackground(Color.cyan);
		JButton mavi = new JButton("mavi");
		JButton sari = new JButton("sari");
		JButton yesil = new JButton("yesil");
		
		
		//mavi.addActionListener(new MaviTusHareketi());
		/*mavi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mavi_panel.setBackground(Color.blue);
				sari_panel.setBackground(Color.gray);
				yesil_panel.setBackground(Color.gray);
				
			}
		});
		sari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sari_panel.setBackground(Color.yellow);
				yesil_panel.setBackground(Color.gray);
				mavi_panel.setBackground(Color.gray);
				
			}
		});
		
		yesil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yesil_panel.setBackground(Color.green);
				mavi_panel.setBackground(Color.gray);
				sari_panel.setBackground(Color.gray);
				
				
			}
		});*/
		mavi.addActionListener(this);
		sari.addActionListener(this);
		yesil.addActionListener(this);
		
		
		
		
		
		
		
		
			
		tus_paneli.add(mavi);
		tus_paneli.add(sari);
		tus_paneli.add(yesil);
		
		add(tus_paneli, BorderLayout.SOUTH);
		
		JPanel ust_panel = new JPanel();
		ust_panel.setLayout(new GridLayout(1,3));
		
		mavi_panel = new JPanel();
		sari_panel = new JPanel();
		yesil_panel = new JPanel();
		
		mavi_panel.setBackground(Color.gray);
		sari_panel.setBackground(Color.gray);
		yesil_panel.setBackground(Color.gray);
			
		ust_panel.add(mavi_panel);
		ust_panel.add(sari_panel);
		ust_panel.add(yesil_panel);
		
		add(ust_panel,BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("mavi")) {
			sari_panel.setBackground(Color.gray);
			yesil_panel.setBackground(Color.gray);
			mavi_panel.setBackground(Color.blue);
		}
		else if(e.getActionCommand().equals("sari")) {
			sari_panel.setBackground(Color.yellow);
			yesil_panel.setBackground(Color.gray);
			mavi_panel.setBackground(Color.gray);

		}
		else {
			sari_panel.setBackground(Color.gray);
			yesil_panel.setBackground(Color.green);
			mavi_panel.setBackground(Color.gray);
		
			
		}
		
	}
	
	
	
}




class OurFrameWithFlowLayoutManager extends JFrame{
	
	public OurFrameWithFlowLayoutManager() {
		setSize(300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		JButton west = new JButton("West");
		JButton east = new JButton("East");
		JButton north = new JButton("North");
		JButton south = new JButton("South");
		JButton center = new JButton("Center");
		
		add(west);
		add(east);
		add(north);
		add(south);
		add(center);
		
		
		
		setVisible(true);
	}
}
class OurFrameWithGridLayoutManager extends JFrame{

	public OurFrameWithGridLayoutManager() {
		setSize(300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(4,4));
		
		JButton west = new JButton("1");
		JButton east = new JButton("2");
		JButton north = new JButton("3");
		JButton south = new JButton("4");
		JButton center = new JButton("5");
		JButton six = new JButton("6");
		
		add(west);
		add(east);
		add(north);
		add(south);
		add(center);
		add(six);
		
		
		
		setVisible(true);

	}

	
	
}













class OurFrameWithBorderLayoutManager extends JFrame{
	
	public OurFrameWithBorderLayoutManager() {
		setSize(300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JButton west = new JButton("West");
		JButton east = new JButton("East");
		JButton north = new JButton("North");
		JButton south = new JButton("South");
		JButton center = new JButton("Center");
		
		add(west,BorderLayout.WEST);
		add(east,BorderLayout.EAST);
		add(north,BorderLayout.NORTH);
		add(south,BorderLayout.SOUTH);
		add(center,BorderLayout.CENTER);
		
		
		
		setVisible(true);
	}
}



class OurFrame extends JFrame{
	public OurFrame() {
		setSize(300,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JTextField field = new JTextField("Ge!");
		//add(field);
		JButton button = new JButton("Çıkmak için tıkla!");
		add(button);
		
		JLabel label = new JLabel("Hello World!");
		add(label);
		
		
		setVisible(true);
	}
}


class OurFrameWithMenu extends JFrame {
	
	JPanel mavi_panel;
	JPanel sari_panel;
	JPanel yesil_panel;
	
	
	public OurFrameWithMenu() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,3));
		mavi_panel = new JPanel();
		sari_panel = new JPanel();
		yesil_panel = new JPanel();
		add(mavi_panel);
		add(sari_panel);
		add(yesil_panel);
		
		
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu menu = new JMenu("Renkler");
		JMenuItem sari = new JMenuItem("Sari");
		JMenuItem yesil = new JMenuItem("Yesil");
		JMenu diger = new JMenu("Diger");
		
		JMenuItem mavi = new JMenuItem("Mavi");
		JMenuItem kirmizi = new JMenuItem("Kirmizi");
		
		diger.add(mavi);
		diger.add(kirmizi);
		
		
		menu.add(yesil);
		menu.add(sari);
		//menu.add(diger);
		mavi.addActionListener( new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mavi_panel.setBackground(Color.BLUE);
					yesil_panel.setBackground(Color.GRAY);
					sari_panel.setBackground(Color.GRAY);			
				}
			}  
		);
		
		yesil.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mavi_panel.setBackground(Color.GRAY);
				yesil_panel.setBackground(Color.GREEN);
				sari_panel.setBackground(Color.GRAY);			
			}
		}  
		);
		
		sari.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mavi_panel.setBackground(Color.GRAY);
				yesil_panel.setBackground(Color.GRAY);
				sari_panel.setBackground(Color.YELLOW);			
			}
		}  
		);
		
		
		
		menubar.add(menu);
		menubar.add(diger);
		setJMenuBar(menubar);
		setVisible(true);
	}

	
}




class FrameWithTextArea extends JFrame{
	

	

	
	
	public FrameWithTextArea() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setLayout(new BorderLayout());
		
		JLabel message = new JLabel("İsminizi giriniz");
		JTextArea input = new JTextArea(10,10);
		input.setText("Default değer");
		input.setEditable(true);

		JPanel input_panel = new JPanel();
		input_panel.setLayout(new BorderLayout());
		input_panel.add(message,BorderLayout.CENTER);
		
		//input_panel.add(input,BorderLayout.SOUTH);
		JScrollPane scrolled_text = new JScrollPane(input);
		scrolled_text.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrolled_text.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		input_panel.add(scrolled_text,BorderLayout.SOUTH);
		
		add(input_panel,BorderLayout.CENTER);
		
		
		JPanel tus_paneli = new JPanel();
		tus_paneli.setLayout(new FlowLayout());
		JButton enter = new JButton("Tamam");
		JButton temizle = new JButton("Temizle");
		
		
		class TamamTusuIslemi implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(input.getText());
				
			}
			
		}
		
		class TemizleTusuIslemi implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				input.setText("");
				
			}
			
		}
		
		enter.addActionListener(new TamamTusuIslemi());
		temizle.addActionListener(new TemizleTusuIslemi());
		
		
		tus_paneli.add(enter);
		tus_paneli.add(temizle);
		
		add(tus_paneli,BorderLayout.SOUTH);
		
		setVisible(true);
		

		
		
	}
	
}



class OurFrameWithWindowsListener extends JFrame{
	
	private class CheckOnExit implements WindowListener{
		@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("windowOpened");
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowClosing");
			ConfirmWindow ccw = new ConfirmWindow();
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			System.out.println("windowClosed");
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			System.out.println("windowIconified");
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("windowDeiconified");
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			System.out.println("windowActivated");
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			System.out.println("windowDeactivated");
			
		}
		
	}
	
	class ConfirmWindow extends JFrame implements ActionListener{

		public ConfirmWindow() {
			setSize(300, 300);
			setLayout(new GridLayout(2,1));
			JLabel label = new JLabel("Çıkmak istediğinizden emin misimiz?");
			add(label);
			
			JPanel tus_paneli = new JPanel();
			tus_paneli.setLayout(new FlowLayout());
			ImageIcon yes_icon = new ImageIcon("yes.jpg");
			ImageIcon no_icon = new ImageIcon("no.jpg");
			
			JButton ok = new JButton("Evet");
			JButton hayir = new JButton("Hayır");
			
			
			ok.setIcon(yes_icon);
			ok.setMargin(new Insets(10,20,10,20));
			hayir.setIcon(no_icon);
			hayir.setMargin(new Insets(10,20,10,20));
			
			ok.addActionListener(this);
			hayir.addActionListener(this);
			
			tus_paneli.add(ok);
			tus_paneli.add(hayir);
			add(tus_paneli);
			
			
			
			setVisible(true);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Evet")) {
				System.exit(0);
			}
			else {
				dispose();
			}
			
		}
		
	}
	
	public OurFrameWithWindowsListener() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		addWindowListener(new CheckOnExit());
		
		setVisible(true);
	}
	
	
}



class Face extends JFrame implements ActionListener{
	
	JButton tus;
	boolean gozlerin_durumu;
	public Face() {
		super();
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		tus = new JButton("Gozlerini Kapat");
		tus.addActionListener(this);
		gozlerin_durumu = true;
		
		add(tus,BorderLayout.SOUTH);
		
		
		setVisible(true);
	}	
	
	public void paint (Graphics g) {
		super.paint(g);
	
		g.drawOval(150,150,200,200);
		
		if(gozlerin_durumu) {
			g.fillOval(200, 200, 30, 30);
			g.fillOval(275, 200, 30, 30);
		}
		else {
			g.drawLine(200,200,230,200);
			g.drawLine(275,200,305,200);
		}
		
		g.drawLine(200,300,300,300);
		g.drawArc(200, 275, 100, 50, 0,180);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(gozlerin_durumu) {
			gozlerin_durumu = false;
			tus.setText("Gozlerini Ac");
		}
		else {
			gozlerin_durumu = true;
			tus.setText("Gozlerini Kapat");
		}
		repaint();
		
	}
	
	
	
}


class FrameWithOurPanel extends JFrame{
	
	
	private class MyPanel extends JPanel{
		public MyPanel() {
			super();
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.cyan);
			g.fillOval(100, 50, 30, 30);
		}
		
	}
	
	
	public FrameWithOurPanel() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new GridLayout(2,1));
		
		add(new MyPanel());
		add(new MyPanel());
		
	
		setVisible(true);
	}
}



class Tasi extends JFrame implements MouseInputListener{

	
	int x = 50;
	int y = 50;
	boolean dragged = false;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(dragged) {
			x = e.getX();
			y = e.getY();
			repaint();
			dragged = false;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int current_x  =e.getX();
		int current_y  =e.getY();

		if( current_x >= x && current_x < (x+50) &&  current_y >= y && current_y < (y+50)   ) {
			
			dragged = true;
		}
		
		
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	//	System.out.println("mouseMoved");
		
	}
	
	public Tasi() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		addMouseListener(this);
		
		JButton but = new JButton("ankara");
		
		add(but);
		
		addMouseMotionListener(this);
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, 500, 500);
		g.fillRect(x, y, 50, 50);
	}
	
	
	
}


class KutuyuTasi extends JFrame implements MouseInputListener{
	
	public int x = 300;
	public int y = 300;
	
	public int old_x = 300;
	public int old_y = 300;
	
	
	public boolean within_box = false;
	
	public KutuyuTasi() {
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		addMouseMotionListener(this);
		setVisible(true);
		
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.fillRect(x, y, 50, 50);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX() >= x && e.getX() <= (x+50) &&
		   e.getY() >= y && e.getY() <= (y+50) )
			within_box = true;
				
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
		within_box = false;
			
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
			
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
				
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(within_box) {
			old_x  = x;
			old_y = y;
			x = e.getX();
			y = e.getY();
			repaint();
		}
				
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("mouseMoved");
				
	}
	
	
	
}







public class GUIMain {

	
	public static void main(String []args) {
		/*JFrame frame = new JFrame();
		frame.setSize(300,500);
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel label = new JLabel("Hello World!");
		
		frame.add(label);
		frame.setVisible(true);*/
		
		//new OurFrame();
		//new OurFrameWithBorderLayoutManager();
		//new OurFrameWithFlowLayoutManager();
		//new OurFrameWithGridLayoutManager();
		//new PanelDemo();
		//new OurFrameWithMenu();
		//new FrameWithTextArea();
		new OurFrameWithWindowsListener();
		//new KutuyuTasi();
		//new Tasi();
		System.out.println("program sonlandı");
		
	}
	
	
}
