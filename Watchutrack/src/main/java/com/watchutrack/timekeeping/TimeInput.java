package com.watchutrack.timekeeping;

import java.sql.Timestamp;

import lombok.Data;

/**
 * Created by Sly-Desktop on 2016-08-11.
 */

@Data
public class TimeInput {

    private Timestamp currentDeviceTime;
    private Timestamp inputTime;

    public TimeInput(Timestamp pCurrentDeviceTime, Timestamp pInputTime){
        this.currentDeviceTime = pCurrentDeviceTime;
        this.inputTime = pInputTime;
    }

}
