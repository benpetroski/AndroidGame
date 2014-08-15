package com.benpetroski.bnptrskFirstAndroidGame;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import com.benpetroski.framework.Game;
import com.benpetroski.framework.Graphics;
import com.benpetroski.framework.Input.TouchEvent;
import com.benpetroski.framework.Screen;

public class GameScreen extends Screen {
	 enum GameState {
		 Ready, Running, Paused, GameOver
	 }
		
	 GameState state = GameState.Ready;
	 
	 //Variables: create game objs here
	 int livesLeft = 1;
	 Paint paint;
	 
	public GameScreen(Game game) {
		super(game);
		//Initialize game objs here
		
		//Defining a paint obj
		paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();		
		
		//Four update methods that update based on game state
		if (state == GameState.Ready)
			updateReady(touchEvents);
		if (state == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if (state == GameState.Paused)
			updatePaused(touchEvents);
		if (state == GameState.GameOver)
			updateGameOver(touchEvents);
	}

	private void updateReady(List<TouchEvent> touchEvents) {
		//Starts with ready screen, game begins after screen touch
		if (touchEvents.size() > 0) {
			state = GameState.Running;
		}
	}

	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
		//Identical to update() method from units 2/3
		
		//handle touch events
		int len = touchEvents.size();
		for (int i=0; i<len; i++) {
			TouchEvent event = touchEvents.get(i);
			
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (event.x < 640) {
					//move left
				} else if (event.x > 640) {
					//move right
				}
			}
			
			if (event.type == TouchEvent.TOUCH_UP) {
				if (event.x < 640) {
					//stop left
				} else if (event.x > 640) {
					//stop right
				}
			}
		}
		
		//handle misc. events
		if (livesLeft == 0) {
			state = GameState.GameOver;
		}
		
		//call indiv. updates here, this is where game updates happen (robot.update();)
	}

	private void updatePaused(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i=0; i<len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				
			}				
		}
	}

	private void updateGameOver(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i=0; i<len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (event.x > 300 && event.x < 980 && event.y > 100 && event.y < 500) {
					nullify();
					game.setScreen(new MainMenuScreen(game));
					return;
				}
			}
		}
	}

	private void nullify() {
		//set all variables to null and recreate with constructor
		paint = null;
		
		//garbage collection
		System.gc();
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		//Draw game elements: g.drawImage(Assets.background, 0, 0);
		
		//Draw UI above game elements
		if (state == GameState.Ready)
			drawReadyUI();
		if (state == GameState.Running)
			drawRunningUI();
		if (state == GameState.Paused)
			drawPausedUI();
		if (state == GameState.GameOver)
			drawGameOverUI();
	}

	private void drawReadyUI() {
		Graphics g = game.getGraphics();
		
		g.drawARGB(155, 0, 0, 0);
		g.drawString("Tap each side of the screen to move in that direction.", 640, 300, paint);
	}

	private void drawRunningUI() {
		Graphics g = game.getGraphics();		
	}

	private void drawPausedUI() {
		Graphics g = game.getGraphics();
		
		//darken screen to display paused menu
		g.drawARGB(155, 0, 0, 0);
	}

	private void drawGameOverUI() {
		Graphics g = game.getGraphics();
		g.drawRect(0, 0, 1281, 801, Color.BLACK);
		g.drawString("Game Over.", 640, 300, paint);
	}

	@Override
	public void pause() {
		if (state == GameState.Running)
			state = GameState.Paused;
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void backButton() {
		pause();
	}

}
