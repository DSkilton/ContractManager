/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;
import java.util.Scanner; 
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;


/**
 *
 * @author Duncan Skilton
 */

public class ContractManager {
    
// global access
    static monthlyRates monthlyRates = new monthlyRates(); 
    //scanner
    static Scanner sc = new Scanner (System.in);
       
    public static void main(String[] args) { 
        welcome();
        getFirstName();
        getSecondName();
        getReference(); 
        getInternationalCalls();
        getMinutes(); 
        getDataBundle(); 
        getContractLength(); 
        confirmDetails();
    }
    
    //welcome menu
    static void welcome(){
        System.out.println("\n-- Welcome to contractManager --\n"
                + "   What would you like to do? \n\n"
                + "1. Enter new Contract \n"
                + "2. Display Summary of Contracts \n"
                + "3. Display Summary of Contracts \n"
                + "   for specific month \n"
                + "4. Find and display Contract \n"
                + "0. Exit \n" );
        int iChoice = sc.nextInt();
            //sMinsInput = sMinsInput.toLowerCase(); 

            if (iChoice == 1){ 
                getFirstName();
            }
            else if (iChoice == 2){
                displaySummary(); 
            } 
            
            else if (iChoice == 3){
                //checkFile();
            }
            
            else if (iChoice == 0) {
                System.exit(0);
            }
            else {
                System.out.println("Enter number between 1 and 3");
                welcome();
            }        
}//end of class

    //get client name 
    static void getFirstName() {
        String sFirstName = " ";
        System.out.println("Please enter Client's first name"); 
        
        sFirstName = sc.next().toUpperCase();
        System.out.println("\n"
                    + "You wrote " 
                    + sFirstName 
                    + " is that correct? \n"
                    + "Y or N");

        String sYesNo;
        sYesNo = sc.next().toUpperCase(); 
        
        if (sYesNo.equals("Y") || sYesNo.equals("N")){
            if (sYesNo.equals("Y") || sYesNo.equals("y")){
                monthlyRates.setFirstName(sFirstName);
                getSecondName();
            }else if (sYesNo.equals("N") || sYesNo.equals("n")) {
                getFirstName();
            }
        } else {
            System.out.println("Enter Y or N");   
            getFirstName();
        }//end of Yes No if 
    }// end of class 
    
    //get client name
    static void getSecondName(){
        String sSecondName = " ";
        System.out.println("\n"
                + "Please enter Client's surname");
        sSecondName = sc.next().toUpperCase();
        
        System.out.println("\n"
                    + "You wrote " 
                    + sSecondName 
                    + " is that correct? \n"
                    + "Y or N");
         
        String sYesNo;
        sYesNo = sc.next().toUpperCase(); 
        
        if (sYesNo.equals("Y") || sYesNo.equals("N")){
            if (sYesNo.equals("Y") || sYesNo.equals("y")){
                monthlyRates.setSecondName(sSecondName);
                getReference();
            }else if (sYesNo.equals("N") || sYesNo.equals("n")) {
                getSecondName();
            }
        } else {
            System.out.println("Enter Y or N");   
            getSecondName();
        }//end of Yes No if 
    } //end of get client name
    
    //reference, last letter must be B for business or N for non business
    static boolean getReference() {
        String sReference = " ";
        System.out.println("\n"
                + "Please enter a reference. \n" 
                + "First two must be letters, \n"
                + "third to fifth must be numbers, \n"
                + "finish with B for business users or \n"
                + "N for non-business users");
        
        sReference = sc.next().toUpperCase();
            // validation checking for reference
            while (!monthlyRates.isValidReference(sReference)){
                System.out.println ("Please check your reference \n");
                getReference();
            return false;             
                    
    }//end while loop 
            System.out.println ("\n"
                    + "your reference is " + sReference + "\n");
            monthlyRates.setReference(sReference);
            getContractLength();
            return true;
    }//close reference 
    
