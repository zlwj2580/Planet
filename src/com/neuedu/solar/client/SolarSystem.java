package com.neuedu.solar.client;

import java.awt.Graphics;

import com.neuedu.solar.core.Background;
import com.neuedu.solar.core.MyFrame;
import com.neuedu.solar.core.Planet;
/**
 * ¿Í»§¶Ë
 * @author Administrator
 *
 */
import com.neuedu.solar.core.Sun;
public class SolarSystem extends MyFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Background bg = new Background();
	Sun sun = new Sun();
	Planet Mercury = new Planet(sun, "img/01.mercury.png", 88, 0.38, 0.2056);
	Planet Venus = new Planet(sun, "img/02.venus.png", 225, 0.72, 0.0068);
	Planet earth = new Planet(sun, "img/03.earth.png", 365, 1, 0.0167);
	Planet Mars = new Planet(sun, "img/04.mars.png", 687, 1.52, 0.0933);
	Planet Jupiter = new Planet(sun, "img/05.jupiter.png", 4333, 5.2, 0.0489);
	Planet Saturn = new Planet(sun, "img/06.saturn.png", 10760, 9.54, 0.0539);
	Planet Uranos = new Planet(sun, "img/07.uranos.png", 30799, 19.218, .0432);
	Planet Nepyune = new Planet(sun, "img/08.nepyune.png", 60188, 30.06, .0011);
	Planet Moon = new Planet(earth, "img/moon.png", 365/12, 0.3, .0011,true);
	
	@Override
	public void paint(Graphics g) {
		bg.draw(g);
		sun.draw(g);
		Mercury.draw(g);
		Venus.draw(g);
		earth.draw(g);
		Moon.draw(g);
		Mars.draw(g);
		Jupiter.draw(g);
		Saturn.draw(g);
		Uranos.draw(g);
		Nepyune.draw(g);
	}
	
	public static void main(String[] args) {
		new SolarSystem().lauchFram();
	}
}
