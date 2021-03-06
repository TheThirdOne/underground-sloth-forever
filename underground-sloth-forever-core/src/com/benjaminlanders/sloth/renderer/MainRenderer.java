package com.benjaminlanders.sloth.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.benjaminlanders.sloth.SlothMain;
import com.benjaminlanders.sloth.controller.Controller;
import com.benjaminlanders.sloth.helper.Assets;
import com.benjaminlanders.sloth.model.Apple;
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
	boolean debug =false;
	public boolean finished = false;
	Music music;
	
	
	BitmapFont font = new BitmapFont();
	public MainRenderer(SpriteBatch batch, SlothMain reference, Controller controller)
	{
		super(batch, reference);
		frameUpdater[0] = new AnimationUnit(0,Animation.NORMAL,Assets.bodyAnim,0,0,true);
		entity = new GraphicEntity(frameUpdater);
		animator = new Animator();
		player = new GraphicCharacter(animator, Assets.bodyAnim,  Assets.armAnim,  Assets.climbAnim);
		debugRenderer = new ShapeRenderer();
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.wav"));
		music.setLooping(true);
		music.play();
		this.controller = controller;
		
	}

	@Override
	public void render(float delta) 
	{
		batch.begin();
        stateTime += delta; 
        controller.update();
        if(controller.isDone())
        	finished = true;
        batch.draw(Assets.getImage(Assets.background), 0,0, SlothMain.width, SlothMain.height);
       // currentFrame = Assets.animations[Assets.legsAnim].getKeyFrame(stateTime, true); 
		animator.render(stateTime);
		//player.update(stateTime);
		player.left = controller.player.left;
		if(controller.player.climbing&&controller.player.y > player.y)
		{
			player.climb();
		}else
		if(!(controller.player.walking && controller.player.moving))
		{
			player.walk();
		}else
		{
			player.stand();
			player.units[1].frame = Assets.getAnimation(Assets.armAnim).getKeyFrame(.15f);
			player.units[2].frame = Assets.getAnimation(Assets.bodyAnim).getKeyFrame(.001f);
			player.units[3].frame = Assets.getAnimation(Assets.armAnim).getKeyFrame(.001f);
		}
		player.x = controller.player.x;
		player.y = controller.player.y;
		//player.render(batch);


		for(Block block:controller.world.blocks)
		{
			batch.draw(Assets.getImage(Assets.rock),block.x*SlothMain.width,block.y*SlothMain.height,
					block.width*SlothMain.width,block.height*SlothMain.height);
		}
		
		for(Block block:controller.world.vines)
		{
			batch.draw(Assets.getImage(Assets.vine),block.x*SlothMain.width,block.y*SlothMain.height,
					block.width*SlothMain.width,block.height*SlothMain.height);
		}
		player.render(batch);
		
		batch.draw(Assets.getImage(Assets.fruit), controller.world.apple.x*SlothMain.width,
				controller.world.apple.y*SlothMain.height, Apple.width*SlothMain.width, Apple.height*SlothMain.height);
		//entity.render(batch);
		//Graphics.draw(batch, Assets.getAnimation(Assets.bodyAnim).getKeyFrame(stateTime, true), .4f, .3f, .1f, 0, true);
		//font.draw(batch, "" + Gdx.graphics.getFramesPerSecond(), 400, 300);
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
			//debugRenderer.rect(player.x*SlothMain.width, player.y*SlothMain.height, .1f*player.units[2].frame.getRegionWidth(), .1f*player.units[2].frame.getRegionHeight());
			debugRenderer.end();
		}
	}

	@Override
	public boolean isFinished() 
	{
		return finished;
	}

}
