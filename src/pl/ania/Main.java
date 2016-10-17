package pl.ania;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        PlayerResponse gameOne = new PlayerResponse();

        gameOne.players();
        board.board();

        gameOne.game();

    }
}
