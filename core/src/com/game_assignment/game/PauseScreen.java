package com.game_assignment.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class PauseScreen extends ScreenAdapter{
    Game_Assignment game;

    BitmapFont font = new BitmapFont();

    Texture tankA ,tankB ;
    public PauseScreen(Game_Assignment game , Texture tankA , Texture tankB)
    {
        this.game = game;
        this.tankA = tankA;
        this.tankB = tankB;
    }

    @Override
    public void show()
    {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if ((keyCode == Input.Keys.NUM_1) || (keyCode == Input.Keys.NUMPAD_1)) {
                    game.setScreen(new PlayScreen(game,tankA ,tankB));
                }

                else if((keyCode == Input.Keys.NUM_2) || (keyCode == Input.Keys.NUMPAD_2))
                {
//                    game.font.draw(game.batch,"state saved" , 200,200);
                    game.setScreen(new PlayScreen(game,tankA,tankB));
                }

                else if((keyCode == Input.Keys.NUM_3) || (keyCode == Input.Keys.NUMPAD_3))
                {
                    game.setScreen(new EndScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(.150f, 0,0 , 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.font.draw(game.batch, "1) Resume Game ",100,400);
        game.font.draw(game.batch,"2) Save Game ",100,300);
        game.font.draw(game.batch,"3) Exit Game", 100, 200);

        game.batch.end();

    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }


}
