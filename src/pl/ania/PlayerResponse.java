package pl.ania;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PlayerResponse {

    Scanner scanner = new Scanner(System.in);
    String playerOne;
    String playerTwo;
    Board gameOne = new Board();
    Map map = new Map();

    boolean isFinished;

    public void players() {
        System.out.println("Podaj imie pierwszego gracza");
        playerOne = scanner.nextLine();
        System.out.println("Podaj imie drugiego gracza");
        playerTwo = scanner.nextLine();
        System.out.println("Zapraszamy do gry!");
    }

    public void game() {
        int i = 0;

        do {
            String player;
            char mark;
            if (i % 2 != 0) {
                player = playerTwo;
                mark = 'X';
            } else {
                player = playerOne;
                mark = 'O';
            }
            startGame(player + ": Proszę podać pole. Twój znak to " + mark + ".", mark, player);
            if (i == 8 && !isFinished) {
                System.out.println("Remis");
                break;
            }
            i++;

        } while (i < 9 && !isFinished);

    }

    public void startGame(String message, char mark, String player) {
        boolean isCorrect;
        Pattern pattern = Pattern.compile("[a-cA-C][1-3]");
        System.out.println(message);
        do {
            String playerChoice = scanner.nextLine();
            isCorrect = false;

            if (pattern.matcher(playerChoice).matches()) {

                isCorrect = completeBoard(mark, playerChoice);

                if (gameOne.tab[0][0] == mark && gameOne.tab[0][1] == mark && gameOne.tab[0][2] == mark ||
                    gameOne.tab[1][0] == mark && gameOne.tab[1][1] == mark && gameOne.tab[1][2] == mark ||
                    gameOne.tab[2][0] == mark && gameOne.tab[2][1] == mark && gameOne.tab[2][2] == mark ||
                    gameOne.tab[0][0] == mark && gameOne.tab[1][0] == mark && gameOne.tab[2][0] == mark ||
                    gameOne.tab[0][1] == mark && gameOne.tab[1][1] == mark && gameOne.tab[1][2] == mark ||
                    gameOne.tab[0][2] == mark && gameOne.tab[1][2] == mark && gameOne.tab[2][2] == mark ||
                    gameOne.tab[0][0] == mark && gameOne.tab[1][1] == mark && gameOne.tab[2][2] == mark ||
                    gameOne.tab[0][2] == mark && gameOne.tab[1][1] == mark && gameOne.tab[2][0] == mark

                    ) {
                    System.out.println("Koniec gry. Wygrał gracz " + player);
                    isFinished = true;

                }

            } else {
                System.out.println("Nie ma takiego pola! Wybierz jeszcze raz");

            }
        } while (!isCorrect);
    }

    public boolean completeBoard(char mark, String playerChoice) {

        if (!setMark(playerChoice, mark)) {

            System.out.println("To pole jest już zajęte! Spróbuj jeszcze raz.");
            return false;
        }

        gameOne.board();
        return true;
    }

    private boolean setMark(String playerChoice, char mark) {
        Coordinates coordinates = map.map.get(playerChoice.toUpperCase());
        if (gameOne.tab[coordinates.x][coordinates.y] == '\u0000') {
            gameOne.tab[coordinates.x][coordinates.y] = mark;
            return true;
        }
        return false;

    }
}
