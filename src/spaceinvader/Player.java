package spaceinvader;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprite implements GameConstants{
	
	public Player() {
		
		x = 200;
		y = G_HEIGHT-P_HEIGHT;
		w = P_WIDTH;
		h = P_HEIGHT;
		this.speed = 10;
		image = new ImageIcon(Player.class.getResource(PLAYER_IMAGE)).getImage();
		
	}
	
	public void drawPlayer(Graphics g) {
		
		g.drawImage(image, x, y, w, h, null);
	move(speed);
       changeDirection();		
	}
	
	private void changeDirection() {
		
		if(x<200) {
			speed*=-1;}
		else if(x>(G_WIDTH-P_WIDTH-200)) {
			speed*=-1;}
		
		
	}

	public void move(int speed) {
			x+=speed;	
			
		}
		
	}
	
	
	


