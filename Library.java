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
public class Library{

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
        String debug = "finding " + title + " by ";
        String name = lastName + ", " + firstName;
        debug += name;

        if(DEBUG){
            System.out.println(debug);
        }

        boolean nameCondition =false;
        boolean titleCondition = false;
        boolean nameMatch = false;
        boolean titleMatch = false;

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
        if(DEBUG)
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
