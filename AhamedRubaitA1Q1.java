//==============================================================================================
//importing scanner and its requirments
import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;
//==============================================================================================
/**
 * Class Name: AhamedShoumikA1Q1
 *
 * DESCRIPTION: taken in the input file and exectutes each line of command
 * COMP2140 Section D01 Assighnment Assightnment #1, Question #1
 * 
 * @author Rubait Ul Ahamed, 007876180
 * @version (20th May 2020)
 */

public class AhamedRubaitA1Q1 {

    //path to input file
    private final static String PATH = "Input.txt";

    //commands
    private final static String ADD_COMMAND = "ADD";
    private final static String SEARCH_BY_TITLE_COMMAND = "SEARCHT";
    private final static String SEARCH_BY_AUTHOR_COMMAND = "SEARCHA";
    private final static String BORROW_BOOK_COMMAND = "GETBOOK";
    private final static String RETURN_BOOK_COMMAND = "RETURNBOOK";

    //debug
    private static final boolean DEBUG = false;


    /**
     * name: main function
     * 
     * @param Strings[]
     * @return void
    */
    public static void main(String[] args) {
        Library bookHouse = new Library();
        try {
            System.out.println("Processing " + PATH + "...\n");
            handleInput(PATH, bookHouse);
        } catch (Exception e) {
            e.printStackTrace();
            if(DEBUG)
                System.out.println("can't acess " + PATH);
        } finally {
            System.out.println("program terminated normally.");
        }
        if(DEBUG)
            System.out.println(bookHouse.toString());
    }


