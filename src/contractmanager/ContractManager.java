/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;
import java.util.Scanner;
import java.util.Calendar;
import java.util.InputMismatchException;
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
        //getFirstName();
        //getSecondName();
        //getReference(); 
        //getInternationalCalls();
        //getMinutes(); 
        //getDataBundle(); 
        //getContractLength(); 
        //confirmDetails();
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
        try{
            if (iChoice == 1){ 
                getFirstName();
                }else if (iChoice == 2){
                    displaySummary(); 
                }else if (iChoice == 3){
                    selectedMonthSummary();
                }else if (iChoice ==4) {
                    searchReferenceAndName();
                }else if (iChoice == 0) {
                    System.exit(0);
            // initial attempt at error checking. Doesn't work for letters
            }else if (iChoice != 1-3 && iChoice !=0){
                System.out.println("Enter number between 1 and 3");
                welcome();
            }        
        }
        //2nd attempt at catching text being entered rather than a number. Does not work for letters
        catch (InputMismatchException e){
            sc.next();
            System.out.println("Please enter numbers between 1-3 or 0 to exit");
            welcome();
        }
}//end of class

    //get client name 
    static void getFirstName() {
        String sFirstName = " ";
        System.out.println("Please enter Client's first name"); 
        // user can check their own input 
        sFirstName = sc.next().toUpperCase();
        System.out.println("\n"
                    + "You wrote " 
                    + sFirstName 
                    + " is that correct? \n"
                    + "Y or N");

        String sYesNo;
        sYesNo = sc.next().toUpperCase(); 
        // simple logic check 
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
        // no need to worry about lower case y or n but put them in logic just in case
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
        //charAt(5) is the last entry of the reference. It can only be a B, b or N, n
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
                // initially had these entries as strings but when came to writing to file,
                // it was much easier and space saving to use int. 
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
                // simple validation check. Doesn't work with letters 
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
            int iMinsInput = 0;
            System.out.println ("Please enter a number: \n"
                                + "1: Small 300 minutes \n"
                                + "2: Medium 600 minutes \n"
                                + "3: Large 1200 minutes \n");
                                
            int iPackage = sc.nextInt();
            //sMinsInput = sMinsInput.toLowerCase(); 

            if (iPackage == 1){
                //small contract
                iMinsInput = 1; 
                monthlyRates.setPackage(iMinsInput);
                System.out.println("small \n");
                getInternationalCalls();
            }
            else if (iPackage == 2){
                iMinsInput = 2;
                monthlyRates.setPackage(iMinsInput);
                System.out.println("medium \n");
                getInternationalCalls();
            }
            else if (iPackage == 3) {
                iMinsInput = 3; 
                monthlyRates.setPackage(iMinsInput);
                System.out.println("large \n");
                getInternationalCalls();
            }else{
                //rerun module
                System.out.println ("Incorrect value entered, must be between 1-3"); 
                getMinutes(); 
            }//end of if else 
        }; //end of get minutes
    
    //boolean check to see if they are included 
    static boolean getInternationalCalls() {
        char cYN = ' ';
        //adds 15% to bill rather than deducting it
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
            System.out.println ("International calls have not been added \n");
            getDataBundle();
        }else {
            validFlag = true;
            monthlyRates.setIntCallsAdjustment(intCallsAdjustment);
            monthlyRates.setsInternationalCalls("Yes ");
            System.out.println ("International calls have been added \n");      
            getDataBundle();
        }
              return true;
    }
    
    static void getDataBundle(){
            int iDataInput = 0;
            System.out.println ("Enter required Data: \n"
                                + "1: 1GB \n"
                                + "2: 4GB \n"
                                + "3: 8GB \n"
                                + "4: Unlimited \n");
                                //some validation will need entering 
            int iPackage = sc.nextInt();

            if (iPackage == 1){
                iDataInput = 1; 
                monthlyRates.setDataBundle(iDataInput);
                System.out.println("1GB selected \n");
                confirmDetails();
                }else if (iPackage == 2){
                    iDataInput = 2;
                    monthlyRates.setDataBundle(iDataInput);
                    System.out.println("4GB selected \n");
                    confirmDetails();
                }else if (iPackage == 3) {
                    iDataInput = 3; 
                    monthlyRates.setDataBundle(iDataInput);
                    System.out.println("8GB selected \n");
                    confirmDetails();
                }else if (iPackage == 4) {
                    iDataInput = 4; 
                    monthlyRates.setDataBundle(iDataInput);
                    System.out.println("Unlimited selected \n");
                    confirmDetails();
            }else{
                //rerun module
                System.out.println ("Incorrect value entered, must be between 1-3"); 
                getMinutes(); 
            }//end of if else 
        System.out.print(iDataInput);
        }; //end of get minutes
    
    public static String getDate() {
    String getDate;
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
    getDate = sdf.format(cal.getTime());
    // added getter and setter to make the date easier to use elsewhere 
    monthlyRates.setDate(getDate);
    return sdf.format(cal.getTime());
    }
    
    public int iTotalPerMonth() {
    int iTotalPerMonth = 0;
        if (monthlyRates.getPackage() == 1 && monthlyRates.getDataBundle() == 1){
            iTotalPerMonth = 500;
            monthlyRates.setCostPerMonth(iTotalPerMonth);
        }else if(monthlyRates.getPackage() == 1 && monthlyRates.getDataBundle() == 2){
                iTotalPerMonth = 700;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage() == 1 && monthlyRates.getDataBundle() == 3){
                iTotalPerMonth = 900;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage()== 2 && monthlyRates.getDataBundle() == 1){
                iTotalPerMonth = 650;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage()== 2 && monthlyRates.getDataBundle() == 2){
                iTotalPerMonth = 850;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage()== 2 && monthlyRates.getDataBundle() == 3){
                iTotalPerMonth = 1050;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage()== 3 && monthlyRates.getDataBundle() == 1){
                iTotalPerMonth = 850;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage()== 3 && monthlyRates.getDataBundle() == 2){
                iTotalPerMonth = 1050;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }else if (monthlyRates.getPackage()== 3 && monthlyRates.getDataBundle() == 3){
                iTotalPerMonth = 1250;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            } else if (monthlyRates.getPackage()== 3 && monthlyRates.getDataBundle() == 4){
                iTotalPerMonth = 2000;
                monthlyRates.setCostPerMonth(iTotalPerMonth);
            }
        return iTotalPerMonth;
    }
            
    static void confirmDetails() {

        String sAlignLeft = "| %10s %-1s %-29s | \r\n";
        String sAlign1 = "| %10s %-12.12s %-5s %-12s | \r\n";
        String sAlign2 = "| %10s %-12.12s %-5s %-12s | \r\n";
        String sAlign3 = "| %10s %-12.12s %-5s %-12s | \r\n";
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
        System.out.print(sFiller);
        System.out.println("+--------------------------------------------+");
        monthlyRates.writeToFileContracts();
        System.out.println("\n");
        
        welcome();     
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
                } else if (iChoice == 2){
                    readFromContract();
                }else if (iChoice == 0) {
                    welcome();
            } else {
            System.out.println("Enter number 1, 2 or 0");
            displaySummary();
            }       
        displaySummary();
    }
    
    static void readFromArchive(){
        System.out.println("\nTotal number of contracts: " + monthlyRates.readFromArchive() + "\n"
                        + "Contracts with High or Unlimited data bundles:" + monthlyRates.highUnlimitedArchive());
        // simple string and floating point formatting
        System.out.format("Average charge for large packages: £%.2f ", monthlyRates.avgChargeArchive()/100);
        // separate method for ease and code readability. 
        monthlyRates.contractsPerMonthArchive();
    }
    
    static void readFromContract(){
        System.out.println("\nTotal number of contracts: " + monthlyRates.readFromContracts() + "\n"
                        + "Contracts with High or Unlimited data bundles:" + monthlyRates.highUnlimitedContracts());
        System.out.format("Average charge for large packages: £%.2f ", monthlyRates.avgChargeContracts()/100);
        monthlyRates.contractsPerMonthContracts();
    }
    
    static void selectedMonthSummary(){
        String sMonth = "";
        String sMonthCapital = "";
        int iChoice = 0; 
        System.out.print("\n");
        System.out.println("\nPlease enter the first three letters\n"
                        + "of the month you wish to search \n");
        
        sMonth = sc.next();
        // this takes the first Char and makes it upper case while the remaining letters and lower case

        sMonthCapital = sMonth.substring(0, 1).toUpperCase() + sMonth.substring(1);
        //System.out.println(sMonthCapital); Testing
        monthlyRates.setMonth(sMonthCapital);
        
        //with the above validation, I was able to make this if statement, much cleaner than having to write it twice
        //for lower case and upper case
        if (!sMonthCapital.equals("Jan") && !sMonthCapital.equals("Feb")  && !sMonthCapital.equals("Mar") && !sMonthCapital.equals("Apr") && !sMonthCapital.equals("May")
                && !sMonthCapital.equals("Jun") && !sMonthCapital.equals("Jul") && !sMonthCapital.equals("Aug") && !sMonthCapital.equals("Sep")
                && !sMonthCapital.equals("Oct")  && !sMonthCapital.equals("Nov") && !sMonthCapital.equals("Dec")){
            System.out.println("That is not a valid entry. Please try again \n"
                    + "for example: Jan, Feb, Mar, Apr etc ");
            selectedMonthSummary();
        }
        System.out.println("\nyou chose " + sMonthCapital + "\n");

        System.out.println("\nwhich file would you like to read from? \n"
            + "1. Read from Archive \n"
            + "2. Read from Contracts \n"
            + "0. Back to main menu \n" );
        iChoice = sc.nextInt();
        if (iChoice == 1){ 
            //realised I can use getters and setters to specify which txt file to read from. This will make future
            //code a lot shorter and neater. Won't need to write two methods for each archive and contracts
            monthlyRates.readFromArchiveSummary();
            System.out.println("\nTotal number of contracts: " + monthlyRates.readFromArchiveSummary() + "\n"
                + "Contracts with High or Unlimited data bundles:" + monthlyRates.highUnlimitedMonth());
            System.out.format("Average charge for large packages: £%.2f ", monthlyRates.averageChargeArchiveMonth()/100);
            selectedMonthSummary();
            }else if (iChoice == 2){
                monthlyRates.readFromContractsSummary();
                System.out.println("\nTotal number of contracts: " + monthlyRates.readFromContractsSummary() + "\n"
                    + "Contracts with High or Unlimited data bundles:" + monthlyRates.highUnlimitedMonthC());
                System.out.format("Average charge for large packages: £%.2f ", monthlyRates.averageChargeContractsMonth()/100);
                selectedMonthSummary();
            }else if (iChoice == 0) {
                    welcome();
        }else{
            System.out.println("Enter number 1, 2 or 0");
            selectedMonthSummary();
        }
    
    }
    
    static void searchReferenceAndName() {
        String sInput = "";
        String sSearch = "";
        int iChoice = 0; 
        System.out.println("\nPlease enter text or numbers to search\n");

        sInput = sc.next();
        // Reference are stored as upper case. The search string in class monthlyRates converts the string to upper case
        sSearch = sInput.toUpperCase();
        monthlyRates.setSearch(sSearch);
        
        System.out.println("\nyou entered " + sSearch + "\n");
        System.out.println("\nwhich file would you like to read from? \n"
            + "1. Read from Archive \n"
            + "2. Read from Contracts \n"
            + "0. Back to main menu \n" );
        
        iChoice = sc.nextInt();
        if (iChoice == 1){ 
            monthlyRates.setReadFrom("archive.txt");
            System.out.println("\nTotal number of contracts: " + monthlyRates.readFromInputSummary() + "\n"
                + "Contracts with High or Unlimited data bundles:" + monthlyRates.highUnlimitedMonthInput());
            System.out.format("Average charge for large packages: £%.2f ", monthlyRates.averageChargeInput()/100);
            System.out.println("\n");
            searchReferenceAndName();
            }else if (iChoice == 2){
                monthlyRates.setReadFrom("contracts.txt");
                System.out.println("\nTotal number of contracts: " + monthlyRates.readFromInputSummary() + "\n"
                    + "Contracts with High or Unlimited data bundles:" + monthlyRates.highUnlimitedMonthC());
                System.out.format("Average charge for large packages: £%.2f ", monthlyRates.averageChargeContractsMonth()/100);
                System.out.println("\n");
                searchReferenceAndName();
            }else if (iChoice == 0) {
                    welcome();
        }else{
            System.out.println("Enter number 1, 2 or 0");
            System.out.println("\n");
            selectedMonthSummary();
            }
    }
    
}// end of program 
