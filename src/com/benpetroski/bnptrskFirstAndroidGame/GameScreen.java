package com.benpetroski.bnptrskFirstAndroidGame;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import com.benpetroski.framework.Game;
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
			updateRunning(touchEvents);
		if (state == GameState.Paused)
			updatePaused(touchEvents);
		if (state == GameState.GameOver)
			updateGameOver(touchEvents);
	}

	private void updateReady(List<TouchEvent> touchEvents) {
		
	}

	private void updateRunning(List<TouchEvent> touchEvents) {
		
	}

	private void updatePaused(List<TouchEvent> touchEvents) {
		
	}

	private void updateGameOver(List<TouchEvent> touchEvents) {
		
	}

	@Override
	public void paint(float deltaTime) {
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
	public void backButton() {
		// TODO Auto-generated method stub

	}

}
