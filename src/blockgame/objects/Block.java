package blockgame.objects;

import blockgame.Game;
import blockgame.GameObject;
import blockgame.ID;

public abstract class Block extends GameObject {

	public Block(float x, float y, ID id, Game game) {
		super(x, y, 32, 32, id, game);
	}

}
