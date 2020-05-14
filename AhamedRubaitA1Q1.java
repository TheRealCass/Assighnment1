/**
 * Class Name: AhamedShoumikA1Q1
 * 
 * COMP2140 Section D01
 * Assighnment  Assightnment #1, Question #1
 * @author   Rubait Ul Ahamed, 007876180
 * @version (13th May 2020)
 * 
 * methods: main
 * Description:
 */
public class AhamedRubaitA1Q1 {

    /**
     * name: main function
     * @param Strings[]
     * @return void
     */
    public static void main(String[] args) {
        
    }
    
}



//==============================================================================================

/**
 * Class Name: Book
 * 
 * COMP2140 Section D01
 * Assighnment  Assightnment #1, Question #1
 * @author   Rubait Ul Ahamed, 007876180
 * @version (13th May 2020)
 * 
 * methods: getInitials, giveOnLoan, RecieveBook
 * Description:
 */
class Book{

    //book info
    private String title;
    private String authorFirstName;
    private String authorLastName;

    boolean onLoan;

    /**
     * constructor
     * @param firstParam
     */
    public Book(String title, String FirstName, String lastName){

        this.title = title;
        authorFirstName = FirstName;
        authorLastName = lastName;
        onLoan = false;

    }

    /**
     * Method name: getInitials
     * @param void
     * @return (String) the initial of the author
     *          Ex- Gaimen, N. (for Neil Gaimen)
     */
    public String getInitials(){
        String toReturn = "";
        toReturn = authorLastName + ", ";
        toReturn += authorFirstName.charAt(0) + ".";
        return toReturn;
    }

    /**
     * Method name: giveOnLoan
     * @param void
     * @return (void) sets the boolean flag onLoad to true
     */
    public void giveOnLoan(){
        onLoan = true;
    }

    /**
     * Method name: recieveBook
     * @param void
     * @return (void) sets the boolean flag onLoad to false
     */
    public void recieveBook(){
        onLoan = false;
    }

    /**
     * Method Name: toString
     * @param void
     * @return (String) returns the title, authors initals and weather it's on loan or not
     *                  Ex- "American Gods" - Gaimen, N. (inLibrary/onLoan)
     */
    public String toString(){
        String toReturn = "";
        toReturn += "\'" + title + "\'";
        toReturn += " - " + getInitials();
        toReturn += "(";
        if(onLoan){
            toReturn += "on loan";
        } else {
            toReturn += "inLibrary";
        }
        toReturn += ")";
        return toReturn;
    }







}


//==============================================================================================

/**
 * Class Name: Library
 * 
 * COMP2140 Section D01
 * Assighnment  Assightnment #1, Question #1
 * @author   Rubait Ul Ahamed, 007876180
 * @version (13th May 2020)
 * 
 * methods:
 * Description:
 */
class Library{

    

    /**
     * constructor for Library
     * @param void
     */
    public Library(){

    }




}