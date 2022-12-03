package ui;
import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Box {
	private char typeBox;
	private int i;
	private int j;
	
	// taille de la box en px
	private int heightBox;
	private int widthBox;
	
	// Pour mettre les images
	private static Image aImage;
	private static Image wImage;
	private static Image dImage;
	private static Image eImage;
	private static Image pImage;
	
	static {
		try {
			aImage = ImageIO.read(new File("data/aBox.png"));
			wImage =ImageIO.read(new File("data/wBox.png"));
			eImage = ImageIO.read(new File("data/eBox.png"));
			dImage = ImageIO.read(new File("data/dBox.png"));
			pImage = ImageIO.read(new File("data/path.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Box(int i, int j, char typeBox) {
		this.i = i;
		this.j = j;
		this.typeBox = typeBox;
		this.heightBox = 0;
		this.widthBox = 0;
	}
	
	public final void paintBox(Graphics g, MazePanel mazePanel, int height, int width) {
		
		// height et width correspondent au nb de case du laby
		heightBox = mazePanel.getHeight()/height;
		widthBox = mazePanel.getWidth()/width;
		
		// on dessine à la coordonnée correspondante la box sous la forme de l'image DANS LE MAZEPANEL
		if(typeBox == 'A') {	
			g.drawImage(aImage, j*widthBox,i*heightBox,widthBox,heightBox, mazePanel);}
		else if(typeBox == 'D') {
		    g.drawImage(dImage, j*widthBox,i*heightBox,widthBox, heightBox,mazePanel);}
		else if (typeBox == 'E') {
			g.drawImage(eImage, j*widthBox,i*heightBox,widthBox,heightBox,mazePanel);}
		else if (typeBox == 'W'){
			g.drawImage(wImage, j*widthBox,i*heightBox,widthBox,heightBox,mazePanel);}
		else {
			g.drawImage(pImage, j*widthBox,i*heightBox,widthBox,heightBox,mazePanel);}
	}
	
	public char getSymbol() {
		return typeBox;
	}
	
	public void setTypeBox(char typeBox) {
		this.typeBox = typeBox;
	}
}
