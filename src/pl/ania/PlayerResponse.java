package pl.ania;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PlayerResponse {

    Scanner scanner = new Scanner(System.in);
    String playerOne;
    String playerTwo;
    Board gameOne = new Board();

    public void players() {
        System.out.println("Podaj imie pierwszego gracza");
        playerOne = scanner.nextLine();
        System.out.println("Podaj imie drugiego gracza");
        playerTwo = scanner.nextLine();
        System.out.println("Zapraszamy do gry!");
    }

    public void game() {
        for (int i = 0; i < 5; i++) {
            startGame(playerOne + ": Proszę podać pole. Twój znak to kółko", 'O');
            if (i == 4) {
                break;
            }
            startGame(playerTwo + ": Proszę podać pole. Twój znak to krzyżyk", 'X');
        }
    }

    public void startGame(String message, char mark) {
        boolean isCorrect;

        Pattern pattern = Pattern.compile("[a-cA-C][1-3]");
        System.out.println(message);
        do {
            String playerChoice = scanner.nextLine();
            isCorrect = false;

            if (pattern.matcher(playerChoice).matches()) {
                completeBoard(mark, playerChoice);
                isCorrect = true;
            } else {
                System.out.println("Nie ma takiego pola! Wybierz jeszcze raz");

            }
        } while (isCorrect == false);
    }

    public void completeBoard(char mark, String playerChoice) {

        if (playerChoice.equalsIgnoreCase("A1") && (gameOne.tab[0][0] == '\u0000')) {
            gameOne.tab[0][0] = mark;
        } else if (playerChoice.equalsIgnoreCase("B1") && (gameOne.tab[0][1] == '\u0000')) {
            gameOne.tab[0][1] = mark;
        } else if (playerChoice.equalsIgnoreCase("C1") && (gameOne.tab[0][2] == '\u0000')) {
            gameOne.tab[0][2] = mark;
        } else if (playerChoice.equalsIgnoreCase("A2") && (gameOne.tab[1][0] == '\u0000')) {
            gameOne.tab[1][0] = mark;
        } else if (playerChoice.equalsIgnoreCase("B2") && (gameOne.tab[1][1] == '\u0000')) {
            gameOne.tab[1][1] = mark;
        } else if (playerChoice.equalsIgnoreCase("C2") && (gameOne.tab[1][2] == '\u0000')) {
            gameOne.tab[1][2] = mark;
        } else if (playerChoice.equalsIgnoreCase("A3") && (gameOne.tab[2][0] == '\u0000')) {
            gameOne.tab[2][0] = mark;
        } else if (playerChoice.equalsIgnoreCase("B3") && (gameOne.tab[2][1] == '\u0000')) {
            gameOne.tab[2][1] = mark;
        } else if (playerChoice.equalsIgnoreCase("C3") && (gameOne.tab[2][2] == '\u0000')) {
            gameOne.tab[2][2] = mark;
        }

        gameOne.board();
    }
}
