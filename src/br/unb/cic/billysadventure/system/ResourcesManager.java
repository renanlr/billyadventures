package br.unb.cic.billysadventure.system;

import java.io.IOException;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.BoundCamera;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import android.graphics.Color;
import br.unb.cic.billysadventure.activity.GameActivity;

public class ResourcesManager {
	
    private static final ResourcesManager INSTANCE = new ResourcesManager();
    
    /* <-- Atributos da AndEngine --> */
    public Engine engine;
    public GameActivity activity;
    public BoundCamera camera;
    public VertexBufferObjectManager vbom;
    
    /* <-- Atributos da Splash Scene --> */
    public ITextureRegion splash_region;
    private BitmapTextureAtlas splashTextureAtlas;
    
    /* <-- Atributos da Menu Scene --> */
    private BuildableBitmapTextureAtlas menuTextureAtlas;
    public ITextureRegion menu_background_region;
    public ITextureRegion jogar_region;
    public ITextureRegion loja_region;
    public ITextureRegion rank_region;
    private Music menu_music;
    
    /* <-- Atributos da Store Scene --> */
    private BuildableBitmapTextureAtlas storeTextureAtlas;
    public ITextureRegion store_background_region;
    private Music store_music;
    
    /* <-- Atributos da Rank Scene --> */
    private BuildableBitmapTextureAtlas rankTextureAtlas;
    public ITextureRegion rank_background_region;

    /* <-- Atributos da Game Scene --> */
	public IFont font;
	public BuildableBitmapTextureAtlas gameTextureAtlas;
	public ITextureRegion platform1_region;
	public ITextureRegion platform2_region;
	public ITextureRegion platform3_region;
	public ITextureRegion coin_region;
	public ITiledTextureRegion player_region;
	
	/* <-- Métodos Responsáveis por carregar e descarregar texturas --> */
	
	public void unloadMenuTextures(){
        menuTextureAtlas.unload();
    }
        
    public void loadMenuTextures(){
        menuTextureAtlas.load();
    }
    
    
    public void loadStoreTextures(){
        storeTextureAtlas.load();
    }
    
    public void unloadStoreTextures(){
        storeTextureAtlas.unload();
    }
    
    
    public void unloadRankTextures(){
        rankTextureAtlas.unload();
    }
        
    public void loadRankTextures(){
        rankTextureAtlas.load();
    }
    
    public void unloadGameTextures(){
        // TODO (Since we did not create any textures for game scene yet)
    }
     
    public void loadSplashScreen(){
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
    	splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
    	splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);
    	splashTextureAtlas.load();
    }
    
    public void unloadSplashScreen(){
    	splashTextureAtlas.unload();
    	splash_region = null;
    }
    
    /* <-- Métodos Responsáveis por carregar recursos --> */
    
    public void loadMenuResources(){
        loadMenuGraphics();
        loadMenuAudio();
        loadMenuFonts();
    }
    
    public void loadGameResources(){
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }
    
	public void loadStoreResources() {
		loadStoreGraphics();
        //loadMenuFonts();
	}
	
    
    public void loadRankResources(){
    	loadRankGraphics();
    }
    
    /* <-- Métodos Responsáveis por carregar a parte gráfica das cenas --> */
    
    private void loadMenuGraphics(){
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
    	menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1224, 1224, TextureOptions.BILINEAR);
    	menu_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "menu_background.png");
    	jogar_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "bt_jogar.png");
    	loja_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "bt_loja.png");
    	rank_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "bt_rank.png");
    	       
    	try{
    		this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    this.menuTextureAtlas.load();
    	}catch (final TextureAtlasBuilderException e){
    	        Debug.e(e);
    	}
    }
    
    private void loadStoreGraphics(){
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/store/");
    	storeTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	store_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(storeTextureAtlas, activity, "store_background.png");
    	       
    	try{
    		this.storeTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    this.storeTextureAtlas.load();
    	}catch (final TextureAtlasBuilderException e){
    	        Debug.e(e);
    	}
    }
    
    private void loadGameGraphics(){
        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
        gameTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
        
        platform1_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "platform1.png");
        platform2_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "platform2.png");
        platform3_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "platform3.png");
        coin_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "coin.png");
        player_region = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(gameTextureAtlas, activity, "player.png", 3, 1);
       
        try{
            this.gameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
            this.gameTextureAtlas.load();
        }catch (final TextureAtlasBuilderException e){
            Debug.e(e);
        }
    }
    
    private void loadRankGraphics(){
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/rank/");
    	rankTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	rank_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(rankTextureAtlas, activity, "rank_background.jpg");
    	        
    	try {
    	    this.rankTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    this.rankTextureAtlas.load();
    	}catch (final TextureAtlasBuilderException e){
    		Debug.e(e);
    	}
    }

    /* <-- Métodos Responsáveis pela parte do Aúdio --> */
    private void loadMenuAudio(){
    	MusicFactory.setAssetBasePath("mfx/");
    	try {
    		menu_music = MusicFactory.createMusicFromAsset(engine.getMusicManager(), activity, "menu_music.mp3");
    		store_music = MusicFactory.createMusicFromAsset(engine.getMusicManager(), activity, "store_music.mp3");
    		getInstance().menu_music.setLooping(true);
    		getInstance().store_music.setLooping(true);
    	}catch (final IOException e){
    		Debug.e(e);
    	}
    }
    
    public void playMenuAudio(){
    	menu_music.play();
    }
    
    public void stopMenuAudio(){
    	menu_music.stop();
    }
    
    public void playStoreAudio(){
    	store_music.play();
    }
    
    public void stopStoreAudio(){
    	store_music.stop();
    }
    
    private void loadGameAudio(){       
    }
    
    /* <-- Métodos Responsáveis pelo funcionamento da AndEngine e carregamento das Fontes --> */
    
    private void loadGameFonts(){     
    }
    
	private void loadMenuFonts(){
		FontFactory.setAssetBasePath("font/");
	    final ITexture mainFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
	    font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "arial.ttf", 50, true, Color.WHITE, 2, Color.BLACK);
	    font.load();
    }
    
    public static void prepareManager(Engine engine, GameActivity activity, BoundCamera camera, VertexBufferObjectManager vbom)
    {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
        getInstance().vbom = vbom;
    }
    
    public static ResourcesManager getInstance(){
        return INSTANCE;
    }
    
}
