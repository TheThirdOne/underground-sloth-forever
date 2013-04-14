package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.benjaminlanders.sloth.SlothMain;
import com.benjaminlanders.sloth.controller.Controller;
import com.benjaminlanders.sloth.helper.Assets;
import com.benjaminlanders.sloth.model.Block;
/**
 * Currently a test bed for graphics
 * @author Benjamin Landers
 */
public class MainRenderer extends Renderer
{
	ShapeRenderer debugRenderer;
	public Animator animator;
	TextureRegion currentFrame;
	float stateTime = 0;
	AnimationUnit[] frameUpdater = new AnimationUnit[6];
	GraphicEntity entity;
	GraphicCharacter player;
	Controller controller; 
	boolean debug =true;
	
	BitmapFont font = new BitmapFont();
	public MainRenderer(SpriteBatch batch, SlothMain reference)
	{
		super(batch, reference);
		frameUpdater[0] = new AnimationUnit(0,Animation.NORMAL,Assets.bodyAnim,0,0,true);
		entity = new GraphicEntity(frameUpdater);
		animator = new Animator();
		player = new GraphicCharacter(animator, Assets.bodyAnim,  Assets.armAnim,  Assets.bodyAnim);
		controller = new Controller();
		debugRenderer = new ShapeRenderer();
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
		player.y = controller.player.y;
		player.render(batch);
		
		//entity.render(batch);
		//Graphics.draw(batch, Assets.getAnimation(Assets.bodyAnim).getKeyFrame(stateTime, true), .4f, .3f, .1f, 0, true);
		font.draw(batch, "" + Gdx.graphics.getFramesPerSecond(), 400, 300);
		batch.end();
		if(debug)
		{
			debugRenderer.begin(ShapeRenderer.ShapeType.Rectangle);
			debugRenderer.setColor(Color.RED);
			for(Block block:controller.world.blocks)
			{
				debugRenderer.rect(block.x*SlothMain.width, block.y*SlothMain.height, block.width*SlothMain.width, block.height*SlothMain.height);
			}
			debugRenderer.setColor(Color.GREEN);
			for(Block vine:controller.world.vines)
			{
				debugRenderer.rect(vine.x*SlothMain.width, vine.y*SlothMain.height, vine.width*SlothMain.width, vine.height*SlothMain.height);
			}
			debugRenderer.end();
		}
		batch.begin();
	}

	@Override
	public boolean isFinished() 
	{
		
		return false;
	}

}
