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
public class Squeegee1 {

	static Random rand = new Random();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		rand = new Random();
		BufferedImage im = new BufferedImage(1000, 1000,
				BufferedImage.TYPE_INT_RGB);

		Graphics2D g = im.createGraphics();

		SemicircularPath sem = new SemicircularPath(1000, 1000, 500, 500, 1,
				1.0, 0.2, 90);
		for (int i = 0; i < 20000; i++) {
			System.out.println(i);
			g.setColor(Color.BLUE);
			Point p = sem.update(10);
			g.fillOval((int) p.getX(), (int) p.getY(), 100, 100);

			g.setColor(Color.WHITE);
			p = sem.update(10);

			g.fillOval((int) p.getX(), (int) p.getY(), 100, 100);

		}

		File outputfile = new File("C:\\Users\\Maximilian\\Desktop\\image.png");
		ImageIO.write(im, "png", outputfile);

	}

}
