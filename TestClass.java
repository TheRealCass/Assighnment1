import java.util.Scanner;

public class TestClass {
    
    public static void main(String[] args) {


        String g = "Gaimen, Neil, American Gods";
        Scanner scan = new Scanner(g);
        try {
            scan.useDelimiter(",");
            String lastName = scan.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }
    }
    
}