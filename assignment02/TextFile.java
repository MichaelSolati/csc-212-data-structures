package assignment02;

import java.io.FileReader; // both needed
import java.io.BufferedReader; // for line input
import java.io.IOException;
import javax.swing.JFileChooser;

public class TextFile {
  // File Parameters
  String dataFilePath = "";
  String dataFileName = "";
  String entireFile = "";
  int[] count = new int[256];
  int[] wordLength = new int[21];

  public TextFile() {
    dataFilePath = null;
    dataFileName = null;
    for (int i = 0; i < count.length; i++) {
      count[i] = 0;
    }
    for (int i = 0; i < wordLength.length; i++) {
      wordLength[i] = 0;
    }
  }

  public void openFile() {
    dataFilePath = null;
    dataFileName = null;

    JFileChooser chooser = new JFileChooser();
    chooser.setDialogType(JFileChooser.OPEN_DIALOG);
    chooser.setDialogTitle("Open Data File");

    int returnVal = chooser.showOpenDialog(null);

    if (returnVal == JFileChooser.APPROVE_OPTION) {
      dataFilePath = chooser.getSelectedFile().getPath();
      dataFileName = chooser.getSelectedFile().getName();
    }
  }

  public String getFileName() {
    return dataFileName;
  }

  public int[] getTokens() {
    return count;
  }

  public int[] getWordLength() {
    return wordLength;
  }

  public String processFile() {
    try {
      // initialize counting array
      for (int k = 0; k < 256; k++) {
        count[k] = 0;
      }

      // Instantiate streams
      BufferedReader inputStream = new BufferedReader(new FileReader(dataFilePath));

      // read the file line by line and count the characters read
      int integerValue;

      while ((integerValue = inputStream.read()) != -1) {
        count[integerValue] += 1;
        entireFile += (char) integerValue;
      }

      tokenizeFile();
      inputStream.close();

    } catch (IOException ioe) {
      System.out.println("oops");
      System.exit(0);
    }
    return ("File Sucessfully Processed");
  }

  public void tokenizeFile() {
    // Bonus
    for (int k = 0; k < wordLength.length; k++) {
      wordLength[k] = 0;
    }
    String[] entireFileArray = entireFile.split(" ");
    for (int k = 0; k < entireFileArray.length; k++) {
      if ((entireFileArray[k].replaceAll("\\W", "")).length() <= 20) {
        wordLength[(entireFileArray[k].replaceAll("\\W", "")).length()] += 1;
      }
    }
  }
}