package My.Game.TTT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TTT game = new TTT();
        game.initializeBoard();
        System.out.println("Tic-Tac-Toe!");
        do {
            System.out.println("Tableau actuel:");
            game.printBoard();
            int row;
            int col;
            do {
                System.out.println("Joueur " + game.getCurrentPlayerMark() + ", placez votre signe dans une ligne et une colonne vide");
                row = scan.nextInt() - 1;
                col = scan.nextInt() - 1;
            }
            while (!game.placeMark(row, col));
            game.changePlayer();
        }
        while (!game.checkForWin() && !game.isBoardFull());
        if (game.isBoardFull() && !game.checkForWin()) {
            System.out.println("Égalité!");
        } else {
            System.out.println("Tableau actuel:");
            game.printBoard();
            game.changePlayer();
            System.out.println(Character.toUpperCase(game.getCurrentPlayerMark()) + " Gagner!");
        }
    }
}
