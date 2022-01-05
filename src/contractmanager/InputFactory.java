/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MC03353
 */
public class InputFactory {    
        
    public static BufferedReader bufferedReader(String path) throws FileNotFoundException{
        return new BufferedReader(new FileReader(path)); 
    }
    
}
