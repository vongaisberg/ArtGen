/**
 * 
 */
package main;

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

	Random rand = new Random();

	public Squeegee1() {
		rand = new Random();// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedImage im = new BufferedImage(1000, 1000,
				BufferedImage.TYPE_INT_RGB);

		SemicircularPath
		
		
		
		File outputfile = new File("C:\\Users\\Maximilian\\Desktop\\image.png");
		ImageIO.write(im, "png", outputfile);

	}

}
