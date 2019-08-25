/*
 * Project 2
 * author: Tien Nguyen
 * date: October-16-2015
 * description: fileI/O, nested looping, selection et. al. 
 */
package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author tiennguyen
 */
public class Project2 {

    /**
     * @param args the command line arguments
     */
    public static final String INPUT_FILE_NAME = "police_report.txt";
    public static final String OUTPUT_FILE_NAME = "project2_TienNguyen.txt";
    

    public static void main(String[] args) {
        // Declared some variables
        
        
        
        int communityService = 0;
        int vacationPenalties = 0;
        
        String name = null;

        Scanner inputFileScanner = null;
        PrintWriter outputFileWriter = null;
           
        
        
        
        
        // Open the file and tell user if the it couldnt find the file

        try {
            inputFileScanner = new Scanner(new File(INPUT_FILE_NAME));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + INPUT_FILE_NAME );
             
            System.exit(1);

        }
        try {

            outputFileWriter = new PrintWriter(new FileOutputStream(OUTPUT_FILE_NAME));

        } catch (FileNotFoundException e) {

            System.err.println("Error opening the file " + OUTPUT_FILE_NAME);

            System.exit(1);

        }
        
        
        
        
        // Declared the variables to the input file so the program can read it
        
        String crime;
        int people = inputFileScanner.nextInt();
        for (int i = 0; i < people; i++) {
                
            name = inputFileScanner.next();
            String vis = inputFileScanner.next();
            int villain = Integer.parseInt(vis);
            
            // which one will have vacation penalties, and which one will have community service.
            if ((name.equals("Rincewind")) || (name.equals("MustrumRidcully")) || (name.equals("TheLibrarian")) || (name.equals("TheBursar") || (name.equals("PonderStibbons")))) {
                vacationPenalties += villain;
                outputFileWriter.printf("%s: %d vacation days penalty because:\n",name,villain);
               
            } else {
                outputFileWriter.printf("%s: %d days of community service because:\n",name,villain);
                communityService += villain;
            }
            for (int j = 0; j < villain; j++) {
               
                inputFileScanner.next();
                crime = inputFileScanner.nextLine();
                outputFileWriter.println(" - " + name + crime);
             // print the file to "project_TienNguyen.txt" 
                
            }
            outputFileWriter.printf("\n");
             
                  
            

            // Print out the total numbers of community service and vacation penalties.                
            
        }
                outputFileWriter.printf("----------------------\n");
                        outputFileWriter.printf("Commnuity serivice: %d days\n",communityService);
                        outputFileWriter.printf("Vacation penalties: %d days\n",vacationPenalties);
                inputFileScanner.close();
                outputFileWriter.close();
                
    }
}
