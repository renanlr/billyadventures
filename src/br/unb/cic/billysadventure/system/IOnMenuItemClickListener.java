package br.unb.cic.billysadventure.system;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;

public class IOnMenuItemClickListener {
	
	private final int MENU_PLAY = 0;
	private final int MENU_OPTIONS = 1;
	private final int MENU_STORE = 2;
	
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, 
			float pMenuItemLocalX, float pMenuItemLocalY){
		
	        switch(pMenuItem.getID()){
	        case MENU_PLAY:
	            return true;
	        case MENU_OPTIONS:
	            return true;
	        case MENU_STORE:
	        	return true;
	        default:
	            return false;
	    }
	}
}
