package com.benjaminlanders.zombie.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.sloth.SlothMain;
import com.benjaminlanders.sloth.helper.Assets;
/**
 * Currently a test bed for graphics
 * @author Benjamin Landers
 */
public class MainRenderer extends Renderer
{
	TextureRegion currentFrame;
	float stateTime = 0;
	int count = 1;
	AnimationUnit[] frameUpdater = new AnimationUnit[6];
	GraphicEntity entity;
	GraphicCharacter character;
	
	BitmapFont font = new BitmapFont();
	public MainRenderer(SpriteBatch batch, SlothMain reference)
	{
		super(batch, reference);
		frameUpdater[0] = new AnimationUnit(0,Animation.NORMAL,Assets.legsAnim,0,0,true);
		entity = new GraphicEntity(frameUpdater);
		//character = new GraphicCharacter(reference.animator, Assets.legsAnim, Assets.armsAnim, Assets.gunAnim, Assets.fireAnim);
		//reference.animator.addAnimations(frameUpdater);
	}

	@Override
	public void render(float delta) 
	{
        stateTime += delta;                     
        currentFrame = Assets.animations[Assets.legsAnim].getKeyFrame(stateTime, true); 
		batch.begin();

		float dY = (-1f*Gdx.input.getY(0)/reference.height+1-character.y), dX = (1f*Gdx.input.getX(0)/reference.width-character.x);
		float temp = (float) Math.atan(dY/dX);
		int flip = (dX < 0)?-1:1;
		reference.animator.render(stateTime);
		character.update(stateTime);
		character.render(batch);
		//entity.render(batch);
		
		font.draw(batch, "" + Gdx.graphics.getFramesPerSecond(), 400, 300);
        batch.end();
	}

	@Override
	public boolean isFinished() 
	{
		
		return false;
	}

}
