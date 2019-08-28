package blockgame;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		
		for (int i = 0; i < object.size(); i++) {
			
			object.get(i).tick();
				
			for (int j = 0; j < object.size(); j++) {
				
				if (i != j && object.get(i).getBounds().intersects(object.get(j).getBounds())) {
					
					object.get(i).collide(object.get(j));
					
				}
				
			}
			
		}
	
	}
		
	public void render(Graphics g) {
		
		for (int i = 0; i < object.size(); i++) {
			
			object.get(i).render(g);
			
		}

	}
	
	public void addObject(GameObject tempObject) {
		object.add(tempObject);
	}

	public void removeObject(GameObject tempObject) {
		object.remove(tempObject);
	}
	
}
