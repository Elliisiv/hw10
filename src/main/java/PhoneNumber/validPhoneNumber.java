package PhoneNumber;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validPhoneNumber {public static boolean isValid(String s) {

    Pattern p = Pattern.compile("^((\\([0-9]{3}\\) )|([0-9]{3}\\-))[0-9]{3}\\-[0-9]{4}$");
    Matcher m = p.matcher(s);
    return (m.find() && m.group().equals(s));
}

    public static void main(String[] args) {
        File file = new File("./files/phone.txt");

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (isValid(line))
                        System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}