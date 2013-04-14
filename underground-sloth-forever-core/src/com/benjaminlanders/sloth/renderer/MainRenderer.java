package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.sloth.SlothMain;
import com.benjaminlanders.sloth.controller.Controller;
import com.benjaminlanders.sloth.helper.Assets;
/**
 * Currently a test bed for graphics
 * @author Benjamin Landers
 */
public class MainRenderer extends Renderer
{
	public Animator animator;
	TextureRegion currentFrame;
	float stateTime = 0;
	AnimationUnit[] frameUpdater = new AnimationUnit[6];
	GraphicEntity entity;
	GraphicCharacter player;
	Controller controller; 
	
	BitmapFont font = new BitmapFont();
	public MainRenderer(SpriteBatch batch, SlothMain reference)
	{
		super(batch, reference);
		frameUpdater[0] = new AnimationUnit(0,Animation.NORMAL,Assets.bodyAnim,0,0,true);
		entity = new GraphicEntity(frameUpdater);
		animator = new Animator();
		player = new GraphicCharacter(animator, Assets.bodyAnim,  Assets.armAnim,  Assets.bodyAnim);
		//reference.animator.addAnimations(frameUpdater);
		controller = new Controller();
	}

	@Override
	public void render(float delta) 
	{
        stateTime += delta; 
        controller.update();
        batch.draw(Assets.getImage(Assets.background), 0,0, SlothMain.width, SlothMain.height);
       // currentFrame = Assets.animations[Assets.legsAnim].getKeyFrame(stateTime, true); 
		animator.render(stateTime);
		//player.update(stateTime);
		player.left = controller.player.left;
		player.x = controller.player.x;
		player.render(batch);
		//entity.render(batch);
		//Graphics.draw(batch, Assets.getAnimation(Assets.bodyAnim).getKeyFrame(stateTime, true), .4f, .3f, .1f, 0, true);
		font.draw(batch, "" + Gdx.graphics.getFramesPerSecond(), 400, 300);
	}

	@Override
	public boolean isFinished() 
	{
		
		return false;
	}

}
