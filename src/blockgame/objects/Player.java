package blockgame.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import blockgame.Game;
import blockgame.GameObject;
import blockgame.Handler;
import blockgame.ID;
import blockgame.KeyInput;
import blockgame.MouseInput;
import blockgame.objects.blocks.DirtBlock;

public class Player extends GameObject {

	private float _acc = 1F;
	private float _dcc = 0.5F;
	private static int width = 32;
	private static int height = 64;
	private float prevX, prevY;
	private KeyInput kInput;
	private MouseInput mInput;
	private Game game;
	
	public Player(float x, float y, KeyInput keyInput, MouseInput mouseInput, Game game) {
		super(x, y, width, height, ID.PLAYER, game);
		
		this.kInput = keyInput;
		this.mInput = mouseInput;
		this.game = game;
		
	}

	@Override
	public void tick() {
		
		Handler handler = game.getHandler();
		
		//Gravity
		boolean inAir = true;
		for (int i = 0; i < handler.object.size(); i++) {
			
			if (handler.object.get(i) instanceof Block) {
				
				if (new Rectangle((int)x, (int)y + 1, (int)width, (int)height).intersects(handler.object.get(i).getBounds())) {
					
					inAir = false;
					
				}
				
			}
			
		}
		if (inAir) {
			
			y++;
			
		}
		
		// Collisions
		for (int i = 0; i < handler.object.size(); i++) {
			
			if (this != handler.object.get(i) && getBounds().intersects(handler.object.get(i).getBounds())) {
				
				collide(handler.object.get(i));
				
			}
			
		}
		
		//Moving the character
		prevX = Float.valueOf(x);
		prevY = Float.valueOf(y);
		x += velX;
		y += velY;
		
		//Keyboard
		//Horizontal movement
		//keys 0 = true right
		//keys 1 = true left
		if (kInput.keys[0]) {
			velX += _acc;
		}
		else if (kInput.keys[1]) {
			velX -= _acc;
		}
		else if (!kInput.keys[0] && !kInput.keys[1]) {
			
			if (velX > 0) {
				velX -= _dcc;
			}
			if (velX < 0) {
				velX += _dcc;
			}
			
		}
		
		//Vertical movement
		//keys 2 = true up
		if (kInput.keys[2]) {
			velY -= _acc;
		}
		else if (kInput.keys[3]) {
			velY += _acc;
		}
		else if (!kInput.keys[2] && !kInput.keys[3]) {
			
			if (velY > 0) {
				velY -= _dcc;
			}
			if (velY < 0) {
				velY += _dcc;
			}
			
		}
		
		velX = clamp(velX, 5, -5);
		velY = clamp(velY, 5, -5);
		
		//Mouse
		//keys 0 = true left
		//keys 1 = true right
		if (mInput.clicks[0]) {
			
			int roundX = Math.round(mInput.x / 32) * 32;
			int roundY = Math.round(mInput.y / 32) * 32;
			
			for (int i = 0; i < handler.object.size(); i++) {
				if (handler.object.get(i) instanceof Block) {
					
					int otherRoundX = Math.round(handler.object.get(i).getX() / 32) * 32;
					int otherRoundY = Math.round(handler.object.get(i).getY() / 32) * 32;
					
					if (roundX == otherRoundX && roundY == otherRoundY) {
						
						handler.removeObject(handler.object.get(i));
						
					}
				}
			}
			
			game.getHandler().removeObject(null);
			
		}
		else if (mInput.clicks[1]) {
			
			int roundX = Math.round(mInput.x / 32) * 32;
			int roundY = Math.round(mInput.y / 32) * 32;
			handler.addObject(new DirtBlock(roundX, roundY, game));
			
		}
		
	}

	@Override
	public void collide(GameObject otherObject) {
		//Handle colliding with another object
			
			x = prevX;
			y = prevY;
			velX = 0;
			velY = 0;
		
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
