package com.neuedu.solar.core;

import java.awt.Graphics;
import java.awt.Image;

import com.neuedu.solar.util.Gameutil;
public class Background {
	int x;
	int y;
	Image img;
	
	public Background() {
		this.x = 0;
		this.y = 0;
		this.img = Gameutil.getImage("img/bg.png");
	}
	
	public void draw(Graphics g) {
		g.drawImage(img,x,y,null);
	}
}
