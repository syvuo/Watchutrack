package com.watchutrack.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.watchutrack.timekeeping.Accuracy;
import com.watchutrack.timekeeping.AccuracyRating;
import com.watchutrack.timekeeping.TimeInput;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sly-Desktop on 2016-08-11.
 */

@Data
@NoArgsConstructor
public class Watch implements Parcelable{

    private String company;
    private String series;
    private String model;
    private AccuracyRating accuracyRating;

    private List<Accuracy> accuracyList;

    public Watch withCompany(String pCompany){
        this.company = pCompany;
        return this;
    }
    public Watch withSeries(String pSeries){
        this.series = pSeries;
        return this;
    }
    public Watch withModel(String pModel){
        this.model = pModel;
        return this;
    }
    public Watch withAccuracyRating(AccuracyRating pAccuracyRating){
        this.accuracyRating = pAccuracyRating;
        return this;
    }

    // Parcelling part
    public Watch(Parcel in){
        String[] stringData = new String[3];
        float[] floatData = new float[2];

        in.readStringArray(stringData);
        in.readFloatArray(floatData);

        this.company = stringData[0];
        this.series = stringData[1];
        this.model = stringData[2];
        this.accuracyRating = new AccuracyRating(floatData[0],floatData[1]);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
                this.company,
                this.series,
                this.model
        });
        dest.writeFloatArray(new float[] {
                this.accuracyRating.getPlus(),
                this.accuracyRating.getMinus()
        });
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Watch createFromParcel(Parcel in) {
            return new Watch(in);
        }

        public Watch[] newArray(int size) {
            return new Watch[size];
        }
    };

    @Override
    public String toString(){
        return this.company + " " + this.series + " " + this.model;
    }

}
