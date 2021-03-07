package package1;
import java.util.Scanner;

public class TicTacToe {
	public char[] gameBoard() {
		char[] board = new char[10];
		for(int index = 1; index < board.length; index++) {
			board[index] = ' ';
		}
		return board;
	}

	public char entry() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter x or O to choose a input");
		char selection = input.next().charAt(0);
		return selection;
	}

	public void showBoard(char[] board) {
		System.out.println(board[7] + "  | " + board[8] + " | " + board[9]);
		System.out.println("--------------");
		System.out.println(board[4] + "  | " + board[5] + " | " + board[6]);
		System.out.println("--------------");
		System.out.println(board[1] + "  | " + board[2] + " | " + board[3]);
	}

	public char[] userInput(char[] board, char player) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number from 1 to 9");
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
		return board;
	}

	public int firstChance() {
		double toss = Math.floor(Math.random() * 10 ) % 2;
		if ((int)toss == 0) {
			System.out.println("Player won the toss");
			return 1;
		} else {
			System.out.println("Computer won the toss");
			return 0;
		}
	}

	public char[] computerPlay(char[] board, char computer) {
		boolean check = true;
		while (check == true) {
			int place = (int)Math.floor(Math.random() * 10) % 9 + 1;
			if (board[place] == ' ') 
			{
				board[place] = computer;
				check = false;
			}
		}
		return board;
	}

	public int winTie(char[] board) {
		int result = 0;
		if ((board[1] == board[2] && board[3] == board[1] && board[3] != ' ')|| 
			(board[4] == board[5] && board[4] == board[6] && board[4] != ' ') ||
			(board[7] == board[8] && board[8] == board[9] && board[8] != ' ') || 
			(board[1] == board[4] && board[1] == board[7] && board[1] != ' ') || 
			(board[2] == board[5] && board[8] == board[5] && board[8] != ' ') || 
			(board[3] == board[6] && board[9] == board[6] && board[6] != ' ') || 
			(board[1] == board[5] && board[9] == board[5] && board[9] != ' ') || 
			(board[3] == board[5] && board[5] == board[7] && board[5] != ' '))
			result = 1;
		else {
			int empty = 0; 
			for (int index = 1; index < board.length; index++) {
				if (board[index] == ' ') {
					empty = 1; 
				}
			}
			if (empty == 0) {
				result = 0;
			}
			else
				result = 2;
		}
		return result;
	}

	public void gamePlay(char player, char computer, char[] board, int chance, TicTacToe game) {
		int result;
		boolean check = true;
		while(check == true) {
			switch(chance) {
				case 1:
					board = game.userInput(board, player);
					switch(game.winTie(board)) {
						case 0:
							System.out.println("The game Tied");
							check = false;
							break;
						case 1: 
							System.out.println("Player won");
							check = false;
							break;
						default:
							System.out.println("Computer has to play");
							game.showBoard(board);
							chance = 0;// changes the turn to computer
					}
					break;
				case 0:
					board = game.computerPlay(board, computer);
					switch(game.winTie(board)) {
					case 0:
							System.out.println("The game Tied");
							check = false;
							break;
					case 1:
							System.out.println("Computer won");
							check = false;
							break;
					default:
							System.out.println("Player has to play");
							game.showBoard(board);
							chance = 1;// changes the turn to player
					}
					break;
			}
		}
	}

	public static void main(String[] args) {
		char value = 'x',computer;
		System.out.println("Welcome to tictactoe game");
		TicTacToe game = new TicTacToe();
		char[] board = game.gameBoard();
		char player = game.entry();
		int compare = Character.compare(player, value);
		if (compare == 0) {
			player = 'x';
			computer = 'o';
		} else {
			player = 'o';
			computer = 'x';
		}
		game.showBoard(board);
		int chance = game.firstChance();
		game.gamePlay(player, computer, board, chance, game);
		game.showBoard(board);
	}
}
