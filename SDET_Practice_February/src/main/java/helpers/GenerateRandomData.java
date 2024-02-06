package helpers;

import com.github.javafaker.Faker;

import java.nio.charset.Charset;
import java.time.Year;
import java.util.Random;

public class GenerateRandomData {
    private static final Faker faker = new Faker();
    private static final String email ="[a-z]{10}\\"+"@"+"[a-z]{10}\\"+"."+"com";

    public static String generateRandomText(){
        byte[] array = new byte[randBetween(1,100)];
        new Random().nextBytes(array);
        String randomText = new String(array, Charset.forName("UTF-8"));
        return randomText;
    }

    public static String generateRandomFirstName(){
        return faker.name().firstName();
    }

    public static String generateRandomLastName(){
        return faker.name().lastName();
    }
    public static String generateRandomEmail(){
        return faker.regexify(email);
    }

    public static String generatePhoneNumber(){return faker.phoneNumber().subscriberNumber(10);}
    public static int generateRandomYear(){
        int year=randBetween(1900,2100);
        return  year;
    }
    public static int generateRandomMonth(){
        int month = randBetween(1,12);
        return month;
    }
    public static int generateRandomDay(int year,int month) {
        int day = 1;
        if (Year.isLeap(year)) {
            if (month == 2) {
                day = randBetween(1, 29);
            } else {
                day = randBetween(1, 28);
            }
        }
        if (month != 2) {
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                day = randBetween(1, 30);
            } else {
                day = randBetween(1, 30);
            }
        }
        return day;
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
