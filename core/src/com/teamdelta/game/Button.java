package com.teamdelta.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Button {
	TextureRegion textureRegion;
	Rectangle colisionRect;
	
	public Button(){
		textureRegion = new TextureRegion();
		colisionRect = new Rectangle();
	}
	public Button(TextureRegion tR, Rectangle colRect) {
		textureRegion = tR;
		colisionRect = colRect;
	}
	
	void draw(SpriteBatch batch){
		batch.draw(textureRegion, colisionRect.x, colisionRect.y, colisionRect.width, colisionRect.height);
	}
}
