package blockgame.objects;

import java.awt.Color;
import java.awt.Graphics;

import blockgame.CollidableObject;
import blockgame.ID;
import blockgame.KeyInput;

public class Player extends CollidableObject {

	private float _acc = 1F;
	private float _dcc = 0.5F;
	private KeyInput input;
	
	public Player(float x, float y, ID id, KeyInput input) {
		super(x, y, 32, 32, id);
		
		this.input = input;
		
	}

	@Override
	public void tick() {
		
		x += velX;
		y += velY;
		
		//Horizontal movement
		//keys 0 = true right
		//keys 1 = true left
		if (input.keys[0]) {
			velX += _acc;
		}
		else if (input.keys[1]) {
			velX -= _acc;
		}
		else if (!input.keys[0] && !input.keys[1]) {
			
			if (velX > 0) {
				velX -= _dcc;
			}
			if (velX < 0) {
				velX += _dcc;
			}
			
		}
		
		//Vertical movement
		//keys 2 = true up
		if (input.keys[2]) {
			velY -= _acc;
		}
		else if (!input.keys[2]) {
			
			if (velY > 0) {
				velX -= _dcc;
			}
			if (velY < 0) {
				velX += _dcc;
			}
			
		}
		
		velX = clamp(velX, 5, -5);
		velY = clamp(velY, 5, -5);
		
	}

	private float clamp(float value, float max, float min) {
		
		if (value > max) {
			value = max;
		}
		else if (value <= min) {
			value = min;
		}
		
		return value;
		
	}
	
	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}

}
