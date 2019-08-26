package blockgame.objects;

import blockgame.CollidableObject;
import blockgame.ID;

public abstract class Block extends CollidableObject {

	public Block(float x, float y, ID id) {
		super(x, y, 32, 32, id);
	}

}
