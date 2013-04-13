package com.benjaminlanders.sloth;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.sloth.helper.Assets;
import com.benjaminlanders.sloth.helper.Graphics;
import com.benjaminlanders.sloth.renderer.Animator;

public class SlothMain implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	float statetime = 0;
	public Animator animator;
	public static float height, width;
	TextureRegion region;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		height = Gdx.graphics.getHeight();
		width = Gdx.graphics.getWidth();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		//texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		//region = new TextureRegion(texture, 0, 0, 512, 275);
		region = Assets.getImage(Assets.libGdx);
		Assets.getAnimation(Assets.legsAnim);
		
		
		sprite = new Sprite(Assets.getAnimation(Assets.legsAnim).getKeyFrame(0));
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
	}

	@Override
	public void dispose() {
		batch.dispose();
		//texture.dispose();
	}

	@Override
	public void render() {	
		statetime+=Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		sprite.setRegion(Assets.getAnimation(Assets.legsAnim).getKeyFrame(statetime, true));
		//batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//sprite.draw(batch);
		//batch.draw(Assets.getAnimation(Assets.legsAnim).getKeyFrame(statetime,true),0, 0);
		Graphics.draw(batch, region, .5f, .5f, .3f, 0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
