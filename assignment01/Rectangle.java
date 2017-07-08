package assignment01;

import javax.swing.JOptionPane;


public class Rectangle {

 private int x, y, width, height;
 private int perimeter, area;

 public Rectangle() {
  x = y = 0;
  perimeter = area = 0;
 }
 public void getProperties() {
  String input;
  int inputCheck = 0;
  while (inputCheck == 0) {
   try {
    input = JOptionPane.showInputDialog(null, "Enter X coorinate of the topleft corner of the rectangle: ",
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
    input = JOptionPane.showInputDialog(null, "Enter Y coorinate of the topleft corner of the rectangle: ",
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
    input = JOptionPane.showInputDialog(null, "Enter the width of the rectangle: ",
     "Please enter an integer, we'll know if you don't!", JOptionPane.QUESTION_MESSAGE);
    width = Integer.parseInt(input);
    inputCheck++;
   } catch (Exception e) {
    //User did a no no....
    JOptionPane.showMessageDialog(null, "I'm sorry Dave, I'm afraid you can't do that.");
   }

  }
  while (inputCheck == 3) {
   try {
    input = JOptionPane.showInputDialog(null, "Enter the height of the rectangle: ",
     "Please enter an integer, we'll know if you don't!", JOptionPane.QUESTION_MESSAGE);
    height = Integer.parseInt(input);
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
 public int getWidth() {
  return width;
 }
 public int getHeight() {
  return height;
 }

 public int getPerimeter() {
  // calculate perimeter
  perimeter = (2 * width) + (2 * height);
  return perimeter;
 }
 public int getArea() {
  // calculate area
  area = width * height;
  return area;
 }
}