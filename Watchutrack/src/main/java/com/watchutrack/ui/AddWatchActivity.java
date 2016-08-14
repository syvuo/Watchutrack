package com.watchutrack.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.watchutrack.R;
import com.watchutrack.entity.Watch;
import com.watchutrack.timekeeping.AccuracyRating;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Sly-Desktop on 2016-08-13.
 */
public class AddWatchActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_watch_form);

        Button btnAdd =  (Button) findViewById(R.id.btnAdd);
        Button btnCancel =  (Button) findViewById(R.id.btnCancel);

        final EditText companyInput = (EditText) findViewById(R.id.companyInput);
        final EditText seriesInput = (EditText) findViewById(R.id.seriesInput);
        final EditText modelInput = (EditText) findViewById(R.id.modelInput);
        final EditText accuracyRatingPlusInput = (EditText) findViewById(R.id.accuracyRatingPlusInput);
        final EditText accuracyRatingMinusInput = (EditText) findViewById(R.id.accuracyRatingMinusInput);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validInputs(companyInput, seriesInput, modelInput, accuracyRatingPlusInput, accuracyRatingMinusInput)){
                    Watch watch = new Watch()
                            .withCompany(companyInput.getText().toString())
                            .withSeries(seriesInput.getText().toString())
                            .withModel(modelInput.getText().toString())
                            .withAccuracyRating(new AccuracyRating(
                                    Float.parseFloat(accuracyRatingPlusInput.getText().toString()),
                                    Float.parseFloat(accuracyRatingMinusInput.getText().toString()))
                            );

                    Intent returnWatch = new Intent();
                    returnWatch.putExtra("watch", watch);
                    setResult(Activity.RESULT_OK, returnWatch);
                    finish();
                }
                else{
                    setFocusRequiredFieldInputError(companyInput);
                    setFocusRequiredFieldInputError(seriesInput);
                    setFocusRequiredFieldInputError(modelInput);
                    setFocusNumericValueInputError(accuracyRatingPlusInput);
                    setFocusNumericValueInputError(accuracyRatingMinusInput);
                }
            }
        });
    }

    private void setFocusRequiredFieldInputError(final EditText pEditText){
        pEditText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!validateInputIsNotBlank(pEditText)){
                    setErrorRequiredField(pEditText);
                }
            }
        });
    }
    private void setFocusNumericValueInputError(final EditText pEditText){
        pEditText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(!validateInputIsNumeric(pEditText)){
                    setErrorNumericValue(pEditText);
                }
            }
        });
    }

    private boolean validInputs(EditText pCompanyInput, EditText pSeriesInput, EditText pModelInput, EditText pAccuracyRatingPlusInput, EditText pAccuracyRatingMinusInput){
        boolean validInputs = true;

        if(!validateInputIsNotBlank(pCompanyInput)){
            setErrorRequiredField(pCompanyInput);
            validInputs = false;
        }
        if(!validateInputIsNotBlank(pSeriesInput)){
            setErrorRequiredField(pSeriesInput);
            validInputs = false;
        }
        if(!validateInputIsNotBlank(pModelInput)){
            setErrorRequiredField(pModelInput);
            validInputs = false;
        }
        if(!validateInputIsNumeric(pAccuracyRatingPlusInput)){
            setErrorNumericValue(pAccuracyRatingPlusInput);
            validInputs = false;
        }
        if(!validateInputIsNumeric(pAccuracyRatingMinusInput)){
            setErrorNumericValue(pAccuracyRatingMinusInput);
            validInputs = false;
        }
        return validInputs;
    }


    private boolean validateInputIsNotBlank(EditText pEditText){
        if(pEditText.getText().toString().length() < 1){
            return false;
        }
        return true;
    }
    private boolean validateInputIsNumeric(EditText pEditText){
        if(!StringUtils.isNumeric(pEditText.getText().toString())){
            return false;
        }
        return true;
    }

    private void setErrorRequiredField(EditText pEditText){
        pEditText.setError("Required field");
    }
    private void setErrorNumericValue(EditText pEditText){
        pEditText.setError("Must be a numeric value");
    }

}
