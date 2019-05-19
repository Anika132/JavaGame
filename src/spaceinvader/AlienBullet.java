package spaceinvader;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class AlienBullet extends Sprite implements GameConstants{
	
	public AlienBullet(int x,int y) {
		
		this.x = x;
		this.y = y;
		this.w = A_BWIDTH;
		this.h = A_BHEIGHT;
		this.speed = 3;
		this.image = new ImageIcon(AlienBullet.class.getResource(BULLET_IMAGE)).getImage();
	}
	
	public void drawAbullet(Graphics g) {
		
		g.drawImage(image, x, y, w, h, null);
		move();
		
	}
	public void move() {
		y+= 3;
	}

}
