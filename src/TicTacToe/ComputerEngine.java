package TicTacToe;

import TicTacToe.Model.TicTacToeBoard;

import java.util.Objects;

public class ComputerEngine {
    public void playMove(TicTacToeBoard board, String symbol){
        int r=-1, c= -1;

        for(int row=0; row<board.getBoard().length; row++){
            for(int col=0; col<board.getBoard()[row].length; col++){
                if(!Objects.nonNull(board.getBoard()[row][col])){
                    r=row;
                    c=col;
                    break;
                }
            }

            if(r!=-1){
                break;
            }
        }

        board.setCell(r, c, symbol);
    }
}
