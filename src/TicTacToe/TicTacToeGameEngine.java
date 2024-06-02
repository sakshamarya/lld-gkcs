package TicTacToe;

import TicTacToe.Model.TicTacToeBoard;
import TicTacToe.Model.TicTacToePlayer;

import java.util.Objects;

public class TicTacToeGameEngine {

    TicTacToePlayer human;
    TicTacToePlayer computer;

    TicTacToeBoard board;

    TicTacToeRuleEngine ruleEngine = new TicTacToeRuleEngine();
    public void start(String game){
        if(Objects.equals(game, "TicTacToe")){
            human = new TicTacToePlayer("human", "O");
            computer = new TicTacToePlayer("Computer", "X");
            board = new TicTacToeBoard();

            playGame(board, human, computer);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    String changeSymbol(String symbol){
        if(Objects.equals(symbol, "O")){
            return "X";
        }
        return "O";
    }

    public void playGame(TicTacToeBoard board, TicTacToePlayer player1, TicTacToePlayer player2){
        String turnSymbol = "O";

        while(Objects.equals(ruleEngine.gameStatus(board), "notComplete")){
            if(Objects.equals(player1.getSymbol(), turnSymbol)){
                player1.move(board);
            }
            else{
                player2.move(board);
            }
            turnSymbol = changeSymbol(turnSymbol);
            board.print();
        }

        if(Objects.equals(turnSymbol, player1.getSymbol())){
            System.out.println(player2.getType()+ " wins");
        }
        else{
            System.out.println(player1.getType()+ " wins");
        }
    }
}
