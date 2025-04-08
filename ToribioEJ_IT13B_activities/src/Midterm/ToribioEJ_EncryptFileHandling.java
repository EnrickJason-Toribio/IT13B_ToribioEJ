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
    
    
    
    public static void main(String[] args) throws IOException {
        String encryptedMessage;

        try (FileWriter myfile = new FileWriter("C:\\Users\\Jayboy\\Desktop\\java programs\\ToribioEJ_encrypted.txt")) {
            int key = 6;
            String message = "I love you!\nGwapa ko!\nBuotan si Ma'am";
            encryptedMessage = encryptMessage(message, key);
            myfile.write(encryptedMessage);
        }
        System.out.println("Encrypted Message:");
        System.out.println(encryptedMessage);
    }

    public static String encryptMessage(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '\n') {
                chars[i] += key;
            }
        }
        return new String(chars);
    }
    
}