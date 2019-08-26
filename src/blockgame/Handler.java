package blockgame;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		
		for (int i = 0; i < object.size(); i++) {
			
			object.get(i).tick();
		
			if (object.get(i) instanceof CollidableObject) {
				
				CollidableObject collI = (CollidableObject) object.get(i);
				
				for (int j = 0; j < object.size(); j++) {
					
					if (object.get(i) != object.get(j) && object.get(j) instanceof CollidableObject) {
						
						CollidableObject collJ = (CollidableObject) object.get(j);
						
						if (collI.collidesWith(collJ)) {
							
							collI.collide(collJ);
							
						}
						
					}
					
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
