// Luke James
// 30 September 2022
// Assignment 3 - View.java
// Function: Add features to game (pipe image, scroll position)

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
//import java.io.IOException;

class View extends JPanel
{
	Model model;
	BufferedImage pipe_image;
	int scrollPos;

	View(Controller c, Model m)
	{
		c.setView(this);
		model = m;
		scrollPos = 0;

		try
		{
			this.pipe_image = ImageIO.read(new File("pipe.png"));
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i = 0; i < model.pipeList.size(); i++)
			g.drawImage(this.pipe_image, model.pipeList.get(i).x - scrollPos, model.pipeList.get(i).y, model.pipeList.get(i).w, model.pipeList.get(i).h, null);
	}
}