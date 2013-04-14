package com.benjaminlanders.sloth.helper;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.sloth.SlothMain;

/**
 * Helper for graphics
 * @author Benjamin Landers
 */
public class Graphics 
{
	/**
	 * Draws a TextureRegion to a SpriteBatch with scale and rotation
	 * @param batch the SpriteBatch
	 * @param region the region 
	 * @param x the x value of the center
	 * @param y the y value of the center
	 * @param scale the scale 1 = same as region, 2 = twice size
	 * @param rotation the rotation in degrees
	 */
	public static void draw(SpriteBatch batch, TextureRegion region,float x, float y,float scale, float rotation)
	{
		draw(batch,region,x,y,scale,scale,rotation);
	}
	/**
	 * Draws a TextureRegion to a SpriteBatch with scale and rotation
	 * @param batch the SpriteBatch
	 * @param region the region 
	 * @param x the x value of the center
	 * @param y the y value of the center
	 * @param scale the scale 1 = same as region, 2 = twice size
	 * @param rotation the rotation in degrees
	 * @param flipX flips over the Y axis?
	 */
	public static void draw(SpriteBatch batch, TextureRegion region,float x, float y,float scale, float rotation, boolean flipX)
	{
		draw(batch,region,x,y,scale*((flipX)?-1:1),scale,rotation);
	}
	/**
	 * Draws a TextureRegion to a SpriteBatch with separate scaling and rotation
	 * @param batch the SpriteBatch
	 * @param region the region 
	 * @param x the x value of the center
	 * @param y the y value of the center
	 * @param scaleX the X scale 
	 * @param scaleY the Y scale 
	 * @param rotation the rotation in degrees
	 */
	public static void draw(SpriteBatch batch, TextureRegion region,float x, float y,float scaleX, float scaleY, float rotation)
	{
		draw(batch,region,x,y,region.getRegionWidth()/2,region.getRegionHeight()/2,scaleX,scaleY,rotation);
	}
	/**
	 * Draws a TextureRegion to a SpriteBatch with scale, center setting and rotation
	 * @param batch the SpriteBatch
	 * @param region the region 
	 * @param x the x value of the center
	 * @param y the y value of the center
	 * @param scale the scale 
	 * @param rotation the rotation in degrees
	 * @param xSrc the x value of the center the TextureRegion
	 * @param ySrc the y value of the center the TextureRegion
	 */
	public static void draw(SpriteBatch batch, TextureRegion region,float x, float y,float xSrc, float ySrc,float scale, float rotation)
	{
		draw(batch,region,x,y,xSrc,ySrc,scale,scale,rotation);
	}
	/**
	 * Draws a TextureRegion to a SpriteBatch with separate scaling, center setting and rotation
	 * @param batch the SpriteBatch
	 * @param region the region 
	 * @param x the x value of the center
	 * @param y the y value of the center
	 * @param scaleX the X scale 
	 * @param scaleY the Y scale 
	 * @param rotation the rotation in degrees
	 * @param xSrc the x value of the center the TextureRegion
	 * @param ySrc the y value of the center the TextureRegion
	 */
	public static void draw(SpriteBatch batch, TextureRegion region,float x, float y,float xSrc, float ySrc,float scaleX, float scaleY, float rotation)
	{
		y *= SlothMain.height;
		x *= SlothMain.width;
		batch.draw(region,- xSrc+x, -ySrc+y, xSrc, ySrc, region.getRegionWidth(),  region.getRegionHeight(), scaleX*SlothMain.width*.005f, scaleY*SlothMain.width*.005f, rotation);
	}
	

}
