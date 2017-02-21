package com.techpalle.myapplication;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragDetailspage extends Fragment {
    Button b1, b2, b3;
    EditText et2, et3, et4, et5, et6, et7, et8;
    MyDatabase myDatabase;



    public FragDetailspage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.open();
    }

    @Override
    public void onDestroy() {
        myDatabase.close();
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.detailspage, container, false);

        et2 = (EditText) v.findViewById(R.id.edittext2);
        et3 = (EditText) v.findViewById(R.id.edittext3);
        et4 = (EditText) v.findViewById(R.id.edittext4);
        et5 = (EditText) v.findViewById(R.id.edittext5);
        et6 = (EditText) v.findViewById(R.id.edittext6);
        et7 = (EditText) v.findViewById(R.id.edittext7);
        et8 = (EditText) v.findViewById(R.id.edittext8);
        b1 = (Button) v.findViewById(R.id.button1);
        b2 = (Button) v.findViewById(R.id.button2);
        b3 = (Button) v.findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateDialog();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = et2.getText().toString();
                String name = et3.getText().toString();
                String mobile = et4.getText().toString();
                String email = et5.getText().toString();
                String sub = et6.getText().toString();
                String des = et7.getText().toString();
                String time = et8.getText().toString();
                myDatabase.insertStudent(no, name, mobile, email, sub, des, time);
                Toast.makeText(getActivity(), "inserted a row", Toast.LENGTH_SHORT).show();
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                et7.setText("");
                et8.setText("");
                et2.requestFocus();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity m = (MainActivity) getActivity();
                m.clickhomebutton();
            }
        });
        return v;
    }
    public Dialog onCreateDialog() {
        Dialog d = null;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                //this method will be called when user click s done button
                Toast.makeText(getActivity(), "selected :" + year + "-" + month + 1 + "-" + date, Toast.LENGTH_LONG).show();
                et8.setText(year + "-" + month + 1 + "-" + date);
            }
        }, year, month, date);
        d = datePickerDialog;
        d.show();
        return d;
    }
}