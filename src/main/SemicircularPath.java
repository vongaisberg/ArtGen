/**
 * 
 */
package main;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * @author Maximilian
 *
 */
public class SemicircularPath {

	int sizeX, sizeY;
	double speed, angularSpeed, angularAcceleration, angle, posX, posY;
	Random rand;

	public SemicircularPath(int sizeX, int sizeY, int posX, int posY,
			double speed, double angularSpeed, double angularAcceleration,
			double angle) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.angularSpeed = angularSpeed;
		this.angle = Math.toRadians(angle);
		this.angularAcceleration = angularAcceleration;
		rand = new Random();
	}

	public Point update(int res) {
		for (int i = 0; i < res; i++) {
			double additionX = Math.sin(angle) * speed;
			double additionY = Math.cos(angle) * speed;

			posX += additionX;
			posY += additionY;

			angle += angularSpeed;

			angularSpeed = rand.nextDouble() * angularAcceleration
					- (angularAcceleration / 2);

			if (posX < 0 || posY < 0 || posX > sizeX || posY > sizeY) {
				posX -= additionX;
				posY -= additionY;
				angle += 2;
			}
		}

		return new Point((int) posX, (int) posY);

	}

	public double getAngle() {
		return angle;
	}

	public static void main(String[] args) throws IOException {
		BufferedImage im = new BufferedImage(1000, 1000,
				BufferedImage.TYPE_INT_RGB);

		SemicircularPath sem = new SemicircularPath(1000, 1000, 500, 500, 1,
				1.0, 0.2, 90);

		for (int i = 0; i < 100000; i++) {
			System.out.println(i);
			Point p = sem.update(1);
			im.setRGB((int) p.getX(), (int) p.getY(), Color.RED.getRGB());
		}

		File outputfile = new File("C:\\Users\\Maximilian\\Desktop\\image.png");
		ImageIO.write(im, "png", outputfile);
	}

}
