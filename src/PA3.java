import java.io.*;
import java.util.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.*;


/**
 * This is Programming Assignment 3, an implementation of Disney Bank
 * This program has many systems, methods, and objects implemented to use disney bank.
 *
 * I confirm that the work of this assignment is completely my own. By turning in this assignment, I declare that I did not receive unauthorized assistance.
 * Moreover, all deliverables including, but not limited to the source code, lab report and output files were written and produced by me alone.
 *
 * @author  Estevan Ramos
 * @version 3.0
 * @since   2020-09-29
 */

public class PA3{

    /**
     * Represents a Person Used in Customer
     */
    static abstract class person{
        public String FirstName;
        public String LastName;
        public String DOB;

        /**
         * Default Constructor
         */
        //Constructors
        public person() {
        }

        /** Main Constructor
         * @param firstName
         * @param lastName
         * @param DOB
         */
        public person(String firstName, String lastName, String DOB) {
            FirstName = firstName;
            LastName = lastName;
            this.DOB = DOB;
        }

        /** sets First Name
         * @param firstName
         */
        //Setters
        public void setFirstName(String firstName) {
            this.FirstName = firstName;
        }

        /**Sets the Last Name
         * @param lastName
         */
        public void setLastName(String lastName) {
            this.LastName = lastName;
        }

        /** Sets the Date of Birth
         * @param DOB
         */
        public void setDOB(String DOB) {
            this.DOB = DOB;
        }


        /**Gets First Name
         * @return Firstname
         */
        //Getters
        public String getFirstName() {
            return FirstName;
        }

        /**Gets the last Name
         * @return LastName
         */
        public String getLastName() {
            return LastName;
        }

        /**Gets Date of Birth
         * @return Date Of Birth
         */
        public String getDOB() {
            return DOB;
        }


    }

    /**
     * Represents an Account used in Checkings,savings,credit
     */
    static abstract class account{
        public int acctNum;
        public double acctBal;

        /**
         * Default Constructor
         */
        //constructors
        public account(){
        }

        /** Main Account Constructor.
         * @param acctNum
         * @param acctBal
         */
        public account(int acctNum, double acctBal) {
            this.acctNum = acctNum;
            this.acctBal = acctBal;
        }

        /**Sets Account Number
         * @param acctNum
         */
        //setters
        public void setAcctNum(int acctNum) {
            this.acctNum = acctNum;
        }

        /** Sets Account Balance
         * @param acctBal
         */
        public void setAcctBal(double acctBal) {
            this.acctBal = acctBal;
        }

        //Getters

        /** Returns Account Number
         * @return acctNum
         */
        public int getAcctNum() {
            return acctNum;
        }


        /**Returns Account Balance
         * @return acctBal
         */
        public double getAcctBal() {
            return acctBal;
        }

        /** Returns String of the Account
         * @return String
         */
        public String toString() {
            return "account: " +
                    "acctNum:" + acctNum +
                    ", acctBal:" + acctBal ;
        }
    }

    /**
     * Represents a Checking Account extends account
     */
    public static class checking extends account{
        //constructors
        public checking(){
            acctBal = 0;
            acctNum = 0;
        }

        /**Constructor for Checking Account
         * @param acctNum
         * @param acctBal
         */
        public checking(int acctNum, double acctBal) {
            super(acctNum, acctBal);
        }
    }

    /**
     * Represents a Savings account extends account
     */
    public static class savings extends account{
        //constructors
        public savings() {
            acctBal = 0;
            acctNum = 0;
        }

        /** Constructor for Savings Account
         * @param acctNum
         * @param acctBal
         */
        public savings(int acctNum, double acctBal) {
            super(acctNum, acctBal);
        }
    }

    /**
     * Represents a credit account extends account
     */
    public static class credit extends account{
        private double creditMax;

        //constructors
        public credit() {
            acctBal = 0;
            acctNum = 0;
            creditMax = 0;
        }

        /** Main Constructor For Credit Account
         * @param acctNum
         * @param acctBal
         */
        public credit(int acctNum, double acctBal, double creditMax) {
            super(acctNum, acctBal);
            this.creditMax = creditMax;
        }

        public double getCreditMax() {
            return creditMax;
        }

        @Override
        public String toString() {
            return "credit:" +
                    "acctNum:" + acctNum +
                    ", acctBal: " + acctBal +
                    ", creditMax: " + creditMax;
        }
    }

    /**
     * Represents Customer extends person makes Use of Checkings,savings, and credit accounts.
     */
    public static class customer extends person{
        private int IDnum;
        private String address;
        private String phoneNum;
        private savings savingsAcct;
        private credit creditAcct;
        private checking checkingAcct;

        /**
         * Default Constructor
         */
        //constructors
        public customer(){
            IDnum = 0;
            address = "";
            phoneNum = "";
            savingsAcct = new savings();
            creditAcct = new credit();
            checkingAcct = new checking();
        }

        /**Main Constructor of Customers
         * @param firstName
         * @param lastName
         * @param DOB
         * @param IDnum
         * @param address
         * @param phoneNum
         * @param savingsAcct
         * @param creditAcct
         * @param checkingAcct
         */
        public customer(String firstName, String lastName, String DOB, int IDnum, String address, String phoneNum, savings savingsAcct, credit creditAcct, checking checkingAcct) {
            super(firstName, lastName, DOB);
            this.IDnum = IDnum;
            this.address = address;
            this.phoneNum = phoneNum;
            this.savingsAcct = savingsAcct;
            this.creditAcct = creditAcct;
            this.checkingAcct = checkingAcct;
        }

        /**Sets ID Number of the Customer
         * @param IDnum
         */
        //Setters
        public void setIDnum(int IDnum) {
            this.IDnum = IDnum;
        }

        /** Sets Address of the Customer
         * @param address
         */
        public void setAddress(String address) {
            this.address = address;
        }

