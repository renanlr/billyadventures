package br.unb.cic.billysadventure.scenes;

import br.unb.cic.billysadventure.system.BaseScene;
import br.unb.cic.billysadventure.system.SceneManager.SceneType;

public class LoadingScene extends BaseScene{

	@Override
	public void createScene() {
		//TODO: O problema de travar o app é nesse método!!
		//setBackground(new Background(Color.WHITE));
	    //attachChild(new Text(400, 240, resourcesManager.font, "Loading...", vbom));
	}

	@Override
	public void onBackKeyPressed() {
		return;
	}

	@Override
	public SceneType getSceneType() {
		return SceneType.SCENE_LOADING;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}
	
}
