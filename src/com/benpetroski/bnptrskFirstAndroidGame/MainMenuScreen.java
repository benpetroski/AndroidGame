package com.benpetroski.bnptrskFirstAndroidGame;

import java.util.List;

import com.benpetroski.framework.Game;
import com.benpetroski.framework.Graphics;
import com.benpetroski.framework.Input.TouchEvent;
import com.benpetroski.framework.Screen;

public class MainMenuScreen extends Screen {

	public MainMenuScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		
		int len = touchEvents.size();
		for (int i=0; i<len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 0, 0, 250, 250)) {
					//start game
					game.setScreen(new GameScreen(game));
				}
			}
		}
	}

	private boolean inBounds(TouchEvent event, int i, int j, int k, int l) {
		if (event.x > i && event.x < i+k-1 && event.y > j && event.y < j+l-1) {
			return true;
		} else
			return false;
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.menu, 0, 0);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {

	}

}
