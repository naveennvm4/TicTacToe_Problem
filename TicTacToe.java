package package1;
import java.util.Scanner;

public class TicTacToe {
	public static void board() {
		char[] board = new char[10];
		for (int i=0; i<10; i++) {
			board[i]=' ';
			System.out.println(board[i]);
		}
	}
	public static void entry() {
		Scanner user = new Scanner(System.in);
		System.out.println("Enter a choice x or o");
		char player = user.next().charAt(0);
		char computer = ' ';
		if(player == 'x' || player == 'X') {
			computer = 'o';
		}
		else if (player == 'O' || player == 'o') {
			computer = 'x';
		}
		else {
			System.out.println("Invalid");
		}
		System.out.println("Player is " + player + " and Computer is " + computer);
	}
	public static void main(String args[]) {
		System.out.println("Welcome to TicTacToeGame");
		board();
		entry();
 	}
}
