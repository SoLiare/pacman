package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MazeRenderer {
	private Maze maze;
	private SpriteBatch batch;
	private Texture wallImg;
	private Texture dotImg;
	
	public MazeRenderer(SpriteBatch batch, Maze maze) {
		this.maze = maze;
		this.batch = batch;
		
		wallImg = new Texture("wall.png");
		dotImg = new Texture("dot.png");
	}
	
	public void render() {
		batch.begin();
		for(int r = 0; r < maze.getHeight(); r++) {
			for(int c = 0; c < maze.getWidth(); c++) {
				int x = c * WorldRenderer.BLOCK_SIZE;
				int y = PacmanGame.HEIGHT - (r * WorldRenderer.BLOCK_SIZE) - WorldRenderer.BLOCK_SIZE;
				
				if(maze.hasWallAt(r, c)) {
					batch.draw(wallImg, x, y);
				}
				else if(maze.hasDotAt(r, c)) {
					batch.draw(dotImg, x, y);
				}
			}
		}
		batch.end();
	}
}
