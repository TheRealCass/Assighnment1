public class AhamedRubaitA1Q2 {
    public static int[][] defaultBord = {
        {5, 0, 9, 4, 0, 0, 8, 0, 1},
        {0, 1, 0, 0, 6, 0, 9, 3, 0},
        {0, 4, 8, 0, 7, 0, 2, 5, 0},
        {9, 2, 0, 3, 0, 0, 5, 0, 7},
        {6, 7, 1, 8, 5, 0, 0, 0, 2},
        {0, 0, 0, 0, 0, 4, 1, 6, 0},
        {0, 0, 6, 1, 0, 3, 0, 0, 0},
        {7, 8, 0, 0, 9, 5, 4, 0, 0},
        {0, 3, 0, 2, 0, 0, 0, 9, 8}
    };

    public static void main(String[] args) {
		Sudoku sudoku = new Sudoku(defaultBord);
		System.out.println("Sudoku grid to solve");
		System.out.println(sudoku.toString());
		if (sudoku.recursiveSolve()) {
			System.out.println("Sudoku Grid solved");
            System.out.println(sudoku.toString());
		} else {
			System.out.println("Unsolvable");
		}
	}
}