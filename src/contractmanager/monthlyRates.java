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
import java.util.Scanner;
import java.util.Collections;


/**
 *
 * @author Duncan Skilton
 */

public class monthlyRates {
    //instance variables
    String _FirstName, _SecondName, _Reference, _BusinessType, _sInternationalCalls, _Date, _Month, _Search, _ReadFrom;
    int _ContractLength, _BusinessAdjustment, _IntCallsAdjustment, _CostPerMonth, _TotalPolicies, _HighUnlimited, _Package, _DataBundle;
    Boolean _InternationalCalls;

    public monthlyRates() {
    _Month = "";
    _Date = "";
    _FirstName = "";
    _SecondName = "";
    _Reference = "";
    _BusinessType = "";
    _DataBundle = 0;
    _Package = 0;
    _ContractLength = 0;
    _InternationalCalls = false;
    _sInternationalCalls = "No";
    _BusinessAdjustment = 0;
    _IntCallsAdjustment = 0;
    _CostPerMonth = 0;
    _TotalPolicies = 0;
    _HighUnlimited = 0;
    
    }// end of Constructors
    
    public String getReadFrom(){
        return _ReadFrom;
    }
    public void setReadFrom(String ReadFrom){
        this._ReadFrom = ReadFrom;
    }
    
    public String getSearch(){
        return _Search;
    }
    public void setSearch(String Search){
        this._Search = Search;
    }
    
    public String getMonth(){
        return _Month;
    }
    public void setMonth(String Month){
        this._Month = Month;
    }
    
    public int getDataBundle() {
        return _DataBundle;
    }
    public void setDataBundle(int DataBundle) {
        this._DataBundle = DataBundle;
    }
    
    public int getPackage() {
        return _Package;
    }
    public void setPackage(int Package) {
        this._Package = Package;
    }
    
    public int getHighUnlimited(){
        return _HighUnlimited;
    }
    public void setHighUnlimited(int HighUnlimited){
        this._HighUnlimited = HighUnlimited;
    }
    
    public int getTotalPolicies(){
        return _TotalPolicies;
    }
    public void setTotalPolicies(int TotalPolicies){
        this._TotalPolicies = TotalPolicies;
    }
    
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

