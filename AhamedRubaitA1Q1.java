import java.io.*;
import java.util.Scanner;
//==============================================================================================
/**
 * Class Name: AhamedShoumikA1Q1
 * 
 * COMP2140 Section D01 Assighnment Assightnment #1, Question #1
 * 
 * @author Rubait Ul Ahamed, 007876180
 * @version (19th May 2020)
 * 
 *          methods: main Description:
 */
public class AhamedRubaitA1Q1 {

    private static final boolean DEBUG = true;

    private final static String PATH = "Input.txt";

    /**
     * name: main function
     * 
     * @param Strings[]
     * @return void
     */
    public static void main(String[] args) {
        Library bookHouse = new Library();
        try {
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

        if (instruction.equals("ADD")) {
         
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
        } else if (instruction.equals("SEARCHA")){
            try {
                lastName = scan.next();
                lastName = lastName.substring(0, lastName.length() - 1);
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
        } else if (instruction.equals("SEARCHT")) {
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
        } else if (instruction.equals("GETBOOK")) {
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
        } else if (instruction.equals("RETURNBOOK")) {
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

    public static void returnBookToLib (Library lib, String lastName, String firstName, String title) {
        boolean result = lib.returnBook(lastName, firstName, title);
        if(DEBUG)
            System.out.println(result);
    }


    public static void add (Library lib, String lastName, String firstName, String title){
        Book temp = new Book(lastName, firstName, title);
        lib.addBook(temp);
    }

    public static void searchByAuthour (Library lib, String lastName){
        String s = lib.listByAuthor(lastName);
        System.out.print(s);
        //formating & printingg needed
    }
    
    public static void searchByTitle (Library lib, String title){
        String s = lib.listByTitle(title);
        System.out.print(s);
        //formating & printingg needed
    }

    public static void borrowBookFromLib (Library lib, String lastName, String firstName, String title) {
        lib.loanBook(lastName, firstName, title);
        //formating & printingg needed
    }
}
