package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GraphicCharacter extends GraphicEntity
{
	float stateTime;
	public boolean left = false;
	boolean prepared = false;
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
		//yCenter[3] = -180;
		//xCenter[3] = -40;
		x = .5f;
		y = .5f;

	}
	
	public void update(float stateTime)
	{
		this.stateTime = stateTime;
	}
	public void climb(){
	
	}
	public void walk()
	{
		
	}
	public void stand()
	{
		
	}
	public void render(SpriteBatch batch)
	{
		super.render(batch,left);
	}

}
