/**
 * Author: Emma McBride
 * Purpose: CSCE 247 Final Project
 */
package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID; 
/**
 * NOTES
 * make a method that returns an int based on user choice; method parameters are bounds //to get user choice
 * make a method that returns a boolean based on user choice based on bouds //see if their input is valid
 * see if you can make it so at any point if they press escape its quits the program
 *      save progress???
 */

public class UI{
    private static final String WELCOME_MESSAGE = "****** Welcome to Camp Campera ******"; 

    private Scanner scanner; 
    private Activities activities = Activities.getInstance();
    private Directors directors = Directors.getInstance(); 
    private Guardians guardians = Guardians.getInstance(); 
    private Counselors counselors = Counselors.getInstance(); 
    private Campers campers = Campers.getInstance(); 
    private Camps camps = Camps.getInstance(); 
    private Cabins cabins = Cabins.getInstance(); 
    private Schedules schedules = Schedules.getInstance();
    private boolean quit; 

    public void run(){
        ArrayList<String> allergies = new ArrayList<>(); 
        allergies.add("nuts");
        allergies.add("grass");
        ArrayList<Contact> contacts = new ArrayList<>(); 
        Contact pediatrician = new Contact("843834999", "Bob", "Billy", "456 Drive"); 

        Director sam = new Director(UUID.randomUUID(), "samsam", "1234", "ssamuels@campera.com", "Samantha", "Samuels", "Camp Director of 12 years and loving every moment.");
        directors.addDirector(sam); 
        directors.save(); 

        Camper nutella = new Camper("01/05/2006", "Male", "Nutella", "Davis", "1234 Road", allergies, contacts, pediatrician);
        Registration nutReg = new Registration(UUID.randomUUID(), UUID.randomUUID(), nutella.getID(), 45.00); 
        Guardian davis = new Guardian(UUID.randomUUID(), "ldavis", "1234", "ldavis@gmail.com", "Levaeh", "Davis");
        guardians.addGuardian(davis);
        guardians.save(); 
        davis.addRegistration(nutReg);

        Counselor kix = new Counselor("kixgon", "1234", "kix@gmail.com", "Kix", "Gonzalez", "Excited to be here!", "08/28/2001", "Smallville", "Male", contacts, pediatrician);
        counselors.addCounselor(kix); 
        counselors.save();

        ArrayList<Cabin> cabins = new ArrayList<>(); 
        Camp camp = new Camp(cabins, sam, "04/02/2015", "04/10/2015", "Ninja", "Lets do some karate!"); 

        activities.addActivity(new Activity("basketball", "a good game of horse"));
        activities.addActivity(new Activity("lake", "splash around in the lake"));
        activities.addActivity(new Activity("hike", "take a hike with your cabin"));
        activities.addActivity(new Activity("Rock Wall", "See if you can get to the top"));
        activities.addActivity(new Activity("archery", "hit the bullseye!"));
        
        System.out.println(WELCOME_MESSAGE);
        quit = false; 
        while(!quit){
            int choice = displayMenu(); 
            switch (choice){
                case 1: 
                    clear();
                    displayLogin(); 
                case 2: 
                    clear(); 
                    displayRegisterGuardian();
                case 3: 
                     quit=true;
                default: 
                    System.out.println("Please type a valid option!");
                    run(); 
            }
        }
    }

    /**
     * Displays the main menu (login/create_account/exit)
     */
    private int displayMenu(){
        System.out.println("1. Log in \n2. Create Account \n3. Exit");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt(); 
        if(choice > 3 || choice < 1){
            System.out.println("Invalid choice. Please try again"); 
        }
        return choice; 
    }

    private void displayLogin(){
        scanner = new Scanner(System.in);
        boolean isPassValid; 

        clear();
        System.out.println("****** Login ******");
        System.out.println("Please enter your credentials \nUsername: ");
        String username = scanner.nextLine();

        if(directors.boolFindByUser(username)){
            System.out.println("Password: ");
            String password = scanner.nextLine(); 
            isPassValid = directors.checkPassword(username, password);
            if(isPassValid){
                clear();
                Director curDir = directors.findByUser(username);
                displayDirectormenu(curDir);
            } else {
                System.out.println("Incorrect Password, please try again.");
                displayLogin(); 
            }
        } else if (counselors.boolFindByUser(username)){
            System.out.println("Password: ");
            String password = scanner.nextLine(); 
            isPassValid = counselors.checkPassword(username, password);
            if(isPassValid){
                clear();
                Counselor curCou = counselors.findByUser(username); 
                displayCounselorMenu(curCou);
            } else {
                System.out.println("Incorrect Password, please try again.");
                displayLogin(); 
            }
        } else if (guardians.boolFindByUser(username)){
            System.out.println("Password: ");
            String password = scanner.nextLine(); 
            isPassValid = guardians.checkPassword(username, password);
            if(isPassValid){
                clear();
                Guardian curGuar = guardians.findByUser(username); 
                displayGuardianMenu(curGuar);
            } else {
                System.out.println("Incorrect Password, please try again.");
                displayLogin(); 
            }
        } else {
            System.out.println("Username not found. Please try again.");
            displayLogin();
        }
    }