        /** Sets Phone Number of the customer
         * @param phoneNum
         */
        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        /**
         * Sets Savings account of the customer
         * @param savingsAcct
         */
        public void setSavingsAcct(savings savingsAcct) {
            this.savingsAcct = savingsAcct;
        }

        /**Sets Credit Account of the customer
         * @param creditAcct
         */
        public void setCreditAcct(credit creditAcct) {
            this.creditAcct = creditAcct;
        }


        /**Sets Checking account of the customer
         * @param checkingAcct
         */
        public void setCheckingAcct(checking checkingAcct) {
            this.checkingAcct = checkingAcct;
        }

        //getters
        /**Gets ID Number of the Customer
         * @return IDnum
         */
        public int getIDnum() {
            return IDnum;
        }

        /** Get The Address of the Customer
         * @return address
         */
        public String getAddress() {
            return address;
        }

        /**Gets the Phone number of the Customer
         * @return phoneNum
         */
        public String getPhoneNum() {
            return phoneNum;
        }

        /** gets the Savings Account of the Customer
         * @return savingsAcct
         */
        public savings getSavingsAcct() {
            return savingsAcct;
        }

        /**gets the Credit Account of the Customer
         * @return creditAcct
         */
        public credit getCreditAcct() {
            return creditAcct;
        }

        /**Gets the Checking Account of the Customer
         * @return checkingAcct
         */
        public checking getCheckingAcct() {
            return checkingAcct;
        }

        /** Returns String of Customer Information
         * @return String
         */
        public String toString() {
            return "customer:" + "\n" +
                    "FirstName: " + FirstName + '\n' +
                    "LastName: " + LastName + '\n' +
                    "DOB: " + DOB + '\n' +
                    "IDnum: " + IDnum + '\n' +
                    "address: " + address + '\n' +
                    "phoneNum: " + phoneNum + '\n' +
                    "savingsAcct: " + savingsAcct.toString() + "\n"+
                    "creditAcct: " + creditAcct.toString() + "\n" +
                    "checkingAcct: " + checkingAcct.toString();
        }

        /**Makes Deposit in Customers Checking Account
         * @throws IOException
         */
        public void checkingDeposit() throws IOException {
            File file = new File("log.txt");
            FileWriter fr = new FileWriter(file, true);//appends to file

            Scanner sc = new Scanner(System.in);
            double deposit = -1;
            do {
                try {
                    System.out.println("how much would you like to deposit");
                    deposit = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid deposit.");
                }
                sc.nextLine(); // clears the buffer
            }while (deposit <= 0);

            this.checkingAcct.acctBal = this.checkingAcct.acctBal + deposit;

            System.out.println("Deposit was successful");
            System.out.println();

            fr.write ("\nuser " + this.FirstName + " made a deposit of "+ deposit);//prints and logs
            fr.close();
        }
        /**Makes Deposit in Customers Savings Account
         * @throws IOException
         */
        public void savingsDeposit() throws IOException {
            File file = new File("log.txt");
            FileWriter fr = new FileWriter(file, true);//appends to file
            Scanner sc = new Scanner(System.in);
            double deposit = -1;
            do {
                try {
                    System.out.println("how much would you like to deposit");
                    deposit = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid deposit.");
                }
                sc.nextLine(); // clears the buffer
            }while (deposit <= 0);
            this.savingsAcct.acctBal = this.savingsAcct.acctBal + deposit;

            System.out.println("Deposit was successful");
            System.out.println();

            fr.write ("\n" + this.getFirstName()+ " " + this.getLastName() + " made a deposit of "+ deposit);//prints and logs
            fr.close();
        }
        /**Makes Deposit in Customers Credit Account
         * @throws IOException
         */
        public void creditDeposit() throws IOException {
            File file = new File("log.txt");
            FileWriter fr = new FileWriter(file, true);//appends to file
            Scanner sc = new Scanner(System.in);
            double deposit = -1;
            do {
                try {
                    System.out.println("how much would you like to deposit");
                    deposit = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid deposit.");
                }
                sc.nextLine(); // clears the buffer
            }while (deposit <= 0 && deposit < this.creditAcct.acctBal*-1);
            this.creditAcct.acctBal = this.creditAcct.acctBal + deposit;
            System.out.println("Deposit was successful");
            System.out.println();

            fr.write ("\nuser " + this.getFirstName() + " " + this.getLastName()+ " made a deposit of "+ deposit);//prints and logs
            fr.close();
        }
        /**Makes Withdraw in Customers Checking Account
         * @throws IOException
         */
        public void checkingsWithdraw() throws IOException {
            File file = new File("log.txt");
            FileWriter fr = new FileWriter(file, true);//appends to file
            Scanner sc = new Scanner(System.in);
            double withdraw = -1;
            do {
                try {
                    System.out.println("how much would you like to deposit");
                    withdraw = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid deposit.");
                }
                sc.nextLine(); // clears the buffer
            }while (withdraw <= 0 && withdraw < this.checkingAcct.acctBal);
            this.checkingAcct.acctBal = this.creditAcct.acctBal + withdraw;
            System.out.println("Withdraw was successful");
            System.out.println();

            fr.write ("\n" + this.getFirstName()+ " " + this.getLastName() + " made a withdraw of "+ withdraw);//prints and logs
            fr.close();
        }
        /**Makes Withdraw in Customers Savings Account
         * @throws IOException
         */
        public void savingsWithdraw() throws IOException {
            File file = new File("log.txt");
            FileWriter fr = new FileWriter(file, true);//appends to file
            Scanner sc = new Scanner(System.in);
            double withdraw = -1;
            do {
                try {
                    System.out.println("how much would you like to deposit");
                    withdraw = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid deposit.");
                }
                sc.nextLine(); // clears the buffer
            }while (withdraw <= 0 && withdraw < this.savingsAcct.acctBal);
            this.savingsAcct.acctBal = this.savingsAcct.acctBal - withdraw;
            System.out.println("Withdraw was successful");
            System.out.println();

            fr.write ("\nuser " + this.getFirstName()+ " " + this.getLastName() + " made a withdraw of $"+ withdraw);//prints and logs
            fr.close();
        }
        /**Makes Withdraw in Customers Credit Account
         * @throws IOException
         */
        public void creditWithdraw() throws IOException {
            File file = new File("log.txt");
            FileWriter fr = new FileWriter(file, true);//appends to file
            Scanner sc = new Scanner(System.in);
            double withdraw = -1;
            do {
                try {
                    System.out.println("how much would you like to withdraw");
                    withdraw = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid deposit.");
                }
                sc.nextLine(); // clears the buffer
            }while (withdraw <= 0);
            this.creditAcct.acctBal = this.creditAcct.acctBal - withdraw;
            System.out.println("Deposit was successful");
            System.out.println();

            fr.write ("\nuser " + this.getFirstName()+ " " + this.getLastName() + " made a withdraw of "+ withdraw);//prints and logs
            fr.close();
        }

