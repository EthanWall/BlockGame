package blockgame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import blockgame.objects.Block;

public class TerrainGenerator {
	
	private int width, height;
	private Game game;
	private ArrayList<ID> block = new ArrayList<ID>(List.of(ID.DIRTBLOCK));
	
	public TerrainGenerator(int width, int height, Game game) {
		
		this.width = width;
		this.height = height;
		this.game = game;
		
	}
	
	public LinkedList<Block> generate() {
		
		Random rand = new Random();
		LinkedList<Block> genBlocks = new LinkedList<Block>();
		
		for (int x = 1; x <= width; x += 32) {
			for (int y = 1; y <= height; y += 32) {
				
				if (y > 400) {
					
					genBlocks.add(ID.createBlockFromID(block.get(rand.nextInt(block.size())), (float)x, (float)y, game));
					
				}
				
			}
		}
		
		System.out.println(genBlocks);
		return genBlocks;
		
	}
	
}
