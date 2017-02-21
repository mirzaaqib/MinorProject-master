package com.techpalle.myapplication;


import android.annotation.TargetApi;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragSearchpage extends Fragment {

    EditText et1,et2;
    Button b1,b2;
    MyDatabase myDatabase;



    public FragSearchpage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase=new MyDatabase(getActivity());
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
        View v= inflater.inflate(R.layout.searchpage, container, false);

        et1= (EditText) v.findViewById(R.id.edittext8);
        et2= (EditText) v.findViewById(R.id.edittext9);

        b1= (Button) v.findViewById(R.id.button8);
        b2= (Button) v.findViewById(R.id.button9);

        b1.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(getActivity(), "enter your name", Toast.LENGTH_SHORT).show();
                }
                else {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.passNameSearch(name);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {

                String mobile=et2.getText().toString();

                if(mobile.isEmpty()){
                    Toast.makeText(getActivity(), "enter your mobile no", Toast.LENGTH_SHORT).show();
                }
                else {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.passMobileSearch(mobile);
                }
            }
        });
        return v;
    }

}
