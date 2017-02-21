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
public class FragLoginpage extends Fragment {
//    TextView tv1,tv2,tv3,tv4;
    EditText et1,et2,et3;
    ImageView iv;
    Button b1,b2;


    public FragLoginpage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.loginpage, container, false);
//        tv1= (TextView) v.findViewById(R.id.textview3);
//        tv2= (TextView) v.findViewById(R.id.textview4);
//        tv3= (TextView) v.findViewById(R.id.textview5);
//        tv4= (TextView) v.findViewById(R.id.textview6);
        iv= (ImageView) v.findViewById(R.id.imageview2);
        et1= (EditText) v.findViewById(R.id.edittext1);
        et2= (EditText) v.findViewById(R.id.edittext2);
        et3= (EditText) v.findViewById(R.id.edittext3);
        b1= (Button) v.findViewById(R.id.button3);
        b2= (Button) v.findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp= getActivity().getSharedPreferences("credentials",0);
                String name=sp.getString("name",null);
                String pw=sp.getString("pw",null);
               String editname=et1.getText().toString();
                String editpw=et2.getText().toString();
                if ((editpw.equals(pw))&&(editname.equals(name))){
                    Toast.makeText(getActivity(), "login success", Toast.LENGTH_SHORT).show();
                    MainActivity m= (MainActivity) getActivity();
                    m.clickhomebutton();
                }else {
                    Toast.makeText(getActivity(), "login failed", Toast.LENGTH_SHORT).show();

                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et3.getText().toString();


            }
        });
        return v;
    }

}