    public void displayRegisterGuardian(){
        scanner = new Scanner(System.in);
        String[] guardianInfo = {"Username", "Password", "Email", "First Name", "Last Name"}; 
        ArrayList<String> userTypesArr = new ArrayList<>(Arrays.asList(guardianInfo)); 
        ArrayList<String> inputs = new ArrayList<String>(); 
         
        System.out.println("****** Create Account ******");
        for(int i=0; i<userTypesArr.size(); i++){
            System.out.println(userTypesArr.get(i) + ":");
            inputs.add(scanner.nextLine()); 
            System.out.println("\n");
        }

        //assigns list of inputs to variables
        String username = inputs.get(0);
        String password = inputs.get(1); 
        String email = inputs.get(2);
        String firstName = inputs.get(3);
        String lastName = inputs.get(4); 
        //TODO program quits after lastname

        if(guardians.haveGuardian(username)){
            System.out.println("Unfortunatley, that username is taken. Choose a different one.");
            displayRegisterGuardian(); 
        } else {
            guardians.addGuardian(new Guardian(username, password, email, firstName, lastName)); 
        }
    }

    /**
     * Gives the director and admin the ability to register a counselor.
     */
    private void displayRegisterCounselor(){ 
        scanner = new Scanner(System.in);    
    
        String[] counselorTypes = {"Username", "Password", "Email", "First Name", "Last Name", "Biography", "Birthdate", "Hometown", "Gender"};

        ArrayList<String> counselorTypesArr = new ArrayList<>(Arrays.asList(counselorTypes));
        ArrayList<String> inputs = new ArrayList<String>(); 

        System.out.println("Please include the following pieces of information.");
        for(int j=0; j<counselorTypesArr.size(); j++){
            System.out.println(counselorTypesArr.get(j) + ":");
            inputs.add(scanner.nextLine()); 
            System.out.println("\n"); 
        }

        String username = inputs.get(0);
        String password = inputs.get(1); 
        String email = inputs.get(2);
        String firstName = inputs.get(3);
        String lastName = inputs.get(4);
        String biography = inputs.get(5);
        String birthdate = inputs.get(6);
        String hometown = inputs.get(7);
        String gender = inputs.get(8); 


        ArrayList<Contact> contacts = displayRegisterContacts();
        System.out.println("Now please input information about your doctor.");
        Contact doctor = displayRegisterContact(); 

        counselors.addCounselor(new Counselor(username, password, email, firstName, lastName, biography, birthdate, hometown, gender, contacts, doctor));
    }

    private void displayGuardianMenu(Guardian guardian){
        scanner = new Scanner(System.in);

        System.out.println("****** Guardian Menu ******");
        System.out.println("1. Register Camper \n2. View Registered Campers \n3. Logout");
        int choice = scanner.nextInt(); 
        
        if(choice > 2 || choice < 1){
            System.out.println("Invalid Choice. Please try again.");
            displayGuardianMenu(guardian);
            
        } else {
            switch(choice){
                case 1:
                    clear();
                    displayRegisterCamper(); 
                    break;
                case 2: 
                    clear();
                    displayRegisteredCampers(guardian); 
                    break; 
                case 3:
                    clear();
                    displayLogin();
                default:
                    System.out.println("Error! UI.DisplayGuardianMenu");
            }

        }
    }

