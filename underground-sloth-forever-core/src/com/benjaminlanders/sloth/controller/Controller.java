package com.benjaminlanders.sloth.controller;

import com.badlogic.gdx.Gdx;
import com.benjaminlanders.sloth.SlothMain;
import com.benjaminlanders.sloth.helper.Assets;
import com.benjaminlanders.sloth.model.Player;
import com.benjaminlanders.sloth.model.World;

public class Controller 
{
	public Player player;
	public World world;
	public Controller()
	{
		player = new Player();
		world = new World(Assets.getString(Assets.level1));
	}
	public void update()
	{
		player.playerUpdate((Gdx.input.getX() - player.x*SlothMain.width)/SlothMain.width, 0, true, false);
	}
}
