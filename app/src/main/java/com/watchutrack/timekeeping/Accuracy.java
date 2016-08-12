package com.watchutrack.timekeeping;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

import lombok.Data;

/**
 * Created by Sly-Desktop on 2016-08-11.
 */

@Data
public class Accuracy {

    private float timeDifference;
    private TimeInput previousInput;
    private TimeInput currentInput;


    public String normalizeDailyAccuracy(){
        return "";
    }

    private int getDaysBetween (Timestamp start, Timestamp end){

        boolean negative = false;
        if (end.before(start))  {
            negative = true;
            Timestamp temp = start;
            start = end;
            end = temp;
        }

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(start);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        GregorianCalendar calEnd = new GregorianCalendar();
        calEnd.setTime(end);
        calEnd.set(Calendar.HOUR_OF_DAY, 0);
        calEnd.set(Calendar.MINUTE, 0);
        calEnd.set(Calendar.SECOND, 0);
        calEnd.set(Calendar.MILLISECOND, 0);


        if (cal.get(Calendar.YEAR) == calEnd.get(Calendar.YEAR)){
            if (negative)
                return (calEnd.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR)) * -1;
            return calEnd.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
        }

        int days = 0;
        while (calEnd.after(cal))    {
            cal.add (Calendar.DAY_OF_YEAR, 1);
            days++;
        }
        if (negative)
            return days * -1;
        return days;
    }

}
