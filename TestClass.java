public class TestClass {
    
    public static void main(String[] args) {

        Book myFavBook = new Book("Game of Thrones", "Gorge", "Martin");
        System.out.println(myFavBook.toString());
        myFavBook.giveOnLoan();
        System.out.println(myFavBook.toString());
        myFavBook.recieveBook();
        System.out.println(myFavBook.toString());
    }
    
}