    public void createSessions(Director director){
        System.out.println(director.toString());
        String[] campTest = {"Start Date (mm/dd/yyy)", "End Date (mm/dd/yyy)", "Theme", "Description"};
        ArrayList<Cabin> cabinList = new ArrayList<>();
        ArrayList<String> campTestList = new ArrayList<>(Arrays.asList(campTest));
        ArrayList<String> inputs = new ArrayList<String>(); 
        ArrayList<String> campDates = new ArrayList<String>();


        System.out.println("****** Create Sessions ******");
        System.out.println("How many camp sessions would you like to create?");
        int choice = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i<choice; i++){
            for(int j=0; j<campTestList.size(); j++){
                System.out.println(campTestList.get(j) + ":");
                inputs.add(scanner.nextLine()); 
                System.out.println("\n"); 
            }
            String startDate = inputs.get(0);
            String endDate = inputs.get(1);
            String theme = inputs.get(2);
            String description = inputs.get(3); 
            Director campDir = director;
        
            Camp campTemp = new Camp(cabinList, campDir, startDate, endDate, theme, description);
            campTemp.createCabins();
            for(Cabin cabin : campTemp.getCabins())
                 cabins.addCabin(cabin);
            campDates = campTemp.getDates();
            for(String day : campDates)
                schedules.generateSchedule(cabinList, activities.getActivities(), day);
            campTemp.getDirector().toString();
            camps.addCamp(campTemp);
            cabins.save(); 
            camps.save();
        }
        displayDirectormenu(director);
    }

    private void displayDirectormenu(Director director){
        scanner = new Scanner(System.in);

        System.out.println("****** Director Menu ******");
        System.out.println("1. Add Camper \n2. Add Counselor \n3. View Schedules \n4. View Campers (Camp Wide) \n5. View Campers (For a specific Cabin) \n6. View Counselors \n7. Create sessions\n8. Logout");
        int choice = scanner.nextInt(); 
        
        if(choice > 7 || choice < 1){
            System.out.println("Error! UI.displayDirectorMenu");
        } else {
            switch(choice){
                case 1:
                    clear();
                    displayRegisterCamper();
                    break;
                case 2: 
                    clear();
                    displayRegisterCounselor(); 
                    break;
                case 3:
                    clear(); 
                    for(Schedule schedule : schedules.getSchedules()){
                        System.out.println(schedule); 
                    } 
                    break;
                case 4:
                    clear();
                    System.out.println(campers.getCampers()); 
                    break;
                case 5: 
                    clear();
                    System.out.println("Which cabin's campers would you like to view? (State cabin name)");
                    String cabinChoice = scanner.next(); 
                    if(cabins.haveCabin(cabinChoice)){
                        Cabin cabin = cabins.findByName(cabinChoice);
                        cabin.getCamperData(); 
                    } else {
                        System.out.println("Sorry, this cabin does not exist."); 
                    }
                    break; 
                case 6:
                    clear();
                    displayCounselors(); 
                    break;
                case 7:
                    clear();
                    createSessions(director);
                    break;
                case 8:
                    clear();
                    displayMenu(); 
                    break;
                default:
                    System.out.println("Error! UI.displayDirectorMenu");
                    break;
            }
            displayDirectormenu(director);

        }
    }

    private void displayCounselorMenu(Counselor coun){
        scanner = new Scanner(System.in);

        System.out.println("****** Counselor Menu ******");
        System.out.println("1. View Schedule for the week\n2. View Campers Information \n3. Logout\n" + 
            "What would you like to do?");
        int choice = scanner.nextInt(); 

        if(choice > 2 || choice < 1){
            System.out.println("Error! UI.displayCounselorMenu"); 
        } else {
            switch(choice){
                case 1:
                    coun.printSchedule(cabins.getCabins());
                    break;
                case 2: 
                    System.out.println("What is your username?");
                    coun.printCamperReport(cabins.getCabins());
                    break; 
                case 3:
                    displayLogin();
                    break;
                default: 
                    System.out.println("ERROR! UI.DisplayCounselorMenu");
                    break;
            }
        }
    }

    /**
     * Allows user to register a camper without a predetermined theme 
     * They will be prompted for which theme they want to register their child for
     * during the registration process
     */
    private void displayRegisterCamper(){
        System.out.println("****** Register Camper ******");
        scanner = new Scanner(System.in);
        String[] contactInfo = {"Birthdate", "Gender", "First Name", "Last Name", "Address"}; 
        ArrayList<String> userTypesArr = new ArrayList<>(Arrays.asList(contactInfo)); 
        ArrayList<String> inputs = new ArrayList<String>(); 
        ArrayList<Camp> campList = camps.getCamps();

        for(Camp camp : campList){
            camp.toString(); 
        }

        System.out.println("Which theme would you like to register your child for?\n");
        String themeChoice = scanner.nextLine(); 
        Camp campChoice = camps.findByTheme(themeChoice); 


        for(int i=0; i<userTypesArr.size(); i++){
            System.out.println(userTypesArr.get(i) + ":");
            inputs.add(scanner.nextLine()); //adds the users reponse to a list of inputs
            System.out.println("\n");
        }

        //assigns list of inputs to variables
        String birthdate = inputs.get(0);
        String gender = inputs.get(1); 
        String firstName = inputs.get(2);
        String lastName = inputs.get(3);
        String address = inputs.get(4);

        ArrayList<String> allergies = new ArrayList<>(); 
        System.out.println("How many allergies does your child have?");
        int allergyTot = scanner.nextInt();
        for(int i=0; i<allergyTot; i++){
            System.out.println("Allergy number " + i + ":"); 
            String allergy = scanner.next();
            allergies.add(allergy);
        }


        ArrayList<Contact> contacts = displayRegisterContacts();
        System.out.println("Now please input information about your doctor.");
        Contact doctor = displayRegisterContact(); 
        
        Camper camper = new Camper(birthdate, gender, firstName, lastName, address, allergies, contacts, doctor);
        campers.addCamper(camper); 
        campChoice.getCabins(); 
        campChoice.addCamper(camper);
       
    }

    /**
     * Shows a list of current campers for specific guardian
     */
    private void displayRegisteredCampers(Guardian guardian){
        System.out.println("****** Registered Camper ******");
        ArrayList<Camper> registeredCampers = guardian.getCampers();
        System.out.println(guardian.getRegistrations());
        int i = 0;
        for(Camper camper : registeredCampers){
            Camp regCamp = camps.getByID(guardian.getRegistrations().get(i).getCampID());
            System.out.println(camper.getName() + " " + regCamp.toString());
        }
    }   

    /**
     * Shows a list of current camp counselors
     */
    private void displayCounselors(){
        System.out.println("****** List of Counselors ******");
        for(Counselor counselor : counselors.getCounselors()){
            System.out.println(counselor); 
        } 
        counselors.getCounselors(); // this is just an array list still need to print it
    }

    /**
     * Shows user the schedule for the chosen week 
     * @param week the week of the schedule wished to be viewed
     */
    private void displaySchedule(int week){

    }

    private ArrayList<Contact> displayRegisterContacts(){
        ArrayList<Contact> contacts = new ArrayList<>(); 

        System.out.println("Please register your first contact.");
        Contact contact1 = displayRegisterContact(); 
        contacts.add(contact1); 
        System.out.println("Please register your second contact.");
        Contact contact2 = displayRegisterContact(); 
        contacts.add(contact2); 
        System.out.println("Please register your third contact.");
        Contact contact3 = displayRegisterContact(); 
        contacts.add(contact3); 

        return contacts; 
    }

    private Contact displayRegisterContact(){
        scanner = new Scanner(System.in);
        String[] contactInfo = {"Phone Number", "First Name", "Last Name", "Address"}; 
        ArrayList<String> userTypesArr = new ArrayList<>(Arrays.asList(contactInfo)); 
        ArrayList<String> inputs = new ArrayList<String>(); 
         
        System.out.println("****** Create Account ******");
        for(int i=0; i<userTypesArr.size(); i++){
            System.out.println(userTypesArr.get(i) + ":");
            inputs.add(scanner.nextLine()); //adds the users reponse to a list of inputs
            System.out.println("\n");

    }

    /**
     * Shows all avaliable themes for the summer program sessions.
     */
    private void displayListOfThemes(){
        scanner = new Scanner(System.in); 
        System.out.println("****** List of Possible Themes ******");

        themes();

        System.out.println("Would you like to register your child for one of these weeks? (Y)es or (N)o?");
        String answr = scanner.next(); 
        if(answr.equalsIgnoreCase("Y")){
            System.out.println("Which one would you like?");
            int choice = scanner.nextInt(); 
            displayRegisterCamper(choice); 
        } else if (answr.equalsIgnoreCase("N")){
            clear();
            displayGuardianMenu();
        } else {
            System.out.println("Invalid selection please chose a different answer.");
        }
    }

    /**
     * List of all possible themes and their descriptions
     */
    private void themes(){
        String[][] themes = {
            {"Mermaid", "Fun with fins!"},
            {"Ninja", "Unlock the secrets of kung foo."},
            {"Spy", "Become the epic spymaster"},
            {"" , ""},
            {"" , ""},
            {"" , ""},
            {"" , ""},
            {"" , ""},
            {"" , ""},
            {"" , ""}};

        for(int i = 0; i<10; i++){
            for(int j = 0; j < 2; j++){
                System.out.println(themes[i][j]); 
            }
        }

        //assigns list of inputs to variables
        String phoneNumber = inputs.get(0);
        String firstName = inputs.get(1); 
        String lastName = inputs.get(2);
        String address = inputs.get(3);
        
        Contact contact = new Contact(phoneNumber, firstName, lastName, address); 
        
        return contact; 
    }

    private void clear(){
        for(int i=0; i<30; i++){
            System.out.println("");
        }
    }
    public static void main(String[] args){
        UI driver = new UI();
        driver.run(); 
    }
}