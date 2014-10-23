package br.unb.cic.billysadventure.system;

import org.andengine.engine.Engine;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

import br.unb.cic.billysadventure.scenes.GameScene;
import br.unb.cic.billysadventure.scenes.LoadingScene;
import br.unb.cic.billysadventure.scenes.MainMenuScene;
import br.unb.cic.billysadventure.scenes.RankScene;
import br.unb.cic.billysadventure.scenes.SplashScene;
import br.unb.cic.billysadventure.scenes.StoreScene;

public class SceneManager{
	
	/* <-- Cenas --> */
	
    private BaseScene splashScene;
    private BaseScene menuScene;
    private BaseScene gameScene;
    private BaseScene loadingScene;
    private BaseScene storeScene;
    private BaseScene rankScene;
    
    private static final SceneManager INSTANCE = new SceneManager();
    private SceneType currentSceneType = SceneType.SCENE_SPLASH;
    private BaseScene currentScene;
    private Engine engine = ResourcesManager.getInstance().engine;
    
    public enum SceneType{
        SCENE_SPLASH,
        SCENE_MENU,
        SCENE_GAME,
        SCENE_LOADING,
        SCENE_STORE,
        SCENE_RANK
    }
    
    public void setScene(BaseScene scene){
        engine.setScene(scene);
        currentScene = scene;
        currentSceneType = scene.getSceneType();
    }
    
    public void setScene(SceneType sceneType){
        switch (sceneType){
            case SCENE_MENU:
                setScene(menuScene);
                break;
            case SCENE_GAME:
                setScene(gameScene);
                break;
            case SCENE_SPLASH:
                setScene(splashScene);
                break;
            case SCENE_LOADING:
                setScene(loadingScene);
                break;
            case SCENE_STORE:
            	setScene(storeScene);
            	break;
            case SCENE_RANK:
            	setScene(rankScene);
            	break;
            default:
                break;
        }
    }
    
    public static SceneManager getInstance(){
        return INSTANCE;
    }
    
    public SceneType getCurrentSceneType(){
        return currentSceneType;
    }
    
    public BaseScene getCurrentScene(){
        return currentScene;
    }
    
    public void loadGameScene(final Engine mEngine){
        setScene(loadingScene);
        ResourcesManager.getInstance().unloadMenuTextures();
        mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback(){
        	
            public void onTimePassed(final TimerHandler pTimerHandler){
                mEngine.unregisterUpdateHandler(pTimerHandler);
                ResourcesManager.getInstance().loadGameResources();
                gameScene = new GameScene();
                setScene(gameScene);
            }
        }));
    }

	public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback){
	    ResourcesManager.getInstance().loadSplashScreen();
	    splashScene = new SplashScene();
	    currentScene = splashScene;
	    pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
	}
	
	private void disposeSplashScene(){
	    ResourcesManager.getInstance().unloadSplashScreen();
	    splashScene.disposeScene();
	    splashScene = null;
	}
	
	public void createMenuScene(){
	    ResourcesManager.getInstance().loadMenuResources();
	    menuScene = new MainMenuScene();
	    loadingScene = new LoadingScene();
	    SceneManager.getInstance().setScene(menuScene);
	    disposeSplashScene();
	}
	
    public void loadMenuScene(final Engine mEngine){
        setScene(loadingScene);
        gameScene.disposeScene();
        ResourcesManager.getInstance().unloadGameTextures();
        mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback(){
        	
            public void onTimePassed(final TimerHandler pTimerHandler){
                mEngine.unregisterUpdateHandler(pTimerHandler);
                ResourcesManager.getInstance().loadMenuTextures();
                setScene(menuScene);
            }
        }));
    }
    
    public void reloadMenuScene(final Engine mEngine){
        //setScene(loadingScene);
        //gameScene.disposeScene();
        ResourcesManager.getInstance().unloadGameTextures();
        mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback(){
            public void onTimePassed(final TimerHandler pTimerHandler){
            	
                mEngine.unregisterUpdateHandler(pTimerHandler);
                ResourcesManager.getInstance().loadMenuTextures();
                setScene(menuScene);
            }
        }));
    }
    
    public void createRankScene(){
        ResourcesManager.getInstance().loadRankResources();
        loadingScene = new LoadingScene();
    	rankScene = new RankScene();
        SceneManager.getInstance().setScene(rankScene);
    }
    
    public void loadRankScene(final Engine mEngine){
    	setScene(loadingScene);
    	menuScene.disposeScene();
    	ResourcesManager.getInstance().unloadMenuTextures();
    	mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback(){
    		
            public void onTimePassed(final TimerHandler pTimerHandler){
                mEngine.unregisterUpdateHandler(pTimerHandler);
                ResourcesManager.getInstance().loadRankTextures();
                setScene(rankScene);
            }
        }));
    }
    
    public void createStoreScene(){
    	ResourcesManager.getInstance().loadStoreResources();
	    storeScene = new StoreScene();
	    loadingScene = new LoadingScene();
	    SceneManager.getInstance().setScene(storeScene);
	}
    
    public void loadStoreScene(final Engine mEngine){
        setScene(loadingScene);
        //storeScene.disposeScene();
        ResourcesManager.getInstance().unloadMenuTextures();
        mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback(){
        	
            public void onTimePassed(final TimerHandler pTimerHandler){
                mEngine.unregisterUpdateHandler(pTimerHandler);
                ResourcesManager.getInstance().loadStoreTextures();
                setScene(storeScene);
            }
        }));
    }
}