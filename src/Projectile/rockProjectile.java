package Projectile;

import java.io.File;

import Towers.Tower;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import model.Enemy;

/**
 * This class handles the rock projectile class
 * 
 * @author Ivan, Marisa, Laura, Albert
 * @param n/a
 * @return n/a
 * @throws n/a
 */
public class rockProjectile extends Projectile {

	private Timeline tl;
	private AudioClip rockSound = new AudioClip(new File("src/Sounds/klonk.wav").toURI().toString());
	private Tower tower;

	/**
	 * Constructor for rock Projectile
	 * 
	 * @author Ivan, Marisa, Laura, Albert
	 * @param String imageName, int speed, int x, int y, Enemy EtoShoot, int damage,
	 *               Tower tower
	 * @return n/a
	 * @throws n/a
	 */
	public rockProjectile(String imageName, int speed, int x, int y, Enemy EtoShoot, int damage, Tower tower) {
		super(imageName, speed, x, y, EtoShoot, damage);
		this.tower = tower;
		rockSound.setVolume(.5f);
		update();

	}

	/**
	 * Update Mehtod that starts the timeline for the animation
	 * 
	 * @author Ivan, Marisa, Laura, Albert
	 * @param n/a
	 * @return n/a
	 * @throws n/a
	 */
	public void update() {
		tl = new Timeline(new KeyFrame(Duration.millis(250), new AnimationHandler()));
		tl.setCycleCount(Animation.INDEFINITE);
		tl.play();

	}

	/**
	 * Event Handler that shoots out a projectile and the tracking to get to the
	 * enemy It uses a algortihm to find it way to the enemy
	 * 
	 * @author Ivan, Marisa, Laura, Albert
	 * @param ActionEvent arg0
	 * @return n/a
	 * @throws n/a
	 */
	private class AnimationHandler implements EventHandler<ActionEvent> {

		int count = 0;

		@Override
		public void handle(ActionEvent arg0) {
			if (count > 20) {
				tl.stop();
			}
			// System.out.println(EtoShoot);
			double length = Math.sqrt(
					(EtoShoot.getX() - x) * (EtoShoot.getX() - x) + (EtoShoot.getY() - y) * (EtoShoot.getY() - y));
			x = x + ((EtoShoot.getX() - x) / length * speed);

			y = y + ((EtoShoot.getY() - y) / length * speed);

			if (handleCol()) {
				rockSound.play();
				if (EtoShoot.getHealth() - damage <= 0) {

				}
				TowerDamage(EtoShoot);
				tl.stop();
			}

			draw();
			count++;
		}

	}
}
