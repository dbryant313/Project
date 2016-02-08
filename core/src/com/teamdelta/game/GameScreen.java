package com.teamdelta.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.teamdelta.game.AbstractEntity.Choices;

public class GameScreen extends AbstractScreen {
	Button rockButton;
	Button paperButton;
	Button scissorsButton;
	Button lizardButton;
	Button spockButton;
	Button aboutButton;
	Button rulesButton;
	Button exitButton;
	User player;
	CPU cpu;
	BitmapFont font;
	Vector3 input;
	boolean playerTookTurn, cpuTookTurn, gameover, isGameTied, isPlayerWin, isCPUWin;
	public GameScreen(Main gameS) {
		super(gameS);

		input = new Vector3();
		font = new BitmapFont(Gdx.files.internal("calibrismall.fnt"));

		player = new User(atlas);
		cpu = new CPU(atlas);

		aboutButton = new Button(atlas.findRegion("ABOUTBUTTON"),
				atlas.findRegion("ABOUTBUTTONSELECTED"), new Rectangle(250, 30,
						100, 50));
		rulesButton = new Button(atlas.findRegion("RULESBUTTON"),
				atlas.findRegion("RULESBUTTONSELECTED"), new Rectangle(350, 30,
						100, 50));
		exitButton = new Button(atlas.findRegion("EXITBUTTON"),
				atlas.findRegion("EXITBUTTONSELECTED"), new Rectangle(450, 30,
						100, 50));

		rockButton = new Button(atlas.findRegion("rock"),
				atlas.findRegion("rock"), new Rectangle(50, 350, 100, 150));
		paperButton = new Button(atlas.findRegion("paper"),
				atlas.findRegion("paper"), new Rectangle(650, 350, 100, 150));
		scissorsButton = new Button(atlas.findRegion("scissors"),
				atlas.findRegion("scissors"), new Rectangle(50, 150, 100, 150));
		lizardButton = new Button(atlas.findRegion("lizard"),
				atlas.findRegion("lizard"), new Rectangle(650, 150, 100, 150));
		spockButton = new Button(atlas.findRegion("spock"),
				atlas.findRegion("spock"), new Rectangle(350, 275, 100, 150));
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
	}

	@Override
	public void hide() {
		Gdx.input.setCatchBackKey(false);
	}

	@Override
	void loadAssets() {

	}

	@Override
	public void render(float delta) {
		renderButtons();
		renderScores();
		renderFPS();
		renderMessages();
		
		player.skin.draw(batch);
		cpu.skin.draw(batch);
	}

	void renderButtons() {
		rockButton.draw(batch);
		paperButton.draw(batch);
		scissorsButton.draw(batch);
		lizardButton.draw(batch);
		spockButton.draw(batch);
		aboutButton.draw(batch);
		rulesButton.draw(batch);
		exitButton.draw(batch);
	}

	void renderScores() {
		font.draw(batch, "Wins:  " + player.winScore, 50, 560);
		font.draw(batch, "Losses:  " + player.loseScore, 50, 540);

		font.draw(batch, "Wins:  " + cpu.winScore, 600, 560);
		font.draw(batch, "Losses:  " + cpu.loseScore, 600, 540);

	}

	void renderFPS() {
		//font.draw(batch, "FPS " + Gdx.graphics.getFramesPerSecond(), 700, 620);

	}

	void renderMessages() {
		if(player.turnToPlay){
			font.draw(batch, "Your Turn", 50, 600);
		}
		if(cpu.turnToPlay){
			font.draw(batch, "CPU's Turn", 50, 600);
		}
		if(playerTookTurn){
			font.draw(batch, "You chose: " + player.choice.toString(), 50, 600);
		}
		if(cpuTookTurn){
			font.draw(batch, "CPU chose: " + cpu.choice.toString(), 600, 600);
		}
		if(gameover){
			if(isGameTied){
				font.draw(batch, "Game is tied", 320, 620);
			}
			if(isPlayerWin){
				font.draw(batch, "You won this round", 320, 620);
			}
			if(isCPUWin){
				font.draw(batch, "CPU won this round", 320, 620);
			}
		}

	}

