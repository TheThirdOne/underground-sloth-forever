package com.benjaminlanders.sloth.controller;

import com.badlogic.gdx.Gdx;
import com.benjaminlanders.sloth.helper.Assets;
import com.benjaminlanders.sloth.model.Apple;
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
	}
	public void selectLevel(int level)
	{
		world = new World(Assets.getString(Assets.levels[level]));
		player.x = .1f;
		player.y = .8f;
	}
	public void update()
	{
		boolean walking = false, climbing = false, needsUp = false;
		for(Block block: world.blocks)
		{
			walking |= testCollision(block,player.x,player.y-.05f);
			needsUp |= testCollision(block,player.x,player.y-.04f);
		}
		for(Block block: world.vines)
		{
			climbing |= testCollision(block,player.x,player.y-.03f);
			
		}
		walking |= climbing;
		float deltaY = (climbing&&Gdx.input.isTouched())?.005f:((walking)?((needsUp)?.004f:0):player.vY-.001f);
		player.playerUpdate(Gdx.input.getX()/((float)Gdx.graphics.getWidth()) - player.x,deltaY , walking, climbing);
		
	}
	public boolean isDone()
	{
		return player.x >= world.apple.x && player.y >= world.apple.y && 
				player.x < Apple.width + world.apple.x && player.y < Apple.height + world.apple.y;
	}
	public static boolean testCollision(Block block, float x , float y)
	{
		if(block.x < x && block.width + block.x > x)
		{
			if(block.y < y && block.height + block.y > y)
			{
				return true;
			}
		}
		return false;
	}
	
}
