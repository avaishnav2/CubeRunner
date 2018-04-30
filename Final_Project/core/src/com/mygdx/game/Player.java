package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Player {
    private Vector3 pos;
    private Vector3 vel;
    private Texture player;
    private static final int MVMT=10;

    public Player(int x, int y){
        pos=new Vector3(x,y,0);
        vel=new Vector3(0,0,0);
        player=new Texture("Pyramid.png");
    }

    public void update(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if(pos.x>0)
                vel.add(-MVMT,0,0);
            vel.scl(dt);
            pos.add(-MVMT,0,0);
            vel.scl(1/dt);
            if(pos.x<0)
                pos.x=0;
        }else if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if(pos.x<960)
                vel.add(MVMT,0,0);
            vel.scl(dt);
            pos.add(MVMT,0,0);
            vel.scl(1/dt);
            if(pos.x>960)
                pos.x=960;
        }
    }
    public Vector3 getPos(){
        return pos;
    }
    public Texture getTexture(){
        return player;
    }
    public void moveLeft(){
        vel.x=-MVMT;
    }
    public void moveRight(){
        vel.x=MVMT;
    }
}
