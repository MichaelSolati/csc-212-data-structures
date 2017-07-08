package assignment03;

public class ColorIsAwesome {
  String[][] theGrid = new String[100][100];
  String[][] theColors = new String[100][100];
  int whatItIs = 0;

  public ColorIsAwesome() {
  }

  public void popGenerator() {
    for (int a = 0; a < 100; a++) {
      for (int b = 0; b < 100; b++) {
        whatItIs = (int) (Math.random() + 0.3);
        if (whatItIs == 1) {
          theGrid[a][b] = "*";
        } else {
          theGrid[a][b] = " ";
        }
      }
    }
  }

  public void colorCalculator() {

    for (int a = 0; a < 100; a++) {
      for (int b = 0; b < 100; b++) {
        int surroundings = 0;

        try {
          if (theGrid[a - 1][b - 1] == "*") {
            surroundings++;
          }
        } catch (Exception e) {
        }

        try {
          if (theGrid[a][b - 1] == "*") {
            surroundings++;
          }
        } catch (Exception e) {
        }

        try {
          if (theGrid[a + 1][b - 1] == "*") {
            surroundings++;
          }
        } catch (Exception e) {
        }

        try {
          if (theGrid[a - 1][b] == "*") {
            surroundings++;
          }
        } catch (Exception e) {
        }

        try {
          if (theGrid[a + 1][b] == "*") {
            surroundings++;
          }
        } catch (Exception e) {
        }

        try {
          if (theGrid[a - 1][b + 1] == "*") {
            surroundings++;
          }
        } catch (Exception e) {
        }

        try {
          if (theGrid[a][b + 1] == "*") {
            surroundings++;
          }
        } catch (Exception e) {
        }

        try {
          if (theGrid[a + 1][b + 1] == "*") {
            surroundings++;
          }
        } catch (Exception e) {
        }

        if (surroundings <= 1) {
          theColors[a][b] = "white";
        } else if (surroundings <= 3) {
          theColors[a][b] = "green";
        } else if (surroundings <= 5) {
          theColors[a][b] = "blue";
        } else if (surroundings <= 7) {
          theColors[a][b] = "red";
        } else {
          theColors[a][b] = "black";
        }
      }
    }
  }
}