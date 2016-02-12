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
        for (Country country : allCountries) {
            char firstLetter = country.countryName.charAt(0);
            countryMap.put(firstLetter, new ArrayList<Country>());
        }
        for (Country country : allCountries) {
            char firstLetter = country.countryName.charAt(0);
            countryMap.get(firstLetter).add(country);
        }

        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Please enter a letter.");
        String userInput = consoleScanner.nextLine().toLowerCase();
        if (userInput.length() != 1) {
            throw new Exception("Input must be one character.");
        }
        char firstLetter = userInput.charAt(0);
        String fileName = userInput + "_countries.txt";
        String fileContentToBeWritten = "";

        for (Country country : countryMap.get(firstLetter)) {
            fileContentToBeWritten += country.countryName + " " + country.countryAb + "\n";
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