        /**Makes a Transfer between different Customer Accounts
         * @throws IOException
         */
        public void transfer() throws IOException {
            File file = new File("log.txt");
            FileWriter fr = new FileWriter(file, true);//appends to file
            Scanner sc = new Scanner(System.in);

            String input;
            double transfer;
            boolean loop = true;

            while(loop){
                System.out.println("Please select on of the following:");
                System.out.println("1.checkings to savings");
                System.out.println("2.savings to checkings");
                System.out.println("3.checkings to credit");
                System.out.println("4.savings to credit");
                System.out.println("5.Exit");
                input = sc.nextLine();
                switch (input){
                    case "1":
                        transfer = -1;
                        do{
                            try {
                                System.out.println("how much would you like to transfer?");
                                transfer = sc.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.print("Invalid Transfer");
                            }
                            sc.nextLine(); // clears the buffer
                        } while (transfer <= 0 && transfer < this.savingsAcct.acctBal);
                        this.checkingAcct.acctBal = this.checkingAcct.acctBal - transfer;
                        this.savingsAcct.acctBal = this.savingsAcct.acctBal + transfer;
                        fr.write ("\n" + this.getFirstName() + " " + this.getLastName()+ " made a Transfer of $" + transfer + " from checkings to savings");//prints and logs
                        fr.close();
                        break;
                    case "2":
                        transfer = -1;
                        do {
                            try {
                                System.out.println("how much would you like to transfer?");
                                transfer = sc.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.print("Invalid Transfer");
                            }
                            sc.nextLine(); // clears the buffer
                        } while (transfer <= 0 && transfer < this.savingsAcct.acctBal);
                        this.savingsAcct.acctBal = this.savingsAcct.acctBal - transfer;
                        this.checkingAcct.acctBal = this.checkingAcct.acctBal + transfer;
                        fr.write ("\n" + this.getFirstName()+ " " + this.getLastName() + " made a Transfer of $" + transfer + " from savings to checkings");//prints and logs
                        fr.close();
                        break;
                    case "3" :
                        transfer = -1;
                        do {
                            try {
                                System.out.println("how much would you like to transfer?");
                                transfer = sc.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.print("Invalid Transfer");
                            }
                            sc.nextLine(); // clears the buffer
                        } while (transfer <= 0 && transfer < this.checkingAcct.acctBal);
                        this.checkingAcct.acctBal = this.checkingAcct.acctBal - transfer;
                        this.creditAcct.acctBal = this.creditAcct.acctBal + transfer;
                        fr.write ("\n" + this.getFirstName()+ " " + this.getLastName() + " made a Transfer of $" + transfer + " from checkings to credit");//prints and logs
                        fr.close();
                        break;

                    case "4" :
                        transfer = -1;
                        do {
                            try {
                                System.out.println("how much would you like to transfer?");
                                transfer = sc.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.print("Invalid Transfer");
                            }
                            sc.nextLine(); // clears the buffer
                        } while (transfer <= 0 && transfer < this.savingsAcct.acctBal);
                        this.savingsAcct.acctBal = this.savingsAcct.acctBal - transfer;
                        this.creditAcct.acctBal = this.creditAcct.acctBal + transfer;
                        fr.write ("\n" + this.getFirstName()+ " " + this.getLastName() + " made a Transfer of $" + transfer + " from savings to credit");//prints and logs
                        fr.close();
                        break;
                    case "5":
                        System.out.println("Exiting...");
                        loop = false;
                        break;
                    default:
                        System.out.println("please enter a valid input");
                }
            }


        }
    }

    /**
     * Represents a Bank Statement
     */
    public static class bankStatement{
        private customer c;
        private ArrayList<String> transactions;
        private String date;

        public bankStatement(){}

        public bankStatement(customer c) throws IOException {
            File logFile = new File("log.txt");
            FileReader fr = new FileReader(logFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String data[];

            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");


            this.c = c;
            this.date = dateFormat.format(date);
            transactions = new ArrayList<String>();

            while((line = br.readLine()) != null){
                data = line.split(" ");
                if(data[0].equals(c.getFirstName()) && data[1].equals(c.getLastName())){
                    transactions.add(line);
                }
            }


        }

        public void write() {
            System.out.println(c.toString());
            System.out.println("As of Today "+ date);
            System.out.println("PREVIOUS TRANSACTIONS:");
            for(String s : transactions){
                System.out.println(s);
            }
        }
    }

