package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.sloth.helper.Assets;

public class GraphicCharacter extends GraphicEntity
{
	float stateTime;
	public boolean left = false;
	public boolean walking, climbing, standing;
	/**
	 * 
	 * @param animator the animator that will be used to animate the animations
	 */
	public GraphicCharacter(Animator animator, int body, int arm, int climb)
	{
		super(5);
		units[0] = new AnimationUnit(0, Animation.NORMAL, climb, .15f, -1f,true);	
		units[1] = new AnimationUnit(0, Animation.NORMAL, arm, .15f, 0f, true);
		units[2] = new AnimationUnit(0, Animation.NORMAL, body, 0f, 0f, true);
		units[3] = new AnimationUnit(0, Animation.NORMAL, arm, 0f, 0f, true);
		units[4] = new AnimationUnit(0, Animation.NORMAL, climb, 0f, -1f, true);	
		
		animator.addAnimations(units);
		x = .5f;
		y = .5f;

	}
	
	public void update(float stateTime)
	{
		this.stateTime = stateTime;
	}
	public void climb()
	{
		if(!climbing)
		{
			units[0].timeEnded = 0;
			units[1].timeEnded = -1;
			units[2].timeEnded = 0;
			units[3].timeEnded = -1;
			units[4].timeEnded = 0;	
			
			units[0].timeStarted = stateTime+.15f;
			units[2].timeStarted = stateTime;
			units[4].timeStarted = stateTime;
			climbing = true;
		}
		walking = false;
		standing = false;
	}
	public void walk()
	{
		if(!walking)
		{
			units[0].timeEnded = -1;
			units[1].timeEnded = 0;
			units[2].timeEnded = 0;
			units[3].timeEnded = 0;
			units[4].timeEnded = -1;	
			
			units[1].timeStarted = stateTime+.15f;
			units[2].timeStarted = stateTime;
			units[3].timeStarted = stateTime;
			walking = true;
		}
		standing = false;
		climbing = false;
	}
	public void stand()
	{
		if(!standing)
		{
			units[0].timeEnded = -1;
			units[1].timeEnded = 0;
			units[2].timeEnded = 0;
			units[3].timeEnded = 0;
			units[4].timeEnded = -1;	
			standing = true;
		}
		walking = false;
		climbing = false;
	}
	public void render(SpriteBatch batch)
	{
				
		super.render(batch,left,.1f,.1f);
	}

}
