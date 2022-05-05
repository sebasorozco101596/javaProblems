package medium;

import java.util.ArrayList;

// 36. Valid Sudoku
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        boolean isRowsValid = checkRows(board);
        boolean isColumnsValid = checkColumns(board);
        boolean isBoxesValid = checkBoxes(board, 0,0,0);

        return isColumnsValid && isBoxesValid && isRowsValid;
    }

    private boolean checkRows(char[][] board) {
        ArrayList<Character> rows = new ArrayList<>();
        // Looking the rows
        for (char[] chars : board) {
            rows.clear();
            for (char aChar : chars) {
                //System.out.println("rows: " + aChar);
                if (!rows.contains(aChar)) {
                    if (aChar != '.') rows.add(aChar);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkColumns(char[][] board) {
        ArrayList<Character> columns = new ArrayList<>();
        // Looking the columns
        for (int i = 0; i < board.length; i++) {
            columns.clear();
            for (int j = 0; j < board[i].length; j++) {
                System.out.println("columns: " + board[j][i]);
                if (!columns.contains(board[j][i])) {
                    if (board[j][i] != '.') columns.add(board[j][i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBoxes(char[][] board, int row, int column,int box) {

        ArrayList<Character> boxes = new ArrayList<>();
        System.out.println("HERE: " + box);

        if (box == 9) {
            System.out.println("HERE");
            return true;
        }

        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                System.out.println("columns: " + board[j][i]);
                if (!boxes.contains(board[j][i])) {
                    if (board[j][i] != '.') boxes.add(board[j][i]);
                } else {
                    return false;
                }
            }
        }

        boxes.clear();

        // Adding two to the rows and when the rows finish restarting and adding to columns up to finish
        row = row + 3;
        box = box + 1;

        if (row > 8) {
            column = column + 3;
            row = 0;
        }

        return checkBoxes(board,row,column,box);
    }


    public boolean isValidSudokuOptimal(char[][] board) {
        int N = 9;

        int[] lines = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {

                if(board[i][j] == '.') {
                    continue;
                }
                int curr = board[i][j] - '0';
                int pos = 1 << curr;

                if((lines[i] & pos) > 0 ) return false;
                lines[i] |= pos;

                if((cols[j] & pos) > 0 ) return false;
                cols[j] |= pos;


                int box = (i / 3) * 3 + j / 3;
                // System.out.println("["+i+","+j+"] "+curr+" in box "+box+" > "+ pos ) ;
                if((boxes[box] & pos) > 0 ) return false;
                boxes[box] |= pos;

            }
        }
        return true;
    }
}