	@Override
	void update(float timeSinceLastFrame) {

		if (playerTookTurn && cpuTookTurn && !gameover) {
			switch (player.choice) {
			case ROCK:
				switch (cpu.choice) {
				case ROCK:
					isGameTied = true;
					gameover = true;
					break;
				case PAPER:
					isCPUWin = true;
					cpu.winScore ++;
					player.loseScore ++;
					gameover = true;
					break;
				case SCISSORS:
					isPlayerWin = true;
					cpu.loseScore ++;
					player.winScore ++;
					gameover = true;
					break;
				case LIZARD:
					isPlayerWin = true;
					cpu.loseScore ++;
					player.winScore ++;
					gameover = true;
					break;
				case SPOCK:
					isCPUWin = true;
					cpu.winScore ++;
					player.loseScore ++;
					gameover = true;
					break;
				default:
					break;
				}
				break;
			case PAPER:
				switch (cpu.choice) {
				case ROCK:
					isPlayerWin = true;
					cpu.loseScore ++;
					player.winScore ++;
					gameover = true;
					break;
				case PAPER:
					isGameTied = true;
					gameover = true;
					break;
				case SCISSORS:
					isCPUWin = true;
					cpu.winScore ++;
					player.loseScore ++;
					gameover = true;
					break;
				case LIZARD:
					isCPUWin = true;
					cpu.winScore ++;
					player.loseScore ++;
					gameover = true;
					break;
				case SPOCK:
					isPlayerWin = true;
					cpu.loseScore ++;
					player.winScore ++;
					gameover = true;
					break;
				default:
					break;
				}
				break;
			case SCISSORS:
				switch (cpu.choice) {
				case ROCK:
					isCPUWin = true;
					cpu.winScore ++;
					player.loseScore ++;
					gameover = true;
					break;
				case PAPER:
					isPlayerWin = true;
					cpu.loseScore ++;
					player.winScore ++;
					gameover = true;
					break;
				case SCISSORS:
					isGameTied = true;
					gameover = true;
					break;
				case LIZARD:
					isPlayerWin = true;
					cpu.loseScore ++;
					player.winScore ++;
					gameover = true;
					break;
				case SPOCK:
					isCPUWin = true;
					cpu.winScore ++;
					player.loseScore ++;
					gameover = true;
					break;
				default:
					break;
				}
				break;
			case LIZARD:
				switch (cpu.choice) {
				case ROCK:
					isCPUWin = true;
					cpu.winScore ++;
					player.loseScore ++;
					gameover = true;
					break;
				case PAPER:
					isPlayerWin = true;
					cpu.loseScore ++;
					player.winScore ++;
					gameover = true;
					break;
				case SCISSORS:
					isCPUWin = true;
					cpu.winScore ++;
					player.loseScore ++;
					gameover = true;
					break;
				case LIZARD:
					isGameTied = true;
					gameover = true;
					break;
				case SPOCK:
					isPlayerWin = true;
					cpu.loseScore ++;
					player.winScore ++;
					gameover = true;
					break;
				default:
					break;
				}
				break;
			case SPOCK:
				switch (cpu.choice) {
				case ROCK:
					isPlayerWin = true;
					cpu.loseScore ++;
					player.winScore ++;
					gameover = true;
					break;
				case PAPER:
					isCPUWin = true;
					cpu.winScore ++;
					player.loseScore ++;
					gameover = true;
					break;
				case SCISSORS:
					isPlayerWin = true;
					cpu.loseScore ++;
					player.winScore ++;
					gameover = true;
					break;
				case LIZARD:
					isCPUWin = true;
					cpu.winScore ++;
					player.loseScore ++;
					gameover = true;
					break;
				case SPOCK:
					isGameTied = true;
					gameover = true;
					break;
				default:
					break;
				}
				break;
			default:
				break;

			}
		}

		if (playerTookTurn) {
			if (cpu.turnToPlay) {
				if (!cpuTookTurn) {
					int randomNum = MathUtils.random(1, 5);
					switch (randomNum) {
					case 1:
						cpu.choice = Choices.ROCK;
						cpuTookTurn = true;
						cpu.turnToPlay = false;
						break;
					case 2:
						cpu.choice = Choices.PAPER;
						cpuTookTurn = true;
						cpu.turnToPlay = false;
						break;
					case 3:
						cpu.choice = Choices.SCISSORS;
						cpuTookTurn = true;
						cpu.turnToPlay = false;
						break;
					case 4:
						cpu.choice = Choices.LIZARD;
						cpuTookTurn = true;
						cpu.turnToPlay = false;
						break;
					case 5:
						cpu.choice = Choices.SPOCK;
						cpuTookTurn = true;
						cpu.turnToPlay = false;
						break;
					default:
						break;
					}
				}
			}
		}

	}

	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

