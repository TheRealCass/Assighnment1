//==============================================================================================
//imports for scanner and it's components
import java.io.File;
import java.util.Scanner;
//==============================================================================================
/**
 * Class Name: AhamedShoumikA1Q1
 * 
 * DESCRIPTION: gets bord from input and passes it on to the sudoku class
 * COMP2140 Section D01 
 * Assighnment Assightnment #1, Question #1
 * 
 * @author Rubait Ul Ahamed, 007876180
 * @version (22th May 2020)
 */
public class AhamedRubaitA1Q2 {    

    public static final String PATH = "input2.txt";
    public static final String EMPTY = "-";
    public static final String SPACE = " ";
    /**
     * main fucntion
     * @param args
     */
    public static void main(String[] args) {
        int[][] gameBord = getBord(PATH);
		Sudoku sudoku = new Sudoku(gameBord);
		System.out.println("Sudoku grid to solve");
		System.out.println(sudoku.toString());
		if (sudoku.recursiveSolve()) {
			System.out.println("Sudoku Grid solved");
            System.out.println(sudoku.toString());
		} else {
			System.out.println("Unsolvable");
		}
        
    }

    /**
     * Method name: getBord
     * @param path path to the input file
     * @return (int[][]) 2D array of the bord from the input file
     */
    public static int[][] getBord(String path){
        int[][] toReturn = null;
        File f = new File(path);
        Scanner scan = null;
        String wholeBord = "";

        try {
            scan = new Scanner(f);
            if(scan.hasNextLine()){
                wholeBord = scan.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }


        String[] string1DArray = wholeBord.split(SPACE);
        toReturn = make2DArray(string1DArray);
        return toReturn;
    }


    /**
     * Mathod name: make2DArray
     * @param stringArray 1D string array
     * @return (int[][]) takes the squroot of the 1D arraysize to make 2D array bord
     *                   takes the valus in string and converts to ints
     */
    private static int[][] make2DArray (String[] stringArray) {

        int size = (int) Math.sqrt(stringArray.length + 1.0);
        int[][] toReturn = new int[size][size];

        int counter = 0;
        for (int row = 0; row < toReturn.length; row++) {
            for (int col = 0; col < toReturn.length; col++) {
                if(stringArray[counter].equals(EMPTY)){
                    toReturn[row][col] = 0;
                } else {
                    toReturn[row][col] = Integer.parseInt(stringArray[counter]);
                }
                counter++;
            }
        }
        return toReturn;
    }
}


//==============================================================================================
/**
 * Class Name: Sudoku
 * 
 * DESCRIPTION: Stores sudoku bords. has methods to solve them if called upon bord
 * COMP2140 Section D01 
 * Assighnment Assightnment #1, Question #1
 * 
 * @author Rubait Ul Ahamed, 007876180
 * @version (19th May 2020)
 *
 */
class Sudoku {

    private static final int[][] DEFAULT_BORD = {
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
    
    //variables to store sudoku bord
    private int[][] bord;
    public int size;
    private final int BLANK = 0;

    //debug
    private final boolean DEBUG = false;


    /**
     * constructor
     * @param toSolve initial bord in form of 2d array
     */
    public Sudoku(int[][] toSolve){
        this.size = toSolve.length;
        this.bord = copyBord(toSolve);

    }


    /**
     * secoundary constructor
     * uses the defaul pre built bord
     */
    public Sudoku(){
        int [][] defaultBord = copyBord(DEFAULT_BORD);
        this.size = defaultBord.length;
        this.bord = defaultBord;

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
                    System.out.println(digit + " found in " + row + "th row");
                return true;
            }
        }
        if(DEBUG)
            System.out.println(digit + " not found in " + row + "th row");
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
                    System.out.println(digit + " found in " + col + "th col");
                return true;
            }
        }

        if(DEBUG)
            System.out.println(digit + " not found in " + col + "th col");
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

        //checking for conditions
        boolean notInRow = !rowCheck(row, digit);
        boolean notInCol = !colCheck(col, digit);
        boolean notInGrid = !gridCheck(row, col, digit);

        if(notInCol && notInRow && notInGrid){
            return true;
        }
        if(DEBUG)
            System.out.println(digit + " can't be in " + row + "th row and" + col + "th col");

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


	/**
	 * Method name: copyBord
	 * @param toCopy 2D arry bord
	 * @return (int[][]) the deep copied bord
	 */
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

//==========================================================================================================