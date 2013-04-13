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
	private static final String[] animationAddress = {"legs"};
 	public static Animation[] animations = new Animation[1];
 	public static final int legsAnim = 0;
	
	private static final String[] imageAddress = {"nullimage","libgdx"};
	public static TextureRegion[] images = new TextureRegion[2];
	public static final int nullimage = 0;
	public static final int libGdx = 1;
	
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
