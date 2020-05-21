import java.util.Scanner;
public class TestClass {
    
    public static void main(String[] args) {

        Book k = new Book("Gaimen", "Neil", "American Gods");
        Library lib = new Library();
        lib.addBook(k);
        String s = lib.toString();
        System.out.println(s);


    }
    
}