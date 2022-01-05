/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contractmanager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author MC03353
 */
class FileReader {

    public int readFromArchiveSummary(MonthlyRates monthlyRates) {
        String array;
        int iMonthReturn = 0;
        System.out.println("\n");
        try {
            String sCurrentLine;
            BufferedReader brContracts = new BufferedReader(new java.io.FileReader("archive.txt"));
            int iLoop = 0;
            String sClean = "";
            while ((sCurrentLine = brContracts.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                sClean = array.replaceAll("[0-9-]", "");
                //_Month is the global variable which forms part of the getters and setters above. It's the users
                //input which has had the first letter to upper case and remaining to lower case
                if ("Jan".contains(sClean) && "Jan".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Feb".contains(sClean) && "Feb".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Mar".contains(sClean) && "Mar".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Apr".contains(sClean) && "Apr".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("May".contains(sClean) && "May".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Jun".contains(sClean) && "Jun".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Jul".contains(sClean) && "Jul".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Aug".contains(sClean) && "Aug".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Sep".contains(sClean) && "Sep".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Oct".contains(sClean) && "Oct".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Nov".contains(sClean) && "Nov".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Dec".contains(sClean) && "Dec".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                }
                {
                    iLoop++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iMonthReturn;
    }

    public int readFromContracts() {
        String sFile = "contracts.txt";
        int iLines = 0;
        try {
            java.io.FileReader contracts = new java.io.FileReader(sFile);
            BufferedReader bReader = new BufferedReader(contracts);
            while (bReader.readLine() != null) {
                iLines++;
            }
            bReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file '" + sFile + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + sFile + "'");
        }
        return iLines;
    }

    //rather having having two methods, one for archive and one for contracts, I began to expirement with user input
    public int readFromInputSummary(MonthlyRates monthlyRates) {
        String arrayReference;
        String arrayName;
        int iMonthReturn = 0;
        System.out.println("\n");
        try {
            String sCurrentLine;
            BufferedReader brContracts = new BufferedReader(new java.io.FileReader(monthlyRates.getReadFrom()));
            int iLoop = 0;
            while ((sCurrentLine = brContracts.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                //array5 is the reference column
                String array5 = "";
                //is the name column
                String array8 = "";
                //changes string result to upper case which makes validation shorter to write
                array5 = arr[5].toUpperCase();
                array8 = arr[8].toUpperCase();
                //I struggled with this until I realised .contains() is a boolean true or false rather than string
                // does found5 contain part of the user input? true or false
                boolean found5 = array5.contains(monthlyRates.getSearch());
                boolean found8 = array8.contains(monthlyRates.getSearch());
                // if some of the input is found to be true, count
                if (found5 == true || found8 == true) {
                    iMonthReturn++;
                }
                {
                    iLoop++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iMonthReturn;
    }

    public int readFromArchive() {
        String sFile = "archive.txt";
        int iLines = 0;
        try {
            java.io.FileReader contracts = new java.io.FileReader(sFile);
            BufferedReader bReader = new BufferedReader(contracts);
            while (bReader.readLine() != null) {
                iLines++;
            }
        } catch (FileNotFoundException whateverWeWant) {
            System.out.println("Unable to open file '" + sFile + "'");
            whateverWeWant.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error reading file '" + sFile + "'");
            ex.printStackTrace();
        }
        return iLines;
    }

    public int readFromContractsSummary(MonthlyRates monthlyRates) {
        String array;
        int iMonthReturn = 0;
        System.out.println("\n");
        try {
            String sCurrentLine;
            BufferedReader brContracts = new BufferedReader(new java.io.FileReader("contracts.txt"));
            int iLoop = 0;
            String sClean = "";
            while ((sCurrentLine = brContracts.readLine()) != null) {
                String[] arr = sCurrentLine.split("\\s+");
                array = arr[0];
                sClean = array.replaceAll("[0-9-]", "");
                if ("Jan".contains(sClean) && "Jan".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Feb".contains(sClean) && "Feb".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Mar".contains(sClean) && "Mar".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Apr".contains(sClean) && "Apr".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("May".contains(sClean) && "May".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Jun".contains(sClean) && "Jun".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Jul".contains(sClean) && "Jul".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Aug".contains(sClean) && "Aug".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Sep".contains(sClean) && "Sep".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Oct".contains(sClean) && "Oct".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Nov".contains(sClean) && "Nov".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                } else if ("Dec".contains(sClean) && "Dec".equals(monthlyRates.getMonth())) {
                    iMonthReturn++;
                }
                
                iLoop++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iMonthReturn;
    }

}
