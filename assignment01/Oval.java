package assignment01;

import javax.swing.JOptionPane;


public class Oval {

 private int x, y, width, height;
 private double perimeter, area;

 public Oval() {
  x = y = 0;
  perimeter = area = 0;
 }
 public void getProperties() {
  String input;
  int inputCheck = 0;
  while (inputCheck == 0) {
   try {
    input = JOptionPane.showInputDialog(null, "Enter X coorinate of the topleft corner of the oval: ",
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
    input = JOptionPane.showInputDialog(null, "Enter Y coorinate of the topleft corner of the oval: ",
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
    input = JOptionPane.showInputDialog(null, "Enter the width of the oval: ",
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
    input = JOptionPane.showInputDialog(null, "Enter the height of the oval: ",
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

 public double getPerimeter() {
  // calculate perimeter
  int a = width;
  int b = height;
  int c = a - b;
  c = Math.abs(c);
  double h = c / (a + b);
  perimeter = (Math.PI / 2) * (a + b) * (1 + (h * (2 / 4)) + (h * (4 / 64)) + (h * (6 / 256)) + (25 * h * (8 / 16384)));
  perimeter = Math.round(perimeter * 100) / 100;
  return perimeter;
 }
 public double getArea() {
  // calculate area
  area = Math.PI * ((width * height) / 4);
  area = Math.round(area * 100) / 100;
  return area;
 }
}