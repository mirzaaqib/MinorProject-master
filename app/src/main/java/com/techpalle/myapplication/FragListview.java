package com.techpalle.myapplication;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragListview extends Fragment {
    ListView lv;
    MyDatabase myDatabase;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;


    public FragListview() {
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
        myDatabase.close();//before super
        super.onDestroy();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragmentlistview, container, false);
        lv= (ListView) v.findViewById(R.id.listview1);
        //code for displaying database table information on listview
        //a-get cursor from table
        cursor=myDatabase.queryStudent();
        simpleCursorAdapter=new SimpleCursorAdapter(getActivity(),R.layout.row1,cursor,
                new String[]{"sno", "sname", "semail", "ssub", "sdes","smobile","stime"},
                new int[]{R.id.textview1, R.id.textview2, R.id.textview3, R.id.textview4, R.id.textview5,R.id.textview6,R.id.textview7});
        lv.setAdapter(simpleCursorAdapter);



        return v;
    }

}