    /**
     * Method name: handleInput
     * @param path path location as a String to the input file
     * @param lib library to execute the commands from the input file
     * @return (void) takes command from the input file to execute on library obj
     */
    public static void handleInput(String path, Library lib) {
        File f = new File(path);
        try {
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine()){
                String command = scan.nextLine();
                executeCommand(command, lib);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
       
    }


    /**
     * Method Name: executeCommand
     * @param command line of command to execute
     * @param lib lib to execute command on
     * @return (void) taken in and executes one line of command on lib.
     *                Command ex: ADD Gaimen, Neil, American Gods
     */
    public static void executeCommand(String command, Library lib){
        Scanner scan = null;
        String instruction = "";
        String lastName = "";
        String firstName = "";
        String title = "";

        try {
            scan = new Scanner(command);
            instruction = scan.next();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (instruction.equals(ADD_COMMAND)) {
         
            try {
                lastName = scan.next();
                lastName = lastName.substring(0, lastName.length() - 1);
                firstName = scan.next();
                firstName = firstName.substring(0, firstName.length() - 1);
                while (scan.hasNext()){
                    title += scan.next() + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scan.close();
                if (DEBUG){
                    System.out.println(instruction);
                    System.out.println(lastName);
                    System.out.println(firstName);
                    System.out.println(title);
                }
            }
            add(lib, lastName, firstName, title);
        } else if (instruction.equals(SEARCH_BY_AUTHOR_COMMAND)){
            try {
                lastName = scan.next();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scan.close();
                if (DEBUG){
                    System.out.println(instruction);
                    System.out.println(lastName);
                }
            }
            searchByAuthour(lib, lastName);
        } else if (instruction.equals(SEARCH_BY_TITLE_COMMAND)) {
            try {
                while (scan.hasNext()){
                    title += scan.next() + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scan.close();
                if (DEBUG){
                    System.out.println(instruction);
                    System.out.println(title);
                }
            }
            searchByTitle(lib, title);
        } else if (instruction.equals(BORROW_BOOK_COMMAND)) {
            try {
                lastName = scan.next();
                lastName = lastName.substring(0, lastName.length() - 1);
                firstName = scan.next();
                firstName = firstName.substring(0, firstName.length() - 1);
                while (scan.hasNext()){
                    title += scan.next() + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scan.close();
                if (DEBUG){
                    System.out.println(instruction);
                    System.out.println(lastName);
                    System.out.println(firstName);
                    System.out.println(title);
                }
            }
            borrowBookFromLib(lib, lastName, firstName, title);
        } else if (instruction.equals(RETURN_BOOK_COMMAND)) {
            try {
                lastName = scan.next();
                lastName = lastName.substring(0, lastName.length() - 1);
                firstName = scan.next();
                firstName = firstName.substring(0, firstName.length() - 1);
                while (scan.hasNext()){
                    title += scan.next() + " ";
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                scan.close();
                if (DEBUG){
                    System.out.println(instruction);
                    System.out.println(lastName);
                    System.out.println(firstName);
                    System.out.println(title);
                }
            }
            returnBookToLib(lib, lastName, firstName, title);
        }
    }


    /**
     * Method name: returnBookToLib
     * @param lib library to return book to
     * @param lastName last name of the author
     * @param firstName first name of the author
     * @param title title of the author
     * @return (void) if book part of lib, returns it to the lib
     */
    public static void returnBookToLib (Library lib, String lastName, String firstName, String title) {
        boolean result = lib.returnBook(lastName, firstName, title);
        if(!result){
            System.out.println("Book does not belong to this library");
        } 
        System.out.println("\n");
    }


    /**
     * Method name: add
     * @param lib library to add to
     * @param lastName last name of the author
     * @param firstName first name of the author
     * @param title title of the author
     * @return (void) adds book to the library
     */
    public static void add (Library lib, String lastName, String firstName, String title){
        Book temp = new Book(lastName, firstName, title);
        lib.addBook(temp);
    }


    /**
     * MEthod name: searchByAuthor
     * @param lib library to search on
     * @param lastName last name of to search by
     * @return (void) searches and prins out list of matched authors
     */
    public static void searchByAuthour (Library lib, String lastName){
        String s = lib.listByAuthor(lastName);
        System.out.print(s + "\n");
    }
    

    /**
     * Method name: searchByTitle
     * @param lib library to search on
     * @param title string to check for title
     * @return (void) searches and prins out list of matched titles
     */
    public static void searchByTitle (Library lib, String title){
        String s = lib.listByTitle(title);
        System.out.print(s + "\n");
        //formating & printingg needed
    }


    /**
     * Method name: borrowBookFromLib
     * @param lib library to borrow from
     * @param lastName last name of the author
     * @param firstName first name of the author
     * @param title title of the author
     * @return (void) loans book from lib
     */
    public static void borrowBookFromLib (Library lib, String lastName, String firstName, String title) {
        boolean result = lib.loanBook(lastName, firstName, title);
        if(!result){
            System.out.println("No Such book avalable");
        } 
        System.out.println("\n");
    }
}


//==============================================================================================
/**
 * Class Name: Book
 * 
 * DESCRIPTION: holds data and info for a book in a library
 * COMP2140 Section D01
 * Assighnment  Assightnment #1, Question #1
 * @author   Rubait Ul Ahamed, 007876180
 * @version (15th May 2020)
 */
class Book{

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


//==============================================================================================
/**
 * Class Name: Library
 * 
 * DESCRIPTION: holds data and info library to store and borrow books
 * COMP2140 Section D01
 * Assighnment  Assightnment #1, Question #1
 * @author   Rubait Ul Ahamed, 007876180
 * @version (18th May 2020)
 */
 /* DESCRIPTION:
 * Limitations: Library can only hold MAX_BOOKS ammount. This can be set with respect to each systems config
 */
class Library{

    private Book[] bookShelf;
    private int bookCount;
    private final int MAX_BOOKS = 50000;

    private final boolean DEBUG = false;

    

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
                System.out.println(toAdd.getTitle() + " by " + toAdd.getInitials() + " added.");
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
        for(int i = 0; i < getBookCount(); i++) {
            boolean match = authorLastName.equals(bookShelf[i].getAuthorLastName()); 
            if(match){
                toReturn += bookShelf[i].toString() + "\n";
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
        for (int i = 0; i < getBookCount(); i++) {
            boolean match = bookTitle.equals(bookShelf[i].getTitle()); 
            if(match){
                toReturn += bookShelf[i].toString() + "\n";
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
        String name = lastName + ", " + firstName;
        if(DEBUG){
            String debug = "finding " + title + " by ";
            debug += name;
            System.out.println(debug);
        }

        //creating condition variables
        boolean nameCondition =false;
        boolean titleCondition = false;
        boolean nameMatch = false;
        boolean titleMatch = false;

        //innitialising condition variables
        for (int i = 0; i < getBookCount(); i++) {
            nameCondition = name.equals(bookShelf[i].getInitials());
            titleCondition = title.equals(bookShelf[i].getTitle());
            if (titleCondition) {
                titleMatch = true;
                if (nameCondition) {
                    nameMatch = true;
                }
            }

            if(nameMatch && titleMatch){
                if(DEBUG)
                    System.out.println("book found");
                return bookShelf[i];
            }
        
        }

        //if not found    
        System.out.println(title + " by " + name + "not found");
        return null;
    }


    /**
     * Method name: toString
     * @param void
     * @return (String) return authour's title and name
     */
    @Override
    public String toString(){
        String toReturn = "Books in " + this.getClass().getName() + "\n";
        for (int i = 0; i < getBookCount(); i++) {
            toReturn += bookShelf[i].toString() + "\n";
        }
        return toReturn;
    }

    /**
     * Method name: getBookCount
     * @param void
     * @return (int) amount of books in the bookshelf array
     */
    public int getBookCount(){
        return bookCount;
    }
}
//==============================================================================================
