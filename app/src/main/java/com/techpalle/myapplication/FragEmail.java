package com.techpalle.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragEmail extends Fragment {
    Button b1,b2;
    TextView tv1,tv2,tv3;
    EditText et1,et2,et3;


    public FragEmail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragmentemail, container, false);
        b1= (Button) v.findViewById(R.id.button1);
        b2= (Button) v.findViewById(R.id.button2);
        et1= (EditText) v.findViewById(R.id.edittext1);
        et2= (EditText) v.findViewById(R.id.edittext2);
        et3= (EditText) v.findViewById(R.id.edittext3);
        tv1= (TextView) v.findViewById(R.id.textview1);
        tv2= (TextView) v.findViewById(R.id.textview2);
        tv3= (TextView) v.findViewById(R.id.textview3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.searchDetails();
            }
        });
        return v;
    }

}
