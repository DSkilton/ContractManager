/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MC03353
 */
public class ContractManager {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        checkFile();
//        checkFileTry();
        System.out.print(countLinesBR("Archive.txt"));
        
    }
    
    public static void checkFile() throws IOException {
        File f = new File("Test.txt");
        
        if(!f.exists()){
          f.createNewFile();
        }else{
          System.out.println("File already exists");
        }
    }
    
    public static boolean checkFileTry() {
        File f = new File("Archive.txt");
        
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (Throwable e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }else{
          System.out.println("File already exists");
        }
        return true;
    }
    
    public static int countLinesBR(String path) throws FileNotFoundException, IOException{
               
        BufferedReader reader = new BufferedReader(new FileReader("Archive.txt"));
        int lines = 0;
        
        while (reader.readLine() != null) lines++;
        
        reader.close();
        System.out.println(lines);



//        int iLines = 0; //variable to store line count
//        String line = InputFactory.bufferedReader(path).readLine();
//        
//        if((InputFactory.bufferedReader(path) != null) && (checkFileTry())){
//            System.out.println("inside if");
//            while(InputFactory.bufferedReader(path) != null){
//                System.out.println("inside while");
//                iLines++;
//            }
//            InputFactory.bufferedReader(path).close();
//        }
//        
//        System.out.println(iLines);
        return 0;
    }
    
}
