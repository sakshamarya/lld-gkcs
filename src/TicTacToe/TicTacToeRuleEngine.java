package TicTacToe;

import TicTacToe.Model.TicTacToeBoard;

import java.util.Objects;

public class TicTacToeRuleEngine{
    boolean rowComplete(TicTacToeBoard board){
        for(String[] arr: board.getBoard()){

            if(Objects.nonNull(arr[0])){
                boolean complete = true;
                for(int index=1; index<arr.length; index++){
                    if(!Objects.equals(arr[index], arr[index - 1])){
                        complete=false;
                        break;
                    }
                }

                if(complete){
                    return true;
                }
            }
        }

        return false;
    }

    boolean columnComplete(TicTacToeBoard board){


        for(int col=0; col<board.getBoard()[0].length; col++){

            if(Objects.nonNull(board.getBoard()[0][col])){
                boolean complete = true;
                for(int row=1; row<board.getBoard().length; row++){
                    if(!Objects.equals(board.getBoard()[row][col], board.getBoard()[row-1][col])){
                        complete = false;
                        break;
                    }
                }

                if(complete){
                    return true;
                }
            }

        }

        return false;
    }

    boolean diagonalComplete(TicTacToeBoard board){

        if(Objects.nonNull(board.getBoard()[0][0])){
            boolean complete = true;
            for(int index = 1; index < board.getBoard().length; index++){
                if(!Objects.equals(board.getBoard()[index][index], board.getBoard()[index-1][index-1])){
                    complete=false;
                    break;
                }
            }
            if(complete){
                return true;
            }
        }

        if(Objects.nonNull(board.getBoard()[0][2])){
            boolean complete = true;
            for(int index = 1; index < board.getBoard().length; index++){
                if(!Objects.equals(board.getBoard()[2-index][index], board.getBoard()[index-1][3-index])){
                    complete=false;
                    break;
                }
            }
            if(complete){
                return true;
            }
        }

        return false;
    }

    boolean boardComplete(TicTacToeBoard board){
        int count=0;

        for(String[] row: board.getBoard()){
            for(String cell: row){
                if(cell != null){
                    count++;
                }
            }
        }

        return count == (board.getBoard().length*board.getBoard().length);
    }

    public String gameStatus(TicTacToeBoard board){

        if(rowComplete(board) || columnComplete(board) || diagonalComplete(board)) {
            return "complete";
        }

        else if(boardComplete(board)){
            return "draw";
        }

        return "notComplete";
    }
}
