package com.neuedu.solar.core;

import java.awt.Color;

import java.awt.Graphics;

import com.neuedu.solar.util.Gameutil;

public class Planet extends Star {

	/**
	 * 半长轴
	 */
	double longAxis;
	double shortAxis;
	double theta;
	/**
	 * 运行的中心
	 */
	Star center;
	
	boolean satellite;
	
	public Planet(Star center,String imgPath,int day,double au,double e) {
		this.center = center;
		this.img = Gameutil.getImage(imgPath);
		this.longAxis = getLongAxis(au);
		this.shortAxis = getShortAxis(e)/4;
		this.x = (int) (center.x + longAxis - this.img.getWidth(null)/2);
		this.y = center.y - this.img.getHeight(null)/2;
		this.speed = getSpeed(day);
	}
	
	/**
	 * 
	 * @param center
	 * @param imgPath
	 * @param day 公转周期
	 * @param au  1天文单位  1au = 1.49亿公里
	 * @param e 轨道离心率
	 */
	
	public Planet(Star center,String imgPath,int day,double au,double e,boolean satellite) {
		this(center, imgPath, day, au, e);
		this.satellite = satellite;
	}
	
	private double getLongAxis(double au) {
		return au * 200;
	}

	public static double getSpeed(int day) {
		return (365d/day) * 0.1;
	}

	public int getShortAxis(double e) {
		
		return (int)(longAxis * Math.sqrt(1 - e * e));
		
	}
	
	@Override
	public void move() {
		x =center.x + center.img.getWidth(null)/2 - this.img.getWidth(null)/2  + (int)(longAxis * Math.cos(theta));
		y = center.y + center.img.getHeight(null)/2 -this.img.getHeight(null)/2  + (int)(shortAxis * Math.sin(theta));
		theta += speed;
	}
	
	@Override
	public void draw(Graphics g) {
		if(!satellite) {
			drawTrace(g);
		}
		super.draw(g);
	}
	
	/**
	 * 运行的椭圆轨道
	 */
	public void drawTrace (Graphics g) {
		//画椭圆的方法
		int o_x = (int) (center.x + center.img.getWidth(null)/2 - longAxis);
		int o_y = (int) (center.y + center.img.getHeight(null)/2 - shortAxis);
		int width = (int) (2 * longAxis);
		int height = (int) (2 * shortAxis);
		//修改颜色
		Color c =g.getColor();
		g.setColor(Color.WHITE);
		g.drawOval(o_x, o_y, width, height);
		g.setColor(c);
	}

}
