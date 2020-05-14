//==============================================================================================
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

    private boolean onLoan;

    private final boolean DEBUG = true;

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
     *                  Ex- "American Gods" - Gaimen, Neil(inLibrary/onLoan)
     */
    public String toString(){
        String toReturn = getInitials();
        toReturn += ", " + getTitle();
        toReturn += "(";
        if(DEBUG){
            if(onLoan){
                toReturn += "onLoan";
            } else {
                toReturn += "inLibrary";
            }
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
 * Limitations: Library can only hold MAX_BOOKS ammount. This can be set with respect to each systems config
 */
class Library{

    private Book[] bookShelf;
    private int bookCount;
    private final int MAX_BOOKS = 50000;

    private final boolean DEBUG = true;

    

    /**
     * constructor for Library
     * @param void
     */
    public Library(){
        bookShelf = new Book[MAX_BOOKS];
        bookCount = 0;
    }


    /**
     * Method name: addBook
     * @param   String title of the book
     * @param   String author's first name
     * @param   String author's last name
     * @return (void) adds books to the array
     */
    public void addBook(String lastName, String firstName, String title){
        if(bookCount <= MAX_BOOKS){
            Book toAdd = new Book(title, firstName, lastName);
            bookShelf[bookCount] = toAdd;
            bookCount++;
        } else {
            if (DEBUG)
                System.out.println("Can not add book to library. Not enough space in  program memory.");
            return;
        }
    }


    /**
     * Method name: listByAuthor
     * @param   String 
     * @return (void) 
     */
    public String listByAuthor(String AuthorFirstName, String AuthorLastName){
        String toReturn = "";
        for (Book match : bookShelf) {
            boolean lastName = match.getAuthorLastName(
            boolean firstName

            if(){

            }
        }
        return toReturn;
        
    }
}

//==============================================================================================