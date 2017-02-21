package com.techpalle.myapplication;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Datepicker extends DialogFragment {


    public Datepicker() {
        // Required empty public constructor
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d=null;
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        int date=calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                //this method will be called when user click s done button
                Toast.makeText(getActivity(),"selected :"+year+"-"+month+1+"-"+date,Toast.LENGTH_LONG).show();
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.passData(+year+"-"+month +"-"+date);
            }
        }, year, month, date);
        d=datePickerDialog;
        return d;
    }
}

