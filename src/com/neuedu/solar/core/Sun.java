package com.neuedu.solar.core;

import com.neuedu.solar.constant.Constant;
import com.neuedu.solar.util.Gameutil;

public class Sun extends Star {
	/**
	 * entity:  µÃÂ¿‡  pojo vo javabean bean
	 */
	public Sun() {
		this.img = Gameutil.getImage("img/Sun.png");
		this.x = Constant.Game_WIDTH/2 - img.getWidth(null)/2;
		this.y = Constant.Game_HEIGHT/2 - img.getHeight(null)/2;
	}
	
	@Override
	public void move() {
		
	}

}