    public String getDate(){
        return _Date;
    }
    public void setDate(String Date){
        this._Date = Date;
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

    /* check to see the director of a file and read it's contents
    public int checkFileArchive() {
        // check directory java is using
        // System.out.println(System.getProperty("user.dir"));
        // The name of the file to open.
        String sFile = "contracts.txt";

        // This will read one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader contracts = new FileReader(sFile);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bReader = new BufferedReader(contracts);

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
            FileReader contracts = new FileReader(sFile);
            BufferedReader bReader = new BufferedReader(contracts);

            while (bReader.readLine() != null){
            iLines++;
            }
        }
        
        catch(FileNotFoundException e) {
            System.out.println( "Unable to open file '" + sFile + "'");
        } catch(IOException ex) {
            System.out.println( "Error reading file '" + sFile + "'");
            }
    return iLines;
    }

    public static final String fileNameContracts = "Contracts.txt";

    public void writeToFileContracts(){
        BufferedWriter bReader = null;
        FileWriter fWriter = null;

        try {
        String content = (getDate() + " " + getPackage() + " " + getDataBundle() + " " + getContractLength() 
                + " " + getInternationalCalls() + " " + getReference() + " " + getCostPerMonth() 
                + " " + getFirstName() + " " + getSecondName());

        fWriter = new FileWriter(fileNameContracts);
        bReader = new BufferedWriter(fWriter);
        bReader.write(content);

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

    public int fileSearchArchive(){
    int iTotalPolicies = 0;
    Scanner input = new Scanner(System.in);  
    input = new Scanner ("contracts.txt");

        while (input.hasNext()){
            iTotalPolicies = iTotalPolicies + 1;
            setTotalPolicies(iTotalPolicies);
            input.nextLine(); 
        }
    return iTotalPolicies;
    }
    
    public int highUnlimitedArchive() {
    //String[] characters = new String[1024];
    int iHighUnlimited = 0; 
    
    String array;
    String sMinutes;     
    int cMinutes;
    
    try {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader("Archive.txt"));

        int i = 0;
        while ((sCurrentLine = br.readLine()) != null) {
            String[] arr = sCurrentLine.split("\\s+");
            array = arr[0];
            sMinutes = arr[2];
            cMinutes = Integer.parseInt(sMinutes);
                if (cMinutes == 3 || cMinutes == 4){
                iHighUnlimited = iHighUnlimited + 1;
                }
            i++;
        }
    } 
    catch (IOException e) {
        e.printStackTrace();
        }
        return iHighUnlimited;
    }
    
    public float avgChargeArchive() {
    int iAvgCharge = 0; 
    float iTotal = 0;
    int iCostPerMonth, iMinutes;    
    String array, sCostPerMonth, sMinutes; 
            
    try {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader("Archive.txt"));
        int i = 0;
        int iCount = 0;
        
        while ((sCurrentLine = br.readLine()) != null) {
            String[] arr = sCurrentLine.split("\\s+");
            array = arr[0];
            sMinutes = arr[1];
                iMinutes = Integer.parseInt(sMinutes);
            sCostPerMonth = arr[6];
                iCostPerMonth = Integer.parseInt(sCostPerMonth);
        
                    if (iMinutes == 3) {
                        iAvgCharge = iAvgCharge + iCostPerMonth;
                        iCount++;
                    }
            i++;
        } 
        iTotal = iAvgCharge/iCount;
    } 
    catch (IOException e) {
        e.printStackTrace();
        }
        return iTotal;
    }
    
    public void contractsPerMonthArchive() {
        int iJan = 0;
        int iFeb = 0;
        int iMar = 0;
        int iApr = 0;
        int iMay = 0;
        int iJun = 0;
        int iJul = 0;
        int iAug = 0;
        int iSep = 0;
        int iOct = 0;
        int iNov = 0;
        int iDec = 0;
        String array; 
        
        System.out.println("\n");
        try {
            String sCurrentLine;
            BufferedReader br = new BufferedReader(new FileReader("Archive.txt"));
            
            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                String clean; 
                clean = array.replaceAll("[0-9-]", "" );
                
                if ("Jan".contains(clean)) {
                        iJan++;
                    }else if ("Feb".contains(clean)){
                        iFeb++;
                    }else if ("Mar".equals(clean)) {
                        iMar++;
                    }else if ("Apr".equals(clean)) {
                        iApr++;
                    }else if ("May".equals(clean)) {
                        iMay++;
                    }else if ("Jun".equals(clean)) {
                        iJun++;
                    }else if ("Jul".equals(clean)) {
                        iJul++;
                    }else if ("Aug".equals(clean)) {
                        iAug++;
                    }else if ("Sep".equals(clean)) {
                        iSep++;
                    }else if ("Oct".equals(clean)) {
                        iOct++;
                    }else if ("Nov".equals(clean)) {
                        iNov++;
                    }else if ("Dec".equals(clean)) {
                        iDec++;
                    } 
                    {i++;
                    }
            }
        String sAlignMonths = "%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s \r\n";
        String sAlignCount = "%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s \r\n";;
        
        System.out.format(sAlignMonths,"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        System.out.format(sAlignCount, iJan,  iFeb,  iMar,  iApr,  iMay,  iJun,  iJul,  iAug,  iSep,  iOct,  iNov,  iDec);
        } 
        catch (IOException e) {
            e.printStackTrace();
            }
    }
    
    public int fileSearchContracts(){
    int iTotalPolicies = 0;
    Scanner input = new Scanner(System.in);  
    input = new Scanner ("contracts.txt");

        while (input.hasNext()){
            iTotalPolicies = iTotalPolicies + 1;
            setTotalPolicies(iTotalPolicies);
            input.nextLine(); 
        }
    return iTotalPolicies;
    }
    
    public int highUnlimitedContracts() {
    int iHighUnlimited = 0; 
    String array;
    String sMinutes;       
    int cMinutes;       
        
    try {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader("contracts.txt"));

        int i = 0;
        while ((sCurrentLine = br.readLine()) != null) {
            String[] arr = sCurrentLine.split("\\s+");
            
            array = arr[0];
            sMinutes = arr[2];
            cMinutes = Integer.parseInt(sMinutes);
                if (cMinutes == 3 || cMinutes == 4){
                iHighUnlimited = iHighUnlimited + 1;
                }
            i++;
        }
    } 
    catch (IOException e) {
        e.printStackTrace();
        }
        return iHighUnlimited;
    }
    
    public float avgChargeContracts() {
    int iAvgCharge = 0; 
    float iTotal = 0;
    int iCostPerMonth, iMinutes;    
    String array, sCostPerMonth, sMinutes; 
            
    try {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader("contracts.txt"));
        int i = 0;
        int iCount = 0;
        
        while ((sCurrentLine = br.readLine()) != null) {
            String[] arr = sCurrentLine.split("\\s+");
            array = arr[0];
            sMinutes = arr[1];
                iMinutes = Integer.parseInt(sMinutes);
            sCostPerMonth = arr[6];
                iCostPerMonth = Integer.parseInt(sCostPerMonth);
        
                    if (iMinutes == 3) {
                        iAvgCharge = iAvgCharge + iCostPerMonth;
                        iCount++;
                    }
            i++;
        } 
        iTotal = iAvgCharge/iCount;
    } 
    catch (IOException e) {
        e.printStackTrace();
        }
        return iTotal;
    }
    
    public void contractsPerMonthContracts() {
        int iJan = 0;
        int iFeb = 0;
        int iMar = 0;
        int iApr = 0;
        int iMay = 0;
        int iJun = 0;
        int iJul = 0;
        int iAug = 0;
        int iSep = 0;
        int iOct = 0;
        int iNov = 0;
        int iDec = 0;
        String array; 
        
        System.out.println("\n");
        try {
            String sCurrentLine;
            BufferedReader br = new BufferedReader(new FileReader("contracts.txt"));
            
            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                String clean; 
                clean = array.replaceAll("[0-9-]", "" );
                
                if ("Jan".contains(clean)) {
                        iJan++;
                    }else if ("Feb".contains(clean)){
                        iFeb++;
                    }else if ("Mar".equals(clean)) {
                        iMar++;
                    }else if ("Apr".equals(clean)) {
                        iApr++;
                    }else if ("May".equals(clean)) {
                        iMay++;
                    }else if ("Jun".equals(clean)) {
                        iJun++;
                    }else if ("Jul".equals(clean)) {
                        iJul++;
                    }else if ("Aug".equals(clean)) {
                        iAug++;
                    }else if ("Sep".equals(clean)) {
                        iSep++;
                    }else if ("Oct".equals(clean)) {
                        iOct++;
                    }else if ("Nov".equals(clean)) {
                        iNov++;
                    }else if ("Dec".equals(clean)) {
                        iDec++;
                    } 
                    {i++;
                    }
            }
        String sAlignMonths = "%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s \r\n";
        String sAlignCount = "%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s \r\n";;
        
        System.out.format(sAlignMonths,"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        System.out.format(sAlignCount, iJan,  iFeb,  iMar,  iApr,  iMay,  iJun,  iJul,  iAug,  iSep,  iOct,  iNov,  iDec);
        } 
        catch (IOException e) {
            e.printStackTrace();
            }
    }
    
    public int readFromContracts(){
    String sFile = "contracts.txt";
    int iLines = 0;

        try {
            FileReader contracts = new FileReader(sFile);

            BufferedReader bReader = new BufferedReader(contracts);

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
    
    public int readFromArchiveSummary(){
        String array;
        int iMonthReturn = 0;
        System.out.println("\n");
        try {
            String sCurrentLine;
            BufferedReader brContracts = new BufferedReader(new FileReader("archive.txt"));
            
            int iLoop = 0;
            String sClean = ""; 
            while ((sCurrentLine = brContracts.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                sClean = array.replaceAll("[0-9-]", "" );
                                
                if ("Jan".contains(sClean) && "Jan".equals(_Month)) {
                    iMonthReturn++;
                    }else if ("Feb".contains(sClean) && "Feb".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Mar".contains(sClean) && "Mar".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Apr".contains(sClean) && "Apr".equals(_Month)){
                        iMonthReturn++;
                    }else if ("May".contains(sClean) && "May".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Jun".contains(sClean) && "Jun".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Jul".contains(sClean) && "Jul".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Aug".contains(sClean) && "Aug".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Sep".contains(sClean) && "Sep".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Oct".contains(sClean) && "Oct".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Nov".contains(sClean) && "Nov".equals(_Month)){
                        iMonthReturn++;
                }else if ("Dec".contains(sClean) && "Dec".equals(_Month)){
                    iMonthReturn++;
                }
                {iLoop++;
                }
            }
        }
        catch (IOException e) {
        e.printStackTrace();
        }
        return iMonthReturn;
    }
    
    public int highUnlimitedMonth(){
        int iHighUnlimitedMonth = 0;
        String array;
        String sMinutes = "";
        int cMinutes = 0;
        
        try {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader("archive.txt"));

            int i = 0;
            String sClean = "";
            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                sClean = array.replaceAll("[0-9-]", "" );
                sMinutes = arr[2];
                cMinutes = Integer.parseInt(sMinutes);
                    if (cMinutes == 3 || cMinutes == 4){
                        if ("Jan".contains(sClean) && "Jan".equals(_Month)) {
                            iHighUnlimitedMonth++;
                            }else if ("Feb".contains(sClean) && "Feb".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Mar".contains(sClean) && "Mar".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Apr".contains(sClean) && "Apr".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("May".contains(sClean) && "May".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Jun".contains(sClean) && "Jun".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Jul".contains(sClean) && "Jul".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Aug".contains(sClean) && "Aug".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Sep".contains(sClean) && "Sep".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Oct".contains(sClean) && "Oct".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Nov".contains(sClean) && "Nov".equals(_Month)){
                                iHighUnlimitedMonth++;
                        }else if ("Dec".contains(sClean) && "Dec".equals(_Month)){
                            iHighUnlimitedMonth++;
                        }
                    }
                i++;
            }
        }
        catch (IOException e) {
        e.printStackTrace();
        }
        return iHighUnlimitedMonth;
    }    
    
    public float averageChargeArchiveMonth(){
    int iAvgCharge = 0; 
    float iTotal = 0;
    int iCostPerMonth, iMinutes;    
    String array, sCostPerMonth, sMinutes, sClean; 
            
    try {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader("Archive.txt"));
        int i = 0;
        int iCount = 0;
        
        while ((sCurrentLine = br.readLine()) != null) {
            String[] arr = sCurrentLine.split("\\s+");
            array = arr[0];
            sClean = array.replaceAll("[0-9-]", "" );
            sMinutes = arr[2];
                iMinutes = Integer.parseInt(sMinutes);
            sCostPerMonth = arr[6];
                iCostPerMonth = Integer.parseInt(sCostPerMonth);
        
            if (iMinutes == 3 && "Jan".contains(sClean) && "Jan".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Feb".contains(sClean) && "Feb".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Mar".contains(sClean) && "Mar".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Apr".contains(sClean) && "Apr".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "May".contains(sClean) && "May".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Jun".contains(sClean) && "Jun".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Jul".contains(sClean) && "Jul".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Aug".contains(sClean) && "Aug".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Sep".contains(sClean) && "Sep".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Oct".contains(sClean) && "Oct".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Nov".contains(sClean) && "Nov".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Dec".contains(sClean) && "Dec".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            i++;
        } 
        iTotal = iAvgCharge/iCount;
    } 
    catch (IOException e) {
        e.printStackTrace();
        }
        return iTotal;
    }
    
    public int readFromContractsSummary(){
        String array;
        int iMonthReturn = 0;
        System.out.println("\n");
        try {
            String sCurrentLine;
            BufferedReader brContracts = new BufferedReader(new FileReader("contracts.txt"));
            
            int iLoop = 0;
            String sClean = ""; 
            while ((sCurrentLine = brContracts.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                sClean = array.replaceAll("[0-9-]", "" );
                                
                if ("Jan".contains(sClean) && "Jan".equals(_Month)) {
                    iMonthReturn++;
                    }else if ("Feb".contains(sClean) && "Feb".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Mar".contains(sClean) && "Mar".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Apr".contains(sClean) && "Apr".equals(_Month)){
                        iMonthReturn++;
                    }else if ("May".contains(sClean) && "May".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Jun".contains(sClean) && "Jun".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Jul".contains(sClean) && "Jul".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Aug".contains(sClean) && "Aug".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Sep".contains(sClean) && "Sep".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Oct".contains(sClean) && "Oct".equals(_Month)){
                        iMonthReturn++;
                    }else if ("Nov".contains(sClean) && "Nov".equals(_Month)){
                        iMonthReturn++;
                }else if ("Dec".contains(sClean) && "Dec".equals(_Month)){
                    iMonthReturn++;
                }
                {iLoop++;
                }
            }
        }
        catch (IOException e) {
        e.printStackTrace();
        }
        return iMonthReturn;
    }
    
    public int highUnlimitedMonthC(){
        int iHighUnlimitedMonth = 0;
        String array;
        String sMinutes = "";
        int cMinutes = 0;
        
        try {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader("contracts.txt"));

            int i = 0;
            String sClean = "";
            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                sClean = array.replaceAll("[0-9-]", "" );
                sMinutes = arr[2];
                cMinutes = Integer.parseInt(sMinutes);
                    if (cMinutes == 3 || cMinutes == 4){
                        if ("Jan".contains(sClean) && "Jan".equals(_Month)) {
                            iHighUnlimitedMonth++;
                            }else if ("Feb".contains(sClean) && "Feb".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Mar".contains(sClean) && "Mar".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Apr".contains(sClean) && "Apr".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("May".contains(sClean) && "May".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Jun".contains(sClean) && "Jun".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Jul".contains(sClean) && "Jul".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Aug".contains(sClean) && "Aug".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Sep".contains(sClean) && "Sep".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Oct".contains(sClean) && "Oct".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Nov".contains(sClean) && "Nov".equals(_Month)){
                                iHighUnlimitedMonth++;
                        }else if ("Dec".contains(sClean) && "Dec".equals(_Month)){
                            iHighUnlimitedMonth++;
                        }
                    }
                i++;
            }
        }
        catch (IOException e) {
        e.printStackTrace();
        }
        return iHighUnlimitedMonth;
    }    
    
    public float averageChargeContractsMonth(){
    int iAvgCharge = 0; 
    float iTotal = 0;
    int iCostPerMonth, iMinutes;    
    String array, sCostPerMonth, sMinutes, sClean; 
            
    try {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader("Contracts.txt"));
        int i = 0;
        int iCount = 0;
        
        while ((sCurrentLine = br.readLine()) != null) {
            String[] arr = sCurrentLine.split("\\s+");
            array = arr[0];
            sClean = array.replaceAll("[0-9-]", "" );
            sMinutes = arr[2];
                iMinutes = Integer.parseInt(sMinutes);
            sCostPerMonth = arr[6];
                iCostPerMonth = Integer.parseInt(sCostPerMonth);
        
            if (iMinutes == 3 && "Jan".contains(sClean) && "Jan".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Feb".contains(sClean) && "Feb".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Mar".contains(sClean) && "Mar".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Apr".contains(sClean) && "Apr".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "May".contains(sClean) && "May".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Jun".contains(sClean) && "Jun".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Jul".contains(sClean) && "Jul".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Aug".contains(sClean) && "Aug".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Sep".contains(sClean) && "Sep".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Oct".contains(sClean) && "Oct".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Nov".contains(sClean) && "Nov".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            if (iMinutes == 3 && "Dec".contains(sClean) && "Dec".equals(_Month)){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            i++;
        } 
        iTotal = iAvgCharge/iCount;
    } 
    catch (IOException e) {
        e.printStackTrace();
        }
        return iTotal;
    }
    
    public int readFromInputSummary(){
        String arrayReference, arrayName;
        int iMonthReturn = 0;
        System.out.println("\n");
        try {
            String sCurrentLine;
            BufferedReader brContracts = new BufferedReader(new FileReader(_ReadFrom));
            
            int iLoop = 0;
            while ((sCurrentLine = brContracts.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                String array5 = "";
                String array8 = "";
                array5 = arr[5].toUpperCase();
                array8 = arr[8].toUpperCase();
                boolean found5 = array5.contains(_Search);
                boolean found8 = array8.contains(_Search);

                if (found5 == true || found8 == true){                    
                    iMonthReturn++;
                }       
            {iLoop++;
            }
            }   
        }
        catch(IOException e) {
        e.printStackTrace();}  
    return iMonthReturn;
    }
    
    public int highUnlimitedMonthInput(){
        int iHighUnlimitedMonth = 0;
        String array;
        String sMinutes = "";
        int cMinutes = 0;
        
        try {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader(_ReadFrom));

            int i = 0;
            String sClean = "";
            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                String array5 = "";
                String array8 = "";
                array5 = arr[5].toUpperCase();
                array8 = arr[8].toUpperCase();
                boolean found5 = array5.contains(_Search);
                boolean found8 = array8.contains(_Search);
                sClean = array.replaceAll("[0-9-]", "" );
                sMinutes = arr[2];
                cMinutes = Integer.parseInt(sMinutes);
                    if (cMinutes == 3 || cMinutes == 4){
                        if ("Jan".contains(sClean) && "Jan".equals(_Month) && found5 == true || found8 == true) {
                            iHighUnlimitedMonth++;
                            }else if ("Feb".contains(sClean) && "Feb".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Mar".contains(sClean) && "Mar".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Apr".contains(sClean) && "Apr".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("May".contains(sClean) && "May".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Jun".contains(sClean) && "Jun".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Jul".contains(sClean) && "Jul".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Aug".contains(sClean) && "Aug".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Sep".contains(sClean) && "Sep".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Oct".contains(sClean) && "Oct".equals(_Month)){
                                iHighUnlimitedMonth++;
                            }else if ("Nov".contains(sClean) && "Nov".equals(_Month)){
                                iHighUnlimitedMonth++;
                        }else if ("Dec".contains(sClean) && "Dec".equals(_Month)){
                            iHighUnlimitedMonth++;
                        }
                    }
                i++;
            }
        }
        catch (IOException e) {
        e.printStackTrace();
        }
        return iHighUnlimitedMonth;
    }    
    
    public float averageChargeInput(){
    int iAvgCharge = 0; 
    float iTotal = 0;
    int iCostPerMonth, iMinutes;    
    String array, sCostPerMonth, sMinutes, sClean; 
            
    try {
        String sCurrentLine;
        BufferedReader br = new BufferedReader(new FileReader(_ReadFrom));
        int i = 0;
        int iCount = 0;
        
        while ((sCurrentLine = br.readLine()) != null) {
            String[] arr = sCurrentLine.split("\\s+");
            array = arr[0];
            String array5 = "";
            String array8 = "";
            array5 = arr[5].toUpperCase();
            array8 = arr[8].toUpperCase();
            boolean found5 = array5.contains(_Search);
            boolean found8 = array8.contains(_Search);
            sClean = array.replaceAll("[0-9-]", "" );
            sMinutes = arr[2];
                iMinutes = Integer.parseInt(sMinutes);
            sCostPerMonth = arr[6];
                iCostPerMonth = Integer.parseInt(sCostPerMonth);
        
            if (iMinutes == 3 && found5 == true || found8 == true){
                iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            i++;
        } 
        iTotal = iAvgCharge/iCount;
    } 
    catch (IOException e) {
        e.printStackTrace();
        }
        return iTotal;
    }
    
} // end of program