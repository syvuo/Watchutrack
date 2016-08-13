package com.watchutrack.timekeeping;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import lombok.Data;

/**
 * Created by Sly-Desktop on 2016-08-11.
 */

@Data
public class Accuracy {

    private boolean firstInput;
    private TimeInput previousTimeInput;
    private TimeInput timePieceInput;

    private float deviation; //seconds
    private float rate; //seconds/day

    public Accuracy(boolean pFirstInput, TimeInput pPreviousTimeInput, TimeInput pTimePieceInput){
        this.firstInput = pFirstInput;
        this.timePieceInput = pTimePieceInput;

        if(pFirstInput){
            this.previousTimeInput = null;
        }
        else{
            this.previousTimeInput = pPreviousTimeInput;
        }
    }

    public String getDeviationString(){
        if(this.deviation > 0){
            return ("+" + this.deviation + " s");
        }
        return ("-" + this.deviation + " s");
    }

    public String getRateString(){
        if(this.rate > 0){
            return ("+" + this.rate + " s/d");
        }
        return ("-" + this.rate + " s/d");
    }

}
