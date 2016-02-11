import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<Character, ArrayList<String>> countryMap = new HashMap();



        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        while(fileScanner.hasNext()){
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns [0], columns [01]);
            char firstLetter = Country.


        }





    }
    }






/*      Description

        Fork the Countries project. Parse each line and store the contents into a data structure.
        Ask the user to type a letter and save a file that lists only the countries starting with it.

        Requirements

        Create a Country class to store both the name and abbreviation.
        Read and parse the "countries.txt" file into an HashMap<String, ArrayList<Country>>
        where the key is a single letter and the value is a list of countries whose names start with that letter.
        Ask the user to type a letter (if they don't type a single letter, throw an exception).
        Save an "X_countries.txt" file, where X is the letter they typed,
        which only lists the countries starting with that letter.



        Optional tasks
        Break your code into separate methods, especially the for loop that loops over each line in the file,
        and the code under it that reads the user's input and writes the file.

        Encode the output as JSON instead of building a string manually. You should be able to take the ArrayList
        you pulled out of your HashMap and directly pass it to the serialize method.
        Remember to add getters to your Country class.

        Override the toString method in your Country class so when you print your HashMap you can see the
        country abbreviations and names. Recall that, by default, Java prints out objects like this: Country@21345362.*/