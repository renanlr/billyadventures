package br.unb.cic.billysadventure.scenes;

import org.andengine.engine.camera.Camera;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import br.unb.cic.billysadventure.system.BaseScene;
import br.unb.cic.billysadventure.system.SceneManager;
import br.unb.cic.billysadventure.system.SceneManager.SceneType;

public class RankScene extends BaseScene{

	@Override
	public void createScene() {
		createBackground();
	}

	@Override
	public void onBackKeyPressed() {
		SceneManager.getInstance().loadMenuScene(engine);
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_RANK;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}
	private void createBackground(){
		 attachChild(new Sprite(400, 240, resourcesManager.rank_background_region, vbom)
		 {
		        @Override
		        protected void preDraw(GLState pGLState, Camera pCamera) 
		        {
		            super.preDraw(pGLState, pCamera);
		            pGLState.enableDither();
		        }
		    });
	}
}
