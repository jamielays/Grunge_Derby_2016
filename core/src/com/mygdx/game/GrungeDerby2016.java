package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GrungeDerby2016 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture batting_bg;
    Camera camera;
    Viewport viewport;
    Stage stage;
	
	@Override
	public void create() {
		batch = new SpriteBatch();

        camera = new OrthographicCamera();
        viewport = new FitViewport(416, 240, camera);
        viewport.apply();

        stage = new Stage(viewport);

        batting_bg = new Texture("Batting_BG.gif");
        //batting_bg.setPosition(0, 0);
        //batting_bg.setSize(100, 100);

        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2,0);
	}

	@Override
	public void render() {
		camera.update();

        Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(batting_bg, 0, 0);
        batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
        batting_bg.dispose();
	}

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2,0);
    }
}
