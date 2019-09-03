package blockgame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	public float x, y;
	public boolean[] clicks = new boolean[2];
	//keys 0 = true left
	//keys 1 = true right
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		int click = e.getButton();
		
		if (click == MouseEvent.BUTTON1) {
			clicks[0] = true;
		}
		if (click == MouseEvent.BUTTON3) {
			clicks[1] = true;
		}
		
		x = e.getX();
		y = e.getY();
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		int click = e.getButton();
		
		if (click == MouseEvent.BUTTON1) {
			clicks[0] = false;
		}
		if (click == MouseEvent.BUTTON3) {
			clicks[1] = false;
		}
		
		x = e.getX();
		y = e.getY();
		
	}
	
}
