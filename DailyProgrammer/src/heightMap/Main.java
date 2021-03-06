package heightMap;

public class Main {
	//Sorry for the haphazard hardcoding of the grid. If there's a better solution, let me know!
	private static String[] lines = /*{ "+-----------------------------------------------------------------------+",
			"|     +--------------------------------------------------------------+  |",
			"|     |      +-----------------------------------------------------+ |  |",
			"|     |      |         +-----------------------------------------+ | |  |",
			"|     |      |         |           +---------------------------+ | | |  |",
			"|     |      |         |           |                           | | | |  |",
			"|     |      |         |           |                           | | | |  |",
			"|     |      |         |           |                           | | | |  |",
			"|     |      |         |           +---------------------------+ | | |  |",
			"|     |      |         |                                         | | |  |",
			"|     |      |         +-----------------------------------------+ | |  |",
			"|     |      |                                                     | |  |",
			"|     |      |                                                     | |  |",
			"|     |      +-----------------------------------------------------+ |  |",
			"|     |                                                              |  |",
			"|     +--------------------------------------------------------------+  |",
			"|                                                                       |",
			"|                                                                       |",
			"|                                                                       |",
			"+-----------------------------------------------------------------------+" };*/
		{"+--------------------------------------------------------------+",
			"|                                                              |",
			"|   +-------------------------------+          +-------+       |",
			"|   |                               |          |       |       |",
			"|   |                               |          |       |       |",
			"|   |     +----------------+        |          |       |       |",
			"|   |     |                |        |          +-------+       |",
			"|   |     |                |        |                          |",
			"|   |     |                |        |          +-------+       |",
			"|   |     +----------------+        |          |       |       |",
			"|   |                               |          |       |       |",
			"|   |                               |          |       |       |",
			"|   +-------------------------------+          +-------+       |",
			"|                                                              |",
			"+--------------------------------------------------------------+"};

	public static void main(String[] args) {
		Grid g = new Grid(lines);
		g.solve();
		
		char[][] grid = g.getGrid();
		for (char[] l : grid){
			System.out.println(l);
		}
	}

}
