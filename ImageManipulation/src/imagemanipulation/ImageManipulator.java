package imagemanipulation;
 
import java.awt.Color;
import java.awt.event.MouseListener;
import java.io.File;
 
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
 
import processing.core.PApplet;
import processing.core.PImage;
 
public class ImageManipulator extends PApplet{
  PImage image;
	public void setup()
	{
		 selectInput("Select a file to process:", "fileSelected");
	}
	public void draw()
	{
		if(this.image!=null)
		{
			image(image,0,0);
			//this.size(image.width,image.height);
		}
		}
	public void fileSelected(File input)
	{
		if(input != null)
		{
			System.out.println("Selected file: "+input.getAbsoluteFile());
			this.image = this.loadImage(input.getAbsolutePath());
		}
		else
			System.out.println("No file selected");
	}
	public void mouseClicked()
	{
		invertBlackandWhite();

	}
	private void invertColors() 
	{
		this.image.loadPixels();
		for(int x=0;x<image.pixels.length;x++)
		{
			int p = image.pixels[x];
			float red = 255-this.red(p);
			float green = 255-this.green(p);
			float blue = 255-this.blue(p);
			this.image.pixels[x] = this.color(red,green,blue);
		}
		this.image.updatePixels();
	}
	public void invertBlackandWhite()
	{
		this.image.loadPixels();
		for(int i = 0; i < image.pixels.length; i++)
		{
			int p = image.pixels[i];
			
			if(p ==0)
				this.image.pixels[i] = this.color(255,255,255);
			if(p == 255)
				this.image.pixels[i] = this.color(0,0,0);
		}
		this.image.updatePixels();
	}
	public void stupidFilterFlip()
	{
		this.image.loadPixels();
		for(int x=0;x<(image.pixels.length/2);x++)
		{
			this.image.pixels[x]= this.image.pixels[this.image.pixels.length-x-1];
		}
		this.image.updatePixels();
	}
}