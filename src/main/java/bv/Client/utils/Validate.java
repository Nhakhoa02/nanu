package bv.Client.utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Validate is the class calculates the age of the players.
 *
 * The class one method: getAge(LocalDate birthday) to calculate the player's
 * age by take the current year minus the player's born year.
 */

public class Validate {
    public static int getAge(LocalDate birthday) {

        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) - birthday.getYear();
    }

}
