package spaceinvader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants {
	private int x,y;
	private Player player;
private AlienBullet alienbullet;
private Timer timer;
	private ArrayList<Bullet> Bullets = new ArrayList<>();
	private Alien[][] Aliens = new Alien[4][10];
	
	private void loadAliens() {
		int i=0,j;
		y=0;
		for(i=0;i<4;i++) {
			x=G_WIDTH/4;
	    for(j=0;j<10;j++) {
		Aliens[i][j] = new Alien(x,y);
		x+=A_WIDTH;
		}
			y+=A_HEIGHT;
		}
		
		
	
	}	
	public Board() {
		//count = 0;
		setSize(G_WIDTH,G_HEIGHT);
		player = new Player();
		loadAliens();
		gameLoop();	
		setFocusable(true);
		bindEvents();
		
	}
	private void checkCollision(Graphics g) {
		for(Bullet bullet:Bullets) {
		 for(int i =3;i>=0;i--) {
	      for(int j=0;j<10;j++) {
	    	if(bullet.isVisible) {
	    	 if(Aliens[i][j].isVisible) {
					if(isCollide(Aliens[i][j],bullet))
					{
						Aliens[i][j].isVisible = false;
                        AllDead(g);
						bullet.isVisible = false;
	    	}	
	      }
		}
	  }
   }
}}
	
	
	
	
	private void DrawAliens(Graphics g) {
		int i,j;
		for(i=0;i<4;i++) {
		for(j=0;j<10;j++) {
			if(Aliens[i][j].isVisible) {
		    Aliens[i][j].drawAlien(g);	
		    
		}
		   }
		 }
		}
	private boolean isCollide(Alien A,Bullet B) {
		int maxW = Math.max(A.getW(), B.getW());
		int maxH = Math.max(A.getH(), B.getH());
		int Xdistance = Math.abs(A.getX() - B.getX());
		int Ydistance = Math.abs(A.getY() - B.getY());
		return Xdistance<=maxW && Ydistance<=maxH;		
	}
	
	
	private void DrawBullets(Graphics g) {
		
		for(Bullet bullet : Bullets) {
			bullet.drawBullet(g);
		}
	}
	
	private boolean isCollision(Player player, Alien alien) {
		int maxW = Math.max(player.getW(), alien.getW());
		int maxH = Math.max(player.getH(), alien.getH());
		int Xdistance = Math.abs(player.getX()-alien.getX());
		int Ydistance = Math.abs(player.getY()-alien.getY());
		return Xdistance<=maxH-50 && Ydistance<=maxW-95;		
	}
	
	private void CheckCollide(Graphics g) {
		 int i,j;
		for(i=3;i>=0;i--) {
			for(j=0;j<10;j++) {
				if(isCollision(player,Aliens[i][j])) {
					gameOver(g);
					return;
				}
			}
		}
}
	
	private void AllDead(Graphics g) {
		int i,j;
	boolean a = false;
//int count =0;
		for(i=3;i>=0;i--) {
			for(j=9;j>=0;j--) {
					a = (a)||(Aliens[i][j].isVisible);
			}
			}
		if(!a) {
			win(g);
			timer.stop();
			return;
			}
		
		
	}
	
	private void win(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial",Font.BOLD,50));
		g.drawString("YOU WIN", G_WIDTH/2-200, G_HEIGHT/2);
		timer.stop();
		
	}
	
	private void gameOver(Graphics g) {
		
		g.setColor(Color.RED);
		g.setFont(new Font("Arial",Font.BOLD,45));
		g.drawString("Game Over", G_WIDTH/2-200, G_HEIGHT/2);
		timer.stop();
	}
	
/*private void DrawAlienBullets(Graphics g) {
	
	int i,j;
	for(i=3;i>=0;i--) {
		for(j=0;j<10;j++) {
			int X = Aliens[i][j].getX() + (Aliens[i][j].getW()/2);
			int Y = Aliens[i][j].getY() + (Aliens[i][j].getH()/2);
			alienbullet = new AlienBullet(X,Y);
			alienbullet.drawAbullet(g);
			alienbullet.move();
		}
	}
}*/
	private void bindEvents() {
		
		this.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				/*if(keyCode == KeyEvent.VK_RIGHT) {
					player.move(5);
					
				}
				 
					if (keyCode== KeyEvent.VK_LEFT) {
						player.move(-5);
					}*/
					
				if(keyCode == KeyEvent.VK_SPACE) {
					int BulletX = player.getX()+(player.getW()/2);
					int BulletY = player.getY()-(player.getH()/2)+40;;
					Bullet bullet = new Bullet(BulletX,BulletY);
					Bullets.add(bullet);
				}
			}
			
		});
		
	}
	
	private void DrawBackground(Graphics g) {
		
		Image img = new ImageIcon(Board.class.getResource(BACKGROUND_IMAGE)).getImage();
		g.drawImage(img, 0, 0, G_WIDTH, G_HEIGHT, null);
		
	}
	
	public void gameLoop() {
		
		timer = new Timer(DELAY,e->{
			repaint();
		});
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		DrawBackground(g);
		player.drawPlayer(g);
		DrawAliens(g);
     //   DrawAlienBullets(g);
		DrawBullets(g);
		checkCollision(g);
		CheckCollide(g);
	//AllDead(g);
		
	}

}
