package com.benjaminlanders.sloth.renderer;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.benjaminlanders.sloth.helper.Assets;

/**
 * Helper for animations
 * @author Benjamin Landers
 */
public class Animator
{
	private ArrayList<AnimationUnit> units = new ArrayList<AnimationUnit>();
	public void addAnimation(AnimationUnit unit)
	{
		units.add(unit);
	}
	public void addAnimations(AnimationUnit[] units)
	{
		for(AnimationUnit unit: units){
			this.units.add(unit);
		}
	}
	public void removeUnit(AnimationUnit unit)
	{
		units.remove(unit);
	}
	/**
	 * 
	 * @param stateTime
	 */
	public void render(float stateTime)
	{
		if(units.isEmpty())
			return;
		for(AnimationUnit unit: units)
		{
			if(unit.timeEnded == 0 || unit.timeEnded > stateTime)
			{
				if(unit.timeStarted < stateTime)
				{
				Assets.getAnimation(unit.reference).setPlayMode(unit.type);
				unit.frame = Assets.getAnimation(unit.reference).getKeyFrame(stateTime - unit.timeStarted, unit.looping);
				Assets.getAnimation(unit.reference).setPlayMode(Animation.NORMAL);
				}else
				{
					unit.frame = Assets.getImage(Assets.nullimage);
				}
			}else
			{
				unit.frame = Assets.getImage(Assets.nullimage);
			}
		}
	}


}
