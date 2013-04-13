package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.benjaminlanders.sloth.helper.Assets;

public class GraphicCharacter extends GraphicEntity
{
	float stateTime;
	boolean prepared = false;
	/**
	 * 
	 * @param animator the animator that will be used to animate the animations
	 * @param legs the leg asset reference
	 * @param arms the arms asset reference
	 * @param prep the prep animation reference
	 * @param fire the firing animation reference
	 */
	public GraphicCharacter(Animator animator,int legs, int arms, int prep, int fire)
	{
		super(5);
		units[0] = new AnimationUnit(0, Animation.NORMAL, legs, 0f, 0f, true);
		units[1] = new AnimationUnit(0, Animation.NORMAL, arms, 0f, 0f, true);
		units[2] = new AnimationUnit(0, Animation.NORMAL, prep, 0f, -1f, false);
		units[3] = new AnimationUnit(0, Animation.NORMAL, fire, 0f, -1f, false);	
		units[4] = new AnimationUnit(0, Animation.REVERSED, prep, 0f, -1f, false);	
		animator.addAnimations(units);
		yCenter[3] = -180;
		xCenter[3] = -40;
		x = .5f;
		y = .5f;

	}
	
	public void update(float stateTime)
	{
		this.stateTime = stateTime;
	}
	public void prep()
	{
		if(!prepared)
		{
		units[1].timeEnded = -1;
		units[2].timeStarted = stateTime;
		units[2].timeEnded = 0;

		units[3].timeStarted = stateTime;
		units[3].timeEnded = -1;
		prepared = true;
		}
		
	}
	public void unprep()
	{
		if(prepared)
		{
		units[4].timeStarted = stateTime;
		units[4].timeEnded = stateTime + Assets.getAnimation(units[2].reference).animationDuration;
		units[2].timeEnded = -1;
		units[1].timeStarted = stateTime + Assets.getAnimation(units[2].reference).animationDuration;
		units[1].timeEnded = 0;
		prepared=false;
		}
	}
	public void fire()
	{
		if(!prepared)
		{
			prep();
		
			units[3].timeEnded = stateTime + Assets.getAnimation(units[2].reference).animationDuration + 
				Assets.getAnimation(units[3].reference).animationDuration;
			units[3].timeStarted = stateTime + Assets.getAnimation(units[2].reference).animationDuration;
		}else
		{
			units[3].timeEnded = stateTime + Assets.getAnimation(units[3].reference).animationDuration;
			units[3].timeStarted = stateTime;	
		}
	}

}
