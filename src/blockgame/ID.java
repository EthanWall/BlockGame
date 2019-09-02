package blockgame;

import blockgame.objects.Block;
import blockgame.objects.blocks.DirtBlock;

public enum ID {

	PLAYER(),
	DIRTBLOCK(),
	STONEBLOCK(),
	BRICKBLOCK();
	
	public static Block createBlockFromID(ID objectID, float x, float y, Game game) {
		
		switch (objectID) {
			case DIRTBLOCK: return new DirtBlock(x, y, game);
			default: return null;
		}
		
	}
	
}
