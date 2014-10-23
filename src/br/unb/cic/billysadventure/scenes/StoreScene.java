package br.unb.cic.billysadventure.scenes;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import br.unb.cic.billysadventure.system.BaseScene;
import br.unb.cic.billysadventure.system.ResourcesManager;
import br.unb.cic.billysadventure.system.SceneManager;
import br.unb.cic.billysadventure.system.SceneManager.SceneType;


public class StoreScene extends BaseScene implements IOnMenuItemClickListener{
	
	private MenuScene storeChildScene;
	private final int STORE_CLOTHES = 0;
	private final int STORE_BONUS = 1;
	
	private void createStoreChildScene(){
		
	}
	
	private void createBackground(){
	    attachChild(new Sprite(400, 240, resourcesManager.store_background_region, vbom){
	    	
	        @Override
	        protected void preDraw(GLState pGLState, Camera pCamera){
	            super.preDraw(pGLState, pCamera);
	            pGLState.enableDither();
	        }
	    });
	}
	
	@Override
	public void createScene(){
		createBackground();
	    createStoreChildScene();
	    ResourcesManager.getInstance().playStoreAudio();
		
	}

	@Override
	public void onBackKeyPressed(){
		ResourcesManager.getInstance().stopStoreAudio();
		SceneManager.getInstance().reloadMenuScene(engine);
	}

	@Override
	public SceneType getSceneType(){
		return SceneType.SCENE_STORE;
	}

	@Override
	public void disposeScene(){
		// TODO Auto-generated method stub
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY){
		// TODO Auto-generated method stub
		return false;
	}

}
