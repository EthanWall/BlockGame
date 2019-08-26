package blockgame.objects.blocks;

import java.awt.Color;
import java.awt.Graphics;

import blockgame.CollidableObject;
import blockgame.ID;
import blockgame.objects.Block;

public class Dirt extends Block {

	public Dirt(float x, float y) {
		super(x, y, ID.DIRTBLOCK);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.orange);
		g.fillRect((int)x, (int)y, width, height);
		
	}

	@Override
	public void collide(CollidableObject otherObject) {
		// TODO Auto-generated method stub
		
	}

}
