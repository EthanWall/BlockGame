package blockgame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	public boolean[] clicks = new boolean[2];
	//keys 0 = true left
	//keys 1 = true right
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		int click = e.getButton();
		
		if (click == MouseEvent.BUTTON1) {
			clicks[0] = true;
		}
		if (click == MouseEvent.BUTTON2) {
			clicks[1] = true;
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		int click = e.getButton();
		
		if (click == MouseEvent.BUTTON1) {
			clicks[0] = false;
		}
		if (click == MouseEvent.BUTTON2) {
			clicks[1] = false;
		}
		
	}
	
}
