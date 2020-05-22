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
 */public class Sudoku2 {
    
    private int[][] bord;
    public int size;

    private final int BLANK = 0;

    private final boolean DEBUG = false;

    /**
     * constructor
     * @param toSolve initial bord in form of 2d array
     */
    public Sudoku2(int[][] toSolve){
        this.size = toSolve.length;
        this.bord = copyBord(toSolve);

    }

    /**
     * Method name: rowCheck
     * @param row the row index to check in the 2d array
     * @param digit the number to check
     * @return (boolean) true if found, flase if not.
     */
    private boolean rowCheck(int row, int digit){
        if(DEBUG)
            System.out.println("checking " + row + "th row for " + digit);
        for (int col = 0; col < size; col++) {
            if(bord[row][col] == digit){
                if(DEBUG)
                    System.out.println(digit + " found in" + row + "th row");
                return true;
            }
        }
        if(DEBUG)
            System.out.println(digit + " not found in" + row + "th row");
        return false;
    }

    /**
     * Method name: col Check
     * @param col the col index to check in the 2d array
     * @param digit the number to check
     * @return (boolean) true if found, flase if not.
     */
    private boolean colCheck(int col, int digit){
        if(DEBUG)
            System.out.println("checking " + col + "th col for " + digit);
        for (int row = 0; row < size; row++) {
            if(bord[row][col] == digit){
                if(DEBUG)
                    System.out.println(digit + " found in" + col + "th col");
                return true;
            }
        }
        if(DEBUG)
            System.out.println(digit + " not found in" + col + "th col");
        return false;
    }

    /**
     * Method name: gridCheck
     * @param row the row index to check in the 2d array
     * @param col the col index to check in the 2d array
     * @param digit the number to check
     * @return (boolean) true if found, flase if not.
     */
    private boolean gridCheck(int row, int col, int digit){
        if(DEBUG)
            System.out.println("checking subgrid for " + digit);
        int gridRow = row - row % 3;
        int gridCol = col - col % 3;

        for (int i = gridRow; i < size + 3; i++) {
            for (int j = gridCol; j < size + 3; j++) {
                if(bord[gridRow][gridCol] == digit){
                    if(DEBUG)
                        System.out.println(digit + " found in subGrid");
                    return true;
                }
            }
        }
        if(DEBUG)
            System.out.println(digit + " not found in subGrid");
        return false;
    }

    /**
     * Method name: validateDigit
     * @param row row index of the 2D array gameBord
     * @param col col index of the 2D array gameBord
     * @param digit the digit to check
     * @return true if the digit given can be a viable option
     *         false if not
     */
    private boolean validateDigit(int row, int col, int digit) {
        if(DEBUG)
            System.out.println("validating " + digit);
        boolean notInRow = !rowCheck(row, digit);
        boolean notInCol = !colCheck(col, digit);
        boolean notInGrid = !gridCheck(row, col, digit);

        if(notInCol && notInRow && notInGrid){
            return true;
        }
        if(DEBUG)
            System.out.println(digit + " can't be in" + row + "th row and" + col + "th col");
        return false;
    }

    
    /**
     * Method name: isBLANK
     * @param row row index of the 2d gambord array
     * @param col col index of the 2d gambord array
     * @return true if BLANK(i.e. has a 0), false if not 
     */
    private boolean isBLANK(int row, int col) {
        if (bord[row][col] == BLANK){
            if(DEBUG)
                System.out.println(row + "th row and "+ col + "th col is BLANK");
            return true;
        }
        if(DEBUG)
            System.out.println(row + "th row and "+ col + "th col has" + bord[row][col] + "in it");
        return false;
    }


    /**
     * Method name: toString
     * @return (String) shows the bord
     */
    public String toString() {
        String toReturn = "";
        for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				toReturn += " " + bord[row][col];
			}
			toReturn += "\n";
        }
        return toReturn;
    }


    /**
     * Method name: recursiveSolve
     * @return (boolean) true if solved
     *                   false if not
     */
    public boolean recursiveSolve(){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(isBLANK(row, col)){
                    for(int digit = 1; digit <= size; digit++){
                        boolean possible = validateDigit(row, col, digit);
                        if(possible){
                            bord[row][col] = digit;  //setiing the validated number
                            if (recursiveSolve()) { 
                                return true;
                            } //runs again with new bord with one validated spot
                            else { 
                                bord[row][col] = BLANK;
                            }//keeps the spot empty if possible digits fail
                        }//runs only if no conflic occus

                    }//goes through the possible digits
                    return false;
                }//runs is spot is blank
            }
        }
        return true;
        
    }


    private int[][] copyBord(int[][] toCopy){
        int size = toCopy.length;
        int[][] toReturn = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                toReturn[row][col] = toCopy[row][col];
            }
        }
        return toReturn;
    }

}

