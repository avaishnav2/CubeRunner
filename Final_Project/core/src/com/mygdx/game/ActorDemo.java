package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class ActorDemo extends ApplicationAdapter {

	Stage stage;
	
	@Override
	public void create() {
		ScreenViewport viewport = new ScreenViewport();
		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage);
		
		MyActor actor = new MyActor(new Sprite(new Texture(Gdx.files.internal("Untitled-1.jpg"))));
		
		MyActor[] actors = new MyActor[100];
		
		for(int i = 0; i < 100; i++){
            actors[i] = new MyActor(new Sprite(new Texture(Gdx.files.internal("bomb.png"))));
            int j = (int)(Math.random()* 50000 + 10000);
            //Assign the position of the jet to a random value within the screen boundaries
            actors[i].setPosition(50*i, j);
            
            // Set the name of the Jet to it's index within the loop
            actors[i].setName(Integer.toString(i));
            
            // Add them to the stage
            stage.addActor(actors[i]);
            
            MoveToAction moveAction = new MoveToAction();
    	    moveAction.setPosition(50*i , j - 70000);
    	    moveAction.setDuration(100);
    	    actors[i].addAction(moveAction);
        }
		
	    stage.addActor(actor);
		stage.addActor(actor);
		stage.setKeyboardFocus(actor); //keyboard handling
	}
	
	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime()); //act is like update
		stage.draw();
	}
	
}