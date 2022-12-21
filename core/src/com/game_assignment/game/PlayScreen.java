package com.game_assignment.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.security.PrivateKey;


public class PlayScreen extends ScreenAdapter {

    Game_Assignment game;
    Texture tankA, tankB;

    private float tankA_X =20  ;
    private float tankA_Y = 65 ;

    private float f=150;
    private int flag =0;
    private float fireball_A_X = tankA_X+100;
    private float fireball_A_Y = tankA_Y+100;
    private float x = fireball_A_X;
    private float y =fireball_A_Y;

    private float power =0;
    private float angle = 0;
    private float height = 0;
    private float range = 0;
    private float tankB_X=600-tankA_X;
    private float tankB_Y=tankA_Y;
    private double a =0;
    private float hA = tankA_X;
    private float hb = tankB_X;

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
                    flag = -1;
                    game.setScreen(new PauseScreen(game,tankA,tankB));
                }

                return true;
            }
        });
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0.150f, 0.2f, 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        game.shapeRenderer.setColor(0, 1, 0, 1);
        game.shapeRenderer.rect(0, 0, 900, 120);
        game.shapeRenderer.setColor(1,0,0,1);
        game.shapeRenderer.rect(hA, 400, 200 ,10);
        game.shapeRenderer.rect(hb,400,200,10);



        game.shapeRenderer.setColor(1,0,1,1);
        game.shapeRenderer.rect(hA,345,f,10);

        game.shapeRenderer.setColor(1,0,0,1);
        game.shapeRenderer.circle(fireball_A_X,fireball_A_Y,10);

        game.font.draw(game.batch,"Tank Player 1 turn" , hA + 100, 395 );
        game.font.draw(game.batch,"Fuel ", hA,350);

        game.font.draw(game.batch,"Angle of Projection :  "+angle, 150,120);
        game.font.draw(game.batch,"Power of Attack :" + power, 650, 120);

        game.batch.draw(tankA,tankA_X ,tankA_Y);
        game.batch.draw(tankB,tankB_X,tankB_Y);
            if(flag == 0)
            {

                if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                    if(f > 0)
                    {
                        tankA_X -= 3;
                        f -=1;
                    }
                }
                else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                    if(f > 0)
                    {
                        tankA_X += 3;
                        f -=1;
                    }
                }

                else if(Gdx.input.isKeyPressed(Input.Keys.W))
                {
                    if (angle <90) {
                        angle += 5;
                    }
                }

                else if (Gdx.input.isKeyPressed(Input.Keys.S))
                {
                    if (angle>0)
                    {
                        angle -= 5;
                    }
                }

                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP))
                {
                    if(power <50f)
                    {
                        power+=1;
                    }
                }
                else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN))
                {
                    if (power > 0)
                    {
                        power-=1;
                    }
                }
                if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
                    a = Math.toRadians(angle);

                    range = (float) ((power * power * 100) * (Math.sin(2 * a)) / 9.8) + x;
                    height = (float) ((10000) * (Math.sin(a) * Math.sin(a)) / 2 * 9.8);
                    if (fireball_A_X < range) {

                        if (fireball_A_X < tankB_X - 50 && fireball_A_Y < tankB_Y - 50) {
                            flag = 1;
                        }
                        fireball_A_X += 10;

                        fireball_A_Y = (float) ((fireball_A_X * Math.tan(a)) - ((9.8 * (fireball_A_X * fireball_A_X)) / (2 * (power * power * 100) * (Math.cos(a) * Math.cos(a))))) + 165;

                    } else {
                        flag = 1;
                    }
//
                }
            }
            else if(flag == 1)
            {
                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
                    tankB_X -= 3;
                } else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
                    tankB_X += 3;
                }
//                flag = 0;
            }

            if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
            {
                flag= -1;
            }
            game.font.draw(game.batch, "tank Player 1 ", hA, 395);
            game.font.draw(game.batch, "tank Player 2 ", hb, 395);

        game.batch.end();
        game.shapeRenderer.end();
    }
//    public float fireball(float fireball_A_X, float power)
//    {
//        float y =(float) ((fireball_A_X * Math.tan(a)) - ((9.8 * (fireball_A_X * fireball_A_X)) / (2 * (power*power*10) * (Math.cos(a) * Math.cos(a)))));
//        return y;
//    }
    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}


