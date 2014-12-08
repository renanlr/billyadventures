package br.unb.cic.billysadventure.scenes;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import android.util.Log;
import br.unb.cic.billysadventure.system.BaseScene;
import br.unb.cic.billysadventure.system.ResourcesManager;
import br.unb.cic.billysadventure.system.SceneManager;
import br.unb.cic.billysadventure.system.SceneManager.SceneType;


public class StoreScene extends BaseScene implements IOnMenuItemClickListener{
	
	private MenuScene storeChildScene;
	public Sprite coin_store;
	final String TAG = "Coordenadas Sprite: ";
	
	private void createStoreChildScene(){
		// TODO: Sprite da Moeda ainda não aparece.
		storeChildScene = new MenuScene(camera);
		storeChildScene.setPosition(0, 0);
		coin_store = new Sprite(20, 20, resourcesManager.coin_store_region, vbom);
		storeChildScene.attachChild(coin_store);
		setChildScene(storeChildScene, false, true, true);
		Log.i(TAG, "X: " + coin_store.getX() + " Y: " + coin_store.getY());
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
	    //ResourcesManager.getInstance().playStoreAudio();	
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
