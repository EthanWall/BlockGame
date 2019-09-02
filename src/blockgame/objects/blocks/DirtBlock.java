package blockgame.objects.blocks;

import java.awt.Color;
import java.awt.Graphics;

import blockgame.Game;
import blockgame.GameObject;
import blockgame.ID;
import blockgame.objects.Block;

public class DirtBlock extends Block {

	public DirtBlock(float x, float y, Game game) {
		super(x, y, ID.DIRTBLOCK, game);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.orange);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		
	}

	@Override
	public void collide(GameObject otherObject) {
	}

}
