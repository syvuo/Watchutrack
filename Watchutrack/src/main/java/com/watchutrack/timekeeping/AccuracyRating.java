package com.watchutrack.timekeeping;

import lombok.Data;

/**
 * Created by Sly-Desktop on 2016-08-11.
 */

@Data
public class AccuracyRating {

    private float plus;
    private float minus;

    public AccuracyRating(float pPlus, float pMinus){
        this.plus = pPlus;
        this.minus = pMinus;
    }

    @Override
    public String toString(){
        return ("+" + this.plus+"/-"+this.minus);
    }

}
