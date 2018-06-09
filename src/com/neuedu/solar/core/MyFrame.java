package com.neuedu.solar.core;

import java.awt.Color;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.neuedu.solar.constant.Constant;

public class MyFrame extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * set the Frame
	 */
	public void lauchFram() {
		setTitle("太阳系八大行星");
		setSize(Constant.Game_WIDTH,Constant.Game_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		//关闭窗口
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});	
		new MyThread().start();
	}
	
	//用双缓冲的方法解决图片闪烁问题
	Image backImg = null;
	
	//重写update()方法，在窗口的里层添加一个虚拟的图片
	@Override
	public void update(Graphics g) {
		if (backImg == null) {
			//如果虚拟图片不存在，创建一个和窗口一样大小的图片
			backImg = createImage(Constant.Game_WIDTH,Constant.Game_HEIGHT);
		}
		//获取到虚拟图片的画笔
		Graphics backg = backImg.getGraphics();
		Color c = backg.getColor();
		backg.setColor(Color.BLACK);
		backg.fillRect(0, 0, Constant.Game_WIDTH, Constant.Game_HEIGHT);
		backg.setColor(c);
		//调用虚拟图片的paint（）方法，每50ms刷新一次
		paint(backg);
		g.drawImage(backImg, 0, 0, null);
	}
	
	/**
	 * 不停执行paint（）方法的线程内部类
	 */
	class MyThread extends Thread{
		@Override
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
