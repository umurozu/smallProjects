import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;


public class Game extends JFrame implements KeyListener, MouseInputListener {
	
	LinkedList<Enemy> enem = new LinkedList<>();
	LinkedList<Friend> frien = new LinkedList<>();
	AirCraft airc = new AirCraft();
	Random rand = new Random();
	boolean fire = false;
	boolean weWon;
	
	private class CheckOnExit implements WindowListener{
		

		@Override
		public void windowClosing(WindowEvent e) {
			//System.out.println("windowClosing");
			System.exit(0);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			
			
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class GameFinishedAlert extends JFrame {
		
		public GameFinishedAlert() {
			setSize(300, 300);
			setLayout(new GridLayout(2,1));
			
			if(!weWon) {
			JLabel label = new JLabel("Oyunu Kaybettiniz");
			add(label);
			}
			else if(weWon) {
				JLabel label = new JLabel("Oyunu Kazandınız");
				add(label);
				}
			
			addWindowListener(new CheckOnExit());
			setVisible(true);
		}

		
		
	}
	
	
	public Game() {
		
		super("Star Wars");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		addKeyListener(this);
		addMouseListener(this);
		
		
		
		
		
		
		setVisible(true);
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		try {
		if(enem != null)
		for(int i = 0; i < enem.size(); i++) {
			
		
			g.setColor(Color.black);
			g.fillRect(enem.get(i).x, enem.get(i).y, 10, 10);
		}
		if(frien != null)
        for(int i = 0; i < frien.size(); i++) {
			
			g.setColor(Color.green);
			g.fillRect(frien.get(i).x, frien.get(i).y, 10, 10);
		}
        
		if(airc.neutralized == false) {
		g.setColor(Color.red);
        g.fillRect(airc.x, airc.y, 10, 10);
		}
		}
		catch(Exception e) {
			
		}
	}
	
	
	
	
	

	public class AirCraft extends Thread{
		
		int x;
		int y;
		Color c = Color.red;
		boolean neutralized = false;
		
		
		
			
			public class Rocket extends Thread {
				
				int r_x;
				int r_y;
				int l_x;
				int l_y;
				AirCraft curr;
				
				
				public Rocket(AirCraft f) {
					r_x = f.x - 5;
					r_y = f.y + 3;
					l_x = f.x + 10;
					l_y = f.y + 3;
					curr = f;
					
				}
				
				public void run() {
					boolean r = true;
					boolean l = true;
					
					while(curr.neutralized == false) {
						Graphics boom = getGraphics();
						
						if(!r && !l) {
							boom.clearRect(r_x , r_y , 5, 5);
							boom.clearRect(l_x , l_y , 5, 5);
							//repaint();
							break;
						}
							
							
						
						
						boom.setColor(Color.orange);
						
						if(l)
						boom.fillRect(l_x, l_y, 5, 5);
						if(r)
						boom.fillRect(r_x, r_y, 5, 5);
						try {
						for(int i = 0; i< enem.size(); i++) {
							//if(i < frien.size())
								if(r_x <= enem.get(i).x + 10 && r_x + 5 >= enem.get(i).x) {
									if((r_y + 5 >= enem.get(i).y && r_y + 5<= enem.get(i).y + 10) || r_y >= enem.get(i).y && r_y <= enem.get(i).y + 10) {
										
										enem.get(i).neutralized = true;
										enem.remove(i);
										
										//repaint();
									}
								}
								else if(l_x <= enem.get(i).x + 10  && l_x + 5 >= enem.get(i).x) {
									if((l_y + 5 >= enem.get(i).y && l_y + 5<= enem.get(i).y + 10) || l_y >= enem.get(i).y && l_y <= enem.get(i).y + 10) {
										enem.get(i).neutralized = true;
										enem.remove(i);
										
										//repaint();
									}
								}
						}
						
						
						for(int i = 0; i< frien.size(); i++) {
					
							if(r_x <= frien.get(i).x + 10 && r_x + 5 >= frien.get(i).x) {
								if((r_y + 5 >= frien.get(i).y && r_y + 5<= frien.get(i).y + 10) || r_y >= frien.get(i).y && r_y <= frien.get(i).y + 10) {
									
									r = false;
									
									//repaint();
									break;
								}
							}
							else if(l_x <= frien.get(i).x + 10  && l_x + 5 >= frien.get(i).x) {
								if((l_y + 5 >= frien.get(i).y && l_y + 5<= frien.get(i).y + 10) || l_y >= frien.get(i).y && l_y <= frien.get(i).y + 10) {
									
									
									l = false;
									
									//repaint();
									break;
								}
							}
							
						} 
						
						
						
						}
						catch(Exception e) {
							
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						boom.clearRect(r_x , r_y , 5, 5);
						boom.clearRect(l_x , l_y , 5, 5);
						if(r_x >= 0 && (r_x - 10) >= 0)
						r_x -= 10;
						else r = false;
						if(l_x < 500 && (l_x + 10) < 500)
						l_x += 10;
						else l = false;
						//System.out.println("ateşşş");

						
						
					}
					//repaint();
				}
			
		}
		
		public AirCraft() {
			this.x = 240;
			this.y = 240;
		}
		
		
		
		public void run() {
			while(true) {
				
			if (fire) {
				
				Rocket rock = new Rocket(airc);
				rock.start();
				fire = false;
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			if((enem.size() > 0 && airc.neutralized == true)) {
				
				weWon = false;
				new GameFinishedAlert();
				break;
				}
			else if( enem.size() == 0 && airc.neutralized == false) {
				
				weWon = true;
				new GameFinishedAlert();
				break;
				}
			else if(airc.neutralized == true) {
				weWon = false;
				new GameFinishedAlert();
				break;
				
			}
			
		}
		}

		
		
		

		

	}

	public class Friend extends Thread {
		
		int x;
		int y;
		Color c = Color.green;
		boolean neutralized = false;
		
		public class Rocket extends Thread {
			
			int r_x;
			int r_y;
			int l_x;
			int l_y;
			Friend curr;
			
			
			public Rocket(Friend f) {
				r_x = f.x - 15;
				r_y = f.y + 3;
				l_x = f.x + 20;
				l_y = f.y + 3;
				curr = f;
				
			}
			
			public void run() {
				boolean r = true;
				boolean l = true;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(true) {
					Graphics boom = getGraphics();
					
					if(!r && !l) {
						boom.clearRect(r_x , r_y , 5, 5);
						boom.clearRect(l_x , l_y , 5, 5);
						//repaint();
						break;
					}
						
						
					
					
					boom.setColor(Color.magenta);
					
					if(l)
					boom.fillRect(l_x, l_y, 5, 5);
					if(r)
					boom.fillRect(r_x, r_y, 5, 5);
					try {
						
						
						if(r_x <= airc.x + 10 && r_x + 5 >= airc.x) {
							if((r_y + 5 >= airc.y && r_y + 5<= airc.y + 10) || r_y >= airc.y && r_y <= airc.y + 10) {
								
							
								r = false;
								break;
								
								//repaint();
							}
						}
						else if(l_x <= airc.x + 10  && l_x + 5 >= airc.x) {
							if((l_y + 5 >= airc.y && l_y + 5<= airc.y + 10) || l_y >= airc.y && l_y <= airc.y + 10) {
								
								//repaint();
								l = false;
								break;
							}
						} 
						
						
						
					for(int i = 0; i< enem.size(); i++) {
						//if(i < frien.size())
							if(r_x <= enem.get(i).x + 10 && r_x + 5 >= enem.get(i).x) {
								if((r_y + 5 >= enem.get(i).y && r_y + 5<= enem.get(i).y + 10) || r_y >= enem.get(i).y && r_y <= enem.get(i).y + 10) {
									
									enem.get(i).neutralized = true;
									enem.remove(i);
									
									//repaint();
									return;
								}
							}
							else if(l_x <= enem.get(i).x + 10  && l_x + 5 >= enem.get(i).x) {
								if((l_y + 5 >= enem.get(i).y && l_y + 5<= enem.get(i).y + 10) || l_y >= enem.get(i).y && l_y <= enem.get(i).y + 10) {
									enem.get(i).neutralized = true;
									enem.remove(i);
									
									//repaint();
									return;
								}
							}
					}
					
					
					for(int i = 0; i< frien.size(); i++) {
						
						if(frien.get(i) != curr )
						if(r_x <= frien.get(i).x + 10 && r_x + 5 >= frien.get(i).x) {
							if((r_y + 5 >= frien.get(i).y && r_y + 5<= frien.get(i).y + 10) || r_y >= frien.get(i).y && r_y <= frien.get(i).y + 10) {
								
								
								
								//repaint();
								r = false;
								break;
							}
						}
						else if(l_x <= frien.get(i).x + 10  && l_x + 5 >= frien.get(i).x) {
							if((l_y + 5 >= frien.get(i).y && l_y + 5<= frien.get(i).y + 10) || l_y >= frien.get(i).y && l_y <= frien.get(i).y + 10) {
								
								//repaint();
								l = false;
								break;
							}
						}
						
					} 
					
					
					
					
					}
					catch (Exception e) {
						
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					boom.clearRect(r_x , r_y , 5, 5);
					boom.clearRect(l_x , l_y , 5, 5);
					
					if(r_x >= 0 && (r_x - 10) >= 0)
					r_x -= 10;
					else r = false;
					if(l_x < 500 && (l_x + 10) < 500)
					l_x += 10;
					else l = false;
					//System.out.println("ateşşş");
					
					
					
				}
				//repaint();
			}
		
			public boolean outBorder() {
			
				if((r_x < 0 && l_x > 490)) {
					return true;
				}
				
				return false;
			}
			
			public boolean enemyDied() {
				
				return false;
			}
			
		}
		
		
		public Friend() {
			boolean empty = false;
			
				
				
				
			while (empty == false) {
				
			this.x = (int) (rand.nextInt(3, 48)) * 10;
			this.y = (int) (rand.nextInt(3, 48)) * 10;
			
			if(this.x == 240 && this.y == 240)
				continue;
			
			
			
			if(frien.size() != 0)
			for(int i = 0; i < frien.size(); i++) {
				System.out.println("burda");
				if(this.x == frien.get(i).x && this.y == frien.get(i).y)
					continue;
				 empty = true;
				 break;
			}
			else {
				empty= true;
				break;
			}
			if(enem.size() != 0)
			for(int i = 0; i < enem.size(); i++) {
				if(this.x == enem.get(i).x && this.y == enem.get(i).y)
					continue;
				 empty = true;
				 break;
			}
			else {
				empty= true;
				break;
			}
			
			}
			}
			
		
		
		public void run() {
			//while neutralized == false
			
			frien.add(this);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
			
			while(this.neutralized == false) {
				
				if(this.neutralized == true) 
					break;
				
				
				Rocket fire = new Rocket(this);
				fire.start();
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int direction = rand.nextInt(1,5);
				
				if(direction == 1 && this.y - 10 >= 30) {
					this.y -= 10;
					repaint();
					
				}
				else if (direction == 2 && this.x + 10 <= 480) {
					this.x += 10;
					repaint();
					
				}
				else if(direction == 3 && this.y + 10 <= 480) {
					this.y += 10;
					repaint();
				}
				else if (direction == 4 && this.x - 10 >= 8) {
					this.x -= 10;
					repaint();
				}
				else {
					
				}
				
			}
			
		}
		
		public void fire() { // ateşi printler aynı zamanda anlık konumdan vurulan var mı onu hesaplar
			
		}
		
		

	}

	public class Enemy extends Thread {
		
		
		int x;
		int y;
		Color c = Color.black;
		LinkedList<Rocket> rockets;
		boolean neutralized = false;
		
		public class Rocket extends Thread {
			
			int r_x;
			int r_y;
			int l_x;
			int l_y;
			Enemy curr;
			
			public Rocket(Enemy e) {
				r_x = e.x - 15;
				r_y = e.y + 3;
				l_x = e.x + 20;
				l_y = e.y + 3;
				curr =e;
			}
			
			public void run() {
				
				boolean r = true;
				boolean l = true;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(curr.neutralized == false) {
					
					Graphics boom = getGraphics();
					if(!r && !l) {
						boom.clearRect(r_x , r_y , 5, 5);
						boom.clearRect(l_x , l_y , 5, 5);
						//repaint();
						break;
					}
					
					
					boom.setColor(Color.blue);
					
					if(l)
					boom.fillRect(l_x, l_y, 5, 5);
					if(r)
					boom.fillRect(r_x, r_y, 5, 5);
					
					
					try {
						
					for(int i = 0; i< enem.size(); i++) {
							if(enem.get(i) != curr)
								if(r_x <= enem.get(i).x + 10 && r_x + 5 >= enem.get(i).x) {
									if((r_y + 5 >= enem.get(i).y && r_y + 5<= enem.get(i).y + 10) || r_y >= enem.get(i).y && r_y <= enem.get(i).y + 10) {
										
										
										
										r = false;
										break;
									}
								}
								else if(l_x <= enem.get(i).x + 10  && l_x + 5 >= enem.get(i).x) {
									if((l_y + 5 >= enem.get(i).y && l_y + 5<= enem.get(i).y + 10) || l_y >= enem.get(i).y && l_y <= enem.get(i).y + 10) {
										
										
										l = false;
										break;
									}
								}
						}
						
						if(airc.neutralized == false)
							if(r_x <= airc.x + 10 && r_x + 5 >= airc.x) {
								if((r_y + 5 >= airc.y && r_y + 5<= airc.y + 10) || r_y >= airc.y && r_y <= airc.y + 10) {
									
									airc.neutralized = true;
									
									boom.clearRect(airc.x, airc.y, 10, 10);
									return;
									
									//repaint();
								}
							}
							else if(l_x <= airc.x + 10  && l_x + 5 >= airc.x) {
								if((l_y + 5 >= airc.y && l_y + 5<= airc.y + 10) || l_y >= airc.y && l_y <= airc.y + 10) {
									airc.neutralized = true;
									
									boom.clearRect(airc.x, airc.y, 10, 10);
									//repaint();
									return;
								}
							}
						
						
						
						
					for(int i = 0; i< frien.size(); i++) {
						
						if(i < frien.size())
						if(r_x <= frien.get(i).x + 10 && r_x + 5 >= frien.get(i).x) {
							if((r_y + 5 >= frien.get(i).y && r_y + 5<= frien.get(i).y + 10) || r_y >= frien.get(i).y && r_y <= frien.get(i).y + 10) {
								
								frien.get(i).neutralized = true;
								frien.remove(i);
								
								//repaint();
								return;
							}
						}
						else if(l_x <= frien.get(i).x + 10  && l_x + 5 >= frien.get(i).x) {
							if((l_y + 5 >= frien.get(i).y && l_y + 5<= frien.get(i).y + 10) || l_y >= frien.get(i).y && l_y <= frien.get(i).y + 10) {
								frien.get(i).neutralized = true;
								frien.remove(i);
								//repaint();
								return;
							}
						}
						
					}
					}
					catch(Exception e) {
						
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//boom.clearRect(r_x - 5, r_y - 5, 5, 5);
					//boom.clearRect(l_x + 5, l_y + 5, 5, 5);
					//
					boom.clearRect(r_x , r_y , 5, 5);
					boom.clearRect(l_x , l_y , 5, 5);
					
					
					if(r_x >= 0 && (r_x - 10) >= 0)
					r_x -= 10;
					else r = false;
					
					
					
					if(l_x < 500 && (l_x + 10) < 500)
					l_x += 10;
					else l = false;
					
					
				}
				//repaint();
				
			}
			
			
			
		}
		
		public Enemy() {
			boolean empty = false;
			
			
			
			
			while (empty == false) {
				
			this.x = (int) (rand.nextInt(3, 48)) * 10;
			this.y = (int) (rand.nextInt(3, 48)) * 10;
			
			if(this.x == 240 && this.y == 240)
				continue;
			
			
			
			if(frien.size() != 0)
			for(int i = 0; i < frien.size(); i++) {
				System.out.println("burda");
				if(this.x == frien.get(i).x && this.y == frien.get(i).y)
					continue;
				 empty = true;
				 break;
			}
			else {
				empty= true;
				break;
			}
			if(enem.size() != 0)
			for(int i = 0; i < enem.size(); i++) {
				if(this.x == enem.get(i).x && this.y == enem.get(i).y)
					continue;
				 empty = true;
				 break;
			}
			else {
				empty= true;
				break;
			}
			
			}
		}
		
		public void run() {
			enem.add(this);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
			
			while(!this.neutralized) {
				
				if(this.neutralized == true)
					break;
				
				
				Rocket fire = new Rocket(this);
				fire.start();
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
				int direction = rand.nextInt(1,5);
				
				if(direction == 1 && this.y - 10 >= 30) {
					this.y -= 10;
					repaint();
					
				}
				else if (direction == 2 && this.x + 10 <= 480) {
					this.x += 10;
					repaint();
					
				}
				else if(direction == 3 && this.y + 10 <= 480) {
					this.y += 10;
					repaint();
				}
				else if (direction == 4 && this.x - 10 >= 8) {
					this.x -= 10;
					repaint();
				}
				else {
					
				}
				try {
				for (int i = 0; i < frien.size(); i++) {
					if(this.x == frien.get(i).x && this.y == frien.get(i).y) {
						this.neutralized = true;
						enem.remove(this);
						
						frien.get(i).neutralized = true;
						frien.remove(i);
						repaint();
					}
						
				}
				
				
				if(this.x == airc.x && this.y == airc.y) {
					airc.neutralized = true;
					enem.remove(this);
					this.neutralized = true;
					repaint();
				}
				}
				
				catch (Exception e) {
					
				}
			}
			
		}
		
		public void fire() { // ateşi printler aynı zamanda anlık konumdan vurulan var mı onu hesaplar
			
		}
		
		


	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		Graphics airCraft = getGraphics();
		airCraft.setColor(Color.red);
		if(airc.neutralized == false)
		if(e.getKeyChar() == 'w' && airc.y - 10 > 20) {
			
			airCraft.clearRect(airc.x, airc.y, 10, 10);
			airCraft.fillRect(airc.x, airc.y-10, 10, 10);
			
			airc.y -= 10;
		}
		else if(e.getKeyChar() == 'a' && airc.x - 10 > 0) {
			airCraft.clearRect(airc.x, airc.y, 10, 10);
			airCraft.fillRect(airc.x-10, airc.y, 10, 10);
			airc.x -= 10;
		}
		else if(e.getKeyChar() == 'd' && airc.x + 10 < 490) {
			airCraft.clearRect(airc.x, airc.y, 10, 10);
			airCraft.fillRect(airc.x+10, airc.y, 10, 10);
			airc.x += 10;
		}
		else if(e.getKeyChar() == 's' && airc.y + 10 < 490) {
			airCraft.clearRect(airc.x, airc.y, 10, 10);
			airCraft.fillRect(airc.x, airc.y+10, 10, 10);
			airc.y += 10;
		}
		else {}
		//repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		fire = true;
		
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
