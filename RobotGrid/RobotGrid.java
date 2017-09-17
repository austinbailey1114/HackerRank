package codingInterview;
import java.util.Random;

public class RobotGrid {
	
	public static void findPath(int row, int column, String[][] grid) {
		/*This recursive function checks if the current row and column are a valid move, if not it returns,
		 * If it is, it will check all possible moves after this one*/
		if (row == grid.length-1 && column == grid[0].length-1) {
			//final spot found, show the grid after all moves to make it here
			grid[row][column] = "X";

			System.out.println("Success: ");
			System.out.println();
			for(int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		else if (row > grid.length-1 || column > grid[0].length-1 || column < 0 || row < 0 || grid[row][column] != "1") {
			return;
		}
		else {
			//mark the cell as visited
			grid[row][column] = "X";
			
			//recursively find all possible solutions from this point
			findPath(row, column+1, grid);
			findPath(row+1, column, grid);
		}
	}

	public static void main(String[] args) {
		
		//Set grid size here
		int rows = 20;
		int columns = 20;
		
		//Set grid
		String[][] grid = new String[rows][columns];
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				//eventually add 0 at random for off columns
				Random rand = new Random();
				int n = rand.nextInt(10) + 1;
				if (n > 2) {
					grid[i][j] = "1";
				}
				else {
					grid[i][j] = "0";
				}
			}
		}
		
		//show the grid cells. 0 is a bad cell, 1 is a good cell
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		findPath(0, 0, grid);

	}

}
