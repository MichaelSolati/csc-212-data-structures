package assignment01;

// GUI-related imports

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project01 extends Frame implements ActionListener {
 // program description displayed in About menu
 String[] description = new String[] {
  " This program receives the geometrical properties of a shape and calculates",
  "   and Displays the perimeter, area and other properties of the shape",
  " Input:",
  "      - Cartesian coordinates of the topleft corner of the Rectangle, width and height  ",
  " Output:",
  "      - shape properties, sides, perimeter and area"
 };

 Rectangle R = new Rectangle();
 Oval Ova = new Oval();
 Octagon Oct = new Octagon();

 // Retrieved command code
 String command = "";

 public static void main(String[] args) {
  Frame frame = new Project01();

  frame.setResizable(true);
  frame.setSize(550, 500);
  frame.setVisible(true);
 }

 public Project01() {
  setTitle("Shape Properties");

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
  Menu rectangleMenu = new Menu("Rectangle");

  // Add it to Menu Bar
  mb.add(rectangleMenu);

  // Create Menu Items
  // Add action Listener 
  // Add to "Rectangle" Menu Group
  MenuItem miEnterRectangleProperties = new MenuItem("Enter Rectangle Properties");
  miEnterRectangleProperties.addActionListener(this);
  rectangleMenu.add(miEnterRectangleProperties);

  MenuItem miRectangleSides = new MenuItem("Rectangle Sides");
  miRectangleSides.addActionListener(this);
  rectangleMenu.add(miRectangleSides);

  MenuItem miRectangleArea = new MenuItem("Rectangle Area");
  miRectangleArea.addActionListener(this);
  rectangleMenu.add(miRectangleArea);

  MenuItem miRectanglePerimeter = new MenuItem("Rectangle Perimeter");
  miRectanglePerimeter.addActionListener(this);
  rectangleMenu.add(miRectanglePerimeter);

  MenuItem miRectangleDraw = new MenuItem("All Rectangle Properties");
  miRectangleDraw.addActionListener(this);
  rectangleMenu.add(miRectangleDraw);

  // Oval Menu
  Menu ovalMenu = new Menu("Oval");

  // Add it to Menu Bar
  mb.add(ovalMenu);

  // Create Menu Items
  // Add action Listener 
  // Add to "Oval" Menu Group
  MenuItem miEnterOvalProperties = new MenuItem("Enter Oval Properties");
  miEnterOvalProperties.addActionListener(this);
  ovalMenu.add(miEnterOvalProperties);

  MenuItem miOvalArea = new MenuItem("Oval Area");
  miOvalArea.addActionListener(this);
  ovalMenu.add(miOvalArea);

  MenuItem miOvalPerimeter = new MenuItem("Oval Perimeter");
  miOvalPerimeter.addActionListener(this);
  ovalMenu.add(miOvalPerimeter);

  MenuItem miOvalDraw = new MenuItem("All Oval Properties");
  miOvalDraw.addActionListener(this);
  ovalMenu.add(miOvalDraw);

  // Octagon Menu
  Menu octagonMenu = new Menu("Octagon");

  // Add it to Menu Bar
  mb.add(octagonMenu);

  // Create Menu Items
  // Add action Listener 
  // Add to "Octagon" Menu Group
  MenuItem miEnterOctagonProperties = new MenuItem("Enter Octagon Properties");
  miEnterOctagonProperties.addActionListener(this);
  octagonMenu.add(miEnterOctagonProperties);

  MenuItem miOctagonArea = new MenuItem("Octagon Area");
  miOctagonArea.addActionListener(this);
  octagonMenu.add(miOctagonArea);

  MenuItem miOctagonPerimeter = new MenuItem("Octagon Perimeter");
  miOctagonPerimeter.addActionListener(this);
  octagonMenu.add(miOctagonPerimeter);

  MenuItem miOctagonDraw = new MenuItem("All Octagon Properties");
  miOctagonDraw.addActionListener(this);
  octagonMenu.add(miOctagonDraw);

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
   } else if ("Enter Rectangle Properties".equals(command)) {
    R.getProperties();
   } else if ("Enter Oval Properties".equals(command)) {
    Ova.getProperties();
   } else if ("Enter Octagon Properties".equals(command)) {
    Oct.getProperties();
   } else if (
    "Rectangle Sides".equals(command) ||
    "Rectangle Area".equals(command) ||
    "Rectangle Perimeter".equals(command) ||
    "All Rectangle Properties".equals(command) ||
    "Oval Area".equals(command) ||
    "Oval Perimeter".equals(command) ||
    "All Oval Properties".equals(command) ||
    "Octagon Area".equals(command) ||
    "Octagon Perimeter".equals(command) ||
    "All Octagon Properties".equals(command)
   ) {
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
  } else if ("Enter Rectangle Properties".equals(command)) {
   g.drawString("Properties of the Rectangle", x - 10, y);
   y = y + 25;
   g.drawLine(x - 50, y, x + 200, y);
   y = y + 25;
   g.drawString("Topleft Corner", x, y);
   g.drawString("= ( " + Integer.toString(R.getX()) + "," + Integer.toString(R.getY()) + " )", x + 90, y);
   y = y + 25;
   g.drawString("Width", x, y);
   g.drawString("= " + Integer.toString(R.getWidth()), x + 90, y);
   y = y + 25;
   g.drawString("Height", x, y);
   g.drawString("= " + Integer.toString(R.getHeight()), x + 90, y);
  } else if ("Rectangle Sides".equals(command)) {
   g.drawString("The length of the sides of the Rectangle are:", x - 40, y);
   y = y + 25;
   g.drawLine(x - 40, y, x + 210, y);
   y = y + 25;
   g.drawString("Width", x, y);
   g.drawString(" = " + Integer.toString(R.getWidth()), x + 90, y);
   y = y + 25;
   g.drawString("Height", x, y);
   g.drawString(" = " + Integer.toString(R.getHeight()), x + 90, y);
  } else if ("Rectangle Area".equals(command)) {
   g.drawString("The area of the Rectangle is", x - 40, y);
   g.drawString(" = " + Integer.toString(R.getArea()), x + 135, y);
  } else if ("Rectangle Perimeter".equals(command)) {
   g.drawString("The perimeter of the Rectangle is", x - 40, y);
   g.drawString(" = " + Integer.toString(R.getPerimeter()), x + 165, y);
  } else if ("All Rectangle Properties".equals(command)) {
   g.drawString("All Rectangle Properties:", x, y);
   y = y + 10;
   g.drawLine(x, y, x + 100, y);
   y = y + 15;
   g.drawString("Width", x, y);
   g.drawString(" = " + Integer.toString(R.getWidth()), x + 60, y);
   y = y + 15;
   g.drawString("Height", x, y);
   g.drawString(" = " + Integer.toString(R.getHeight()), x + 60, y);
   y = y + 15;
   g.drawString("Area", x, y);
   g.drawString(" = " + Integer.toString(R.getArea()), x + 60, y);
   y = y + 15;
   g.drawString("Perimeter", x, y);
   g.drawString(" = " + Integer.toString(R.getPerimeter()), x + 60, y);
   g.drawRect(R.getX(), R.getY(), R.getWidth(), R.getHeight());
  }  else if ("Enter Oval Properties".equals(command)) {
   g.drawString("Properties of the Oval", x - 10, y);
   y = y + 25;
   g.drawLine(x - 50, y, x + 200, y);
   y = y + 25;
   g.drawString("Topleft Corner", x, y);
   g.drawString("= ( " + Integer.toString(Ova.getX()) + "," + Integer.toString(Ova.getY()) + " )", x + 90, y);
   y = y + 25;
   g.drawString("Width", x, y);
   g.drawString("= " + Integer.toString(Ova.getWidth()), x + 90, y);
   y = y + 25;
   g.drawString("Height", x, y);
   g.drawString("= " + Integer.toString(Ova.getHeight()), x + 90, y);
  } else if ("Oval Area".equals(command)) {
   g.drawString("The area of the Oval is", x - 40, y);
   g.drawString(" = " + Double.toString(Ova.getArea()), x + 135, y);
  } else if ("Oval Perimeter".equals(command)) {
   g.drawString("The perimeter of the Oval is", x - 40, y);
   g.drawString(" = " + Double.toString(Ova.getPerimeter()), x + 165, y);
  } else if ("All Oval Properties".equals(command)) {
   g.drawString("All Oval Properties:", x, y);
   y = y + 10;
   g.drawLine(x, y, x + 100, y);
   y = y + 15;
   g.drawString("Width", x, y);
   g.drawString(" = " + Integer.toString(Ova.getWidth()), x + 60, y);
   y = y + 15;
   g.drawString("Height", x, y);
   g.drawString(" = " + Integer.toString(Ova.getHeight()), x + 60, y);
   y = y + 15;
   g.drawString("Area", x, y);
   g.drawString(" = " + Double.toString(Ova.getArea()), x + 60, y);
   y = y + 15;
   g.drawString("Perimeter", x, y);
   g.drawString(" = " + Double.toString(Ova.getPerimeter()), x + 60, y);

   g.drawOval(Ova.getX(), Ova.getY(), Ova.getWidth(), Ova.getHeight());
  } else if ("Enter Octagon Properties".equals(command)) {
   g.drawString("Properties of the Octagon", x - 10, y);
   y = y + 25;
   g.drawLine(x - 50, y, x + 200, y);
   y = y + 25;
   g.drawString("Topleft Corner", x, y);
   g.drawString("= ( " + Integer.toString(Oct.getX()) + "," + Integer.toString(Oct.getY()) + " )", x + 90, y);
   y = y + 25;
   g.drawString("Side Length", x, y);
   g.drawString("= " + Integer.toString(Oct.getSide()), x + 90, y);
  } else if ("Octagon Area".equals(command)) {
   g.drawString("The area of the Octagon is", x - 40, y);
   g.drawString(" = " + Double.toString(Oct.getArea()), x + 135, y);
  } else if ("Octagon Perimeter".equals(command)) {
   g.drawString("The perimeter of the Octagon is", x - 40, y);
   g.drawString(" = " + Integer.toString(Oct.getPerimeter()), x + 165, y);
  } else if ("All Octagon Properties".equals(command)) {
   g.drawString("All Octagon Properties:", x, y);
   y = y + 10;
   g.drawLine(x, y, x + 100, y);
   y = y + 15;
   g.drawString("Width", x, y);
   g.drawString(" = " + Integer.toString(Oct.getSide()), x + 60, y);
   y = y + 15;
   g.drawString("Area", x, y);
   g.drawString(" = " + Double.toString(Oct.getArea()), x + 60, y);
   y = y + 15;
   g.drawString("Perimeter", x, y);
   g.drawString(" = " + Double.toString(Oct.getPerimeter()), x + 60, y);

   int[][] octPoints = new int[8][2];
   int xC = Oct.getX();
   int yC = Oct.getY();
   int side = Oct.getSide();
   double cornerDouble = Math.sqrt(((side * side) / 2));
   int corner = (int) cornerDouble;

   // Calculate all points of Octagon
   octPoints[0][0] = corner + xC;
   octPoints[0][1] = yC;
   octPoints[1][0] = octPoints[0][0] + side;
   octPoints[1][1] = yC;

   octPoints[2][0] = octPoints[1][0] + corner;
   octPoints[2][1] = yC + corner;
   octPoints[3][0] = octPoints[2][0];
   octPoints[3][1] = octPoints[2][1] + side;

   octPoints[4][0] = octPoints[1][0];
   octPoints[4][1] = octPoints[3][1] + corner;
   octPoints[5][0] = octPoints[0][0];
   octPoints[5][1] = octPoints[4][1];

   octPoints[6][0] = xC;
   octPoints[6][1] = octPoints[3][1];
   octPoints[7][0] = xC;
   octPoints[7][1] = octPoints[2][1];

   // Draw Octagon
   g.drawLine(octPoints[0][0], octPoints[0][1], octPoints[1][0], octPoints[1][1]);
   g.drawLine(octPoints[1][0], octPoints[1][1], octPoints[2][0], octPoints[2][1]);
   g.drawLine(octPoints[2][0], octPoints[2][1], octPoints[3][0], octPoints[3][1]);
   g.drawLine(octPoints[3][0], octPoints[3][1], octPoints[4][0], octPoints[4][1]);
   g.drawLine(octPoints[4][0], octPoints[4][1], octPoints[5][0], octPoints[5][1]);
   g.drawLine(octPoints[5][0], octPoints[5][1], octPoints[6][0], octPoints[6][1]);
   g.drawLine(octPoints[6][0], octPoints[6][1], octPoints[7][0], octPoints[7][1]);
   g.drawLine(octPoints[7][0], octPoints[7][1], octPoints[0][0], octPoints[0][1]);

  }
 }
}