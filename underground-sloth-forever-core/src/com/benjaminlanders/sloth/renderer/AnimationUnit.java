package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
/**
 * Unit used to cordinate 
 * @author Benjamin Landers
 */
public class AnimationUnit
{
	/**
	 * constructor
	 * @param id not used yet may be used for coordinating set to 0 for now
	 * @param type Animation type EX/ Animation.NORMAL
	 * @param reference int from Assets EX/ Assets.arms
	 * @param timeStarted statetime when the animation will start 
	 * @param timeEndedstatetime when the animation will end 0 for never
	 * @param looping whether the animation loops during the time it is on
	 */
	public AnimationUnit(int id, int type, int reference, float timeStarted,float timeEnded, boolean looping)
	{
		this.id = id;
		this.type = type;
		this.reference = reference;
		this.timeStarted = timeStarted;
		this.timeEnded = timeEnded;
		this.looping = looping;
	}
	public int id;
	public int type;
	public int reference;
	public float timeStarted;
	public boolean looping;
	public float timeEnded;
	public TextureRegion frame;
	
}
