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

    


    public boolean isFull(int[][] bord){
        for (int row = 0; row < bord.length; row++){
            for (int col = 0; row < bord[row].length; col++) {
                if(bord[row][col] == 0){
                    return false;
                }
            }
        }
        return true;
    }

}