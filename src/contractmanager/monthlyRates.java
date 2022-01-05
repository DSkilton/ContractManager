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
public class MonthlyRates {

    //instance variables
    private String firstName, secondName, reference, businessType, internationalCalls, date, getMonth, search, readFrom;
    private int contractLength, businessAdjustment, callsAdjustment, costPerMonth, totalPolicies, highUnlimited, packageType, dataBundle;
    private Boolean _InternationalCalls;

//    public MonthlyRates() {
//        month = "";
//        date = "";
//        firstName = "";
//        secondName = "";
//        reference = "";
//        businessType = "";
//        dataBundle = 0;
//        _Package = 0;
//        contractLength = 0;
//        _InternationalCalls = false;
//        internationalCalls = "No";
//        _BusinessAdjustment = 0;
//        callsAdjustment = 0;
//        costPerMonth = 0;
//        totalPolicies = 0;
//        highUnlimited = 0;
//    }// end of Constructor

    public String getReadFrom() {
        return readFrom;
    }

    public void setReadFrom(String ReadFrom) {
        this.readFrom = ReadFrom;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String Search) {
        this.search = Search;
    }

    public String getMonth() {
        return getMonth;
    }

    public void setMonth(String Month) {
        this.getMonth = Month;
    }

    public int getDataBundle() {
        return dataBundle;
    }

    public void setDataBundle(int DataBundle) {
        this.dataBundle = DataBundle;
    }

    public int getPackage() {
        return packageType;
    }

    public void setPackage(int Package) {
        this.packageType = Package;
    }

    public int getHighUnlimited() {
        return highUnlimited;
    }

    public void setHighUnlimited(int HighUnlimited) {
        this.highUnlimited = HighUnlimited;
    }

    public int getTotalPolicies() {
        return totalPolicies;
    }

    public void setTotalPolicies(int TotalPolicies) {
        this.totalPolicies = TotalPolicies;
    }

    public int getCostPerMonth() {
        return costPerMonth;
    }

    public void setCostPerMonth(int CostPerMonth) {
        this.costPerMonth = CostPerMonth;
    }

    public int getBusinessAdjustment() {
        return businessAdjustment;
    }

    public void setBusinessAdjustment(int businessAdjustment) {
        this.businessAdjustment = businessAdjustment;
    }

    public int getIntCallsAdjustment() {
        return callsAdjustment;
    }

    public void setIntCallsAdjustment(int callsAdjustment) {
        this.callsAdjustment = callsAdjustment;
    }

    public boolean getInternationalCalls() {
        return _InternationalCalls;
    }

    public void setInternationalCalls(Boolean InternationalCalls) {
        this._InternationalCalls = InternationalCalls;
    }

    public void setsInternationalCalls(String sInternationalCalls) {
        this.internationalCalls = sInternationalCalls;
    }

    public String getInternationallCalls() {
        return internationalCalls;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String Reference) {
        this.reference = Reference;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String BusinessType) {
        this.businessType = BusinessType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String SecondName) {
        this.secondName = SecondName;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int ContractLength) {
        this.contractLength = ContractLength;
    }


    //I should have made contracts and archive both static final globals
    public static final String fileNameContracts = "Contracts.txt";

