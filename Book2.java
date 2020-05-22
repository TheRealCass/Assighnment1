//==============================================================================================

/**
 * Class Name: Book
 * 
 * COMP2140 Section D01
 * Assighnment  Assightnment #1, Question #1
 * @author   Rubait Ul Ahamed, 007876180
 * @version (15th May 2020)
 */
/* methods: getInitials, giveOnLoan, RecieveBook, getStatus, getTitle, getAuthorFirstName,
            getAuthorLastName, toString
 * Description: holds data and info for a book in a library
 */
public class Book2{

    //book info
    private String title;
    private String authorFirstName;
    private String authorLastName;

    private boolean onLoan;

    private final boolean DEBUG = false;

    /**
     * constructor
     * @param firstParam
     */
    public Book(String lastName, String firstName, String title){

        this.title = title;
        authorFirstName = firstName;
        authorLastName = lastName;
        onLoan = false;

    }


    /**

     * Method name: getStatus
     * @param void
     * @return (boolean) the onLoad variable
     */
    public boolean getStatus(){
        return this.onLoan;
    }


    /**
     * Method name: getTitle
     * @param void
     * @return (String) the title of the book
     */
    public String getTitle() {
        return this.title;
    }


    /**
     * Method name: getAuthorFirstName
     * @param void
     * @return (String) the first name of the author
     */
    public String getAuthorFirstName() {
        return this.authorFirstName;
    }


    /**
     * Method name: getAuthorLastName
     * @param void
     * @return (String) the author's last name
     */
    public String getAuthorLastName() {
        return this.authorLastName;
    }


    /**
     * Method name: getInitials
     * @param void
     * @return (String) the initial of the author
     *          Ex- Gaimen, Neil
     */
    public String getInitials(){
        String toReturn = "";
        toReturn += getAuthorLastName();
        toReturn += ", " + getAuthorFirstName();
        return toReturn;
    }

    /**
     * Method name: giveOnLoan
     * @param void
     * @return (void) sets the boolean flag onLoad to true
     */
    public void giveOnLoan(){
        onLoan = true;
        String msg = "Book loaned:\n" + toString();
        System.out.println(msg);
    }

    /**
     * Method name: recieveBook
     * @param void
     * @return (void) sets the boolean flag onLoad to false
     */
    public void recieveBook(){
        onLoan = false;
        String msg ="Book returned:\n" + toString();
        System.out.println(msg);
    }

    /**
     * Method Name: toString
     * @param void
     * @return (String) returns the title, authors initals and weather it's on loan or not
     *                  Ex- "American Gods" - Gaimen, Neil(inLibrary/onLoan)
     */
    @Override
    public String toString(){
        String toReturn = getInitials();
        toReturn += ", " + getTitle();
        if(DEBUG){
            toReturn += "(";
                if(onLoan){
                    toReturn += "onLoan";
                } else {
                    toReturn += "inLibrary";
                }
            toReturn += ")";
        }
        return toReturn;

    }

}