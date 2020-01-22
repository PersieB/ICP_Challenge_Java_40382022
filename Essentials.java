/**
 * importing various modules needed
 */
import java.util.Scanner;
import java.io.*;

/**
 * Essentials.java - a program created to store records of current stock in Essential's shop into a file
 * It also creates a backup of the same record in another file and prints the details of the original file
 * @author Percy George Brown
 * date - 22nd January 2020
 * @version 1.0
 */
public class Essentials {
    //instance variables
    float price;
    String product;
    int quantity;

    /**
     * Default Constructor
     */
    public Essentials() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Parameterized Constructor to refer instance variables
     * @param price    to refer the price instance variable
     * @param product  to refer the product instance variable
     * @param quantity to refer the quantity instance variable
     */

    public Essentials(int price, String product, int quantity) {
        this.price = price;
        this.product = product;
        this.quantity = quantity;
    }
    /**
     * SETTERS FOR THE INSTANCE VARIABLES
     */

    /**
     * setter method for price
     *
     * @param price with parameter price to set the price value
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * setter method for product
     *
     * @param product with parameter product to set the product name
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * setter method for quantity
     *
     * @param quantity with parameter quantity to set the quantity value
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter methods for the instance variables
     */

    /**
     * getter method to return price
     *
     * @return returns the price as a float type
     */
    public float getPrice() { return price; }

    /**
     * getter method to return product
     *
     * @return returns the product as a String type
     */
    public String getProduct() { return product; }

    /**
     * getter method to return quantity
     *
     * @return returns the product as an integer type
     */
    public int getQuantity() { return quantity; }

    int k = 1;    // variable k initially set to 1;

    /**
     * Phase 1
     * A method Stock() to take 10 10 products with their respective price and quantities available.
     *
     * @return returns a string - output containing the 10 products with their respective price and quantities available.
     */
    public String Stock() {
        String output = "";
        while (k < 11) {
            Scanner stdin = new Scanner(System.in);    //for obtaining input
            System.out.print("Enter a product " + k + ": ");
            product = stdin.nextLine();   // product input
            System.out.print("Enter it's quantity: ");
            quantity = stdin.nextInt();   // quantity input
            System.out.print("Enter it's price: ");
            price = stdin.nextFloat();   // price input

            // getting all inputs as a string with the help of the getters defined above
            String details = "< " + getProduct() + " > < " + getQuantity() + " > < GHC" + getPrice() + " >";
            output += details + "\n";  // output containing all the details of 10 current stock
            k++;
            //System.out.println(output);
        }
        return output;
    }

    /**
     * Phase 2 and 3
     * This method writes the inputs into an original file, then duplicates the same record into another file
     * Every operation on the original file is simultaneously carried out on the backup file
     *
     * @param s StringBuilder object that is written into the files
     */
    public void writingTextToFile(StringBuilder s) {
        PrintWriter printWriter = null;
        PrintWriter printWriter1 = null;
        try {
            //for the purposes of the assignment, no appending is allowed. Only new set of 10 inputs are needed, hence false.
            //both original and backup file passed as parameters
            printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", false));
            printWriter1 = new PrintWriter(new FileOutputStream("backup_essentials.txt", false));
        } catch (FileNotFoundException fnfe) {
            fnfe.getMessage();  // returns the exception message
        }
        String categories = "< PRODUCT > < QUANTITY > < PRICE >";

        //Prints the string above into both files
        printWriter.print(categories);
        printWriter1.print(categories);
        printWriter.println();
        printWriter1.println();

        // prints the StringBuilder object passed as a parameter to both files
        printWriter.print(s);
        printWriter1.print(s);
        printWriter.println();
        printWriter1.println();

        //Closing Both writers
        printWriter.close();
        printWriter1.close();
    }

    /**
     * This method displays the records in the original file - "essentials_stock.txt" onto the screen
     * Uses BuffedReader class to enable efficient reading of the file line by line
     */
    public void DisplayStock() {
        System.out.println();
        System.out.println("You need to check your books for the records. View from here!!!");
        try (BufferedReader percy = new BufferedReader(new FileReader("essentials_stock.txt"))) {
            String StockDetails;
            while ((StockDetails = percy.readLine()) != null) {  // while a line is not empty
                System.out.println(StockDetails);   //print the outputs
            }
        } catch (FileNotFoundException e) {    //to trace the exceptions
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}