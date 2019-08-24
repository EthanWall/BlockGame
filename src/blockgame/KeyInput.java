package blockgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	public boolean keys[] = new boolean[3];
	//keys 0 = true right
	//keys 1 = true left
	//keys 2 = true up
	
	public void keyPressed(KeyEvent e) {
		System.out.println("Pressed");
		int key = e.getKeyCode();
		System.out.println(key);
		if (key == KeyEvent.VK_D) {
			keys[0] = true;
		}
		if (key == KeyEvent.VK_A) {
			keys[1] = true;
		}
		if (key == KeyEvent.VK_SPACE) {
			keys[2] = true;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		System.out.println("Released");
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_D) {
			keys[0] = false;
		}
		if (key == KeyEvent.VK_A) {
			keys[1] = false;
		}
		if (key == KeyEvent.VK_SPACE) {
			keys[2] = false;
		}
		
	}
	
}
