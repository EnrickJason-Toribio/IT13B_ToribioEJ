package Midterm;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ToribioEJ_EncryptFileHandling {
//    public static void main(String[] args) {
//        try {
//            File myFile = new File("C:\\Users\\Jayboy\\Desktop\\java programs\\ToribioEJ_input.txt");
//            if (myFile.createNewFile()) {
//                System.out.println("File created: " + myFile.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }   
//    }
        
    
    
//    public static void main(String[] args) {
//        try {
//            FileWriter myText = new FileWriter("C:\\Users\\Jayboy\\Desktop\\java programs\\ToribioEJ_input.txt");
//            myText.write("I love you!\nGwapa ko!\nBuotan si Ma'am\n");
//            myText.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }




//    public static void main(String[] args){
//        try {
//            File input = new File("C:\\Users\\Jayboy\\Desktop\\java programs\\ToribioEJ_input.txt");
//            Scanner myReader = new Scanner(input);
//            while(myReader.hasNextLine()){
//                String data = myReader.nextLine();
//                System.out.println(data);
//            }
//            myReader.close();
//        } catch (FileNotFoundException e){
//            System.out.println("An error occured.");
//            e.printStackTrace();
//        }
//    }
    
    

public static char encryptMessage(char chars) {
        return (char)(chars + 6);
    }

    public static void main(String[] args) {
        String input = "C:\\Users\\Jayboy\\Desktop\\java programs\\ToribioEJ_input.txt";
        String encrypted = "C:\\Users\\Jayboy\\Desktop\\java programs\\ToribioEJ_encrypted.txt";

        try (
            FileReader fr = new FileReader(input);
            FileWriter fw = new FileWriter(encrypted)
        ) {
            int data;
            while ((data = fr.read()) != -1) {
                char chars = (char) data;
                fw.write(encryptMessage(chars)); // encrypt and write character
            }

            System.out.println("Encrypted message to: " + encrypted);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}