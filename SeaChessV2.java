package seaChess;

import java.util.Scanner;

public class SeaChessV2 {
	
	
	static void printRules() {
		System.out.println("Welcome to Java Sea Chess v1.0 !");
		System.out.println("\t>> RULES <<");
		System.out.println("-> Player 1 starts with \"X\".");
		System.out.println("-> Player 2 starts with \"O\".");
		System.out.println("-> On each turn type coordinates, where you want to place your sign.");
		System.out.println("-> For example, type 1 and then 2 - this places your sign on 1st row, 2nd column.");
		System.out.println("=================================================================================");
	}
		
		
	static void printUpdatedBoard(char array[][]) {
		// prints updated chess board
		for (int i = 0; i < 7; i++) {
			if (i % 2 == 0) {
				System.out.println(" +---+---+---+");
			} else {
				for (int j = 0; j < 7; j++) {
					if (j % 2 == 0) {
						System.out.print(" | ");
					} else {
						if (i == 1 && j == 1) System.out.print(array[0][0]);
						else if (i == 1 && j == 3) System.out.print(array[0][1]);
						else if (i == 1 && j == 5) System.out.print(array[0][2]);
						else if (i == 3 && j == 1) System.out.print(array[1][0]);
						else if (i == 3 && j == 3) System.out.print(array[1][1]);
						else if (i == 3 && j == 5) System.out.print(array[1][2]);
						else if (i == 5 && j == 1) System.out.print(array[2][0]);
						else if (i == 5 && j == 3) System.out.print(array[2][1]);
						else if (i == 5 && j == 5) System.out.print(array[2][2]);
					}
				}
				System.out.println();
			}
		}
	}
	
	
	
	static void printEmptyBoard() {
		// prints empty board
		for (int i = 0; i < 7; i++) {
			if (i % 2 == 0) {
				System.out.println(" +---+---+---+");
			} else {
				for (int j = 0; j < 7; j++) {
					if (j % 2 == 0) {
						System.out.print(" | ");
					} else {
						System.out.print(' ');
					}
				}
				System.out.println();
			}
		}
	}
	



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		printRules();

		do {

			char[][] seaChess = new char[3][3];

			// prints empty board
			printEmptyBoard();
			

			outerloop: 
			for (int turn = 1; turn <= 9; turn++) { // we have maximum 9 turns
				if (turn % 2 != 0) {  // all odd turns are for player 1
					System.out.println("Player 1's turn. Select coordinates: ");
					int row, col;
					while (true) {
						// player 1 enters row number
						do {
							System.out.println("Enter number of row: ");
							row = sc.nextInt();
							if (row < 1 || row > 3) 
								System.out.print("Invalid input. ");
							else break;
						} while (true);
						// player 1 enters column number
						do {
							System.out.println("Enter number of column: ");
							col = sc.nextInt();
							if (col < 1 || col > 3)
								System.out.print("Invalid input. ");
							else break;
						} while (true);
						if (seaChess[row - 1][col - 1] == 'X' || seaChess[row - 1][col - 1] == 'O') {
							System.out.println("This field is not empty! Choose another one.");
						} else break;
					}

					seaChess[row - 1][col - 1] = 'X';
					
				} else { // all even turns are for player 2
					System.out.println("Player 2's turn. Select coordinates:");
					int row, col;

					while (true) {
						// player 2 enters row number
						do {
							System.out.println("Enter number of row: ");
							row = sc.nextInt();
							if (row < 1 || row > 3)
								System.out.print("Invalid input. ");
							else break;
						} while (true);
						// player 2 enters column number
						do {
							System.out.println("Enter number of column: ");
							col = sc.nextInt();
							if (col < 1 || col > 3)
								System.out.print("Invalid input. ");
							else break;
						} while (true);
						if (seaChess[row - 1][col - 1] == 'X' || seaChess[row - 1][col - 1] == 'O') {
							System.out.println("This field is not empty! Choose another one.");
						} else break;
					}

					seaChess[row - 1][col - 1] = 'O';

				} // end else condition for player 2
				
				
				printUpdatedBoard(seaChess);
				
				
				
				
				// HERE CHECK IF THERE'S A WINNER
				// checks rows
				for (int i = 0; i < seaChess.length; i++) {
					if (seaChess[i][0] == seaChess[i][1] && seaChess[i][1] == seaChess[i][2]) {
						if (seaChess[i][0] == 'O') {
							System.out.println("Player 2 wins!");
							break outerloop;
						}
						if (seaChess[i][0] == 'X') {
							System.out.println("Player 1 wins!");
							break outerloop;
						}
					}
				}
				// checks columns
				for (int j = 0; j < seaChess.length; j++) {
					if (seaChess[0][j] == seaChess[1][j] && seaChess[1][j] == seaChess[2][j]) {
						if (seaChess[0][j] == 'O') {
							System.out.println("Player 2 wins!");
							break outerloop;
						}
						if (seaChess[0][j] == 'X') {
							System.out.println("Player 1 wins!");
							break outerloop;
						}
					}
				}
				// checks diagonal 1
				if (seaChess[0][0] == seaChess[1][1] && seaChess[1][1] == seaChess[2][2]) {
					if (seaChess[0][0] == 'O') {
						System.out.println("Player 2 wins!");
						break outerloop;
					}
					if (seaChess[0][0] == 'X') {
						System.out.println("Player 1 wins!");
						break outerloop;
					}
				}
				// checks diagonal 2
				if (seaChess[0][2] == seaChess[1][1] && seaChess[1][1] == seaChess[2][0]) {
					if (seaChess[0][2] == 'O') {
						System.out.println("Player 2 wins!");
						break outerloop;
					}
					if (seaChess[0][2] == 'X') {
						System.out.println("Player 1 wins!");
						break outerloop;
					}
				}
				

				if (turn == 9) { // if this code runs, this means there's no winner
					System.out.println("No winner in this game.");
				}
				

			} // end for loop with 9 turns

			
			// checks if players want to play again
			System.out.println("Do you want to play again? Press 'Y' for YES or 'N' for NO/EXIT: ");
			char answer;
			do {
				answer = sc.next().trim().charAt(0);
			} while (answer != 'Y' && answer != 'N');
			if (answer == 'N') {
				break; // instead of break here we can put also System.exit(0);
			} 
			// else plays again

			
		} while (true);

		sc.close();
		

	} // end main

} // end class
