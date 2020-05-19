import java.util.Scanner;
public class TestClass {
    
    public static void main(String[] args) {


        String g = "ADD Atwood, Margaret, The Handmaids Tale";
        Scanner scan = new Scanner(g);
        String command = "";
        String lastName = "";
        String firstName = "";
        String title = "";
        try {
            command = scan.next();
            //scan.useDelimiter(",");
            lastName = scan.next();
            lastName = lastName.substring(0, lastName.length() - 1);
            //scan.useDelimiter(" ");
            firstName = scan.next();
            firstName = firstName.substring(0, lastName.length() - 1);
            while (scan.hasNext()){
                title += scan.next() + " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
            System.out.println(command);
            System.out.println(lastName);
            System.out.println(firstName);
            System.out.println(title);
        }
    }
    
}