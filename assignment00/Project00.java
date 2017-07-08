	// GUI-related imports
	package assignment00;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;

	public class Project00 extends Frame implements ActionListener {
	 // program description displayed in About menu
	 String[] description = new String[] {
	  " This program receives two integer numbers and calculates",
	  "   and Displays the sum, difference and product of the numbers entered",
	  " Input:",
	  "      - Two integer numbers  ",
	  " Output:",
	  "      - sum, difference and product of input numbers"
	 };

	 Mathematics t = new Mathematics();
	 // Retrieved command code

	 String command = "";

	 public static void main(String[] args) {
	  Frame f = new Project00();

	  f.setResizable(true);
	  f.setSize(550, 500);
	  f.setVisible(true);

	 }

	 public Project00() {
	  setTitle("Simple Integer Mathematics");

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

	  // Create Menu Group Labeled "Triangle"

	  Menu mathematicsMenu = new Menu("Mathematics");

	  // Add it to Menu Bar

	  mb.add(mathematicsMenu);

	  // Create Menu Items
	  // Add action Listener 
	  // Add to "Triangle" Menu Group

	  MenuItem miEnterNumbers = new MenuItem("Enter Numbers");
	  miEnterNumbers.addActionListener(this);
	  mathematicsMenu.add(miEnterNumbers);

	  MenuItem miAdd = new MenuItem("Add");
	  miAdd.addActionListener(this);
	  mathematicsMenu.add(miAdd);
	  // Add the rest of the menu items
	  MenuItem miSub = new MenuItem("Subtract");
	  miSub.addActionListener(this);
	  mathematicsMenu.add(miSub);

	  MenuItem miMul = new MenuItem("Multiply");
	  miMul.addActionListener(this);
	  mathematicsMenu.add(miMul);

	  MenuItem miAll = new MenuItem("All Operations");
	  miAll.addActionListener(this);
	  mathematicsMenu.add(miAll);

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
	   } else
	   if ("Exit".equals(command)) {
	    System.exit(0);
	   } else
	   if ("Enter Numbers".equals(command)) {
	    t.getNumbers();
	   } else
	   if ("Add".equals(command) || "Subtract".equals(command) || "Multiply".equals(command) ||
	    "All Operations".equals(command)) {
	    repaint();
	   }

	  }
	  //********************************************************
	  // called by repaint() to redraw the screen
	  //********************************************************

	 public void paint(Graphics g) {
	  int x = 200;
	  int y = 150;

	  if ("About".equals(command)) {
	   for (int i = 0; i < 6; i++) {
	    g.drawString(description[i], x - 120, y + 40);
	    y = y + 25;
	   }
	  } else

	  if ("Enter Numbers".equals(command)) {
	   g.drawString("The Two numbers entered are:", x, y);
	   y = y + 25;
	   g.drawLine(x - 50, y, x + 200, y);
	   y = y + 25;
	   g.drawString("First  Number", x, y);
	   g.drawString(" = " + Integer.toString(t.getFirst()), x + 100, y);
	   y = y + 25;
	   g.drawString("SecondNumber", x, y);
	   g.drawString(" = " + Integer.toString(t.getSecond()), x + 100, y);
	   y = y + 25;

	  } else
	  if ("Add".equals(command)) {
	   g.drawString(Integer.toString(t.getFirst()) + " +", x + 50, y);
	   y = y + 25;
	   g.drawString(Integer.toString(t.getSecond()), x + 50, y);
	   y = y + 15;
	   g.drawLine(x + 40, y, x + 80, y);
	   y = y + 25;
	   g.drawString(Integer.toString(t.getSum()), x + 50, y);
	  } else
	  if ("Subtract".equals(command)) {
	   //similar to add
	   g.drawString(Integer.toString(t.getFirst()) + " -", x + 50, y);
	   y = y + 25;
	   g.drawString(Integer.toString(t.getSecond()), x + 50, y);
	   y = y + 15;
	   g.drawLine(x + 40, y, x + 80, y);
	   y = y + 25;
	   g.drawString(Integer.toString(t.getDifference()), x + 50, y);
	  } else
	  if ("Multiply".equals(command)) {
	   //similar to add
	   g.drawString(Integer.toString(t.getFirst()) + " *", x + 50, y);
	   y = y + 25;
	   g.drawString(Integer.toString(t.getSecond()), x + 50, y);
	   y = y + 15;
	   g.drawLine(x + 40, y, x + 80, y);
	   y = y + 25;
	   g.drawString(Integer.toString(t.getProduct()), x + 50, y);
	  } else
	  if ("All Operations".equals(command)) {
	   // need to get a bit creative on this one
	   g.drawString(Integer.toString(t.getFirst()) + " +", x - 75, y);
	   g.drawString(Integer.toString(t.getFirst()) + " -", x + 35, y);
	   g.drawString(Integer.toString(t.getFirst()) + " *", x + 145, y);
	   y = y + 25;
	   g.drawString(Integer.toString(t.getSecond()), x - 75, y);
	   g.drawString(Integer.toString(t.getSecond()), x + 35, y);
	   g.drawString(Integer.toString(t.getSecond()), x + 145, y);
	   y = y + 15;
	   g.drawLine(x - 85, y, x + 15, y);
	   g.drawLine(x + 25, y, x + 125, y);
	   g.drawLine(x + 135, y, x + 235, y);
	   y = y + 25;
	   g.drawString(Integer.toString(t.getSum()), x - 75, y);
	   g.drawString(Integer.toString(t.getDifference()), x + 35, y);
	   g.drawString(Integer.toString(t.getProduct()), x + 145, y);
	  }
	 }
	}