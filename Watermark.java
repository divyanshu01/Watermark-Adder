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
			g.setColor(Color.BLACK);
			FontMetrics fm = g.getFontMetrics();
			AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f);
			g.setComposite(composite);
			int x = (image.getWidth() - fm.stringWidth(str)) / 2;
			int y = (image.getHeight()) / 2 + 50;
			g.drawString(str, x, y);
			ImageIO.write(image, "jpg", destination);
			g.dispose();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String [] args) {
		Watermark wt = new Watermark();
		File source = new File("D:\\Lion's Den\\overloading_comic.jpg");
		File destination = new File("D:\\Lion's Den\\overloading_comic1.jpg");
		wt.addWatermark(source, destination);
	}
}
