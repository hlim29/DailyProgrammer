package heightMap;

public class Grid {
	private char[][] grid = new char[20][70];
	private char fillChars[] = { '#', '=', '-', '@', '&' };
	private boolean[][] visited = new boolean[100][100];
	private int latestRow=0, latestCol=0;

	public Grid(String[] lines) {
		int row = 0;
		for (String s : lines) {
			grid[row] = s.toCharArray();
			row++;
		}
	}

	public void solve() {
		int i = 0;
		
		floodFill(1,1, fillChars[i]);
		
		while (searchForSpaces(fillChars[i])) {
			floodFill(latestRow,latestCol, fillChars[i+1]);
			if (!searchForSpaces(fillChars[i])){
				i++;
			}
		}
	}

	
	public char[][] getGrid() {
		return grid;
	}

	
	private boolean searchForSpaces(char prevChar) {
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				if (grid[i][j] == '+' && grid[i-1][j-1] == prevChar && grid[i+1][j+1] == ' ') {
					latestRow = j+1;
					latestCol = i+1;
					return true;
				}
			}
		}
		return false;
	}

	
	private void floodFill(int row, int col, char fillChar) {
		
		
		//These prevent IndexOutOfBoundExceptions
		if (row < 0)
			return;
		if (col < 0)
			return;
		if (row >= grid[0].length)
			return;
		if (col >= grid.length)
			return;
		
		//Stops when it encounters an empty array element
				if (grid[col][row] == 0)
					return;

		//Stops when it encounters an already visited array element
		if (visited[col][row])
			return;

		if (grid[col][row] == ' ') {
			grid[col][row] = fillChar;
			visited[col][row] = true;
		} else if (grid[col][row] == '+' || grid[col][row] == '-' || grid[col][row] == '|') {
			return;
		}

		floodFill(row - 1, col, fillChar);
		floodFill(row + 1, col, fillChar);
		floodFill(row, col + 1,  fillChar);
		floodFill(row, col - 1, fillChar);
	}
}
