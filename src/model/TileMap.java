package model;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * 
 * @author Alberto Villareal, Laura [Last Name], Ivan [Last Name], and Marissa
 *         [Last Name]
 * 
 *         Summary: [Summary goes here]
 *
 */
public class TileMap {

	// Variables for this class
	private List<List<Tile>> tileGrid;
	private static Timeline tl;

	/**
	 * The default constructor class that would make a map of only grass tiles.
	 */
	public TileMap() {
		this.tileGrid = new ArrayList<List<Tile>>();

		for (int i = 0; i < 20; i++) {
			ArrayList<Tile> temp = new ArrayList<Tile>();
			for (int j = 0; j < 15; j++) {
				temp.add(new Tile(i * 32, j * 32, 32, 32, TileType.Grass));
			}
			this.tileGrid.add(temp);

		}
	}

	/**
	 * A more detailed constructor that takes in a 2d list of integers to specify
	 * what tiles should be used in creating a map. Makes creating a level easier to
	 * do.
	 * 
	 * @param tileMap
	 */
	public TileMap(int[][] tileMap) {
		this.tileGrid = new ArrayList<List<Tile>>();

		for (int i = 0; i < 20; i++) {
			ArrayList<Tile> temp = new ArrayList<Tile>();
			for (int j = 0; j < 15; j++) {
				int value = tileMap[j][i];
				switch (value) {
				case 0:
					temp.add(new Tile(i * 32, j * 32, 32, 32, TileType.Grass));
					break;

				case 1:
					temp.add(new Tile(i * 32, j * 32, 32, 32, TileType.Dirt));
					break;

				case 2:
					temp.add(new Tile(i * 32, j * 32, 32, 32, TileType.Water));
					break;
				}
			}
			this.tileGrid.add(temp);
		}
	}

	/**
	 * Sets a certain tile within the Tilemap
	 * 
	 * @param x
	 * @param y
	 * @param type
	 */
	public void SetTile(int x, int y, TileType type) {
		Tile newTile = new Tile(x * 32, y * 32, 32, 32, type);
		tileGrid.get(x).set(y, newTile);
	}

	/**
	 * Gets the tile at a certain indexed value
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Tile GetTile(int x, int y) {
		if (x < 0 || y < 0 || x >= 20 || y >= 15)
			return new Tile(0, 0, 0, 0, TileType.DEBUG);
		else
			return tileGrid.get(x).get(y);
	}

	/**
	 * Draws all the tiles in the Tilemap
	 */
	public void Draw() {
		for (List<Tile> list : tileGrid) {
			for (Tile tile : list) {
				tile.Draw();
			}
		}
	}

	/**
	 * Creates an animation that draws the level, NOTE: This update should be used
	 * before any other update function in the view.
	 */
	public void update() {
		tl = new Timeline(new KeyFrame(Duration.millis(500), new AnimationHandler()));
		tl.setCycleCount(Animation.INDEFINITE);
		tl.play();
	}

	/**
	 * A basic animation that draws the level.
	 *
	 */
	private class AnimationHandler implements EventHandler<ActionEvent> {

		int tick = 0;

		@Override
		public void handle(ActionEvent arg0) {
			tick++;
			Draw();
		}

	}
}