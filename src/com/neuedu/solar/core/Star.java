package com.neuedu.solar.core;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Star implements Moveable,Drawable{
	/**
	 * Field
	 * 
	 */
	int x;
	int y;
	Image img;
	double speed;
	String name;
	
	/**
	 * method
	 */
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		move();
	}
	
	public abstract void move();
	
}
