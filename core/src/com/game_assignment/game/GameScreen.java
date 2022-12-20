package com.game_assignment.game;

import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
// import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameScreen extends ScreenAdapter {

    Game_Assignment game;

    float touch_distance = 50;

    // Screen Input
    float x_newgame =(float) Gdx.graphics.getWidth() / 2 - 50;
    float y_newgame = (float)Gdx.graphics.getHeight() / 2 + 50;

    float x_resume_game = (float)Gdx.graphics.getWidth() / 2 - 50;
    float y_resume_game = (float)Gdx.graphics.getHeight() / 2;

    float x_exit = (float)(Gdx.graphics.getWidth() / 2) - 50;
    float y_exit = (float)Gdx.graphics.getHeight() / 2 - 50;

    boolean p = false;

    public GameScreen(Game_Assignment game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int x, int y, int pointer, int button) {
                int renderY = Gdx.graphics.getHeight() - y;
                if (Vector2.dst(x_newgame, y_newgame, x, renderY) < touch_distance) {
                    game.setScreen(new TankSelectionScreen(game));
                    p=true;
                    return true;
                }
                else if (Vector2.dst(x_resume_game, y_resume_game, x, renderY) < touch_distance )
                {
                    game.setScreen(new ResumeScreen(game));
                    p=true;
                    return true;
                }
                else if(Vector2.dst(x_exit, y_exit, x, renderY) < touch_distance )
                {
                    game.setScreen(new EndScreen(game));
                    p=true;
                    return true;
                }
                p=false;
                return false;
            }
        });

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(.1f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(game.img, -50, 10);
        game.font = new BitmapFont();

        // Game starting Screen
        game.font.draw(game.batch, "New Game", (float)Gdx.graphics.getWidth() / 2 - 50, (float)Gdx.graphics.getHeight() / 2 + 50);
        game.font.draw(game.batch, "Resume Game  ", (float)Gdx.graphics.getWidth() / 2 - 50, (float)Gdx.graphics.getHeight() / 2);
        game.font.draw(game.batch, "Exit Game", (float)Gdx.graphics.getWidth() / 2 - 50, (float)Gdx.graphics.getHeight() / 2 - 50);

        game.batch.end();

    }

    @Override
    public void hide()
    {
        Gdx.input.setInputProcessor(null);
    }
}
