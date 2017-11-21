package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private PacmanGame pacmanGame;
	private Texture pacmanImg;
	World world;
	SpriteBatch batch;
	
	private MazeRenderer mazeRenderer;
	
	public WorldRenderer (PacmanGame pacmanGame, World world) {
		this.pacmanGame = pacmanGame;
		batch = pacmanGame.batch;
		
		this.world = world;
		
		pacmanImg = new Texture("pacman.png");
		
		mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
	}
	
	public void render(float delta) {
		mazeRenderer.render();
		
		batch.begin();
		Vector2 pos = world.getPacman().getPosition();
		batch.draw(pacmanImg, pos.x, pos.y);
		batch.end();
	}
}
