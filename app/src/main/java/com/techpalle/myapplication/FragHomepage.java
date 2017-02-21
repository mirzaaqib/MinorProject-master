package com.techpalle.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragHomepage extends Fragment {
            TextView tv1;
    Button b1,b2,b3,b4,b5,b6,b7;

    public FragHomepage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.homepage, container, false);
        tv1= (TextView) v.findViewById(R.id.textview7);
        b1= (Button) v.findViewById(R.id.button1);
        b2= (Button) v.findViewById(R.id.button2);
        b3= (Button) v.findViewById(R.id.button3);
        b4= (Button) v.findViewById(R.id.button4);
        b5= (Button) v.findViewById(R.id.button5);
        b6= (Button) v.findViewById(R.id.button6);
        b7= (Button) v.findViewById(R.id.button7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            MainActivity m= (MainActivity) getActivity();
                m.loadstudentdetails();
                Toast.makeText(getActivity(), "clickhere", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity m= (MainActivity) getActivity();
                m.loadstudentdetails();
                Toast.makeText(getActivity(), "clickhere", Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity m= (MainActivity) getActivity();
                m.loadstudentdetails();
                Toast.makeText(getActivity(), "clickhere", Toast.LENGTH_SHORT).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity m= (MainActivity) getActivity();
                m.loadstudentdetails();
                Toast.makeText(getActivity(), "clickhere", Toast.LENGTH_SHORT).show();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity m= (MainActivity) getActivity();
                m.loadlistview();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            MainActivity m= (MainActivity) getActivity();
                m.clicksearch();
            }
        });



        return v;
    }

}
