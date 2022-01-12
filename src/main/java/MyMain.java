public class MyMain {
    // Returns the String that shows up latest alphabetically
    // in a normal 1D String array
    // You can assume that the array will not be empty
    // and that all Strings are lowercase
    // Hint: recall how the compareTo() method works:
    //      int x = "apple".compareTo("banana"); // x is negative
    //      int y = "banana".compareTo("apple"); // y is positive
    public static String findLastWord(String[] arr) {
//        // YOUR CODE HERE
//        return "";
        String last = arr[0];
        for (String x: arr) {
            if (x.compareTo(last) > 0) {
                last = x;
            }
        }
        return last;
    }

    // Given a 2D array, return an 1D array of the last word
    // in each row in the array
    // You can assume that the matrix will not be empty
    // Hint: use the previous method to help yourself!
    public static String[] findLastWord2D(String[][] mat) {
//        // YOUR CODE HERE
//        return "";

        String[] lastWords = new String[mat.length];

        for (int row = 0; row < mat.length; row++) {
            String[] arr = mat[row];
            String rowLast = findLastWord(arr);
            lastWords[row] = rowLast;
        }

        return lastWords;
    }

    // Given a 2D array and some column index col
    // finds the number of Strings in the specified column
    // of the 2D array that contain the word "apple"
    // For example, if col = 0, you should only look through
    // the values in column 0 of the array; likewise, if
    // col = 2, you should only look through the values in column 2

    // Hint: remember how the indexOf() method works?
    // alternatively, consider the contains() method
    public static int appleCounter(String[][] mat, int col) {
//        // YOUR CODE HERE
//        return -1;
        int count = 0;

        for (int row = 0; row < mat.length; row++) {
            String x = mat[row][col];
            if (x.indexOf("apple") > -1) {
                count++;
            }
        }

        return count;
    }

    // Given a 2D array, return the column number corresponding
    // to the column that contains the most Strings containing
    // the word "apple"

    // Hint: use your previous method!
    // Hint 2: you might need to loop through the columns!
    public static int findMostAppleColumn(String[][] mat) {
//        // YOUR CODE HERE
//        return -1;
        int most = appleCounter(mat, 0);
        int mostIdx = 0;

        for (int col = 1; col < mat[0].length; col++) {
            int count = appleCounter(mat, col);
            if (count > most) {
                most = count;
                mostIdx = col;
            }
        }

        return mostIdx;
    }


    // Creates Pascal's Triangle, with a height of n
    // The first row of numbers has a single number, 1
    // Each subsequent row has one more number than the previous row
    // The first and last numbers of every row are 1
    // All other numbers’ values are calculated by adding together the two numbers above that number

    // Here are some examples:
    // pascalTriangle(2) =>
    // 1  0
    // 1  1

    // pascalTriangle(6) =>
    // 1  0  0  0  0  0
    // 1  1  0  0  0  0
    // 1  2  1  0  0  0
    // 1  3  3  1  0  0
    // 1  4  6  4  1  0
    // 1  5  10 10 5  1

    // Hint: fill in the first column and first diagonal with 1's
    //       and then go through and calculate the rest of the values
    //       from top to bottom

    public static int[][] pascal(int height) {
//        // YOUR CODE HERE
//        return null;
        int[][] mat = new int[height][height];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < row+1; col++) {
                // If col is the beginning or col is along the diagonal
                if (col == 0 || col == row) {
                    mat[row][col] = 1;
                }
                else {
                    mat[row][col] = mat[row-1][col] + mat[row-1][col-1];
                }
            }
        }
        return mat;
    }










    // Methods for the homework:

    // Checks if a 2D array is a magic square or not
    // You can assume that the 2D array mat will be square
    // A 2D array is a magic square if:
    // There is some set value x such that:
    // * all rows sum to x
    // * all columns sum to x
    // * both diagonals sum to x

    // Hint 1: you might first want to add up the values in the
    // first row/col and save that value to compare with later.
    // Then, you should check each rows, check each column, and
    // check each diagonal

    // Hint 2: you problably want to break this down into many parts.
    // You should have two loops to check the row sums. Then two more
    // loops to chekc the column sums. Finally, it might help to have
    // one for loop for each diagonal

    // Hint 3: when thinking the diagonals, consider the following
    // * do you see any pattern for the row and col indexes for a diagonal?
    // * can you use a for loop that goes through that pattern?
    public static boolean isMagic(int[][] mat) {
        // YOUR CODE HERE
        int sum = 0;

        for (int row = 0; row < mat.length; row++) {
            sum += mat[row][0];
        }

        // Go through rows
        for (int row = 0; row < mat.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < mat[0].length; col++) {
                rowSum += mat[row][col];
            }
            if (rowSum != sum) {
                return false;
            }
        }

        // Go through columns
        for (int col = 0; col < mat[0].length; col++) {
            int colSum = 0;
            for (int row = 0; row < mat.length; row++) {
                colSum += mat[row][col];
            }
            if (colSum != sum) {
                return false;
            }
        }

        // Go through diagonal 1
        int diagSum1 = 0;

        for (int i = 0; i < mat.length; i++) {
            diagSum1 += mat[i][i];
        }

        if (diagSum1 != sum) {
            return false;
        }

        // Go through diagonal 2
        int diagSum2 = 0;

        for (int i = 0; i < mat.length; i++) {
            diagSum2 += mat[i][mat.length-1-i];
        }

        if (diagSum2 != sum) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
    }
}
