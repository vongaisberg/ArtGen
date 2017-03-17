package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * @author Maximilian
 *
 */
public class Colors {
	static Random rand;
	static int sizex = 300;
	static int sizey = 300;

	public Colors() {

	}

	static Color getColor(BufferedImage i, int x, int y) {
		return x < 0 || y < 0 || x >= sizex || y >= sizey ? Color.BLACK : new Color(i.getRGB(x, y));
	}

	static Color random() {
		return new Color((int) (0x1000000 * Math.random()));

	}

	static Color flatColor(Color c, Color d, int e) {

		Color[] c2 = new Color[e];
		for (int i = 1; i < e; ++i)
			c2[i] = d;
		c2[0] = c;
		return getAverage(c2);

	}

	static Color getAverage(Color[] c1) {

		int red = 0, green = 0, blue = 0;
		for (Color color : c1) {
			red += color.getRed();
			green += color.getGreen();
			blue += color.getBlue();
		}

		red /= c1.length;
		green /= c1.length;
		blue /= c1.length;

		return new Color(red, green, blue);

	}

	public static void main(String[] args) throws IOException {
		rand = new Random();
		BufferedImage im = new BufferedImage(sizex, sizey,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) im.getGraphics();

		for (int i = 0; i < 300; i += 10)
			for (int e = i; e < (i + 10); ++e)
				im.setRGB(0, e, random().getRGB());

		for (int x = 1; x < sizex; ++x) {
			System.out.println(x);
			for (int y = 1; y < sizey; ++y) {

				Color[] mix = new Color[9];
				mix[0] = getColor(im, x - 1, y - 1);
				mix[1] = getColor(im, x - 1, y);
				mix[2] = getColor(im, x - 1, y + 1);
				mix[3] = getColor(im, x - 1, y);
				mix[4] = getColor(im, x - 1, y);
				mix[5] = getColor(im, x - 1, y);
				mix[6] = getColor(im, x - 1, y);
				mix[7] = getColor(im, x - 1, y);
				mix[8] = getColor(im, x - 1, y);

				im.setRGB(x, y, flatColor(random(), getAverage(mix), 100)
						.getRGB());

			}
		}

		ImageIO.write(im, "png", new File("C:\\Users\\Maximilian\\Desktop\\image.png"));

	}
}
