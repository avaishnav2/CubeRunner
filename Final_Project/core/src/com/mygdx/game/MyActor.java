package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

public class MyActor extends Actor {
	Sprite sprite;

	public MyActor(Sprite sprite) {
		this.sprite = sprite;
		setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());// set bounds of Actor
		setTouchable(Touchable.enabled); // tell actor you can touch it

		addListener(new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if (keycode == Keys.RIGHT) { // if user presses right
					MoveByAction mba = new MoveByAction();
					mba.setAmount(100f, 0f); // set how much (100 to the right)
					mba.setDuration(.01f);

					MyActor.this.addAction(mba);
				}
				if (keycode == Keys.LEFT) { // if user presses right
					MoveByAction mba = new MoveByAction();
					mba.setAmount(-100f, 0f); // set how much (100 to the right)
					mba.setDuration(.01f);

					MyActor.this.addAction(mba);
				}
				return true;
			}
		});

	}
	
	@Override
	protected void positionChanged() { //allows for movement
		sprite.setPosition(getX(), getY());
		super.positionChanged();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.draw(batch);
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
	}
}