package com.game_assignment.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class PlayScreen extends ScreenAdapter {

    Game_Assignment game;
    Texture tankA, tankB;


    float tankA_X =20  ;
    float tankA_Y = 65 ;

    float f=150;
    int flag =0;
    float fireball_A_X = tankA_X+100;
    float fireball_A_Y = tankA_Y+100;
    float x = fireball_A_X;
    float angle = 0;
    float height = 0;
    float range = 0;
    float tankB_X=600-tankA_X;
    float tankB_Y=tankA_Y;
    double a =0;
    float hA = tankA_X;
     float hb = tankB_X;

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

        game.font.draw(game.batch,"Angle of Projection :  "+angle, 150,200);


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
                if (Gdx.input.isKeyPressed(Input.Keys.ENTER))
                {
                    a= Math.toRadians(angle);
                    range = (float) ((10*10)*(Math.sin(2*a))/9.8) + x;
                    if(fireball_A_X <= range) {
                        fireball_A_X += 10;
                    }
                    fireball_A_Y = (float) ((fireball_A_X*Math.tan(a))-((9.8*(fireball_A_X*fireball_A_X))/(2*(100)*(Math.cos(a)*Math.cos(a))))) + fireball_A_Y;

                }
                flag = 1;
            }
            else if(flag == 1)
            {
                if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
                    tankB_X -= 3;
                } else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
                    tankB_X += 3;
                }
                flag = 0;
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



    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

}
