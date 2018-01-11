/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Duncan Skilton
 */

public class monthlyRates {
    //instance variables
    String _FirstName;
    String _SecondName;
    String _Reference;
    String _BusinessType;
    String _Package;
    String _DataBundle;
    String _sInternationalCalls;
    int _ContractLength;
    Boolean _InternationalCalls;
    int _BusinessAdjustment;
    int _IntCallsAdjustment;
    int _CostPerMonth;

    public monthlyRates() {
    _FirstName = "";
    _SecondName = "";
    _Package = "";
    _DataBundle = "";
    _Reference = "";
    _BusinessType = "";
    _ContractLength = 0;
    _InternationalCalls = false;
    _sInternationalCalls = "No";
    _BusinessAdjustment = 0;
    _IntCallsAdjustment = 0;
    _CostPerMonth = 0;
    }// end of Constructors

    public int getCostPerMonth(){
        return _CostPerMonth;
    }

    public void setCostPerMonth(int CostPerMonth){
        this._CostPerMonth = CostPerMonth;
    }
    public int getBusinessAdjustment(){
        return _BusinessAdjustment;
    }

    public void setBusinessAdjustment(int BusinessAdjustment){
        this._BusinessAdjustment = BusinessAdjustment;
    }

    public String businessAdjustment;{
        if (businessAdjustment != ""){
        System.out.print(_BusinessAdjustment);
        }
    };

    public int getIntCallsAdjustment(){
        return _IntCallsAdjustment;
    }

    public void setIntCallsAdjustment(int IntCallsAdjustment){
        this._IntCallsAdjustment = IntCallsAdjustment;
    }
    public boolean getInternationalCalls(){
        return _InternationalCalls;
    }

    public void setInternationalCalls(Boolean InternationalCalls){
        this._InternationalCalls = InternationalCalls;
    }

    public void setsInternationalCalls(String sInternationalCalls){
        this._sInternationalCalls = sInternationalCalls;
    }

    public String getsInternationallCalls(){
        return _sInternationalCalls;
    }

    public String getReference(){
        return _Reference;
    }

    public void setReference(String Reference){
        this._Reference = Reference;
    }

    public String getBusinessType(){
        return _BusinessType;
    }

    public void setBusinessType(String BusinessType){
        this._BusinessType = BusinessType;
    }

    public String getPackage() {
        return _Package;
    }
    public void setPackage(String Package) {
        this._Package = Package;
    }

    public String getDataBundle() {
        return _DataBundle;
    }
    public void setDataBundle(String DataBundle) {
        this._DataBundle = DataBundle;
    }

    public String getFirstName(){
        return _FirstName;
    }
    public void setFirstName(String FirstName){
        this._FirstName = FirstName;
    }

    public String getSecondName(){
        return _SecondName;
    }
    public void setSecondName(String SecondName){
        this._SecondName = SecondName;
    }

    public int getContractLength(){
        return _ContractLength;
    }
    public void setContractLength(int ContractLength){
        this._ContractLength = ContractLength;
    }

    public boolean isValidReference (String Ref){
    boolean validFlag = true;
    if (Ref.length() != 6 )
    {
        validFlag = false;
        System.out.println ("Too Many/Too Few Characters");
    }
    else if (!Character.isLetter(Ref.charAt(0)) || !Character.isLetter(Ref.charAt(1)) || !Character.isDigit(Ref.charAt(2)) ||
            !Character.isDigit(Ref.charAt(3)) || !Character.isDigit(Ref.charAt(4)) || !Character.isLetter(Ref.charAt(5))){
        validFlag = false;
        System.out.println ("Incorrect format");
    }
    else if (Ref.charAt(Ref.length() - 1) == 'B' && Ref.charAt(Ref.length() - 1) == 'N'){
        validFlag = false;
        System.out.println ("Last character must be N or B");
    }
    return validFlag;
    } // end of class

    public static char isValidName (char cName){
        boolean validFlag = true;
        if (cName != 'Y' && cName != 'N')
        {
            validFlag = false;
            System.out.println ("Enter Y or N only");
        }
        else if (cName == 'N')
        {
            validFlag = false;
            System.out.println ("Please enter correct name");
        }
            return 0;
        } // end of class

    /*
    public int checkFileArchive() {
        // check directory java is using
        // System.out.println(System.getProperty("user.dir"));
        // The name of the file to open.
        String sFile = "archive.txt";

        // This will read one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader archive = new FileReader(sFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bReader = new BufferedReader(archive);

            while((line = bReader.readLine()) != null) {
            }

            // Always close files.
            bReader.close();
        }
        catch(FileNotFoundException e) {
            System.out.println(
                "Unable to open file '" +
                sFile + "'");
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"
                + sFile + "'");
        }
        return 0;
    }
*/

    public int readFromArchive(){
    String sFile = "archive.txt";
    int iLines = 0;

        try {
            FileReader archive = new FileReader(sFile);

            BufferedReader bReader = new BufferedReader(archive);

            while (bReader.readLine() != null) iLines++;
            bReader.close();
            }

        catch(FileNotFoundException e) {
            System.out.println( "Unable to open file '" + sFile + "'");
        } catch(IOException ex) {
            System.out.println( "Error reading file '" + sFile + "'");
            }
    return iLines;
    }

    public static final String fileNameContracts = "Contracts.txt";

    static void writeToFileContracts() {
        BufferedWriter bReader = null;
        FileWriter fWriter = null;

        try {
        String content = "***This is the content to write to file***";

        fWriter = new FileWriter(fileNameContracts);
        bReader = new BufferedWriter(fWriter);
        bReader.write(content);

        System.out.println("***Confirm information which has been written to file");

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (bReader != null)
                    bReader.close();

                if (fWriter != null)
                    fWriter.close();

            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

public int fileSearch() {
    String sFile = "archive.txt";
    int iSearch = 0;
    String sLine = "";
    int iIndex = 0;

    String[] cDate = new String[11];
    int[] cMinutes = new int[1];
    int[] cData = new int [1];
    int[] cLength = new int [2];
    boolean[] cIntCalls = new boolean[1];
    String[] cReference = new String[6];
    int[] cCostPerMonth = new int[5];
    String[] cFirstName = new String[20];
    String[] cSecondName = new String[20];

    try {
        FileReader archive = new FileReader(sFile);
        BufferedReader bReader = new BufferedReader(archive);

        while ((sLine = bReader.readLine()) != null) {}
            String temp= "" ;
            int iCount= 1 ;
            cSecondName[iIndex]="";
                StringTokenizer st = new StringTokenizer(sLine," ");
    }

        catch(FileNotFoundException e) {
        System.out.println( "Unable to open file '" + sFile + "'");
        }catch(IOException ex) {
        System.out.println( "Error reading file '" + sFile + "'");
        }
    return iSearch;
}


} // end of program