    static void getBusinessType() {
        char businessNonBusiness = monthlyRates.getReference().charAt(5);
        
        if(businessNonBusiness == 'b' || businessNonBusiness == 'B'){
            monthlyRates.setBusinessType("Business");
            }else if(businessNonBusiness == 'n' || businessNonBusiness == 'N'){
            monthlyRates.setBusinessType("Non business");
            }
    }
    
    //business or non business selector
    static void getContractLength() {
        char businessNonBusiness = monthlyRates.getReference().charAt(5);
        //business rates
        if(businessNonBusiness == 'b' || businessNonBusiness == 'B'){
            int businessAdjustment = 10;
            System.out.println("Please enter a number: \n"
                                + "1: 12 months \n"
                                + "2: 18 months \n"
                                + "3: 24 months \n");
            
            int iMinutes = sc.nextInt();
            if (iMinutes == 1){
                //small contract
                iMinutes = 12; 
                monthlyRates.setContractLength(iMinutes);
                monthlyRates.setBusinessAdjustment(businessAdjustment);
                System.out.println("12 months with a 10% discount \n");
                getMinutes();
            } else if (iMinutes == 2){
                iMinutes = 18; 
                monthlyRates.setContractLength(iMinutes);
                monthlyRates.setBusinessAdjustment(businessAdjustment);
                System.out.println("18 months with a 10% discount \n");
                getMinutes();
            } else if (iMinutes == 3){
                iMinutes = 24; 
                monthlyRates.setContractLength(iMinutes);
                monthlyRates.setBusinessAdjustment(businessAdjustment);
                System.out.println("24 months with a 10% discount \n");
                getMinutes();
            }else{
                System.out.println ("Incorrect value entered, must be between 1-3"); 
                getContractLength(); 
            }//end of business getContractLength
           
            
        // non business rates
        }else if (businessNonBusiness == 'n' || businessNonBusiness == 'N') {
            int businessAdjustment;
            System.out.println("Please enter a number: \n"
                + "1: 1 months \n"
                + "2: 12 months \n"
                + "3: 18 months \n"
                + "4: 24 months \n");

            int iMinutes = sc.nextInt();
            if (iMinutes == 1){
                //small contract
                iMinutes = 1; 
                monthlyRates.setContractLength(iMinutes);
                System.out.println("1 month contract");
                getMinutes();
            } else if (iMinutes == 2){
                iMinutes = 12; 
                businessAdjustment = 5;
                monthlyRates.setContractLength(iMinutes);
                monthlyRates.setBusinessAdjustment(businessAdjustment);
                System.out.println("12 months with a " + businessAdjustment + "% discount");
                getMinutes();
            } else if (iMinutes == 3){
                iMinutes = 18; 
                businessAdjustment = 5;
                monthlyRates.setContractLength(iMinutes);
                monthlyRates.setBusinessAdjustment(businessAdjustment);
                System.out.println("18 months with a " + businessAdjustment + "% discount");
                getMinutes();
            } else if (iMinutes == 4){
                iMinutes = 24; 
                businessAdjustment = 10;
                monthlyRates.setContractLength(iMinutes);
                monthlyRates.setBusinessAdjustment(businessAdjustment);
                System.out.println("24 months with a " + businessAdjustment + "% discount");
                getMinutes();
            }else{
                System.out.println ("Incorrect value entered, must be between 1-4"); 
                getContractLength(); 
            }//end of non business getContractLength
        }          
    }
    
