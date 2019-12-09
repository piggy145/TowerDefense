package controller;

import javafx.scene.image.Image;

public class ResourceManager {
	
	//All the enemies
	public static Image ghostImg = QuickLoad("ghost");
	public static Image redGhostImg = QuickLoad("redghost");
	public static Image blueGhostImg = QuickLoad("blueghost");
	public static Image yellowGhostImg = QuickLoad("yellowghost");
	public static Image greenGhostImg = QuickLoad("greenghost");
	public static Image purpleGhostImg = QuickLoad("purpleghost");
	public static Image metalGhostImg = QuickLoad("metalghost");
	public static Image goldGhostImg = QuickLoad("goldghost");
	public static Image bossImg = QuickLoad("ghoully");
	
	//Extra Images
	public static Image fireballImg = QuickLoad("Fireball");
	public static Image optionsimg = QuickLoad("Options");
	public static Image startScreenimg = QuickLoad("startscreen");
	
	//All the towers
	public static Image Tower1img = QuickLoad("tower1");
	public static Image Tower2img = QuickLoad("tower2");
	public static Image Tower3img = QuickLoad("tower3");
	public static Image Tower4img = QuickLoad("tower4");
	public static Image Tower5img = QuickLoad("tower5");
	public static Image Tower6img = QuickLoad("tower6");
	public static Image Tower7img = QuickLoad("tower7");
	public static Image Tower8img = QuickLoad("tower8");
	
	//All the projectiles
	public static Image bloodProjimg = QuickLoad("blood");
	public static Image arrowProjimg = QuickLoad("arrow");
	public static Image boneProjimg = QuickLoad("bone");
	public static Image rockProjimg = QuickLoad("rock");
	public static Image lazerProjimg = QuickLoad("lazer");
	public static Image lightningProjimg = QuickLoad("lightning");
	public static Image fireProjimg = QuickLoad("Fireball");
	public static Image lavaProjimg = QuickLoad("lava");
	public static Image holyWaterProjimg = QuickLoad("holyWater");
	
	//All the tiles
	public static Image grass32Img = QuickLoad("grass32");
	public static Image water32TileImg = QuickLoad("water32");
	public static Image dirt32Tile = QuickLoad("dirt32");
	public static Image hellGround1Img = QuickLoad("hellground1");
	public static Image hellGround2Img = QuickLoad("hellground2");
	public static Image hellGround3Img = QuickLoad("hellground3");
	
	
	public static Image QuickLoad(String imgPath) {
		Image img = new Image("Images/" + imgPath + ".png");
		return img;
	}
	
}
