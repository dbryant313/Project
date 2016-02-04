package com.teamdelta.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class StartScreen extends  AbstractScreen {

	Vector3 input;
	
	Button playGameButton;
	Button aboutButton;
	Button rulesButton;
	Button closeButton;
	
	
	public StartScreen(Main game) {
		super(game);

		loadAssets();

		input = new Vector3();

	}

	void loadAssets() {
		playGameButton = new Button(atlas.findRegion("playGameButton"), 
				new Rectangle(140, 250, 120, 50));
		aboutButton = new Button(atlas.findRegion("mainMenuButton"), 
				new Rectangle(100, 300, 140, 50));
		rulesButton = new Button(atlas.findRegion("playAgainButton"), 
				new Rectangle(100, 200, 120, 50));

	}
	@Override
	public void show() {

		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
		System.out.println("Menu show");
	}

	@Override
	public void render(float delta) {
		playGameButton.draw(batch);
		//creditsButton.draw(batch);
		//helpButton.draw(batch);
	}
	
	@Override
	public void update(float timeSinceLastFrame) {

	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

		System.out.println("Menu resumed");
	}

	@Override
	public void hide() {
		System.out.println("Menu hidden!");
		Gdx.input.setCatchBackKey(false);
	}

	@Override
	public void dispose() {
		System.out.println("Menu disposed!");
	}

	// Override InputAdapter TouchUp
	public boolean touchUp(int screenX, int screenY, int pointer, int button){
			
			input.x = screenX;
			input.y = screenY;
			
			gameInstance.camera.unproject(input);
			if(playGameButton.colisionRect.contains(input.x, input.y)){
				this.hide();
				gameInstance.currentScreen = gameInstance.gameScreen;
				gameInstance.currentScreen.show();
			}
			
		return true;
	}

	// Override InputAdapter TouchUp
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		input.x = screenX;
		input.y = screenY;

		gameInstance.camera.unproject(input);
		
		return true;
	}

	// Override InputAdapter
	public boolean keyUp(int keycode) {

		if (keycode == Input.Keys.BACK || keycode == Input.Keys.ESCAPE) {
			Gdx.input.setCatchBackKey(false);
			Gdx.app.exit();
		}
		return true;
	}

	@Override
	void disposeAssets() {
		// TODO Auto-generated method stub
		
	}

}
