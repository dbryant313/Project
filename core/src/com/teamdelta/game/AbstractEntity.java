package com.teamdelta.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public abstract class AbstractEntity {
	String name;
	Sprite skin;
	boolean turnToPlay;
	int winScore;
	int loseScore;
	enum Choices{ROCK, PAPER, SCISSORS, LIZARD, SPOCK};
	Choices choice;
	TextureAtlas atlas;
	
	abstract void render(float timeSinceLastFrame, SpriteBatch bath);
	abstract void update(float timeSinceLastFrame);
}
