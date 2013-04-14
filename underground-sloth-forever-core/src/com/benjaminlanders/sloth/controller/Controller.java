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
		player.x = .1f;
		player.y = .8f;
	}
	public void update()
	{
		boolean walking = false, climbing = false;
		for(Block block: world.blocks)
		{
			walking |= testCollision(block,player.x,player.y-.23f);
		}
		for(Block block: world.vines)
		{
			climbing |= testCollision(block,player.x,player.y-.20f);
			
		}
		walking |= climbing;
		float deltaY = (climbing&&Gdx.input.isTouched())?(-Gdx.input.getY()/((float)Gdx.graphics.getHeight()) + player.y)/50:((walking)?0:-.025f);
		Gdx.app.log("climbing?", "" + deltaY);
		player.playerUpdate(Gdx.input.getX()/((float)Gdx.graphics.getWidth()) - player.x,deltaY , walking, climbing);
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
