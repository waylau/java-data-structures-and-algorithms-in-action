/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.hannotta;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Hannotta Window.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-16
 */
public class HannottaWindow extends JFrame
		implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static final int MAX_DISCS = 10; // 最大碟子數量

	private static final char[] towerNames = { 'A', 'B',
			'C' }; // 塔名

	private final Tower tower;

	private int amountOfDisc = 3; // 碟子数量

	public HannottaWindow() {

		tower = new Tower(towerNames);

		tower.setAmountOfDisc(amountOfDisc);

		tower.setMaxDiscWidth(120);

		tower.setMinDiscWidth(50);

		tower.setDiscHeight(16);

		tower.putDiscOnTower();

		add(tower, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();

		JMenu amountOfDiscMenu = new JMenu("碟子数");

		for (int i = 1; i <= MAX_DISCS; i++) {
			JMenuItem gradeItem = new JMenuItem(i + "",
					MenuTypeEnum.DISC.getValue());

			gradeItem.addActionListener(this);

			amountOfDiscMenu.add(gradeItem);
		}

		JMenu settingMenu = new JMenu("设置");

		JMenuItem renewMenuItem = new JMenuItem("重新开始",
				MenuTypeEnum.RENEW.getValue());

		renewMenuItem.addActionListener(this);

		settingMenu.add(renewMenuItem);

		JMenuItem autoMenuItem = new JMenuItem("自动演示",
				MenuTypeEnum.AUTO.getValue());

		autoMenuItem.addActionListener(this);

		settingMenu.add(autoMenuItem);

		menuBar.add(amountOfDiscMenu);

		menuBar.add(settingMenu);

		setTitle("Hannotta");

		setJMenuBar(menuBar);

		setResizable(false);

		setVisible(true);

		setBounds(60, 60, 460, 410);

		validate();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 事件处理
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			// 碟子数
			JMenuItem menuItem = (JMenuItem) e.getSource();

			int menuTypeValue = menuItem.getMnemonic();

			if (MenuTypeEnum.DISC
					.getValue() == menuTypeValue) { // 碟子数
				String menuItemName = menuItem.getText();
				amountOfDisc = Integer
						.valueOf(menuItemName);

				tower.setAmountOfDisc(amountOfDisc);
				tower.putDiscOnTower();
			} else if (MenuTypeEnum.RENEW
					.getValue() == menuTypeValue) {// 重新开始

				tower.setAmountOfDisc(amountOfDisc);
				tower.putDiscOnTower();
			} else if (MenuTypeEnum.AUTO
					.getValue() == menuTypeValue) { // 自动演示

				tower.setAmountOfDisc(amountOfDisc);
				tower.putDiscOnTower();

				int x = this.getBounds().x
						+ this.getBounds().width;
				int y = this.getBounds().y;

				tower.getAutoMoveDisc().setLocation(x, y);
				tower.getAutoMoveDisc().setSize(280,
						this.getBounds().height);
				tower.getAutoMoveDisc().setVisible(true);
			}

			validate();
		}
	}
}
