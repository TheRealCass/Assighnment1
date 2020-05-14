import java.io.InputStream;

public class TestClass {
    
    public static void main(String[] args) {

        libClass();
        //stringStuff();
        //bookClass();
        
    }

    private static void bookClass(){
        Book myFavBook = new Book("Game of Thrones", "Gorge", "Martin");
        System.out.println(myFavBook.toString());
        myFavBook.giveOnLoan();
        System.out.println(myFavBook.toString());
        myFavBook.recieveBook();
        System.out.println(myFavBook.toString());


        String h = "boobs";
        String p = "boobS";
        boolean result = h.equals(p);
        System.out.print(result);
    }

    private static void stringStuff(){
        String s = "A";
        System.out.print((int) s.charAt(0));

    }

    private static void libClass(){
        Library fortRichmondLibrary = new Library();
        fortRichmondLibrary.a
    }
    
}