package com.game_assignment.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class PlayScreen extends ScreenAdapter {

    Game_Assignment game;
    // ShapeRenderer shapeRenderer;
    Sprite sprite;
    Texture tankA, tankB;

    // tankB
//    Texture tanklist[];
    float tankA_X =20  ;
    float tankA_Y = 65 ;

    float tankB_X=600-tankA_X;
    float tankB_Y=tankA_Y;

    float hA = tankA_X;
    float hb = tankB_X;

    BitmapFont font = new BitmapFont();
    public PlayScreen(Game_Assignment game , Texture tex ,Texture tankB) {
        this.game = game;
        this.tankA= tex;
        this.tankB=tankB;
    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(new PauseScreen(game,tankA,tankB));
                }

//                if(keyCode == Input.Keys.D)
//                {
//                    tank_X+=3;
//                }
//
//                if (keyCode == Input.Keys.A)
//                {
//                    tank_X-=3;
//                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.150f, 0.2f, 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();


        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        game.shapeRenderer.setColor(0, 1, 0, 1);
        game.shapeRenderer.rect(0, 0, 900, 120);
        game.shapeRenderer.setColor(1,0,0,1);
        game.shapeRenderer.rect(hA, 400, 200 ,10);
        game.shapeRenderer.rect(hb,400,200,10);
        game.batch.draw(tankA,tankA_X ,tankA_Y);
//        game.batch.draw(game.healthbar, tankA_X ,
        // sprite.flip(true,false);
        // sprite.draw(game.batch,tankB_Y);
        game.batch.draw(tankB,tankB_X,tankB_Y);
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            tankA_X-=3;
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            tankA_X+=3;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)){
            tankB_X-=3;
        }

        else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)){
            tankB_X+=3;
        }
        game.font.draw(game.batch , "tank Player 1 " , hA , 395);
        game.font.draw(game.batch , "tank Player 2 " , hb , 395);
        game.batch.end();
        game.shapeRenderer.end();
    }



    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}