    //inclusive minutes
    static void getMinutes(){
            String sMinsInput ="";
            System.out.println ("Please enter a number: \n"
                                + "1: Small 300 minutes \n"
                                + "2: Medium 600 minutes \n"
                                + "3: Large 1200 minutes \n");
                                
            int iPackage = sc.nextInt();
            //sMinsInput = sMinsInput.toLowerCase(); 

            if (iPackage == 1){
                //small contract
                sMinsInput = "small"; 
                monthlyRates.setPackage(sMinsInput);
                System.out.println("small \n");
                getInternationalCalls();
            }
            else if (iPackage == 2){
                sMinsInput = "medium";
                monthlyRates.setPackage(sMinsInput);
                System.out.println("medium \n");
                getInternationalCalls();
            }
            else if (iPackage == 3) {
                sMinsInput = "large"; 
                monthlyRates.setPackage(sMinsInput);
                System.out.println("large \n");
                getInternationalCalls();
            }else{
                //rerun module
                System.out.println ("Incorrect value entered, must be between 1-3"); 
                getMinutes(); 
            }//end of if else 
        System.out.print(sMinsInput);
        }; //end of get minutes
    
    //boolean check to see if they are included 
    static boolean getInternationalCalls() {
        char cYN = ' ';
        int intCallsAdjustment = 15;
        System.out.println("Would you like international calls? Y or N \n"
                            + "1. Yes \n"
                            + "2. No \n");
        cYN = sc.next().charAt(0); 
        boolean validFlag = false;   
        
        if (cYN != 'Y' && cYN != 'N' && cYN != 'y' && cYN != 'n')
        {
            validFlag = false;
            System.out.println ("Enter Y or N only");
            getInternationalCalls();
        }
        else if (cYN == 'N' || cYN =='n') 
        {
            validFlag = false;
            System.out.println ("Internation calls have not been added \n");
            getDataBundle();
        }else {
            validFlag = true;
            monthlyRates.setIntCallsAdjustment(intCallsAdjustment);
            monthlyRates.setsInternationalCalls("Yes ");
            System.out.println ("Internation calls have been added \n");      
            getDataBundle();
        }
              return true;
    }
    
    static void getDataBundle(){
            String sDataInput ="";
            System.out.println ("Enter required Data: \n"
                                + "1: 1GB \n"
                                + "2: 4GB \n"
                                + "3: 8GB \n"
                                + "4: Unlimited \n");
                                //some validation will need entering 
            int iPackage = sc.nextInt();

            if (iPackage == 1){
                //small contract
                sDataInput = "1Gb"; 
                monthlyRates.setDataBundle(sDataInput);
                System.out.println("1GB selected \n");
                confirmDetails();
                }else if (iPackage == 2){
                    sDataInput = "4GB";
                    monthlyRates.setPackage(sDataInput);
                    System.out.println("4GB selected \n");
                    confirmDetails();
                }else if (iPackage == 3) {
                    sDataInput = "8GB"; 
                    monthlyRates.setPackage(sDataInput);
                    System.out.println("8GB selected \n");
                    confirmDetails();
                }else if (iPackage == 4) {
                    sDataInput = "Unlimited"; 
                    monthlyRates.setPackage(sDataInput);
                    System.out.println("Unlimited selected \n");
                    confirmDetails();
            }else{
                //rerun module
                System.out.println ("Incorrect value entered, must be between 1-3"); 
                getMinutes(); 
            }//end of if else 
        System.out.print(sDataInput);
        }; //end of get minutes
    
