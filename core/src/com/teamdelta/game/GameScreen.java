package com.teamdelta.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameScreen extends AbstractScreen {
	Sprite rockSprite;
	Sprite paperSprite;
	Sprite scissorsSprite;
	Sprite lizardSprite;
	Sprite spockSprite;
	public GameScreen(Main gameS) {
		super(gameS);
		
		rockSprite = new Sprite(atlas.findRegion("rock"));
		rockSprite.setSize(100, 200);
		rockSprite.setPosition(20, 250);
		
		paperSprite = new Sprite(atlas.findRegion("paper"));
		paperSprite.setSize(100, 200);
		paperSprite.setPosition(100, 250);
		
		scissorsSprite = new Sprite(atlas.findRegion("scissors"));
		scissorsSprite.setSize(100, 200);
		scissorsSprite.setPosition(150, 250);
		
		lizardSprite = new Sprite(atlas.findRegion("lizard"));
		lizardSprite.setSize(100, 200);
		lizardSprite.setPosition(240, 250);
		
		spockSprite = new Sprite(atlas.findRegion("spock"));
		spockSprite.setSize(100, 200);
		spockSprite.setPosition(290, 250);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	void loadAssets() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void render(float delta) {
		rockSprite.draw(gameInstance.batch);
		paperSprite.draw(gameInstance.batch);
		scissorsSprite.draw(gameInstance.batch);
		lizardSprite.draw(gameInstance.batch);
		spockSprite.draw(gameInstance.batch);
	}

	@Override
	void update(float timeSinceLastFrame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


	@Override
	void disposeAssets() {
		// TODO Auto-generated method stub
		
	}

	
}