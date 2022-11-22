package com.game_assignment.game;

// import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
// import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
// import com.badlogic.gdx.utils.ScreenUtils;
// import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.Input;
// import com.badlogic.gdx.InputAdapter;
// import com.badlogic.gdx.math.Vector2;

public class Game_Assignment extends Game {

	SpriteBatch batch;
	Texture img;

	ShapeRenderer shapeRenderer;
	BitmapFont font ;
	@Override
	public void create () {
        batch = new SpriteBatch();
		img = new Texture("Game Over.jpg");
        shapeRenderer = new ShapeRenderer();
        setScreen(new GameScreen(this));
    }
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		shapeRenderer.dispose();
		font.dispose();
	}
}
