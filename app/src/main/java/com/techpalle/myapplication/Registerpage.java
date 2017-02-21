package com.techpalle.myapplication;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registerpage extends Fragment {
    Button b1,b2;
    EditText et2,et3,et4,et5,et6,et7;
//    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    ImageView imageView;


    public Registerpage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.registerpage, container, false);
        imageView= (ImageView) v.findViewById(R.id.imageview2);
        et2= (EditText) v.findViewById(R.id.edittext2);
        et3= (EditText) v.findViewById(R.id.edittext3);
        et4= (EditText) v.findViewById(R.id.edittext4);
        et5= (EditText) v.findViewById(R.id.edittext5);
        et6= (EditText) v.findViewById(R.id.edittext6);
        et7= (EditText) v.findViewById(R.id.edittext7);
//        tv1= (TextView) v.findViewById(R.id.textview8);
//        tv2= (TextView) v.findViewById(R.id.textview9);
//        tv3= (TextView) v.findViewById(R.id.textview10);
//        tv4= (TextView) v.findViewById(R.id.textview11);
//        tv5= (TextView) v.findViewById(R.id.textview12);
//        tv6= (TextView) v.findViewById(R.id.textview13);
        b1= (Button) v.findViewById(R.id.button1);
        b2= (Button) v.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp= getActivity().getSharedPreferences("credentials",0);
                SharedPreferences.Editor editor=sp.edit();//open editor
                editor.putString("no",et5.getText().toString());//writename
                editor.putString("name",et3.getText().toString());//writepw
                editor.putString("email",et4.getText().toString());
                editor.putString("pw",et6.getText().toString());
                editor.putString("confirm",et7.getText().toString());
                editor.putString("pwhit",et2.getText().toString());
                editor.commit();//save in to preference file
                Toast.makeText(getActivity(), "register here", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity m= (MainActivity) getActivity();
                m.clickloginbutton();


            }
        });


        return v;
    }

}
