/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

/**
 *
 * @author MC03353
 */
public class Validation {

    public static char isValidName(char cName) {
        boolean validFlag = true;
        if (cName != 'Y' && cName != 'N') {
            validFlag = false;
            System.out.println("Enter Y or N only");
        } else if (cName == 'N') {
            validFlag = false;
            System.out.println("Please enter correct name");
        }
        return 0;
    } // end of class

    public boolean isValidReference(String Ref) {
        boolean validFlag = true;
        if (Ref.length() != 6) {
            validFlag = false;
            System.out.println("Too Many/Too Few Characters");
        } else if (!Character.isLetter(Ref.charAt(0)) || !Character.isLetter(Ref.charAt(1)) || !Character.isDigit(Ref.charAt(2)) || !Character.isDigit(Ref.charAt(3)) || !Character.isDigit(Ref.charAt(4)) || !Character.isLetter(Ref.charAt(5))) {
            validFlag = false;
            System.out.println("Incorrect format");
        } else if (Ref.charAt(Ref.length() - 1) == 'B' && Ref.charAt(Ref.length() - 1) == 'N') {
            validFlag = false;
            System.out.println("Last character must be N or B");
        }
        return validFlag;
    } // end of class
    
}
