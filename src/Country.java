/**
 * Created by ericweidman on 2/11/16.
 */
public class Country {
    String countryName;
    String countryAb;


    public Country(String countryAb, String countryName) {
        this.countryName = countryName;
        this.countryAb = countryAb;
    }

    public Country() {

    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryAb() {
        return countryAb;


    }
}
