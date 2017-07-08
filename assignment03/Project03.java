package assignment03;

// GUI-related imports

import java.awt.*;
import java.awt.event.*;

public class Project03 extends Frame implements ActionListener {
	// program description displayed in About menu
	String[] description = new String[] {
			"A program to color code a population of binary population (made of 0 or 1) based on the how crowded their",
			"neighborhood is. The population represents the presence/absence of an entity in a grid of 100X100 (their land).",
			"The color of an entity (its survival) depends on the population of its neighbors (3X3 grid around the cell).",
			"      -If a cell is surrounded by less than 2 cells color code is white",
			"      -If a cell is surrounded by 2 or 3 cells color code is green",
			"      -If a cell  is surrounded by 4 or 5 cells color code is blue",
			"      -If a cell is surrounded by 6 or 7 cells color code is red", "      -Otherwise color code is black" };

	ColorIsAwesome colorPop = new ColorIsAwesome();
	String command = "";
	Font population = new Font("Calibri", Font.BOLD, 16);
	Font title = new Font("Calibri", Font.BOLD, 24);

	public static void main(String[] args) {
		Frame frame = new Project03();
		frame.setResizable(true);
		frame.setSize(900, 900);
		frame.setVisible(true);

	}

	public Project03() {
		setTitle("Color Code Binary Population");

		// Create Menu Bar
		MenuBar mb = new MenuBar();
		setMenuBar(mb);

		// Create Menu Group Labeled "File"
		Menu fileMenu = new Menu("File");

		// Add it to Menu Bar
		mb.add(fileMenu);

		// Create Menu Items
		// Add action Listener 
		// Add to "File" Menu Group
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);

		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);

		// Create Menu Group Labeled "Color"
		Menu colorMenu = new Menu("Color");

		// Add it to Menu Bar
		mb.add(colorMenu);

		// Create Menu Items
		// Add action Listener 
		// Add to "Color" Menu Group
		MenuItem miRunGRP = new MenuItem("Generate Random Population");
		miRunGRP.addActionListener(this);
		colorMenu.add(miRunGRP);

		MenuItem miRunColor = new MenuItem("Color");
		miRunColor.addActionListener(this);
		colorMenu.add(miRunColor);

		// End program when window is closed
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}

			public void windowActivated(WindowEvent ev) {
				repaint();
			}

			public void windowStateChanged(WindowEvent ev) {
				repaint();
			}
		};

		ComponentListener k = new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				repaint();
			}
		};

		// register listeners
		this.addWindowListener(l);
		this.addComponentListener(k);
	}

	//******************************************************************************
	//  called by windows manager whenever the application window performs an action
	//  (select a menu item, close, resize, ....
	//******************************************************************************

	public void actionPerformed(ActionEvent ev) {
		// figure out which command was issued
		command = ev.getActionCommand();
		// take action accordingly
		if ("About".equals(command)) {
			repaint();
		} else if ("Exit".equals(command)) {
			System.exit(0);
		} else if ("Generate Random Population".equals(command)) {
			colorPop.popGenerator();
		} else if ("Color".equals(command)) {
			colorPop.colorCalculator();
		}
	}
	//********************************************************
	// called by repaint() to redraw the screen
	//********************************************************

	public void paint(Graphics g) {
		int x = 450;
		int y = 200;

		if ("About".equals(command)) {
			x = 300;
			y = 200;

			for (int i = 0; i < description.length; i++) {
				g.drawString(description[i], x - 250, y);
				y += 20;
			}

			x = 300;
			y = 200;
		} else if ("Generate Random Population".equals(command)) {
			x = 450;
			y = 200;
			g.setFont(title);
			g.setColor(Color.red);
			g.drawString("Original Population", 327, 160);
			g.setColor(Color.black);
			g.drawRect(145, 180, 610, 610);

			for (int a = 0; a < 100; a++) {
				for (int b = 0; b < 100; b++) {
					g.setFont(population);
					g.setColor(Color.black);
					g.drawString(colorPop.theGrid[a][b], x - 300, y);
					x += 6;
				}
				x = 450;
				y += 6;
			}
			x = 450;
			y = 200;
		} else if ("Color".equals(command)) {
			x = 450;
			y = 200;

			g.setFont(title);
			g.setColor(Color.red);
			g.drawString("Color Coded", 372, 160);
			g.setColor(Color.black);
			g.drawRect(145, 180, 610, 610);

			for (int a = 0; a < 100; a++) {
				for (int b = 0; b < 100; b++) {
					g.setFont(population);
					if (colorPop.theColors[a][b] == "white") {
						g.setColor(Color.white);
					} else if (colorPop.theColors[a][b] == "green") {
						g.setColor(Color.green);
					} else if (colorPop.theColors[a][b] == "blue") {
						g.setColor(Color.blue);
					} else if (colorPop.theColors[a][b] == "red") {
						g.setColor(Color.red);
					} else if (colorPop.theColors[a][b] == "black") {
						g.setColor(Color.black);
					}
					g.drawString(colorPop.theGrid[a][b], x - 300, y);
					x += 6;
				}
				x = 450;
				y += 6;
			}
			x = 450;
			y = 200;
		}
	}
}