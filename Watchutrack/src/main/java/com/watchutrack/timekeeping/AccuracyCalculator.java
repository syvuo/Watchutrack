package com.watchutrack.timekeeping;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Sly-Desktop on 2016-08-12.
 */
public class AccuracyCalculator {

    public float getDaysBetween(TimeInput pStart, TimeInput pEnd){
        long startMillis = pStart.getCurrentDeviceTime().getTime();
        long endMillis = pEnd.getCurrentDeviceTime().getTime();

        return (endMillis - startMillis ) / (1000 * 60 * 60 * 24);
    }

    public float calculateDeviation(TimeInput pTimeInput){
        long deviceTime = pTimeInput.getCurrentDeviceTime().getTime();
        long inputTime = pTimeInput.getInputTime().getTime();

        return (inputTime - deviceTime) / (1000);
    }

    public float calculateRate(TimeInput pPreviousTimeInput, TimeInput pTimePieceInput, float pDeviation){
        return pDeviation/getDaysBetween(pPreviousTimeInput, pTimePieceInput);
    }

}
