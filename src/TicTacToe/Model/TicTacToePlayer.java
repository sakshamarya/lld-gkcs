package TicTacToe.Model;

import Model.Player;
import TicTacToe.ComputerEngine;

import java.util.Objects;
import java.util.Scanner;

public class TicTacToePlayer extends Player {
    public String type;
    public String symbol;

    ComputerEngine computerEngine= new ComputerEngine();

    public TicTacToePlayer(String type, String symbol){
        this.type = type;
        this.symbol = symbol;
    }

    public String getType(){
        return type;
    }

    public String getSymbol(){
        return symbol;
    }

    public void move(TicTacToeBoard board){
        if(Objects.equals(this.getType(), "human")){
            System.out.println("Select Index");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            board.setCell(row, col, this.symbol);
        }
        else{
            computerEngine.playMove(board, this.symbol);
        }
    }
}