    public void writeToFileContracts() {
        BufferedWriter bReader = null;
        FileWriter fWriter = null;

        try {
            // This takes all the getters and saves/ appends them to file separated by a tab space 
            String content = (getDate() + " " + getPackage() + " " + getDataBundle() + " " + getContractLength()
                    + " " + getInternationalCalls() + " " + getReference() + " " + getCostPerMonth()
                    + " " + getFirstName() + " " + getSecondName());

            fWriter = new FileWriter(fileNameContracts);
            bReader = new BufferedWriter(fWriter);
            // the write to file part
            bReader.write(content);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (bReader != null) {
                    bReader.close();
                }

                if (fWriter != null) {
                    fWriter.close();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //returns total policies which we know should be 1000
    public int fileSearchArchive() {
        int iTotalPolicies = 0;
        Scanner input = new Scanner(System.in);
        input = new Scanner("archive.txt");

        while (input.hasNext()) {
            iTotalPolicies = iTotalPolicies + 1;
            setTotalPolicies(iTotalPolicies);
            input.nextLine();
        }
        return iTotalPolicies;
    }

    public int highUnlimitedArchive() {
        int iHighUnlimited = 0;
        String array, sMinutes;
        int cMinutes;

        try {
            String sCurrentLine;
            BufferedReader br = new BufferedReader(new FileReader("Archive.txt"));

            //loop which reads through the file line by line and checks the 3rd[2] column 
            while ((sCurrentLine = br.readLine()) != null) {
                //array is created by looking for tab spaces 
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                //third column off array
                sMinutes = arr[2];
                //all results are strings so need to be converted/ parsed to int
                cMinutes = Integer.parseInt(sMinutes);
                if (cMinutes == 3 || cMinutes == 4) {
                    iHighUnlimited = iHighUnlimited + 1;
                }
            }
        } catch (IOException e) {
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
            iTotal = iAvgCharge / iCount;
        } catch (IOException e) {
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
                // first column, the date colum
                array = arr[0];
                String clean;
                //removing the numbers 0 to 9 and the - symbol so I am left with Jan, Feb, Mar etc
                clean = array.replaceAll("[0-9-]", "");

                //if the string clean contrains Jan, add 1 to the int iJan
                if ("Jan".contains(clean)) {
                    iJan++;
                } else if ("Feb".contains(clean)) {
                    iFeb++;
                } else if ("Mar".equals(clean)) {
                    iMar++;
                } else if ("Apr".equals(clean)) {
                    iApr++;
                } else if ("May".equals(clean)) {
                    iMay++;
                } else if ("Jun".equals(clean)) {
                    iJun++;
                } else if ("Jul".equals(clean)) {
                    iJul++;
                } else if ("Aug".equals(clean)) {
                    iAug++;
                } else if ("Sep".equals(clean)) {
                    iSep++;
                } else if ("Oct".equals(clean)) {
                    iOct++;
                } else if ("Nov".equals(clean)) {
                    iNov++;
                } else if ("Dec".equals(clean)) {
                    iDec++;
                }
                {
                    i++;
                }
            }
            // with the months being 3 characters long, it made sense to set the formatting to 3 characters for the months
            // and the int result. Both rows are set to the right. 
            String sAlignMonths = "%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s \r\n";
            String sAlignCount = "%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s \r\n";;

            System.out.format(sAlignMonths, "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
            System.out.format(sAlignCount, iJan, iFeb, iMar, iApr, iMay, iJun, iJul, iAug, iSep, iOct, iNov, iDec);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int fileSearchContracts() {

        //searching the contracts file for total amount of policies
        int iTotalPolicies = 0;
        Scanner input = new Scanner(System.in);
        input = new Scanner("contracts.txt");

        while (input.hasNext()) {
            iTotalPolicies = iTotalPolicies + 1;
            setTotalPolicies(iTotalPolicies);
            input.nextLine();
        }
        return iTotalPolicies;
    }

    public int highUnlimitedContracts() {
        int iHighUnlimited = 0;
        String array, sMinutes;
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
                if (cMinutes == 3 || cMinutes == 4) {
                    iHighUnlimited = iHighUnlimited + 1;
                }
                i++;
            }
        } catch (IOException e) {
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
                //[6] is the 7th column of the text file which is the string of pence 
                sCostPerMonth = arr[6];
                // the string needs to be parsed so we can perform maths 
                iCostPerMonth = Integer.parseInt(sCostPerMonth);

                if (iMinutes == 3) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
                i++;
            }
            iTotal = iAvgCharge / iCount;
        } catch (IOException e) {
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
            // this should have been written as a public method so I didn't have to copy and paste each time I
            // wanted to use it
            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                String clean;
                clean = array.replaceAll("[0-9-]", "");

                if ("Jan".contains(clean)) {
                    iJan++;
                } else if ("Feb".contains(clean)) {
                    iFeb++;
                } else if ("Mar".equals(clean)) {
                    iMar++;
                } else if ("Apr".equals(clean)) {
                    iApr++;
                } else if ("May".equals(clean)) {
                    iMay++;
                } else if ("Jun".equals(clean)) {
                    iJun++;
                } else if ("Jul".equals(clean)) {
                    iJul++;
                } else if ("Aug".equals(clean)) {
                    iAug++;
                } else if ("Sep".equals(clean)) {
                    iSep++;
                } else if ("Oct".equals(clean)) {
                    iOct++;
                } else if ("Nov".equals(clean)) {
                    iNov++;
                } else if ("Dec".equals(clean)) {
                    iDec++;
                }
                {
                    i++;
                }
            }
            String sAlignMonths = "%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s \r\n";
            String sAlignCount = "%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s %3s \r\n";;

            System.out.format(sAlignMonths, "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
            System.out.format(sAlignCount, iJan, iFeb, iMar, iApr, iMay, iJun, iJul, iAug, iSep, iOct, iNov, iDec);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int highUnlimitedMonth() {
        //searching the archive txt file for a specific months data
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
                sClean = array.replaceAll("[0-9-]", "");
                //[2] is the third column which has numbers 1 to 4. 3 and 4 are high or unlimited data usage 
                sMinutes = arr[2];
                cMinutes = Integer.parseInt(sMinutes);
                if (cMinutes == 3 || cMinutes == 4) {
                    if ("Jan".contains(sClean) && "Jan".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Feb".contains(sClean) && "Feb".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Mar".contains(sClean) && "Mar".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Apr".contains(sClean) && "Apr".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("May".contains(sClean) && "May".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Jun".contains(sClean) && "Jun".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Jul".contains(sClean) && "Jul".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Aug".contains(sClean) && "Aug".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Sep".contains(sClean) && "Sep".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Oct".contains(sClean) && "Oct".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Nov".contains(sClean) && "Nov".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Dec".contains(sClean) && "Dec".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iHighUnlimitedMonth;
    }

    public float averageChargeArchiveMonth() {
        int iAvgCharge = 0;
        float iTotal = 0;
        int iCostPerMonth, iMinutes;
        String array, sCostPerMonth, sMinutes, sClean;

        try {
            String sCurrentLine;
            //interestingly, the filereader doesn't seem to be case sensitive! 
            BufferedReader br = new BufferedReader(new FileReader("Archive.txt"));
            int i = 0;
            int iCount = 0;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                sClean = array.replaceAll("[0-9-]", "");
                //creating a column array of minutes 
                sMinutes = arr[2];
                // parsing minutes to int
                iMinutes = Integer.parseInt(sMinutes);
                //creating a column array for the pence cost of the contract
                sCostPerMonth = arr[6];
                //parsing to int
                iCostPerMonth = Integer.parseInt(sCostPerMonth);

                if (iMinutes == 3 && "Jan".contains(sClean) && "Jan".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Feb".contains(sClean) && "Feb".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Mar".contains(sClean) && "Mar".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Apr".contains(sClean) && "Apr".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "May".contains(sClean) && "May".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Jun".contains(sClean) && "Jun".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Jul".contains(sClean) && "Jul".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Aug".contains(sClean) && "Aug".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Sep".contains(sClean) && "Sep".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Oct".contains(sClean) && "Oct".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Nov".contains(sClean) && "Nov".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Dec".contains(sClean) && "Dec".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
                i++;
            }
            iTotal = iAvgCharge / iCount;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iTotal;
    }


    public int highUnlimitedMonthC() {
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
                sClean = array.replaceAll("[0-9-]", "");
                sMinutes = arr[2];
                cMinutes = Integer.parseInt(sMinutes);
                if (cMinutes == 3 || cMinutes == 4) {
                    if ("Jan".contains(sClean) && "Jan".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Feb".contains(sClean) && "Feb".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Mar".contains(sClean) && "Mar".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Apr".contains(sClean) && "Apr".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("May".contains(sClean) && "May".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Jun".contains(sClean) && "Jun".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Jul".contains(sClean) && "Jul".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Aug".contains(sClean) && "Aug".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Sep".contains(sClean) && "Sep".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Oct".contains(sClean) && "Oct".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Nov".contains(sClean) && "Nov".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    } else if ("Dec".contains(sClean) && "Dec".equals(getMonth)) {
                        iHighUnlimitedMonth++;
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iHighUnlimitedMonth;
    }

    public float averageChargeContractsMonth() {
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
                sClean = array.replaceAll("[0-9-]", "");
                sMinutes = arr[2];
                iMinutes = Integer.parseInt(sMinutes);
                sCostPerMonth = arr[6];
                iCostPerMonth = Integer.parseInt(sCostPerMonth);

                if (iMinutes == 3 && "Jan".contains(sClean) && "Jan".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Feb".contains(sClean) && "Feb".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Mar".contains(sClean) && "Mar".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Apr".contains(sClean) && "Apr".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "May".contains(sClean) && "May".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Jun".contains(sClean) && "Jun".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Jul".contains(sClean) && "Jul".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Aug".contains(sClean) && "Aug".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Sep".contains(sClean) && "Sep".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Oct".contains(sClean) && "Oct".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Nov".contains(sClean) && "Nov".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                } else if (iMinutes == 3 && "Dec".contains(sClean) && "Dec".equals(getMonth)) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
                i++;
            }
            iTotal = iAvgCharge / iCount;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iTotal;
    }


    public int highUnlimitedMonthInput() {
        int iHighUnlimitedMonth = 0;
        String array;
        String sMinutes = "";
        int cMinutes = 0;

        try {
            String sCurrentLine;
            BufferedReader br = new BufferedReader(new FileReader(readFrom));

            int i = 0;
            String sClean = "";
            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                String array5 = "";
                String array8 = "";
                array5 = arr[5].toUpperCase();
                array8 = arr[8].toUpperCase();
                boolean found5 = array5.contains(search);
                boolean found8 = array8.contains(search);
                sClean = array.replaceAll("[0-9-]", "");
                sMinutes = arr[2];
                cMinutes = Integer.parseInt(sMinutes);
                //each stages checks for requirement
                //are the contracts high or unlimited data?
                if (cMinutes == 3 || cMinutes == 4) {
                    //do the referene or name contain part of the user input?
                    if (found5 == true || found8 == true) {
                        if ("Jan".contains(sClean) && "Jan".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("Feb".contains(sClean) && "Feb".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("Mar".contains(sClean) && "Mar".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("Apr".contains(sClean) && "Apr".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("May".contains(sClean) && "May".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("Jun".contains(sClean) && "Jun".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("Jul".contains(sClean) && "Jul".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("Aug".contains(sClean) && "Aug".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("Sep".contains(sClean) && "Sep".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("Oct".contains(sClean) && "Oct".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("Nov".contains(sClean) && "Nov".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        } else if ("Dec".contains(sClean) && "Dec".equals(getMonth)) {
                            iHighUnlimitedMonth++;
                        }
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iHighUnlimitedMonth;
    }

    public float averageChargeInput() {
        int iAvgCharge = 0;
        float iTotal = 0;
        int iCostPerMonth, iMinutes;
        String array, sCostPerMonth, sMinutes, sClean;

        try {
            String sCurrentLine;
            BufferedReader br = new BufferedReader(new FileReader(readFrom));
            int iCount = 0;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                String array5 = "";
                String array8 = "";
                array5 = arr[5].toUpperCase();
                array8 = arr[8].toUpperCase();
                boolean found5 = array5.contains(search);
                boolean found8 = array8.contains(search);
                sClean = array.replaceAll("[0-9-]", "");
                sMinutes = arr[2];
                iMinutes = Integer.parseInt(sMinutes);
                sCostPerMonth = arr[6];
                iCostPerMonth = Integer.parseInt(sCostPerMonth);

                if (iMinutes == 3 && found5 == true || found8 == true) {
                    iAvgCharge = iAvgCharge + iCostPerMonth;
                    iCount++;
                }
            }
            iTotal = iAvgCharge / iCount;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iTotal;
    }

} // end of program
