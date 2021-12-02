//This class is used to answer question 5 and 6 of the assignment. It is then called upon in
// the ReadFilmData main method. It contains the code for input validation and exception handling.
package Andrew_English_Code;
import java.util.ArrayList;
import java.util.Scanner;
import Andrew_English_Code.ReadFilmData;


public class InputValidation {
    //creating new Film object for setters
    public static  Film filmObj;

    public static void validateFilmID(){
        filmObj = new Film(0,"","", 0, 0,0,0,"");
        //variables
        int filmsID = 0;
        String stringInput;
        boolean validInput = false;

        //Setting up scanner
        Scanner scanner1 = new Scanner(System.in);

        //while loop to keep checking until condition is met.
        while ( !validInput) {
            //prompting user for film ID
            System.out.println("Please enter the ID of the film");
            //getting input
            stringInput = scanner1.nextLine();
            try{
                //converting string to int if int value provided
                filmsID = Integer.parseInt(stringInput);
                filmObj.setFilmID(filmsID);
                if (filmsID <=1000){
                    System.out.println("Incorrect input. Film ID must be greater than 1000.");
                    validateFilmID();
                }
                validInput = true;
                System.out.println("The film ID entered is: "+filmsID);
            }
            //provides user with exception if non numeric provided.
            catch (NumberFormatException e){
                System.out.println("Error - You must enter a numeric value.");
            }
        }
    }

    public static void validateFilmTitle(){
        //setting up scanner
        Scanner scanner2 = new Scanner(System.in);
        //variables
        String titleInput = "";
        Boolean titleValid = false;
        //do while loop to check if string input is correct while the title is not valid.
        do{
            System.out.println("Please enter the title of the film");
            if (scanner2.hasNext()){
                titleInput=scanner2.nextLine();
                //setting title user input to filmObj
                filmObj.setTitle(titleInput);
                titleValid=true;
                //if condition of regex not met, user presented with message
            }else{
                scanner2.next();
                System.out.println("Incorrect entry. Please try again");
            }
        }while(!titleValid);
        System.out.println("The film title entered is: "+titleInput);
    }

    public static void validateDescription(){
        //setting up scanner
        Scanner scanner3 = new Scanner(System.in);
        //variables
        String descInput = "";
        Boolean descValid = false;
        //do while loop to check if string input is correct while the desc is not valid.
        do{
            System.out.println("Please provide a description of the film");
            if (scanner3.hasNext()){
                descInput=scanner3.nextLine();
                //setting description user input to filmObj
                filmObj.setDescription(descInput);
                descValid=true;
                //if condition of regex not met, user presented with message
            }else{
                scanner3.next();
                System.out.println("Incorrect entry. Please try again");
            }
        }while(!descValid);
        System.out.println("The film description entered is: "+descInput);
    }

    public static void validateReleaseYear(){
        //variables
        int releaseYear = 0;
        String stringInput;
        boolean validInput = false;
        //Setting up scanner
        Scanner scanner4 = new Scanner(System.in);
        // do while loop to keep checking until condition is met.
        do {
            //prompting user for film release year
            System.out.println("Please enter the release year of the film");
            //getting input
            stringInput = scanner4.nextLine();
            try{
                //converting string to int if int value provided
                releaseYear = Integer.parseInt(stringInput);
                //setting release year user input to filmObj
                filmObj.setReleaseYear(releaseYear);
                if (releaseYear < 1900 | releaseYear > 2021){
                    System.out.println("Incorrect input. Release year must be less than 2021 and greater than 1900.");
                    validateReleaseYear();
                }
                validInput = true;
            }
            //provides user with exception if non numeric provided.
            catch (NumberFormatException e){
                System.out.println("Error - You must enter a release year between 1900 and 2022.");
            }
        }while (!validInput);
        System.out.println("The release year entered is: "+releaseYear);
    }

    public static void validateRentalRate(){
        //variables
        double rentalRate = 0;
        String stringInput;
        boolean validInput = false;
        //Setting up scanner
        Scanner scanner5 = new Scanner(System.in);
        //while loop to keep checking until condition is met.
        while (!validInput) {
            //prompting user for rental rate
            System.out.println("Please enter the rental rate of the film");
            //getting input
            stringInput = scanner5.next();
            try{
                //converting string to int if int value provided
                rentalRate = Double.parseDouble(stringInput);
                //setting rental rate in filmObj
                filmObj.setRentalRate(rentalRate);
                if (rentalRate <= 0 | rentalRate > 10){
                    System.out.println("Rental rate cannot be negative, €0 or greater than €10");
                    validateRentalRate();
                }
                validInput = true;
            }
            //provides user with exception if non numeric provided.
            catch (NumberFormatException e){
                System.out.println("Error - You must enter a valid numeric rental rate between €1 and €10.");
            }
        }
        System.out.println("The rental rate is €"+rentalRate);
    }

    public static void validateFilmLength(){
        //variables
        int filmLength = 0;
        String stringInput;
        boolean validInput = false;
        //Setting up scanner
        Scanner scanner6 = new Scanner(System.in);
        //while loop to keep checking until condition is met.
        while (!validInput) {
            //prompting user for film length
            System.out.println("Please enter the length of the film in minutes");
            //getting input
            stringInput = scanner6.nextLine();
            try{
                //converting string to int if int value provided
                filmLength = Integer.parseInt(stringInput);
                //user setter for film length.
                filmObj.setLength(filmLength);
                if (filmLength < 20 | filmLength > 240){
                    System.out.println("Incorrect input. Film length must be greater than 20 minutes and less than 240 minutes.");
                    validateFilmLength();
                }
                validInput = true;
            }
            //provides user with exception if non numeric provided.
            catch (NumberFormatException e){
                System.out.println("Error - You must enter a numeric value greater than 30 minutes and less than 240 minutes.");
            }
        }
        System.out.println("The length of the film: "+filmLength+" minutes");
    }

    public static void validateReplaceCost(){
        //variables
        double replaceCost = 0;
        String stringInput;
        boolean validInput = false;
        //Setting up scanner
        Scanner scanner7 = new Scanner(System.in);
        //while loop to keep checking until condition is met.
        while (!validInput) {

            //prompting user for replacement cost
            System.out.println("Please enter the replacement cost of the film");
            //getting input
            stringInput = scanner7.next();

            try{
                //converting string to int if int value provided
                replaceCost = Double.parseDouble(stringInput);
                //setting replacement cost
                filmObj.setReplacementCost(replaceCost);
                if (replaceCost < 10 | replaceCost > 50){
                    System.out.println("Replacement rate cannot be less than €10 or greater than €50");
                    validateReplaceCost();
                }
                validInput = true;
            }
            //provides user with exception if non numeric provided.
            catch (NumberFormatException e){
                System.out.println("Error - You must enter a valid numeric replacement rate between €10 and €50.");
            }
        }
        System.out.println("The replacement cost is €"+replaceCost);
    }

    public static void validateSpecialFeature(){
        //setting up scanner
        Scanner scanner8 = new Scanner(System.in);
        //variables
        String specialFeatureInput = "";
        Boolean specialFeatureValid = false;

        //do while loop to check if string input is correct while the special feature input is not valid.
        do{
            System.out.println("Please provide the film's special features");
            if (scanner8.hasNext()){
                specialFeatureInput=scanner8.nextLine();
                //setting special feature
                filmObj.setSpecialFeatures(specialFeatureInput);
                specialFeatureValid=true;
            }else{
                scanner8.next();
                System.out.println("Incorrect entry. Please try again");
            }
        }while(!specialFeatureValid);
        System.out.println("The film's special features are: "+specialFeatureInput);
    }
}
