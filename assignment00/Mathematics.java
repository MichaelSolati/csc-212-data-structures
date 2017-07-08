package assignment00;
import javax.swing.JOptionPane;


public class Mathematics {

 private int first, second;
 private int sum, difference, product;

 public Mathematics() {
  first = second = 0;
  sum = difference = product = 0;
 }
 public void getNumbers() {
  // get the first number
  String input = JOptionPane.showInputDialog(null, "Please enter an integer:",
   "Enter the First Number", JOptionPane.QUESTION_MESSAGE);
  first = Integer.parseInt(input);

  // get the first number
  input = JOptionPane.showInputDialog(null, "Please enter an integer:",
   "Enter the Second Number", JOptionPane.QUESTION_MESSAGE);
  second = Integer.parseInt(input);
  // call the methods to calculate the sum, difference and product
  setSum();
  setDifference();
  setProduct();
 }

 public int getFirst() {
  return first;
 }
 public int getSecond() {
  return second;
 }
 public void setSum() {
  sum = first + second;
 }
 public void setDifference() {
  // complete the operation
  difference = first - second;
 }
 public void setProduct() {
  // complete the operation
  product = first * second;
 }
 public int getSum() {
  return sum;
 }
 public int getDifference() {
  return difference;
 }
 public int getProduct() {
  return product;
 }
}