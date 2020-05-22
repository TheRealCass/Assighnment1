//==============================================================================================
/**
 * Class Name: Sudoku
 * 
 * COMP2140 Section D01 
 * Assighnment Assightnment #1, Question #1
 * 
 * @author Rubait Ul Ahamed, 007876180
 * @version (19th May 2020)
 * 
 * methods:  
 * Description:
 */public class Sudoku {

    public int[][] bord;
    public static final int EMPTY = 0;
    public static final int SIZE = 9;

    public Sudoku(int[][] bord){
        this.bord = new int[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                this.bord[row][col] = bord[row][col];
            }
        }
    }


    private boolean isInRow(int row, int digit){
        for (int col = 0; col < SIZE; col++) {
            if(bord[row][col] == digit){
                return true;
            }
        }
        return false;
    }

    private boolean isInCol(int col, int digit){
        for (int row = 0; row < bord.length; row++) {
            if (bord[row][col] == digit){
                return true;
            }
        }
        return false;
    }

    private boolean isInGrid(int row, int col, int digit){
        int r = row - row % 3;
        int c = col - col % 3;

        for (int i = r; i < r + 3; i++) {
            for (int j = 0; j < c + 3; j++) {
                if (bord[row][col] == digit) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isvalid(int row, int col, int digit){
        return !isInRow(row, digit) && !isInCol(col, digit) && !isInGrid(row, col, digit);
    }


    public boolean solve(){

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                
                if(bord[row][col] == EMPTY){
                    
                    for (int tryNum = 0; tryNum < SIZE; tryNum++) {
                        if (isvalid(row, col, tryNum)) {
                            bord[row][col] = tryNum;

                            if(solve()){
                                return true;
                            } else {
                                bord[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;

                }

            }
        }
        return true;
    }

    public void display(){
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(" " + bord[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    

}