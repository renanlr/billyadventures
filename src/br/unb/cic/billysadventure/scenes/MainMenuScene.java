package br.unb.cic.billysadventure.scenes;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import br.unb.cic.billysadventure.system.BaseScene;
import br.unb.cic.billysadventure.system.ResourcesManager;
import br.unb.cic.billysadventure.system.SceneManager;
import br.unb.cic.billysadventure.system.SceneManager.SceneType;

import org.andengine.engine.camera.Camera;

public class MainMenuScene extends BaseScene implements IOnMenuItemClickListener{
	
	private MenuScene menuChildScene;
	private final int MENU_JOGAR = 0;
	private final int MENU_LOJA = 1;
	private final int MENU_RANK = 2;
	
	final String TAG = "COORDENADAS";
	
	private void createMenuChildScene(){
	    menuChildScene = new MenuScene(camera);
	    menuChildScene.setPosition(0, 0);
	    
	    final IMenuItem jogarMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_JOGAR, resourcesManager.jogar_region, vbom), 0.6f, 0.4f);
	    final IMenuItem lojaMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_LOJA, resourcesManager.loja_region, vbom), 0.6f, 0.4f);
	    final IMenuItem rankMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_RANK, resourcesManager.rank_region, vbom), 0.6f, 0.4f);
	    
	    menuChildScene.addMenuItem(jogarMenuItem);
	    menuChildScene.addMenuItem(lojaMenuItem);
	    menuChildScene.addMenuItem(rankMenuItem);
	    
	    menuChildScene.buildAnimations();
	    menuChildScene.setBackgroundEnabled(false);
	    
	    jogarMenuItem.setPosition(jogarMenuItem.getX() - 250, jogarMenuItem.getY() - 470);
	    lojaMenuItem.setPosition(lojaMenuItem.getX(), lojaMenuItem.getY() - 70);
	    rankMenuItem.setPosition(rankMenuItem.getX() + 250, rankMenuItem.getY() + 280);
	    
	    menuChildScene.setOnMenuItemClickListener(this);
	    
	    setChildScene(menuChildScene);
	}
	
	
	private void createBackground()
	{
	    attachChild(new Sprite(400, 240, resourcesManager.menu_background_region, vbom)
	    {
	        @Override
	        protected void preDraw(GLState pGLState, Camera pCamera) 
	        {
	            super.preDraw(pGLState, pCamera);
	            pGLState.enableDither();
	        }
	    });
	}

	@Override
	public void createScene() {
		createBackground();
	    createMenuChildScene();
//	    ResourcesManager.getInstance().playMenuAudio();
	}

	@Override
	public void onBackKeyPressed() {
		ResourcesManager.getInstance().stopMenuAudio();
		System.exit(0);
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_MENU;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY){
	        switch(pMenuItem.getID())
	        {
	        case MENU_JOGAR:
	        	SceneManager.getInstance().loadGameScene(engine);
	        	ResourcesManager.getInstance().stopMenuAudio();
	            return true;
	        case MENU_LOJA:
	            return true;
	        case MENU_RANK:
	        	return true;
	        default:
	            return false;
	    }
	}

}
