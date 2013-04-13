package com.benjaminlanders.sloth.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Loader 
{
	/**
	 * Loads an animation from a name which can be used to find the file address
	 * of a txt config and a png spritesheet so the animation can be loaded.
	 * The config should be in this pattern: a,b,c such that a = columns b = rows c = time per frame in seconds * 100
	 * @param address the name of the file -.png and animation/
	 * @return the animation
	 */
	public static Animation loadAnimation(String address)
	{
		Animation out;
		String text = Gdx.app.getFiles().internal("animations/"+address+".txt").readString();
		String[] split = text.split(",");
		int[] values = new int[split.length];
		for(int i = 0; i< split.length;i++)
		{
			
			values[i] = Integer.parseInt(split[i]);
		}
		out = loadAnimation("animations/"+address+".png",
				values[0],values[1], .01f*values[2]);
	
		return out;	
	}
	/**
	 * A function to load animations from a file. It starts left to right then down one.
	 * @param address A string that refers to the location of the file
	 * @param columns the number of columns
	 * @param rows the number of rows
	 * @param timePerFrame A float that is the time 1 frame will be one the screen in seconds
	 * @return the finished animation
	 */
	public static Animation loadAnimation(String address, int columns, int rows, float timePerFrame)
	{
		Texture texture = new Texture(Gdx.files.internal(address));
		TextureRegion[][] temp = TextureRegion.split(texture,texture.getWidth()/columns, texture.getHeight()/rows);
		TextureRegion[] frames = new TextureRegion[columns*rows];
		int index = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++) 
            {
                    frames[index++] = temp[i][j];
            }
        }
		return  new Animation(timePerFrame, frames);
		
	}
}
