package com.game_assignment.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
// import com.badlogic.gdx.graphics.Texture;

public class TankSelectionScreen extends ScreenAdapter{

    Game_Assignment game;
    // Texture tank1,tank2,tank3;



    public TankSelectionScreen(Game_Assignment game)
    {
        this.game = game;
        // this.tank1=new Texture("Blazer.jpg");
        // this.tank2 = new Texture("helios.jpg");
        // this.tank3 = new Texture("Mark1.jpg");
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(new GameScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(.25f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(game.tank1 , 30, 100);
        game.batch.draw(game.tank2, 330 , 100);
        game.batch.draw(game.tank3, 630 , 100);

        game.font.draw(game.batch , "Select your tank " , 100 , 50);
        game.font.draw(game.batch , "Press Space to return " , 100 , 20);

        game.batch.end();
    }

    @Override
    public void hide()
    {
        Gdx.input.setInputProcessor(null);
    }
}
