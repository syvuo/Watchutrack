package com.example.sly_desktop.helloworld.entity;

import com.example.sly_desktop.helloworld.timekeeping.Accuracy;
import com.example.sly_desktop.helloworld.timekeeping.AccuracyRating;
import com.example.sly_desktop.helloworld.timekeeping.TimeInput;

import java.util.List;

import lombok.Data;

/**
 * Created by Sly-Desktop on 2016-08-11.
 */

@Data
public class Watch {

    private String brand;
    private String series;
    private String model;
    private AccuracyRating accuracyRating;

    private List<TimeInput> timeInputs;
    private Accuracy accuracy;

    public Watch(String pBrand, String pSeries, String pModel, AccuracyRating pAccuracyRating){
        this.brand = pBrand;
        this.series = pSeries;
        this.model = pModel;
        this.accuracyRating = pAccuracyRating;
    }

}
