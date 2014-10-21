package br.unb.cic.billysadventure.system;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;

public class IOnStoreItemClickListener {

	private final int STORE_CLOTHES = 0;
	private final int STORE_BONUS = 1;
	
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY){
	        switch(pMenuItem.getID())
	        {
	        case STORE_CLOTHES:
	            return true;
	        case STORE_BONUS:
	            return true;
	        default:
	            return false;
	    }
	}
}
