package com.example.sly_desktop.helloworld.timekeeping;

import lombok.Data;

/**
 * Created by Sly-Desktop on 2016-08-11.
 */

@Data
public class AccuracyRating {

    private Short plus;
    private Short minus;

    public AccuracyRating(Short pPlus, Short pMinus){
        this.plus = pPlus;
        this.minus = pMinus;
    }

    @Override
    public String toString(){
        return ("+" + this.plus+"/-"+this.minus);
    }

}
