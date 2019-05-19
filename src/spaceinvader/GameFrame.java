package spaceinvader;

import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants {
	
	public GameFrame() {
		
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setTitle(TITLE);
        Board board  = new Board();
        add(board);
        setSize(G_WIDTH,G_HEIGHT);
        setVisible(true);
	}
	
	
	

	public static void main(String[] args) {

		GameFrame Frame  = new GameFrame();
		
	}

}
