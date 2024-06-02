package TicTacToe.Model;

import Model.Board;

public class TicTacToeBoard extends Board {
    String[][] board = new String[3][3];

    public String[][] getBoard() {
        return board;
    }

    public Boolean isCellEmpty(int row, int col){
        return board[row][col] == null;
    }

    public void setCell(int row, int col, String symbol){
        board[row][col] = symbol;
    }

    public String getCell(int row, int col){
        return board[row][col];
    }

    public void print(){
        for(String[] arr: this.board){
            for(String cell: arr){
                System.out.print(cell + ", ");
            }
            System.out.println();
        }
    }
}
