import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//==============================================================================================
/**
 * Class Name: AhamedShoumikA1Q1
 * 
 * COMP2140 Section D01
 * Assighnment  Assightnment #1, Question #1
 * @author   Rubait Ul Ahamed, 007876180
 * @version (19th May 2020)
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
    public static void main(String[] args) throws IOException{

        Library bookHouse = new Library();
        handleInput("Input.txt");


       
        
    }

    private static void handleInput(String path){
        Scanner scan = new Scanner(new File(path));
        String command = "";
        try{
            while (scan.hasNextLine()) {
                command = scan.nextLine();
                executeCommand(command);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }
    }

    private static void executeCommand(String command) throws IOException{
        Scanner scan = new Scanner(command);
        String operation = scan.next();
        if(operation.equals("ADD")){
            String lastName = scan.next();
        }
    }
}



//==============================================================================================

/**
 * Class Name: Book
 * 
 * COMP2140 Section D01
 * Assighnment  Assightnment #1, Question #1
 * @author   Rubait Ul Ahamed, 007876180
 * @version (15th May 2020)
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
 * @version (18th May 2020)
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
     * @param   toAdd object of type book
     * @return (void) adds books to the array
     */
    public void addBook(Book toAdd){
        if(bookCount <= MAX_BOOKS){
            bookShelf[bookCount] = toAdd;
            bookCount++;
            if (DEBUG){
                System.out.println(toAdd.getTitle() + " added.");
            }
        } else {
            if (DEBUG)
                System.out.println("Can not add book to library. Not enough space in  program memory.");
            return;
        }
    }


    /**
     * Method name: listByAuthor
     * @param   authorLastName the last name of the author as a String 
     * @return (String) list containing all the books by the author with te same last name
     */
    public String listByAuthor(String authorLastName){
        String toReturn = "Books by " + authorLastName + ":\n";
        for (Book book : bookShelf) {
            boolean match = authorLastName.equals(book.getAuthorLastName()); 
            if(match){
                toReturn += book.toString() + "\n";
            } else {
                if(DEBUG)
                    System.out.println("No books found by " + authorLastName);
            }
        }
        return toReturn;
        
    }

    /**
     * Method name: listByTitle
     * @param bookTitle title of the book as a String
     * @return (String) lsit contailed all the books with matching name in the param
     */
    public String listByTitle(String bookTitle){
        String toReturn = "Books named " + bookTitle + ":\n";
        for (Book inHouseBook : bookShelf) {
            boolean match = bookTitle.equals(inHouseBook.getTitle()); 
            if(match){
                toReturn += inHouseBook.toString() + "\n";
            } else {
                if(DEBUG)
                    System.out.println("No books found by " + bookTitle);
            }
        }
        return toReturn;
        
    }


    /**
     * Method name: loadBook
     * @param lastName last name of the author
     * @param firstName first name of the author
     * @param title title of the book
     * @return (boolean) true if the book is avalable on loan. Turns onLoan flag to true;
     *                   fasle if not
     */
    public boolean loanBook(String lastName, String firstName, String title){
        Book match = matchBook(lastName, firstName, title);
        if(match != null){
            boolean notAvalable = match.getStatus();
            if(!notAvalable){
                match.giveOnLoan();
                return true;
            } else {
                if(DEBUG)
                    System.out.println(title + " is already out for loan.");
            }
        }
        return false;
    }

    /**
     * Method name: returnBook
     * @param lastName last name of the author
     * @param firstName first name of the author
     * @param title title of the book
     * @return (boolean) true if the book was found. Also changes the onLoan flag ito false
     *                   fasle if not found.
     */
    public boolean returnBook(String lastName, String firstName, String title){
        boolean toReturn = false;
        Book match = matchBook(lastName, firstName, title);
        if(match != null){
            boolean notAvalable = match.getStatus();
            if(notAvalable){
                match.recieveBook();
                toReturn = true;
            }
        }
        return toReturn;
    }

    /**
     * Method name: matchBook
     * @param lastName last name of the author
     * @param firstName first name of the author
     * @param title title of the book
     * @return (Book) book if found. if not found, null book returned
     * 
     */
    private Book matchBook(String lastName, String firstName, String title){
        Book toReturn = null;
        String name = lastName + ", " + firstName;
        boolean nameMatch = false;
        boolean titleMatch = false;
        for (Book inHouseBook : bookShelf) {
            boolean match = name.equals(inHouseBook.getInitials());
            if(match){
                nameMatch = true;
                if(DEBUG)
                    System.out.println("book by " + name + "found");
                match = title.equals(inHouseBook.getTitle());
                if(match){
                    titleMatch = true;
                    if(DEBUG)
                        System.out.println("book named " + title + " found");
                }
            }
            if(nameMatch && titleMatch){
                return inHouseBook;
            }
        }
        return toReturn;
    }

    /**
     * Method name: toString
     * @param void
     * @return (String) return authour's title and name
     */
    public String toString(){
        String toReturn = "";
        for (Book inHouseBook : bookShelf) {
            toReturn += inHouseBook.toString() + "\n";
        }
        return toReturn;
    }
}

//==============================================================================================
