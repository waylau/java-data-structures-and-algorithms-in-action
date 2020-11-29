/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.hannotta;

import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Mouse Handler.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-16
 */
public class MouseHandler
		implements MouseListener, MouseMotionListener {

	private TowerPoint[] pointA, pointB, pointC;

	private TowerPoint startPoint = null, endPoint = null;

	private int leftX, leftY, x0, y0;

	private boolean move = false;

	private Container con;

	MouseHandler(Container con) {
		this.con = con;
	}

	public TowerPoint[] getPointA() {
		return pointA;
	}

	public void setPointA(TowerPoint[] pointA) {
		this.pointA = pointA;
	}

	public TowerPoint[] getPointB() {
		return pointB;
	}

	public void setPointB(TowerPoint[] pointB) {
		this.pointB = pointB;
	}

	public TowerPoint[] getPointC() {
		return pointC;
	}

	public void setPointC(TowerPoint[] pointC) {
		this.pointC = pointC;
	}

	@Override

	public void mouseDragged(MouseEvent e) {
		Disc disc = null;

		disc = (Disc) e.getSource();
		leftX = disc.getBounds().x;
		leftY = disc.getBounds().y;

		int x = e.getX();
		int y = e.getY();

		leftX = leftX + x;
		leftY = leftY + y;

		if (move == true) {
			disc.setLocation(leftX - x0, leftY - y0);
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		move = false;

		Disc disc = null;
		disc = (Disc) e.getSource();
		startPoint = disc.getPoint();

		x0 = e.getX();
		y0 = e.getY();

		int m = 0;

		for (int i = 0; i < pointA.length; i++) {
			if (pointA[i].equals(startPoint)) {
				m = i;
				if (m > 0 && (pointA[m - 1]
						.isHaveDisc() == false)) {
					move = true;
					break;
				} else if (m == 0) {
					move = true;
					break;
				}
			}
		}

		for (int i = 0; i < pointB.length; i++) {
			if (pointB[i].equals(startPoint)) {
				m = i;
				if (m > 0 && (pointB[m - 1]
						.isHaveDisc() == false)) {
					move = true;
					break;
				} else if (m == 0) {
					move = true;
					break;
				}
			}
		}

		for (int i = 0; i < pointC.length; i++) {
			if (pointC[i].equals(startPoint)) {
				m = i;
				if (m > 0 && (pointC[m - 1]
						.isHaveDisc() == false)) {
					move = true;
					break;
				} else if (m == 0) {
					move = true;
					break;
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Disc disc = null;

		disc = (Disc) e.getSource();

		Rectangle rect = disc.getBounds();

		boolean location = false;

		int x = -1, y = -1;

		for (int i = 0; i < pointA.length; i++) {
			x = pointA[i].getX();
			y = pointA[i].getY();

			if (rect.contains(x, y)) {
				endPoint = pointA[i];
				if (i == pointA.length - 1
						&& endPoint.isHaveDisc() == false) {
					location = true;
					break;
				} else if (i < pointA.length - 1
						&& pointA[i + 1]
								.isHaveDisc() == true
						&& endPoint.isHaveDisc() == false

						&& pointA[i + 1].getDiscOnPoint()
								.getNumber() > disc
										.getNumber()) {

					location = true;
					break;
				}

			}

		}

		for (int i = 0; i < pointB.length; i++) {
			x = pointB[i].getX();
			y = pointB[i].getY();

			if (rect.contains(x, y)) {
				endPoint = pointB[i];

				if (i == pointB.length - 1
						&& endPoint.isHaveDisc() == false) {
					location = true;
					break;
				} else if (i < pointB.length - 1
						&& pointB[i + 1]
								.isHaveDisc() == true
						&& endPoint.isHaveDisc() == false

						&& pointB[i + 1].getDiscOnPoint()
								.getNumber() > disc
										.getNumber()) {
					location = true;
					break;
				}
			}
		}

		for (int i = 0; i < pointC.length; i++) {
			x = pointC[i].getX();
			y = pointC[i].getY();

			if (rect.contains(x, y)) {
				endPoint = pointC[i];
				if (i == pointC.length - 1
						&& endPoint.isHaveDisc() == false) {
					location = true;
					break;
				} else if (i < pointC.length - 1
						&& pointC[i + 1]
								.isHaveDisc() == true
						&& endPoint.isHaveDisc() == false

						&& pointC[i + 1].getDiscOnPoint()
								.getNumber() > disc
										.getNumber()) {
					location = true;
					break;
				}
			}
		}

		if (endPoint != null && location == true) {
			endPoint.putDisc(disc, con);
			startPoint.setHaveDisc(false);
		} else {
			startPoint.putDisc(disc, con);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}