    /**Given a Customer List Creates a bank Statement and writes it
     * @param customerList
     * @throws IOException
     */
    public static void writeBankStatement(ArrayList<customer> customerList) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean findingUser = true;
        String input;
        String names[];
        customer user = new customer();
        while(findingUser) {
            System.out.println("Please enter the first and last name of the person you would like to create a bank statement for");
            input = sc.nextLine();
            names = input.split(" ");
            for(customer c: customerList){
                if(c.getFirstName().equals(names[0]) && c.getLastName().equals(names[1])){
                    user = c;
                    findingUser = false;
                }
            }
            if(findingUser){
                System.out.println("Please enter a valid name");
            }

        }

        bankStatement BS = new bankStatement(user);
        BS.write();
    }

    /**Returns a Array List of Customers given a csv file
     * @param filename
     * @return Hashtable
     * @throws IOException
     */
     public static ArrayList makeCustomerList(String filename) throws IOException {
        File file = new File(filename);// creates csv
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);//reads csv file

        String seperator = ",";//used for splitting csv file
        String line = "";//seperates line
        String[] data = null;//stores data
        int counter = 0;

        ArrayList<customer> arr = new ArrayList<customer>();//creates hashtable

        while((line = br.readLine()) != null){//runs while theres still lines in the file
            data = line.split(seperator);//creates array of strings with data
                if(counter > 0){//makes sure not to take in the first row of csv
                    String first = data[14];
                    String last = data[2];
                    String DOB = data[3];
                    int IDnum = Integer.parseInt(data[0]);
                    String address = data[11] + "," + data[12] + "," + data[13];
                    String phoneNUm = data[6];
                    int checkingacctNum = Integer.parseInt(data[4]);
                    int savingsacctNum = Integer.parseInt(data[1]);
                    int creditacctNum = Integer.parseInt(data[5]);
                    double checkingBal = Double.parseDouble(data[7]);
                    double savingsBal = Double.parseDouble(data[8]);
                    double creditBal = Double.parseDouble(data[10]);
                    double creditMax = Double.parseDouble(data[9]);

                    checking tempcheckings = new checking(checkingacctNum,checkingBal);
                    savings tempsavings = new savings(checkingacctNum,checkingBal);
                    credit tempcredit = new credit(checkingacctNum,checkingBal,creditMax);
                    customer temp = new customer(first,last,DOB,IDnum,address,phoneNUm,tempsavings,tempcredit,tempcheckings);

                    arr.add(temp);
                }
            counter++;
        } //converts csv into hash table with first names as the key
        br.close();

