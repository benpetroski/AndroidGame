package com.benpetroski.bnptrskFirstAndroidGame;

import com.benpetroski.framework.Screen;
import com.benpetroski.framework.implementation.AndroidGame;

public class SampleGame extends AndroidGame {

	@Override
	public Screen getInitScreen() {
		return new LoadingScreen(this);
	}
	
	@Override
	public void onBackPressed() {
		getCurrentScreen().backButton();
	}

}