		input.x = screenX;
		input.y = screenY;

		aboutButton.selected = false;
		rulesButton.selected = false;
		exitButton.selected = false;

		gameInstance.camera.unproject(input);

		if (aboutButton.colisionRect.contains(input.x, input.y)) {
			this.hide();
			gameInstance.currentScreen = gameInstance.aboutScreen;
			gameInstance.previousScreen = this;
			gameInstance.currentScreen.show();
		}

		if (rulesButton.colisionRect.contains(input.x, input.y)) {
			this.hide();
			gameInstance.currentScreen = gameInstance.rulesScreen;
			gameInstance.previousScreen = this;
			gameInstance.currentScreen.show();
		}

		if (exitButton.colisionRect.contains(input.x, input.y)) {
			dispose();
			Gdx.app.exit();
		}

		if (player.turnToPlay) {
			if (rockButton.colisionRect.contains(input.x, input.y)) {
				player.choice = Choices.ROCK;
				playerTookTurn = true;
				player.turnToPlay = false;
				cpu.turnToPlay = true;
			}
			if (paperButton.colisionRect.contains(input.x, input.y)) {

				player.choice = Choices.PAPER;
				playerTookTurn = true;
				player.turnToPlay = false;
				cpu.turnToPlay = true;
			}
			if (scissorsButton.colisionRect.contains(input.x, input.y)) {
				player.choice = Choices.SCISSORS;
				playerTookTurn = true;
				player.turnToPlay = false;
				cpu.turnToPlay = true;
			}
			if (lizardButton.colisionRect.contains(input.x, input.y)) {
				player.choice = Choices.LIZARD;
				playerTookTurn = true;
				player.turnToPlay = false;
				cpu.turnToPlay = true;
			}
			if (spockButton.colisionRect.contains(input.x, input.y)) {
				player.choice = Choices.LIZARD;
				playerTookTurn = true;
				player.turnToPlay = false;
				cpu.turnToPlay = true;
			}

		}

		return true;
	}

	// Override InputAdapter TouchUp
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		input.x = screenX;
		input.y = screenY;

		gameInstance.camera.unproject(input);

		if (aboutButton.colisionRect.contains(input.x, input.y)) {
			aboutButton.selected = true;
		} else {
			aboutButton.selected = false;
		}

		if (rulesButton.colisionRect.contains(input.x, input.y)) {
			rulesButton.selected = true;
		} else {
			rulesButton.selected = false;
		}

		if (exitButton.colisionRect.contains(input.x, input.y)) {
			exitButton.selected = true;
		} else {
			exitButton.selected = false;
		}

		if (player.turnToPlay) {
			if (rockButton.colisionRect.contains(input.x, input.y)) {

			}
			if (rockButton.colisionRect.contains(input.x, input.y)) {

			}
			if (rockButton.colisionRect.contains(input.x, input.y)) {

			}
			if (rockButton.colisionRect.contains(input.x, input.y)) {

			}
			if (rockButton.colisionRect.contains(input.x, input.y)) {

			}
			if (rockButton.colisionRect.contains(input.x, input.y)) {

			}
		}

		return true;
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
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	void disposeAssets() {
		// TODO Auto-generated method stub

	}

}