package com.watchutrack.entity;

import com.watchutrack.timekeeping.Accuracy;
import com.watchutrack.timekeeping.AccuracyRating;
import com.watchutrack.timekeeping.TimeInput;

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
