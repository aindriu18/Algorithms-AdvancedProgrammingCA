package Andrew_English_Code;
import Andrew_English_Code.ReadFilmData;
import Andrew_English_Code.BinarySearchFilm;
import Andrew_English_Code.InputValidation;

import java.io.File;
import java.util.*;

public class ReadFilmData {

    public static void main(String[] args) throws Exception{

        //parsing and reading the CSV file data into the film (object) array
        // provide the path here...
        Scanner sc = new Scanner(new File("C:\\Users\\aindr\\Algorithms and Advanced Programming\\CA\\film_data.csv"));
        Film[] films = new Film[1000];

        // this will just print the header in CSV file
        sc.nextLine();

        int i = 0; String st = "";
        while (sc.hasNextLine())  //returns a boolean value
        {
            st = sc.nextLine();
            String[] data = st.split(",");
            films[i] = new Film(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), Double.parseDouble(data[4]), Integer.parseInt(data[5]), Double.parseDouble(data[6]), data[7]);
            i++;
        }
        sc.close();  //closes the scanner

        //------------------ Question 5 & 6 -----------------------------
        //creating array list
        List<Film> filmList = Arrays.asList(films);
        filmList = new ArrayList<>(filmList);

        //calling on validation methods
        InputValidation.validateFilmID();
        InputValidation.validateFilmTitle();
        InputValidation.validateDescription();
        InputValidation.validateReleaseYear();
        InputValidation.validateRentalRate();
        InputValidation.validateFilmLength();
        InputValidation.validateReplaceCost();
        InputValidation.validateSpecialFeature();

        //setting the user input to array.
        filmList.add(InputValidation.filmObj);
        //printing out full array with new film added
        System.out.println(filmList);
        //------------------ Question 5 & 6 -----------------------------


        //------------------ Question 1 ---------------------------------
        MergeSortFilms.mergeSort(films, 0, films.length);
        //System.out.println(films[1]);
        //System.out.println(films[999]);
        /*for (int k = 0; k < films.length; k++) {
            System.out.println(films[k]);
         */
        //------------------ Question 1 ---------------------------------

        //------------------ Question 3 ---------------------------------
        BinarySearchFilm binarySearchFilm = new BinarySearchFilm();
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter The Title of the Film You're Searching for: ");
        //using toUpperCase to make sure user input is consistent with data entry in array.
        String filmInput = input.nextLine().toUpperCase();
        int results = binarySearchFilm.binarySearchRecursion(films, 0, films.length-1, filmInput);
        //depending on input from user, user will receive one of the followng messages.
        if (results == -1)
            System.out.println("Film not Found. Film may not exist or the spelling may be incorrect.");
        else
            System.out.println("Film Found at Index "+ results +" " + films[results]);
        input.close();
        //------------------ Question 3 ---------------------------------

        //------------------ Question 4 ---------------------------------
        //Searching 10 Films with known film------------------------------------------------------
        long startTimeSearch10 = System.nanoTime();
        binarySearchFilm.binarySearchRecursion(films, 0, 10, "ACADEMY DINOSAUR");
        long endTimeSearch10 = System.nanoTime();
        long timeTakenSearch10 = endTimeSearch10 - startTimeSearch10;
        System.out.println("Time taken to search 10 films: "+ timeTakenSearch10 + "ns");

        //Searching 100 Films with known film------------------------------------------------------
        long startTimeSearch100 = System.nanoTime();
        binarySearchFilm.binarySearchRecursion(films, 0, 100, "ACADEMY DINOSAUR");
        long endTimeSearch100 = System.nanoTime();
        long timeTakenSearch100 = endTimeSearch100 - startTimeSearch100;
        System.out.println("Time taken to search 100 films: "+ timeTakenSearch100+ "ns");

        //Searching 500 Films with known film------------------------------------------------------
        long startTimeSearch500 = System.nanoTime();
        binarySearchFilm.binarySearchRecursion(films, 0, 500, "ACADEMY DINOSAUR");
        long endTimeSearch500 = System.nanoTime();
        long timeTakenSearch500 = endTimeSearch500 - startTimeSearch500;
        System.out.println("Time taken to search 500 films: "+ timeTakenSearch500 + "ns");

        //Searching 1000 Films with known film------------------------------------------------------
        long startTimeSearch1000 = System.nanoTime();
        binarySearchFilm.binarySearchRecursion(films, 0, 1000, "ACADEMY DINOSAUR");
        long endTimeSearch1000 = System.nanoTime();
        long timeTakenSearch1000 = endTimeSearch1000 - startTimeSearch1000;
        System.out.println("Time taken to search 1000 films: "+ timeTakenSearch1000 + "ns");
        //------------------ Question 4 ---------------------------------

        //------------------ Question 2 ---------------------------------
        //10 items----------------------------------------------------------
        long startTime10 = System.nanoTime();
        MergeSortFilms.mergeSort(films, 0, 10);
        long endTime10 = System.nanoTime();
        long timeTaken10 = endTime10 - startTime10;
        System.out.println("Time taken to sort 10 items: "+ timeTaken10 + "ns");

        //100 items-----------------------------------------------
        long startTime100 = System.nanoTime();
        MergeSortFilms.mergeSort(films, 0, 100);
        long endTime100 = System.nanoTime();
        long timeTaken100 = endTime100 - startTime100;
        System.out.println("Time taken to sort 100 items: "+ timeTaken100 + "ns");

        //500 items------------------------------------------
        long startTime500 = System.nanoTime();
        MergeSortFilms.mergeSort(films, 0, 500);
        long endTime500 = System.nanoTime();
        long timeTaken500 = endTime500 - startTime500;
        System.out.println("Time taken to sort 500 items: "+ timeTaken500 + "ns");

        //1000 items------------------------------------------
        long startTime1000 = System.nanoTime();
        MergeSortFilms.mergeSort(films, 0, 1000);
        long endTime1000 = System.nanoTime();
        long timeTaken1000 = endTime1000 - startTime1000;
        System.out.println("Time taken to sort 1000 items: "+ timeTaken1000 + "ns");
        //------------------ Question 2 ---------------------------------

        // We can print film details due to overridden toString method in film class
        //System.out.println(films[0]);
        //System.out.println(films[999]);

        // we can compare films based on their first name due to overridden CompareTo method in film class
        //System.out.println(films[0]==films[0]);
        //System.out.println(films[0]==films[1]);
    }
}

class Film implements Comparable<Object>{

    private int filmID;
    private String title;
    private String description;
    private int releaseYear;
    private double rentalRate;
    private int length;
    private double replacementCost;
    private String specialFeatures;

    // constructor
    public Film(int filmID, String title, String description, int releaseYear, double rentalRate, int length,
                double replacementCost, String specialFeatures) {
        super();
        this.filmID = filmID;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.specialFeatures = specialFeatures;
    }

    // setters and getters
    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }


    // so the film objects can be compared when sorting/searching
    // NOTE: this will only allow comparisons based on the title of the film
    //@Override

    // so the film objects can be compared when sorting/searching
    // NOTE: this will only allow comparisons based on the title of the film
    //@Override
    public int compareTo(Object obj) {
       Film flm = (Film)obj;
        return title.compareTo(flm.getTitle());
    }

    @Override
    public String toString() {
        return "Film [filmID=" + filmID + ", title=" + title + ", description=" + description + ", releaseYear="
                + releaseYear + ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost="
                + replacementCost + ", specialFeatures=" + specialFeatures + "]";
    }
}
