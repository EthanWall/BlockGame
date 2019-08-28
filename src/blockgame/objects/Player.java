package blockgame.objects;

import java.awt.Color;
import java.awt.Graphics;

import blockgame.GameObject;
import blockgame.ID;
import blockgame.KeyInput;

public class Player extends GameObject {

	private float _acc = 1F;
	private float _dcc = 0.5F;
	private static int width = 32;
	private static int height = 64;
	private float prevX, prevY;
	private KeyInput input;
	
	public Player(float x, float y, KeyInput input) {
		super(x, y, width, height, ID.PLAYER, true);
		
		this.input = input;
		
	}

	@Override
	public void tick() {
		
		prevX = Float.valueOf(x);
		prevY = Float.valueOf(y);
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
		else if (input.keys[3]) {
			velY += _acc;
		}
		else if (!input.keys[2] && !input.keys[3]) {
			
			if (velY > 0) {
				velY -= _dcc;
			}
			if (velY < 0) {
				velY += _dcc;
			}
			
		}
		
		velX = clamp(velX, 5, -5);
		velY = clamp(velY, 5, -5);
		
	}

	@Override
	public void collide(GameObject otherObject) {
		//Handle colliding with another object
		
		if (otherObject.isCollidable()) {
			
			x = prevX;
			y = prevY;
			velX = 0;
			velY = 0;
			
		}
		
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
		g.fillRect((int)x, (int)y, width, height);
		
	}

}
