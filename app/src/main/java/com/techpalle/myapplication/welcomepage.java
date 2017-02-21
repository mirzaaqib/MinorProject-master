package com.techpalle.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class welcomepage extends Fragment {
    TextView tv1,tv2;
    Button b1,b2;
    ImageView imageView;


    public welcomepage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.welcomepage, container, false);
        tv1= (TextView) v.findViewById(R.id.textview1);
        tv2= (TextView) v.findViewById(R.id.textview2);
        imageView= (ImageView) v.findViewById(R.id.imageview);
        b1= (Button) v.findViewById(R.id.button);
        b2= (Button) v.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity m= (MainActivity) getActivity();
                m.registerbuttonclicked();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.clickloginbutton();

            }
        });
        return v;
    }

}