    public static String getDate() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
    return sdf.format(cal.getTime());
    }
    
    public int iTotalPerMonth() {
    int iTotalPerMonth = 0;
        if (monthlyRates.getPackage().equals("small") && monthlyRates.getDataBundle().equals("1GB")){
            iTotalPerMonth = 500;
            monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage().equals("small") && monthlyRates.getDataBundle().equals("4GB")){
                iTotalPerMonth = 700;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage().equals("small") && monthlyRates.getDataBundle().equals("8GB")){
                iTotalPerMonth = 900;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage().equals("medium") && monthlyRates.getDataBundle().equals("1GB")){
                iTotalPerMonth = 650;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage().equals("medium") && monthlyRates.getDataBundle().equals("4GB")){
                iTotalPerMonth = 850;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage().equals("medium") && monthlyRates.getDataBundle().equals("8GB")){
                iTotalPerMonth = 1050;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage().equals("large") && monthlyRates.getDataBundle().equals("1GB")){
                iTotalPerMonth = 850;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage().equals("large") && monthlyRates.getDataBundle().equals("4GB")){
                iTotalPerMonth = 1050;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage().equals("large") && monthlyRates.getDataBundle().equals("8GB")){
                iTotalPerMonth = 1250;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            } else if (monthlyRates.getPackage().equals("large") && monthlyRates.getDataBundle().equals("unlimited")){
                iTotalPerMonth = 2000;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }
        return iTotalPerMonth;
    }
            
    static void confirmDetails() {

        String sAlignLeft = "| %10s %-1s %-29s | \r\n";
        String sAlign1 = "| %10s %-12.12s %-5s %12s | \r\n";
        String sAlign2 = "| %10s %-12.12s %-5s %12s | \r\n";
        String sAlign3 = "| %10s %-12.12s %-5s %12s | \r\n";
        String sAlignCentre = "";        
        String sFiller = ("|                                            | \n");
        
        int iWidth = sFiller.length();
            //testing System.out.println(iWidth);
        int iPadding = iWidth - 34;
            //testing System.out.println(iPadding);
        int iPadStart = iPadding/2;
            //testing System.out.println(iPadStart);
        
        sAlignCentre = String.format("|%" + iPadding + "s","%-" + iPadding  + "s %1s \n");
        
        System.out.println("\n");
        System.out.format("+--------------------------------------------+\n");
        System.out.print(sFiller);
        System.out.format(sAlignLeft,"Name:",monthlyRates.getFirstName().charAt(0),monthlyRates.getSecondName());
        System.out.print(sFiller);
        System.out.format(sAlign1,"Ref:",monthlyRates.getReference(),"Date:",getDate());
        System.out.format(sAlign2,"Package:",monthlyRates.getPackage(),"Data:",monthlyRates.getDataBundle());    
        System.out.format(sAlign3,"Period:",monthlyRates.getContractLength(),"Type:",monthlyRates.getBusinessType());    
        System.out.print(sFiller);
            if (monthlyRates.businessAdjustment == null){
                String sAlign4 = "| %29s %-12s | \r\n";
                System.out.format(sAlign4,"Intl. Calls:",monthlyRates.getsInternationallCalls());    
            }else if (monthlyRates.businessAdjustment != null){
                String sAlign4 = "| %10s %-12.12s %-5s %12s | \r\n";
                System.out.format(sAlign4,"Discount:",monthlyRates.businessAdjustment," " ,"Intl. Calls:",monthlyRates.getsInternationallCalls()," ");    
            }
        System.out.print(sFiller);
        System.out.format(sAlignCentre,"Discounted Monthly Charge: ","£",monthlyRates.getCostPerMonth());
        System.out.println("+--------------------------------------------+");

    }   
    
    static void displaySummary() {
        int iChoice = 0; 
        System.out.println("\n-- Please choose one of the following:  --\n"
            + "1. Read from Archive \n"
            + "2. Read from Contracts \n"
            + "0. Back to main menu \n" );
        iChoice = sc.nextInt();
            if (iChoice == 1){ 
                readFromArchive();
            }
                else if (iChoice == 2){
                    readFromContract();
                } 
                else if (iChoice == 0) {
                    welcome();
                }
            else {
            System.out.println("Enter number 1, 2 or 0");
            displaySummary();
            }     
                
    }
    
    static void readFromArchive(){
        System.out.println("\nTotal number of contracts: " + monthlyRates.readFromArchive() + " \n"
            + "Contracts with High or Unlimited data bundles: \n"
            + "Average charge for large packages: £");
    }
    static void readFromContract(){
        System.out.println("Total number of contracts: \n"
            + "Contracts with High or Unlimited data bundles: " + monthlyRates.readFromArchive() + " \n"
            + "Average charge for large packages: £");
    }
    
    
}// end of program 
