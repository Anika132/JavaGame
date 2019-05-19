package spaceinvader;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Alien extends Sprite implements GameConstants {
	
	 boolean isVisible;
	public Alien(int x,int y) {
		
		this.x = x;
		this.y = y;
		this.w = 50;
	     this.h=50;
		this.speed= 3;
		image = new ImageIcon(Alien.class.getResource(ALIEN_IMAGE)).getImage();	
		this.isVisible = true;
	}
	

	public void drawAlien(Graphics g) {
		if(isVisible) {
		g.drawImage(image, x, y, A_WIDTH, A_HEIGHT, null);
		move();
		}	
	}

	private void move() {
		y+=1;
	}
	
}
