import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
class Watermark {
	public void addWatermark(File source, File destination) {
		String str = "RSAP";
		try {
			BufferedImage image1 = ImageIO.read(source);
			BufferedImage image = image1;
			Graphics2D g = (Graphics2D)image.getGraphics();
			g.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 190));
