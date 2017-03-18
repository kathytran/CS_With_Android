import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Country {
    private static HashMap<String, String> countries = new HashMap<String, String>();

    public static void main(String[] args) {
        countries.put("USA", "United States of America");
        countries.put("AFG", "Afghanistan");
        countries.put("GBR", "United Kingdom of Great Britain and Northern Ireland");
        countries.put("IDN", "Indonesia");
        countries.put("IND", "India");
        System.out.println("Enter Country Name/Code");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        if (!exists(code)){   // error if the code doesn't exist
            System.out.println("ERROR. Country not found. Exiting...");
            System.exit(0);
        }
        if (code.length() == 3) {   // outputs country name if code is valid
            System.out.println(getCountry(code));
        }
        else {   // outputs code if country name is valid
            System.out.println(getCode(code));
        }
    }

    public static boolean exists(String input) {   // checks if the key/value is valid
        if (countries.containsValue(input)) return true;
        if (countries.containsKey(input)) return true;
        return false;
    }
    public static String getCountry(String code) {    // returns the name of the country in which the code belongs
        if (!countries.containsKey(code)) return "Country not found.";
        return countries.get(code);
    }
    public static String getCode(String code) {   // returns the code that the country belongs to
        for (Map.Entry<String, String> entry : countries.entrySet()) {
            if (entry.getValue().equals(code)) {
                return entry.getKey();
            }
        }
        return "ERROR. Country not found";
    }
}
