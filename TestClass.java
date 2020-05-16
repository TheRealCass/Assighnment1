import java.io.InputStream;

public class TestClass {
    
    public static void main(String[] args) {

        Book a = new Book("Gaimen", "Neil", "American");
        Book b = new Book("Martin", "Gorge", "Game Of Thrones");
        Book c = new Book("Rolling", "J.K.", "Harry Potter");
        Book d = new Book("Tolkin", "J.R.R.", "Lord of the rings");




        //libClass();
        //stringStuff();
        //bookClass();
        
    }

    private static void bookClass(){
        Book myFavBook = new Book("Martin", "Gorge", "Game of Thrones");

        String s = myFavBook.getInitials();
        System.out.println(s);
        myFavBook.recieveBook();
        System.out.println(myFavBook.toString());


        // String h = "boobs";
        // String p = "boobS";
        // boolean result = h.equals(p);
        // System.out.print(result);
    }

    private static void stringStuff(){
        String s = "A";
        System.out.print((int) s.charAt(0));

    }

    private static void libClass(){
        Library fortRichmondLibrary = new Library();
        fortRichmondLibrary.addBook(new Book("Martin", "Gorge", "Game of Thrones"));

    }
    
}