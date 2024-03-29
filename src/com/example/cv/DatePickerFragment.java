package com.example.cv;

import java.util.Calendar;
import com.example.cv.FirstActivity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;



//public class DatePickerFragment extends DialogFragment
public class DatePickerFragment extends DialogFragment
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) 
    {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it;
        return new DatePickerDialog(getActivity(), (FirstActivity)getActivity(), year, month, day);
    }
}
