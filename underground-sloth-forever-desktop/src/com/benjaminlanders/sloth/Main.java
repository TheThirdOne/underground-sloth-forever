package com.benjaminlanders.sloth;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "underground-sloth-forever";
		cfg.useGL20 = false;
		cfg.width = 1000;
		cfg.height = 1000;
		
		new LwjglApplication(new SlothMain(), cfg);
	}
}
