/*
 * Project 1
 * author: Tien Nguyen
 * date: September-25-2015
 * description: This assignment will include switch and if-else, nested selection, keyboard input, string comparsison and formated output.
 */
package project1;

import java.util.Scanner;
import java.util.Date;

public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Declare Variables
        double taxFund = 0;
        double donationFund = 0;
        double darkFund = 0;
        double money = 0;
        int garment = 0;
        int murder = 0;
        int robbery = 0;
        String guild;
        String fund;

       //DATE d= New Date ();
        // User input         
        System.out.print("Which guild made a payment today? ");
        guild = input.next();
        System.out.println("");
        // System.out.println("working");

        System.out.print("What was the amount of today's payment? ");
        money = input.nextDouble();
        System.out.println("");

        //the amount of money cant be 0 or less   
        if (money < 0) {
            System.out.print("Invalid payment amount. Yell at someone. Goodbye.");
            System.exit(-1);
        }

        System.out.print("What kind of payment - tax or donation? ");
        fund = input.next();
        System.out.println("");

        // guilds and tax or donation check
        switch (guild.toLowerCase()) {
            case "assassins":
                if (fund.equalsIgnoreCase("tax")) {
                    taxFund = money;
                } else if (fund.equalsIgnoreCase("donation")) {
                    donationFund = money;
                } else {
                    darkFund = money;
                }

                break;

            case "seamstresses":

                if (fund.equalsIgnoreCase("tax")) {
                    taxFund = money;
                } else if (fund.equalsIgnoreCase("donation")) {
                    donationFund = money;
                } else {
                    darkFund = money;
                }
                break;

            case "thieves":

                if (fund.equalsIgnoreCase("tax")) {
                    taxFund = money;
                } else if (fund.equalsIgnoreCase("donation")) {
                    donationFund = money;
                } else {
                    darkFund = money;
                }
                break;

            default:

                darkFund = money;

        }
        //Receipt and date
        Date date = new Date();
        System.out.println("----- RECEIPT -- " + date + "------------");
        System.out.println("");

        //Messages for the unregister guilds
        if (!guild.equalsIgnoreCase("assassins") && !guild.equalsIgnoreCase("seamstresses") && !guild.equalsIgnoreCase("thieves")) {
            System.out.printf("If you wish to register a new guild,\n"
                    + "you must appear in person in front of the Patrician.\n"
                    + "By the way, we lost your payment, so\n"
                    + "please make it again when you register.\n"
                    + "Thank you.\n");
            System.out.println("");

            //Checking if the input is tax
        } else {
            if (fund.equalsIgnoreCase("tax")) {
                System.out.print("Guild of " + guild + " " + fund + " payment of " + "$" + money + " confirmed.\n"
                        + "Thank you.");
                System.out.println("");
                System.out.println("");

            //Checking if the input is donation and credits for each register guilds
            } else if (fund.equalsIgnoreCase("donation")) {
                if (guild.equalsIgnoreCase("assassins")) {
                    if (money >= 60) {
                        murder = (int) (money / 60);
                        System.out.print("Guild of " + guild + ", thank you for your donation,\n"
                                + "you have received credit of " + murder + " murders.");
                        System.out.println("");
                        System.out.println("");

                    } else {
                        System.out.print("Guild of " + guild + ", thank you for your donation, however,\n"
                                + "it's not enough for an item of credit.");
                        System.out.println("");
                        System.out.println("");

                    }
                } else if (guild.equalsIgnoreCase("seamstresses")) {
                    if (money >= 12) {
                        garment = (int) (money / 12);
                        System.out.print("Guild of " + guild + ", thank you for your donation,\n"
                                + "you have received credit of " + garment + " garments.");
                        System.out.println("");
                        System.out.println("");

                    } else {
                        System.out.print("Guild of " + guild + ", thank you for your donation, however,\n"
                                + "it's not enough for an item of credit.");
                        System.out.println("");
                        System.out.println("");

                    }
                } else if (guild.equalsIgnoreCase("thieves")) {
                    if (money >= 25) {
                        robbery = (int) (money / 25);
                        System.out.print("Guild of " + guild + ", thank you for your donation,\n"
                                + "you have received credit of " + robbery + " robberies.");
                        System.out.println("");
                        System.out.println("");

                    } else {
                        System.out.print("Guild of " + guild + ", thank you for your donation, however,\n"
                                + "it's not enough for an item of credit.");
                        System.out.println("");
                        System.out.println("");

                    }
                } else {
                    System.out.print("Guild of " + guild + ", thank you for your donation, however,\n"
                            + "it's not enough for an item of credit.");
                    System.out.println("");
                    System.out.println("");

                    // If the input for fund is neither tax or donation 
                }
            } else {
                System.out.printf("Dear guild of " + guild + ",\n"
                        + "We're sorry, we don't take that kind of payment, so we lost it.\n"
                        + "Please make the payment again tomorrow.\n"
                        + "Goodbye.\n");
                System.out.println("");

            }
        }
        //money placed in the appropriate fund and display all funds
        System.out.println("---------------------------------------------------------");
        System.out.println("");

        System.out.println("Funds standing after transaction:");
        System.out.printf("%-14s $%.2f \n", "Tax fund:", taxFund);
        System.out.printf("%-14s $%.2f \n", "Donation fund:", donationFund);
        System.out.printf("%-14s $%.2f \n", "Dark fund:", darkFund);

    }

}
