public class AhamedRubaitA1Q2 {    
    public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
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