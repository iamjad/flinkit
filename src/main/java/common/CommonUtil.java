package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
    public static int safeStringToInt(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
        }catch (Exception ex) {
            // do nothing
        }
        return result;
    }

    public static long safeDateToLong(String input) {
        long result = 0;
        try {
            if (input == null || input.trim().isEmpty()) {
                return result;
            }
            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(input.trim());
            result = date.getTime() / 1000; // convert to seconds
        }catch (Exception ex) {
            // do nothing
        }
        return result;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(safeDateToLong("08/05/2021")); //
    }
}
