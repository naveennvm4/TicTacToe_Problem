package package1;

import java.util.Scanner;

public class TicTacToe {
	public char[] board() {
		char[] board = new char[10];
		for(int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public char entry() {
		char player, computer;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter X or O to enter a value into cells");
		char selection = input.next().charAt(0);
		if (selection == 'x') {
			player = 'x';
			computer = 'o';
		}
		else {
			player = 'o';
			computer = 'x';
		}
		return player;
	}

	public void showBoard(char[] board) {
		System.out.println(board[1] + "  | " + board[2] + " | " + board[3]);
		System.out.println("--------------");
		System.out.println(board[4] + "  | " + board[5] + " | " + board[6]);
		System.out.println("--------------");
		System.out.println(board[7] + "  | " + board[8] + " | " + board[9]);
	}

	public void userInput(char[] board, char player) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number between 1 to 9");
		int user_input = input.nextInt();
		if (user_input < 10 && user_input > 0) {
			if (board[user_input] == ' ') {
				board[user_input] = player;
			}
			else
				System.out.println("Place is already taken");
		}
		else
			System.out.println("Invalid Input");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe game");
		TicTacToe game = new TicTacToe();
		char[] board = game.board();
		char player = game.entry();
		game.showBoard(board);
		game.userInput(board, player);
	}
}
