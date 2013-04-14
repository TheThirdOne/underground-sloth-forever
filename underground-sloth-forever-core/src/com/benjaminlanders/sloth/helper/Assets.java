package com.benjaminlanders.sloth.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.sloth.SlothMain;
import com.benjaminlanders.sloth.helper.Loader;

public class Assets
{
	public static SlothMain application;
	private static final String[] animationAddress = {"character/body","character/arm"};
 	public static Animation[] animations = new Animation[2];
 	public static final int bodyAnim = 0;
 	public static final int armAnim = 1;
 	
	
	private static final String[] imageAddress = {"nullimage","libgdx","game-background","story-background",
		"story-1","story-2","story-3","story-4","story-5","story-6","story-7","story-8"};
	public static TextureRegion[] images = new TextureRegion[12];
	public static final int nullimage = 0;
	public static final int libGdx = 1;
	public static final int background = 2;
	public static final int story0 = 3;
	public static final int story1 = 4;
	public static final int story2 = 5;
	public static final int story3 = 6;
	public static final int story4 = 7;
	public static final int story5 = 8;
	public static final int story6 = 9;
	public static final int story7 = 10;
	public static final int story8 = 11;
	
	private static final String[] stringAddress = {"level-1"};
	public static String[] strings = new String[1];
	public static final int level1 = 0;
	public static String getString(int reference)
	{
		if(strings.length <= reference)
			return null;
		if(strings[reference]==null)
		{
			strings[reference] = Gdx.files.internal("strings/"+stringAddress[reference]+".txt").readString();
		}
		return strings[reference];
		
	}
	
	/**
	 * gets the image if its loaded, if not it loads and then gives it
	 * @param reference the value in the array for the correct image. use the constants
	 * @return the image
	 */
	public static TextureRegion getImage(int reference)
	{
		if(images.length <= reference)
			return null;
		if(images[reference]==null)
		{
			images[reference] = new TextureRegion(new Texture(Gdx.files.internal("images/"+imageAddress[reference]+".png")));
		}
		return images[reference];
	}
	/**
	 * gets the animation if its loaded, if not it loads and then gives it
	 * @param reference the value in the array for the correct animation. use the constants
	 * @return the animation
	 */
	public static Animation getAnimation(int reference)
	{
		if(animations.length < reference)
			return null;
		if(animations[reference]==null)
		{
			animations[reference] = Loader.loadAnimation(animationAddress[reference]);
		}
		return animations[reference];
	}

}
