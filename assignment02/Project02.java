package assignment02;

import java.awt.*;
import java.awt.event.*;

public class Project02 extends Frame implements ActionListener {
 private static final long serialVersionUID = 1 L;

 // program description displayed in About menu
 String[] description = new String[] {
  "This program reads a text file selected by a user              ",
  "and displays the selected attributes of the file.              ",
  "      Input:                                                   ",
  "      -A .txt file                                             ",
  "                                                               ",
  "      Output:                                                  ",
  "      -Frequency of ASCII Characters                           ",
  "      -Frequency of Letters                                    ",
  "      -Frequency of Digits                                     ",
  "      -Frequency of Words (Length 1-20)                        "
 };

 TextFile textFile = new TextFile();

 String command = "";

 public static void main(String[] args) {
  Frame f = new Project02();

  f.setResizable(true);
  f.setSize(1100, 600);
  f.setVisible(true);

 }

 public Project02() {
  setTitle("Text Parser");

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

  // Create Operations Bar
  Menu operationsMenu = new Menu("Operations");
  mb.add(operationsMenu);

  // Create Menu Items
  // Add action Listener
  // Add to Menu Group

  MenuItem openFile = new MenuItem("Open File");
  openFile.addActionListener(this);
  operationsMenu.add(openFile);

  MenuItem process = new MenuItem("Process");
  process.addActionListener(this);
  operationsMenu.add(process);

  // Create Report Bar
  Menu reportMenu = new Menu("Report");
  mb.add(reportMenu);

  // Create Menu Items
  // Add action Listener
  // Add to Menu Group

  MenuItem asciiFrequency = new MenuItem("Frequency of ASCII Characters");
  asciiFrequency.addActionListener(this);
  reportMenu.add(asciiFrequency);

  MenuItem letterFrequency = new MenuItem("Frequency of Letters");
  letterFrequency.addActionListener(this);
  reportMenu.add(letterFrequency);

  MenuItem digitFrequency = new MenuItem("Frequency of Digits");
  digitFrequency.addActionListener(this);
  reportMenu.add(digitFrequency);

  MenuItem wordFrequency = new MenuItem("Frequency of Words (Length 1-20)");
  wordFrequency.addActionListener(this);
  reportMenu.add(wordFrequency);

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
   } else if ("Open File".equals(command)) {
    textFile.openFile();
   } else {
    repaint();
   }
  }
  //********************************************************
  // called by repaint() to redraw the screen
  //********************************************************

 public void paint(Graphics g) {
  int x = (getWidth() / 2);
  int y = (((getHeight() - 40) / 2) + 40);
  String displayedString;

  if ("About".equals(command)) {
   x -= (g.getFontMetrics().stringWidth(description[1]) / 2);
   y -= ((g.getFontMetrics().getHeight()) / 2) + 400;
   for (int i = 0; i < 10; i++) {
    g.drawString(description[i], x, y);
    y = y + 25;
   }
  } else if ("Open File".equals(command)) {
   if (textFile.getFileName() != "") {
    displayedString = "Your file: " + (textFile.getFileName());
   } else {
    displayedString = "Please Select A .txt File";
   }
   x -= (g.getFontMetrics().stringWidth(displayedString) / 2);
   y -= (g.getFontMetrics().getHeight()) / 2;
   g.drawString(displayedString, x, y);
  } else if ("Process".equals(command)) {
   displayedString = textFile.processFile();
   x -= (g.getFontMetrics().stringWidth(displayedString) / 2);
   y -= (g.getFontMetrics().getHeight()) / 2;
   g.drawString(displayedString, x, y);
  } else if ("Frequency of ASCII Characters".equals(command)) {
   displayedString = "Frequency of ASCII Characters";
   x -= (g.getFontMetrics().stringWidth(displayedString) / 2);
   y -= 270;

   int halfLine = (g.getFontMetrics().stringWidth(displayedString) / 2);
   int intCol, charCol, countCol, fullCol;

   displayedString = "Int | ";
   intCol = g.getFontMetrics().stringWidth(displayedString);

   displayedString = "Char | ";
   charCol = g.getFontMetrics().stringWidth(displayedString);

   displayedString = "Count - ";
   countCol = g.getFontMetrics().stringWidth(displayedString);

   fullCol = intCol + charCol + countCol;

   g.setColor(Color.red);
   displayedString = "Frequency of ASCII Characters";

   g.drawString(displayedString, x, y);

   g.setColor(Color.black);
   y = y + 15;

   g.drawLine((x + halfLine) - (4 * fullCol), y, (x + halfLine) + (4 * fullCol), y);
   y = y + 15;

   displayedString = "Int | ";
   g.drawString(displayedString, (x + halfLine) - (4 * fullCol), y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) - (3 * fullCol), y);
   g.setColor(Color.black);
   g.drawString(displayedString, (x + halfLine) - (2 * fullCol), y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) - fullCol, y);
   g.setColor(Color.black);
   g.drawString(displayedString, (x + halfLine), y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) + fullCol, y);
   g.setColor(Color.black);
   g.drawString(displayedString, (x + halfLine) + (2 * fullCol), y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) + (3 * fullCol), y);
   g.setColor(Color.black);

   displayedString = "Char | ";
   g.drawString(displayedString, (x + halfLine) - (4 * fullCol) + intCol, y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) - (3 * fullCol) + intCol, y);
   g.setColor(Color.black);
   g.drawString(displayedString, (x + halfLine) - (2 * fullCol) + intCol, y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) - fullCol + intCol, y);
   g.setColor(Color.black);
   g.drawString(displayedString, (x + halfLine) + intCol, y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) + fullCol + intCol, y);
   g.setColor(Color.black);
   g.drawString(displayedString, (x + halfLine) + (2 * fullCol) + intCol, y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) + (3 * fullCol) + intCol, y);
   g.setColor(Color.black);

   displayedString = "Count ";
   g.drawString(displayedString, (x + halfLine) - (4 * fullCol) + intCol + charCol, y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) - (3 * fullCol) + intCol + charCol, y);
   g.setColor(Color.black);
   g.drawString(displayedString, (x + halfLine) - (2 * fullCol) + intCol + charCol, y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) - fullCol + intCol + charCol, y);
   g.setColor(Color.black);
   g.drawString(displayedString, (x + halfLine) + intCol + charCol, y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) + fullCol + intCol + charCol, y);
   g.setColor(Color.black);
   g.drawString(displayedString, (x + halfLine) + (2 * fullCol) + intCol + charCol, y);
   g.setColor(Color.blue);
   g.drawString(displayedString, (x + halfLine) + (3 * fullCol) + intCol + charCol, y);
   g.setColor(Color.black);

   y = y + 15;
   g.drawLine((x + halfLine) - (4 * fullCol), y, (x + halfLine) + (4 * fullCol), y);
   y = y + 15;

   int[] ascii = textFile.getTokens();

   for (int i = 0; i < 32; i++) {
    g.drawString(Integer.toString(i), (x + halfLine) - (4 * fullCol), y);
    g.setColor(Color.blue);
    g.drawString(Integer.toString(i + 32), (x + halfLine) - (3 * fullCol), y);
    g.setColor(Color.black);
    g.drawString(Integer.toString(i + 64), (x + halfLine) - (2 * fullCol), y);
    g.setColor(Color.blue);
    g.drawString(Integer.toString(i + 96), (x + halfLine) - fullCol, y);
    g.setColor(Color.black);
    g.drawString(Integer.toString(i + 128), (x + halfLine), y);
    g.setColor(Color.blue);
    g.drawString(Integer.toString(i + 160), (x + halfLine) + fullCol, y);
    g.setColor(Color.black);
    g.drawString(Integer.toString(i + 192), (x + halfLine) + (2 * fullCol), y);
    g.setColor(Color.blue);
    g.drawString(Integer.toString(i + 224), (x + halfLine) + (3 * fullCol), y);
    g.setColor(Color.black);

    g.drawString(Character.toString((char) i), (x + halfLine) - (4 * fullCol) + intCol, y);
    g.setColor(Color.blue);
    g.drawString(Character.toString((char)(i + 32)), (x + halfLine) - (3 * fullCol) + intCol, y);
    g.setColor(Color.black);
    g.drawString(Character.toString((char)(i + 64)), (x + halfLine) - (2 * fullCol) + intCol, y);
    g.setColor(Color.blue);
    g.drawString(Character.toString((char)(i + 96)), (x + halfLine) - fullCol + intCol, y);
    g.setColor(Color.black);
    g.drawString(Character.toString((char)(i + 128)), (x + halfLine) + intCol, y);
    g.setColor(Color.blue);
    g.drawString(Character.toString((char)(i + 160)), (x + halfLine) + fullCol + intCol, y);
    g.setColor(Color.black);
    g.drawString(Character.toString((char)(i + 192)), (x + halfLine) + (2 * fullCol) + intCol, y);
    g.setColor(Color.blue);
    g.drawString(Character.toString((char)(i + 224)), (x + halfLine) + (3 * fullCol) + intCol, y);
    g.setColor(Color.black);

    g.drawString(Integer.toString(ascii[i]), (x + halfLine) - (4 * fullCol) + intCol + charCol, y);
    g.setColor(Color.blue);
    g.drawString(Integer.toString(ascii[i + 32]), (x + halfLine) - (3 * fullCol) + intCol + charCol, y);
    g.setColor(Color.black);
    g.drawString(Integer.toString(ascii[i + 64]), (x + halfLine) - (2 * fullCol) + intCol + charCol, y);
    g.setColor(Color.blue);
    g.drawString(Integer.toString(ascii[i + 96]), (x + halfLine) - fullCol + intCol + charCol, y);
    g.setColor(Color.black);
    g.drawString(Integer.toString(ascii[i + 128]), (x + halfLine) + intCol + charCol, y);
    g.setColor(Color.blue);
    g.drawString(Integer.toString(ascii[i + 160]), (x + halfLine) + fullCol + intCol + charCol, y);
    g.setColor(Color.black);
    g.drawString(Integer.toString(ascii[i + 192]), (x + halfLine) + (2 * fullCol) + intCol + charCol, y);
    g.setColor(Color.blue);
    g.drawString(Integer.toString(ascii[i + 224]), (x + halfLine) + (3 * fullCol) + intCol + charCol, y);
    g.setColor(Color.black);
    y = y + 15;
   }



  } else if ("Frequency of Letters".equals(command)) {
   g.setColor(Color.red);
   displayedString = "Frequency of Letters";

   x -= (g.getFontMetrics().stringWidth(displayedString) / 2);
   y -= 225;
   int halfLine = (g.getFontMetrics().stringWidth(displayedString) / 2);
   int fullLine = g.getFontMetrics().stringWidth(displayedString);
   int secondColumn, secondSecondColumn;
   g.drawString(displayedString, x, y);

   g.setColor(Color.black);
   y = y + 15;

   g.drawLine((x + halfLine) - 200, y, (x + halfLine) + 200, y);
   y = y + 15;
   displayedString = "Frequency";
   secondSecondColumn = secondColumn = fullLine - g.getFontMetrics().stringWidth(displayedString);
   g.drawString(displayedString, (x + halfLine + secondColumn) - 200, y);
   g.drawString(displayedString, (x + halfLine - secondColumn) + 200, y);

   displayedString = "Letter";
   g.drawString(displayedString, (x + halfLine) - 200, y);
   g.drawString(displayedString, (x + halfLine - (2 * secondColumn)) + 200, y);
   y = y + 15;
   g.drawLine((x + halfLine) - 200, y, (x + halfLine) + 200, y);
   y = y + 15;

   int[] ascii = textFile.getTokens();

   for (int i = 65; i < 91; i++) {
    displayedString = Character.toString((char) i);
    g.drawString(displayedString, (x + halfLine) - 200, y);

    displayedString = Character.toString((char)(i + 32));
    g.drawString(displayedString, (x + halfLine - (2 * secondSecondColumn)) + 200, y);

    displayedString = Integer.toString(ascii[i]);
    secondColumn = fullLine - g.getFontMetrics().stringWidth(displayedString);
    g.drawString(displayedString, (x + halfLine + secondColumn) - 200, y);

    displayedString = Integer.toString(ascii[(i + 32)]);
    secondColumn = g.getFontMetrics().stringWidth(displayedString);
    g.drawString(displayedString, (x + halfLine - secondColumn) + 200, y);

    y = y + 15;
   }

  } else if ("Frequency of Digits".equals(command)) {
   g.setColor(Color.red);
   displayedString = "Frequency of Digits";

   x -= (g.getFontMetrics().stringWidth(displayedString) / 2);
   y -= ((g.getFontMetrics().getHeight()) / 2) + 175;
   int fullLine = g.getFontMetrics().stringWidth(displayedString);
   int secondColumn;
   g.drawString(displayedString, x, y);

   g.setColor(Color.black);
   y = y + 25;

   g.drawLine(x, y, x + fullLine, y);
   y = y + 25;
   displayedString = "Digit";
   g.drawString(displayedString, x, y);
   displayedString = "Frequency";
   secondColumn = fullLine - g.getFontMetrics().stringWidth(displayedString);
   g.drawString(displayedString, x + secondColumn, y);
   y = y + 25;
   g.drawLine(x, y, x + fullLine, y);
   y = y + 25;

   int[] ascii = textFile.getTokens();

   for (int i = 48; i < 58; i++) {
    displayedString = Integer.toString(i - 48);
    g.drawString(displayedString, x, y);
    displayedString = Integer.toString(ascii[i]);
    secondColumn = fullLine - g.getFontMetrics().stringWidth(displayedString);
    g.drawString(displayedString, x + secondColumn, y);
    y = y + 25;
   }
  } else if ("Frequency of Words (Length 1-20)".equals(command)) {
   g.setColor(Color.red);
   displayedString = "Frequency of Words (Length 1-20)";

   x -= (g.getFontMetrics().stringWidth(displayedString) / 2);
   y -= ((g.getFontMetrics().getHeight()) / 2) + 180;
   int fullLine = g.getFontMetrics().stringWidth(displayedString);
   int secondColumn;
   g.drawString(displayedString, x, y);

   g.setColor(Color.black);
   y = y + 15;

   g.drawLine(x, y, x + fullLine, y);
   y = y + 15;
   displayedString = "Length of Word";
   g.drawString(displayedString, x, y);
   displayedString = "Number of Words";
   secondColumn = fullLine - g.getFontMetrics().stringWidth(displayedString);
   g.drawString(displayedString, x + secondColumn, y);
   y = y + 15;
   g.drawLine(x, y, x + fullLine, y);
   y = y + 15;

   int[] wordLength = textFile.getWordLength();

   for (int i = 1; i < 21; i++) {
    displayedString = Integer.toString(i);
    g.drawString(displayedString, x, y);
    displayedString = Integer.toString(wordLength[i]);
    secondColumn = fullLine - g.getFontMetrics().stringWidth(displayedString);
    g.drawString(displayedString, x + secondColumn, y);
    y = y + 15;
   }
  }
 }
}