package assignment01;

import javax.swing.JOptionPane;


public class Octagon {

 private int x, y, side, perimeter;
 private double area;

 public Octagon() {
  x = y = perimeter = 0;
  area = 0;
 }
 public void getProperties() {
  String input;
  int inputCheck = 0;
  while (inputCheck == 0) {
   try {
    input = JOptionPane.showInputDialog(null, "Enter X coorinate of the topleft corner of the octagon: ",
     "Please enter an integer, we'll know if you don't!", JOptionPane.QUESTION_MESSAGE);
    x = Integer.parseInt(input);
    inputCheck++;
   } catch (Exception e) {
    //User did a no no....
    JOptionPane.showMessageDialog(null, "I'm sorry Dave, I'm afraid you can't do that.");
   }
  }
  while (inputCheck == 1) {
   try {
    input = JOptionPane.showInputDialog(null, "Enter Y coorinate of the topleft corner of the octagon: ",
     "Please enter an integer, we'll know if you don't!", JOptionPane.QUESTION_MESSAGE);
    y = Integer.parseInt(input);
    inputCheck++;
   } catch (Exception e) {
    //User did a no no....
    JOptionPane.showMessageDialog(null, "I'm sorry Dave, I'm afraid you can't do that.");
   }
  }
  while (inputCheck == 2) {
   try {
    input = JOptionPane.showInputDialog(null, "Enter the length of a side of the octagon: ",
     "Please enter an integer, we'll know if you don't!", JOptionPane.QUESTION_MESSAGE);
    side = Integer.parseInt(input);
    inputCheck++;
   } catch (Exception e) {
    //User did a no no....
    JOptionPane.showMessageDialog(null, "I'm sorry Dave, I'm afraid you can't do that.");
   }

  }
 }

 public int getX() {
  return x;
 }
 public int getY() {
  return y;
 }
 public int getSide() {
  return side;
 }

 public int getPerimeter() {
  // calculate perimeter
  perimeter = side * 8;
  return perimeter;
 }
 public double getArea() {
  // calculate area
  area = 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
  area = Math.round(area * 100) / 100;
  return area;
 }
}