package Towers;

import controller.Drawer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import model.Tower;

public class DogTower extends Tower {

	private String towerName = "Dog";
	private float towerSpeed = 2f;
	private int towersDestroyed = 0;
	private float range = 50f;
	private Timeline tl;

	public DogTower(Image img, int x, int y, int width, int height) {
		super(img, x, y, width, height);
	}

	public void printTowerData() {
		System.out.printf("Tower: %s\nEnemies killed: %d\nRange: %f\nSpeed: %f\n", towerName, towersDestroyed, range,
				towerSpeed);
	}

	public void drawRange() {

	}

}