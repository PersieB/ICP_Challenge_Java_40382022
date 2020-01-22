/**
 * @author Percy George Brown
 * @version 1.0
 * This is the test class for Essentials.java file
 * All the methods in Essentials.java are successfully tested here
 */

public class TestEssentials {
    public static void main(String[] args){
        System.out.println("WELCOME TO FIFI'S ESSENTIALS SHOP DATABASE SYSTEM @ ASHESI UNIVERSITY");
        System.out.println();
        Essentials p = new Essentials();    //instance of Essentials class

        String c = p.Stock();         // c stores the string output returned by the Stock() method after taking the inputs

        StringBuilder d = new StringBuilder(c); //converts the string returned into StringBuilder object to enable efficient writing into files

        p.writingTextToFile(d); // passes the StringBuilder object as a parameter to be written into the files

        p.DisplayStock(); // displays the records in the original file @essentials_stock.txt

    }
}
