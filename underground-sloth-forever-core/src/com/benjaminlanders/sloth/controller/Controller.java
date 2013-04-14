package com.benjaminlanders.sloth.controller;

import com.badlogic.gdx.Gdx;
import com.benjaminlanders.sloth.SlothMain;
import com.benjaminlanders.sloth.helper.Assets;
import com.benjaminlanders.sloth.model.Block;
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
		player.y = .6f;
	}
	public void update()
	{
		boolean walking = false;
		for(Block block: world.blocks)
		{
			walking |= testCollision(block,player.x,player.y-.21f);
			Gdx.app.log("block - y", "" +(block.y -player.y+.21f));
		}
		Gdx.app.log("waling?", "" + walking);
		player.playerUpdate(Gdx.input.getX()/((float)Gdx.graphics.getWidth()) - player.x, 0, true, false);
	}
	public static boolean testCollision(Block block, float x , float y)
	{
		if(block.x < x && block.width + block.x > x)
		{
			Gdx.app.log("x - k?", "yes");
			if(block.y < y && block.height + block.y > y)
			{
				return true;
			}
		}
		return false;
	}
	
}
