package blockgame.objects;

import blockgame.GameObject;
import blockgame.ID;

public abstract class Block extends GameObject {

	public Block(float x, float y, ID id, boolean collidable) {
		super(x, y, 32, 32, id, collidable);
	}

}