        return arr;
    }

    /**Allows the Customer To inquire there Information
     * @param user
     * @throws IOException
     */
    public static void inquire(customer user) throws IOException {
        File file = new File("log.txt");
        FileWriter fr = new FileWriter(file, true);//appends to file

        System.out.println(user.toString());

        fr.write("\nuser " + user.getFirstName() + " inquired there account");//logs to file
        fr.close ();
    }

    /**Given A Customer list allows search of a user by name or ID
     * @param customerList
     * @throws IOException
     */
    public static void inquire(ArrayList<customer> customerList) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input;
        boolean loop = true;
        boolean contains = false;
        String name;
        String [] fullName;
        String type;
        int acctNum = -1;

        while(loop){
            System.out.println("How would you like to inquire?");
            System.out.println("1.Inquire by Name");
            System.out.println("2.Inquire by account by type/number");
            input = sc.nextLine();

            switch(input){
                case "1":
                    while(!contains){
                        System.out.println("Please enter First and Last Name:");
                        name = sc.nextLine();
                        fullName = name.split(" ");
                        for(customer c: customerList){
                            if(fullName[0].equals(c.getFirstName()) && fullName[1].equals(c.getLastName())){
                                inquire(c);
                                loop = false;
                                contains = true;
                            }
                        }
                        if(contains == false){
                            System.out.println("Name not found Please Try again");
                        }
                    }
                    break;
                case "2":
                    while(!contains){
                        System.out.println("Which account type? checking/savings/credit");
                        type = sc.nextLine();
                        switch (type){
                            case "checkings":
                                do {
                                    try {
                                        System.out.print("Please enter account Number:");
                                        acctNum = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.print("Please enter a valid account Number ");
                                    }
                                    sc.nextLine(); // clears the buffer
                                } while (acctNum <= 0);
                                for(customer c : customerList){
                                    if(c.getCheckingAcct().getAcctNum() == acctNum){
                                        inquire(c);
                                        contains = true;
                                        loop = false;
                                    }
                                    if(contains == false){
                                        System.out.println("The Account Number was not found please try again");
                                    }
                                }
                                break;
                            case "savings":
                                do {
                                    try {
                                        System.out.print("Please enter account Number:");
                                        acctNum = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.print("Please enter a valid account Number ");
                                    }
                                    sc.nextLine(); // clears the buffer
                                } while (acctNum <= 0);
                                for(customer c : customerList){
                                    if(c.getSavingsAcct().getAcctNum() == acctNum){
                                        inquire(c);
                                        contains = true;
                                        loop = false;
                                    }
                                    if(contains == false){
                                        System.out.println("The Account Number was not found please try again");
                                    }
                                }
                                break;
                            case "credit":
                                do {
                                    try {
                                        System.out.print("Please enter account Number:");
                                        acctNum = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.print("Please enter a valid account Number ");
                                    }
                                    sc.nextLine(); // clears the buffer
                                } while (acctNum <= 0);
                                for(customer c : customerList){
                                    if(c.getCreditAcct().getAcctNum() == acctNum){
                                        inquire(c);
                                        contains = true;
                                        loop = false;
                                    }
                                    if(contains == false){
                                        System.out.println("The Account Number was not found please try again");
                                    }
                                }
                                break;
                            default:
                                System.out.println("The type you entered was not valid");
                        }
                    }
                    break;
                default :
                    System.out.println("please enter a valid option");
            }
        }
    }

    /**Inquires all accounts in a Array List of Customers
     * @param customerList
     */
    public static void inquireAll(ArrayList<customer> customerList){
        for(customer c: customerList){
            System.out.println(c.toString());
        }
    }

    /**Allows the Customer to make Deposit into any of there accounts.
     * @param user
     * @throws IOException
     */
    public static void makeDeposit(customer user) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Please select one of the following to deposit too:");
        System.out.println("1.Checkings");
        System.out.println("2.Savings");
        System.out.println("3.Credit");
        input = sc.nextLine();
        switch(input){
            case "1":
                user.checkingDeposit();
                break;
            case "2":
                user.savingsDeposit();
                break;
            case "3":
                user.creditDeposit();
                break;
            default:
                System.out.println("please enter a valid input");//default case
        }
    }

    /**Allows User to Withdraw from any of its Accounts
     * @param user
     * @throws IOException
     */
    public static void makeWithdraw(customer user) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Please select one of the following to withdraw from:");
        System.out.println("1.Checkings");
        System.out.println("2.Savings");
        System.out.println("3.Credit");
        input = sc.nextLine();
        switch(input){
            case "1":
                user.checkingsWithdraw();
                break;
            case "2":
                user.savingsWithdraw();
                break;
            case "3":
                user.creditWithdraw();
                break;
            default:
                System.out.println("please enter a valid input");//default case
        }
    }

    /**Given a Customer and Hashtable, Allows the Customer to Transfer money to any other Customer in the Hashtable
     * Assumes The transfer is checkings to checkings
     * @param user
     * @param customerList
     * @throws IOException
     */
    public static void makeTransaction(customer user, ArrayList<customer> customerList) throws IOException {
        File file = new File("log.txt");
        FileWriter fr = new FileWriter(file, true);//append to file

        Scanner sc = new Scanner(System.in);
        String input;
        customer temp = new customer();
        double transfer = -1;

        System.out.println("please enter name of someone you are  going to transfer too");
        input = sc.nextLine();
        String [] names = input.split(" ");
        boolean contains = false;

        for(customer c: customerList){
            if(names[0].equals(c.getFirstName()) && names[1].equals(c.getLastName())){
                temp = c;
                contains = true;
            }
        }
        if(!contains){
            System.out.println("The name inputted was not found");
        }else{
            do {
                try {
                    System.out.println("How much would you like to transfer too "+temp.getFirstName());
                    transfer = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.print("Invalid transfer ");
                }
                sc.nextLine(); // clears the buffer
            } while (transfer <= 0);
            user.getCheckingAcct().setAcctBal(user.getCheckingAcct().getAcctBal() - transfer);
            temp.getCheckingAcct().setAcctBal(temp.getCheckingAcct().getAcctBal() + transfer);
            System.out.println("Transaction Successful");
            fr.write("\n" + user.getFirstName()+ " " + user.getLastName() + " Transferred $" + transfer + " to " + temp.getFirstName()+ " " + temp.getLastName());
            fr.close();
        }

    }

    /** Given A Customer list, Allows Customer to perform various actions in there accounts.
     * @param CustomerList
     * @throws IOException
     */
    public static void runbank(ArrayList<customer> CustomerList) throws IOException {
        Scanner sc = new Scanner(System.in);//gets user input
        String input;
        boolean gettingUser = true;
        boolean isID = true;
        customer user = new customer();
        while(gettingUser){
            System.out.println("Please Enter First and Last Name or ID Number");
            input = sc.nextLine();

            for(int i = 0; i< input.length();i++){
                if (Character.isDigit(input.charAt(i))== false){
                    isID = false;
                }
            }

            if(isID){
               for(customer C : CustomerList){
                   if(Integer.parseInt(input) == C.getIDnum()){
                       user = C;
                       gettingUser = false;
                   }else{
                       System.out.println("The ID Number Inputted was not found please try again.");
                   }
               }
            }else{
                String [] names = input.split(" ");
                for(customer C : CustomerList){
                    if (names[0].equals(C.getFirstName()) && names[1].equals(C.getLastName())){
                        user = C;
                        gettingUser = false;
                    }
                }
                if(gettingUser){
                    System.out.println("The Name You Inputted was not recognized please try again.");
                }

            }

        }


        boolean loop = true;
        while(loop){//main menu
            System.out.println("please select an option");
            System.out.println("1. Inquire account");
            System.out.println("2. Make Transaction");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Switch Users");
            System.out.println("7. Exit");
            input = sc.nextLine();//reads input
            switch (input) {//for determining which action take
                case "1":
                    inquire(user);//inquire account
                    break;
                case "2":
                    makeTransaction(user,CustomerList);
                    break;
                case "3":
                    makeDeposit(user);//makes deposit
                    break;
                case "4":
                    makeWithdraw(user);//makes with draw
                    break;
                case "5":
                    user.transfer();
                    break;
                case "6":
                    System.out.println("switching users");
                    System.out.println();
                    loop = false;//breaks out of main menu and returns to first menu
                    break;
                case "7":
                    loop = false;
                    break;
                default:
                    System.out.println("please enter a valid input");//default case
            }
        }

    }

    /** Given A customer List Runs all the trasnactions specified in the Transaction Actions File
     * @param customerList
     * @throws IOException
     */
    public static void transactionReader(ArrayList<customer> customerList) throws IOException {
        File logFile = new File("log.txt");
        FileWriter fw = new FileWriter(logFile, true);//appends to file

        String filename = "src/Transaction Actions.csv";
        File file = new File(filename);// creates csv
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);//reads csv file

        String seperator = ",";//used for splitting csv file
        String line = "";//seperates line
        String[] data = null;//stores data
        int counter = 0;
        String Name;
        customer temp;
        customer temp2;
        String action;

        Map<String , customer> hm = new HashMap();
        for(customer c: customerList){
            Name = c.getFirstName() + c.getLastName();
            hm.put(Name , c);
        }

        while((line = br.readLine()) != null){
            data = line.split(seperator);
            if(counter > 0){
                action = data[3];
                switch (action){
                    case "pays":
                        temp = hm.get(data[0]+data[1]);
                        temp2 = hm.get(data[4]+data[5]);

                        if(Double.parseDouble(data[7]) > temp.getCheckingAcct().getAcctBal() ){
                            System.out.println("Error: Transfer is greater then account balance");
                        }else{
                            temp.getCheckingAcct().setAcctBal(temp.getCheckingAcct().getAcctBal()- Double.parseDouble(data[7]));
                            temp2.getCheckingAcct().setAcctBal(temp2.getCheckingAcct().getAcctBal()+ Double.parseDouble(data[7]));
                            fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + " paid " + temp2.getFirstName()+ " " + temp2.getLastName() +" $"+ data[7]);
                        }
                        break;
                    case "transfers":
                        temp = hm.get(data[0]+data[1]);
                        switch(data[2]){
                            case "Savings":
                                if(data[6].equals("Checking")){
                                    if(temp.getSavingsAcct().getAcctBal() > Double.parseDouble(data[7])){
                                        temp.getSavingsAcct().setAcctBal(temp.getSavingsAcct().getAcctBal() - Integer.parseInt(data[7]));
                                        temp.getCheckingAcct().setAcctBal(temp.getCheckingAcct().getAcctBal() + Integer.parseInt(data[7]));
                                        fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + "transferred $"+ data[7]+ " from Savings to Checking");
                                    }else{
                                        System.out.println("Error: Transfer more then Balance");
                                    }
                                }else{
                                    if(temp.getSavingsAcct().getAcctBal() > Double.parseDouble(data[7])){
                                        if(temp.getCreditAcct().getAcctBal() + Double.parseDouble(data[7]) > 0) {
                                            temp.getSavingsAcct().setAcctBal(temp.getSavingsAcct().getAcctBal() - Integer.parseInt(data[7]));
                                            temp.getCreditAcct().setAcctBal(temp.getCreditAcct().getAcctBal() + Integer.parseInt(data[7]));
                                            fw.write("\n" + temp.getFirstName() + " " + temp.getLastName()+ "transferred $"+ data[7]+ " from Savings to Credit");
                                        }else{
                                            System.out.println("Error: Credit account cant go Below 0");
                                        }
                                    }
                                    else{
                                        System.out.println("Error: Transfer more then Balance");
                                    }
                                }
                                break;
                            case "Checking":
                                if(data[6].equals("Savings")){
                                    if(temp.getCheckingAcct().getAcctBal() > Double.parseDouble(data[7])){
                                        temp.getCheckingAcct().setAcctBal(temp.getSavingsAcct().getAcctBal() - Integer.parseInt(data[7]));
                                        temp.getSavingsAcct().setAcctBal(temp.getSavingsAcct().getAcctBal() + Integer.parseInt(data[7]));
                                        fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + " transferred $"+ data[7]+ " from Checking to Savings");
                                    }else{
                                        System.out.println("Error: Transfer more then Balance");
                                    }
                                }else{
                                    if(temp.getCheckingAcct().getAcctBal() > Double.parseDouble(data[7])){
                                        if(temp.getCreditAcct().getAcctBal() + Double.parseDouble(data[7]) > 0) {
                                            temp.getCheckingAcct().setAcctBal(temp.getCheckingAcct().getAcctBal() - Double.parseDouble(data[7]));
                                            temp.getCreditAcct().setAcctBal(temp.getCreditAcct().getAcctBal() + Double.parseDouble(data[7]));
                                            fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + " transferred $"+ data[7]+ " from Checking to Credit");
                                        }else{
                                            System.out.println("Error: Credit account cant go Below 0");
                                        }
                                    }
                                    else{
                                        System.out.println("Error: Transfer more then Balance");
                                    }
                                }
                                break;
                            case "Credit":
                                if(data[6].equals("Checking")){
                                    if(temp.getCreditAcct().getCreditMax() > Double.parseDouble(data[7]) + (-1 * temp.getCreditAcct().getAcctBal())){
                                        temp.getCreditAcct().setAcctBal(temp.getCreditAcct().getAcctBal() - Double.parseDouble(data[7]));
                                        temp.getCheckingAcct().setAcctBal(temp.getCheckingAcct().getAcctBal() + Double.parseDouble(data[7]));
                                        fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + " transferred $"+ data[7]+ "from Credit to Checking");
                                    }else{
                                        System.out.println("Error: Transfer more then Balance");
                                    }
                                }else{
                                    if(temp.getCreditAcct().getCreditMax() < -1 * (temp.getCreditAcct().getAcctBal() - Double.parseDouble(data[7]))) {
                                        temp.getCreditAcct().setAcctBal(temp.getCreditAcct().getAcctBal() - Double.parseDouble(data[7]));
                                        temp.getSavingsAcct().setAcctBal(temp.getSavingsAcct().getAcctBal() + Double.parseDouble(data[7]));
                                        fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + " transferred $"+ data[7]+ "from Credit to Savings");
                                    }
                                    else{
                                        System.out.println("Error: Transfer more then Balance");
                                    }
                                }
                                break;
                            default:
                                System.out.println("Error: Account not found");
                        }
                        break;
                    case "inquires":
                        temp = hm.get(data[0]+data[1]);
                        fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + " inquired about there account");
                        break;
                    case "withdraws":
                        temp = hm.get(data[0] + data[1]);
                        switch(data[2]){
                            case "Savings":
                                if(Double.parseDouble(data[7]) > temp.getSavingsAcct().getAcctBal()){
                                    System.out.println("Error: Withdraw greater then balance");
                                }else{
                                    temp.getSavingsAcct().setAcctBal(temp.getSavingsAcct().getAcctBal() - Double.parseDouble(data[7]));
                                    fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + " withdrew $"+ data[7]+ " from Savings");
                                }
                                break;
                            case "Checking":
                                if(Double.parseDouble(data[7]) > temp.getCheckingAcct().getAcctBal()){
                                    System.out.println("Error: Withdraw greater then balance");
                                }else{
                                    temp.getCheckingAcct().setAcctBal(temp.getCheckingAcct().getAcctBal() - Double.parseDouble(data[7]));
                                    fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + " withdrew $"+ data[7]+ " from Checking");
                                }
                                break;
                            case "Credit":
                                if(Double.parseDouble(data[7]) > temp.getCreditAcct().getCreditMax() - temp.getCreditAcct().getAcctBal()){
                                    System.out.println("Error: Withdraw greater then balance");
                                }else{
                                    temp.getSavingsAcct().setAcctBal(temp.getCreditAcct().getAcctBal() - Double.parseDouble(data[7]));
                                    fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + " withdrew $"+ data[7]+ " from Credit");
                                }
                                break;
                            default:
                                System.out.println("Error: Account not found");
                        }
                        break;
                    case "deposits":
                        temp = hm.get(data[4]+data[5]);
                        switch(data[6]){
                            case "Savings":
                                if(Double.parseDouble(data[7]) > 0){
                                    temp.getSavingsAcct().setAcctBal(temp.getSavingsAcct().getAcctBal() + Double.parseDouble(data[7]));
                                    fw.write("\n" + temp.getFirstName()+ " " + temp.getLastName() + " deposited $"+ data[7]+ " into Savings");
                                }else{
                                    System.out.println("Error: Deposit not valid");
                                }
                                break;
                            case "Checking":
                                if(Double.parseDouble(data[7]) > 0){
                                    temp.getCheckingAcct().setAcctBal(temp.getCheckingAcct().getAcctBal() + Double.parseDouble(data[7]));
                                    fw.write("\n" + temp.getFirstName() + " " + temp.getLastName() + " deposited $"+ data[7]+ " into Checking");
                                }else{
                                    System.out.println("Error: Deposit not valid");
                                }
                                break;
                            case "Credit":
                                if(Double.parseDouble(data[7]) > 0 && !(temp.getCreditAcct().getAcctBal() + Double.parseDouble(data[7]) > 0) ){
                                    temp.getCreditAcct().setAcctBal(temp.getCreditAcct().getAcctBal() + Double.parseDouble(data[7]));
                                    fw.write("\n" + temp.getFirstName() +" "+temp.getLastName() + " deposited $"+ data[7]+ " into Credit");
                                }else{
                                    System.out.println("Error: Deposit not valid");
                                }
                                break;
                            default:
                                System.out.println("Error: Account not found");
                        }
                        break;
                    default:
                        System.out.println("There was an error with the action");
                }
            }
            counter++;
        }
        fw.close();
    }

    /**Allows creation of checking account in console
     * @return
     */
    public static checking createCheckingAccount(){
        Scanner sc = new Scanner(System.in);
        String input;
        int acctnum = -1;
        double acctBal = -1;

        checking checking = new checking();

        do {
            try {
                System.out.println("Please enter account Number");
                acctnum = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid account number please try again.");
            }
            sc.nextLine(); // clears the buffer
            try {
                System.out.println("Please enter account balance");
                acctBal = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid account balance please try again.");
            }
        } while (acctnum <= 0 && acctBal <= 0);
        checking.setAcctBal(acctBal);
        checking.setAcctNum(acctnum);
        return checking;
    }

    /**Allows creation of Savings account from the console
     * @return
     */
    public static savings createSavingsAccount(){
        Scanner sc = new Scanner(System.in);
        String input;
        int acctnum = -1;
        double acctBal = -1;

        savings savings = new savings();

        do {
            try {
                System.out.println("Please enter account Number");
                acctnum = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid account number please try again.");
            }
            //sc.nextLine(); // clears the buffer
            try {
                System.out.println("Please enter account balance");
                acctBal = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid account balance please try again.");
            }
        } while (acctnum <= 0 && acctBal <= 0);
        savings.setAcctBal(acctBal);
        savings.setAcctNum(acctnum);
        return savings;
    }

    /**Allows creation of Credit account from the console
     * @return
     */
    public static credit createCreditAccount(){
        Scanner sc = new Scanner(System.in);
        String input;
        int acctnum = -1;
        double acctBal = 1;
        double creditMax = 1;

        credit credit = new credit();

        do {
            try {
                System.out.println("Please enter account Number");
                acctnum = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid account number please try again.");
            }
            sc.nextLine(); // clears the buffer
            try {
                System.out.println("Please enter account balance");
                acctBal = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid account balance please try again.");
            }
        } while (acctnum <= 0 && acctBal >= 0);
        credit.setAcctBal(acctBal);
        credit.setAcctNum(acctnum);
        return credit;
    }

    /**Given A Customer List, Allows for the creation of a new customer from the console
     * @param customerList
     * @return void
     */
    public static void createCustomer(ArrayList<customer> customerList){
        Scanner sc = new Scanner(System.in);
        String input;
        boolean loop = true;
        String firstName;
        String lastName;
        String DOB;
        int IDnum = 0;
        String address;
        String phoneNum;
        savings savingsAcct;
        credit creditAcct;
        checking checkingAcct;

        customer C = new customer();

        System.out.println("Please Enter First Name");
        input = sc.nextLine();
        firstName = input;
        C.setFirstName(firstName);

        System.out.println("Please Enter Last Name");
        input = sc.nextLine();
        lastName = input;
        C.setLastName(lastName);

        System.out.println("Please enter date of birth(1-Jan-2020):");
        input = sc.nextLine();
        DOB = input;
        C.setDOB(DOB);

        System.out.println("Please enter Phone number ie.(915)123-456:");
        input = sc.nextLine();
        phoneNum = input;
        C.setPhoneNum(phoneNum);

        savingsAcct = createSavingsAccount();
        C.setSavingsAcct(savingsAcct);

        do{
            //sc.nextLine();
            System.out.println("Would you like to create a checking account? Y/N");
            input = sc.nextLine();
            if(!input.equals("Y") && !input.equals("N")){
                System.out.println("Please Enter a Valid Option");
            }
        }while(!input.equals("Y") && !input.equals("N"));
        if(input.equals("Y")){
            checkingAcct = createCheckingAccount();
            C.setCheckingAcct(checkingAcct);
        }
        do{
            //sc.nextLine();
            System.out.println("Would you like to create a credit account? Y/N");
            input = sc.nextLine();
            if(!input.equals("Y") && !input.equals("N")){
                System.out.println("Please Enter a Valid Option");
            }
        }while(!input.equals("Y") && !input.equals("N"));
        if(input.equals("Y")){
            creditAcct = createCreditAccount();
            C.setCreditAcct(creditAcct);
        }

        do{
            System.out.println("Would you like to add Address? Y/N");
            input = sc.nextLine();
            if(!input.equals("Y") && !input.equals("N")){
                System.out.println("Please Enter a Valid Option");
            }
        }while(!input.equals("Y") && !input.equals("N"));
        if(input.equals("Y")){
            System.out.println("Please enter Your Street:");
            input = sc.nextLine();
            address = input + ", ";
            System.out.println("Please enter city:");
            input = sc.nextLine();
            address = address + input+ ", ";
            System.out.println("Please enter state ie. TX:");
            input = sc.nextLine();
            address = address + input + " " ;
            System.out.println("Please enter Zip Code:");
            input = sc.nextLine();
            address = address + input;
            C.setAddress(address);
        }

        for(customer c :customerList){
            if(IDnum < c.getIDnum()){
                IDnum = c.getIDnum();
            }
        }
        IDnum += 1;
        C.setIDnum(IDnum);

        System.out.println("Customer Succesfully Created.");
        System.out.println(C.toString());
        customerList.add(C);
    }

    /**Given A customer List Allows Bank Manager to perform various actions
     * @param customerList
     * @throws IOException
     */
    public static void bankManager(ArrayList<customer> customerList) throws IOException {
        Scanner sc = new Scanner(System.in);//gets user input
        String input;
        boolean loop = true;
        while(loop){
            customer temp;
            System.out.println("Hello Bank Manager please select an option:");
            System.out.println("1.Inquire about an account");
            System.out.println("2.Print all accounts.");
            System.out.println("3.Create New Customer");
            System.out.println("4.Run Transaction Reader");
            System.out.println("5.Write Bank Statement");
            System.out.println("6.Exit");
            input = sc.nextLine();

            switch(input) {
                case "1":
                    inquire(customerList);
                    break;
                case "2":
                    inquireAll(customerList);
                    break;
                case "3":
                    createCustomer(customerList);
                    break;
                case "4":
                    transactionReader(customerList);
                    break;
                case "5":
                    writeBankStatement(customerList);
                    break;
                case "6":
                    loop = false;
                    break;
                default:
                    System.out.println("please enter a valid input");//default case
            }

        }


    }

    /**Given customer List creates a new updated CSV
     * @param customerList
     * @throws IOException
     */
    public static void createCSV(ArrayList<customer> customerList) throws IOException {
        File file = new File("Updated Bank Users.csv");
        FileWriter fw = new FileWriter(file);

        String delimeter = ",";
        String TopRow = "Identification Number,Savings Account Number,Last Name,Date of Birth,Checking Account Number,Credit Account Number,Phone Number,Checking Starting Balance,Savings Starting Balance,Credit Max,Credit Starting Balance,Address,First Name";

        fw.write(TopRow);
        for(customer c: customerList){
            fw.write("\n"+c.getIDnum() + delimeter);
            fw.write(c.getSavingsAcct().getAcctNum() + delimeter);
            fw.write(c.getLastName() + delimeter);
            fw.write(c.getDOB() + delimeter);
            fw.write(c.getCheckingAcct().getAcctNum() + delimeter);
            fw.write(c.getCreditAcct().getAcctNum() + delimeter);
            fw.write(c.getPhoneNum() + delimeter);
            fw.write(c.getCheckingAcct().getAcctBal() + delimeter);
            fw.write(c.getSavingsAcct().getAcctBal() + delimeter);
            fw.write(c.getCreditAcct().getCreditMax() + delimeter);
            fw.write(c.getAddress() + delimeter);
            fw.write(c.getFirstName() + delimeter);
        }
    }

    /**Main method of Disney Bank
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        File file = new File("log.txt");//creates log file
        FileWriter fr = new FileWriter(file, true);
        Scanner sc = new Scanner(System.in);//gets user input

        String filename = "src/CS 3331 - Bank Users 3(3).csv";
        ArrayList<customer> customerList = makeCustomerList(filename);//creates am array list of Customers
        boolean exit = true;//menu operator
        customer user = new customer();//main user

        while(exit){
            String input = "";
            System.out.println("welcome to Disney Bank");
            System.out.println("Please select one of the following ");
            System.out.println("1.Bank Manager");
            System.out.println("2.Individual customer");
            System.out.println("3.Exit");
            input = sc.nextLine();//reads input

            switch (input){
                case "1":
                    bankManager(customerList);
                    break;
                case "2":
                    runbank(customerList);
                    break;
                case "3":
                    System.out.println("Goodbye");
                    exit = false;
                    createCSV(customerList);
                    break;
                default:
                    System.out.println("Please enter a valid input");

            }
        }
    }
}

