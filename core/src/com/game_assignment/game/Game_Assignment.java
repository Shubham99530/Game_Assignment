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
	Texture img,tank1,tank2;
	Texture tank3;
	Texture[] tanklist;
	Texture tank1_player , tank2_player, tank3_player , tank1_player_new, tank2_player_new,tank3_player_new;
	ShapeRenderer shapeRenderer;
	BitmapFont font ;
	@Override
	public void create () {
        batch = new SpriteBatch();
		img = new Texture("Game Over.jpg");
		tank1=new Texture("Blazer.jpg");
        tank2 = new Texture("helios.jpg");
        tank3 = new Texture("Mark 1.jpg");
		tank1_player = new Texture("blazer_player.jpg");
		tank2_player = new Texture("helios_player.jpg");
		tank3_player = new Texture("Mark_1_player.jpg");
		tank1_player_new = new Texture("blazer_player_new.jpg");
		tank2_player_new = new Texture("helios_player_new.jpg");
		tank3_player_new = new Texture("Mark_1_player_new.jpg");
//		healthbar= new Texture("healthbar.jpg");
        shapeRenderer = new ShapeRenderer();
		tanklist = new Texture[]{tank1_player_new, tank2_player_new, tank3_player_new};
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
