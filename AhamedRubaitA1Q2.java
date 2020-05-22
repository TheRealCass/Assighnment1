public class AhamedRubaitA1Q2 {
    public static int[][] defaultBord = {
        {0, 0, 0}, {0, 0, 0}, {5, 4, 0},
        {0, 0, 6}, {0, 0, 0}, {0, 0, 8},
        {4, 2, 0}, {7, 0, 0}, {0, 0, 0},
        {0, 0, 3}, {6, 7, 0}, {0, 2, 0},
        {0, 0, 1}, {0, 8, 0}, {0, 0, 9},
        {0, 0, 0}, {4, 2, 1}, {0, 0, 0},
        {0, 0, 0}, {0, 3, 0}, {6, 7, 5},
        {0, 0, 0}, {0, 0, 9}, {0, 0, 0},
        {9, 2, 0}, {0, 0, 9}, {0, 0, 0}
    };

    public static void main(String[] args){
        Sudoku sudoku = new Sudoku(defaultBord);
        System.out.print("bord to solve");
        sudoku.display();

        if(sudoku.solve()){
            System.out.println("Solving");
            sudoku.display();
        } else {
            System.out.println("Not Solvable");

        }
    }
}