/**
 * 
 */
package main;

import java.awt.Color;
import java.awt.Graphics2D;
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
public class Squeegee2 {

	static Random rand = new Random();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		rand = new Random();
		BufferedImage im = new BufferedImage(2000, 2000,
				BufferedImage.TYPE_INT_RGB);

		Graphics2D g = im.createGraphics();

		SemicircularPath sem = new SemicircularPath(2000, 2000, 500, 500, 1,
				1.0, 0.15, 90);
		SemicircularPath sem2 = new SemicircularPath(2000, 2000, 500, 500, 1,
				1.0, 0.15, 90);
		SemicircularPath sem3 = new SemicircularPath(2000, 2000, 500, 500, 1,
				1.0, 0.15, 90);
		SemicircularPath sem4 = new SemicircularPath(2000, 2000, 500, 500, 1,
				1.0, 0.15, 90);
		for (int i = 0; i < 40000; i++) {
			System.out.println(i);
			g.setColor(Color.WHITE);
			Point p = sem.update(10);
			g.fillOval((int) p.getX(), (int) p.getY(), 100, 100);

			g.setColor(Color.BLUE);
			p = sem.update(10);

			g.fillOval((int) p.getX(), (int) p.getY(), 100, 100);

			// SECOND
			g.setColor(Color.WHITE);
			p = sem2.update(10);
			g.fillOval((int) p.getX(), (int) p.getY(), 100, 100);

			g.setColor(Color.RED);
			p = sem2.update(10);

			g.fillOval((int) p.getX(), (int) p.getY(), 100, 100);

			// THIRD
			g.setColor(Color.WHITE);
			p = sem3.update(10);
			g.fillOval((int) p.getX(), (int) p.getY(), 100, 100);

			g.setColor(Color.BLUE.darker());
			p = sem3.update(10);

			g.fillOval((int) p.getX(), (int) p.getY(), 100, 100);

			// FOURTH
			g.setColor(Color.WHITE);
			p = sem4.update(10);
			g.fillOval((int) p.getX(), (int) p.getY(), 100, 100);

			g.setColor(Color.RED.darker());
			p = sem4.update(10);

			g.fillOval((int) p.getX(), (int) p.getY(), 100, 100);

		}

		File outputfile = new File("C:\\Users\\Maximilian\\Desktop\\image.png");
		ImageIO.write(im, "png", outputfile);

	}

}
