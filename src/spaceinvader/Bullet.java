package spaceinvader;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Bullet extends Sprite implements GameConstants{
	
    int count;
	boolean isVisible;
	public Bullet(int x , int y) {
		
		this.x = x;
		this.y = y;
		this.w = B_WIDTH;
		this.h = B_HEIGHT;
		this.speed=10;
		this.image = new ImageIcon(Bullet.class.getResource(BULLET_IMAGE)).getImage();
		count =0;
		this.isVisible = true;
	}
	
	public void drawBullet(Graphics g) {
		if(isVisible) {
		g.drawImage(image, x, y, w, h, null);
		move();
		}
	}
	
	public void move() {
		y-=speed;
	}
	
}
