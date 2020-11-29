/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.hannotta;

import java.awt.Color;
import javax.swing.JButton;

/**
 * Disc
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-16
 */
public class Disc extends JButton {

	private static final long serialVersionUID = 1L;

	private int number;

	private TowerPoint point;

	Disc() {
		setBackground(Color.YELLOW);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public TowerPoint getPoint() {
		return point;
	}

	public void setPoint(TowerPoint point) {
		this.point = point;
	}
}
