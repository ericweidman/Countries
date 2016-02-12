import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Countries {
    public static void main(String[] args) throws Exception {
        HashMap<Character, ArrayList<Country>> countryMap = new HashMap();
        ArrayList<Country> allCountries = new ArrayList<Country>();

        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            allCountries.add(country);
        }
         for(Country country : allCountries) {
             char firstLetter = country.countryName.charAt(0);
             countryMap.put(firstLetter, new ArrayList<Country>());
         }
       for(Country country : allCountries) {
           char firstLetter = country.countryName.charAt(0);
           countryMap.get(firstLetter).add(country);
       }

            Scanner consoleScanner = new Scanner(System.in);
            System.out.println("Please enter a letter.");
            String userInput = consoleScanner.nextLine().toLowerCase();
            if(userInput.length()!=1) {
                throw new Exception("Input must be one character.");
            }
            char firstLetter = userInput.charAt(0);
            String fileName = userInput + "_countries.txt";
            String fileContentToBeWritten = "";

            for (Country country: countryMap.get(firstLetter)){
                fileContentToBeWritten += country.countryName + " " + country.countryAb+ "\n";
            }
            writeFile(fileName, fileContentToBeWritten);

        }

    static void writeFile(String fileName, String fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(fileContent);
        fw.close();
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