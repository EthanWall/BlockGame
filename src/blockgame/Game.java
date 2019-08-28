package blockgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import blockgame.objects.Player;
import blockgame.objects.blocks.DirtBlock;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 443550799945276174L;
	
	public static int WIDTH = 800, HEIGHT= 608;
	public static String title = "Block Game";
	
	private Thread thread;
	private boolean isRunning = false;
	
	private Handler handler;
	private KeyInput input;
	
	public Game() {
		
		new Window(WIDTH, HEIGHT, title, this);
		start();
		
		init();
		
	}
	
	private void init() {
		
		handler = new Handler();
		input = new KeyInput();
		this.addKeyListener(input);
		
		handler.addObject(new Player(100, 512, input));
		handler.addObject(new DirtBlock(300, 100));
		
	}
	
	private synchronized void start() {
		
		if (isRunning) return;
		
		thread = new Thread(this);
		thread.start();
		isRunning = true;
		
	}
	
	@SuppressWarnings("unused")
	private synchronized void stop() {
		
		if (!isRunning) return;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isRunning = false;
		
	}
	
	@Override
	public void run() {
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		
	}

	private void tick() {
		//Updates the game
		handler.tick();
	}
	
	private void render() {
		//Renders the game
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			
			this.createBufferStrategy(3);
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(0, 255, 255));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		bs.show();
		g.dispose();
		
	}
	
	public static void main(String args[]) {
		
		new Game();
		
	}
	
}
