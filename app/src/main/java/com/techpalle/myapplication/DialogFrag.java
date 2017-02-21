package com.techpalle.myapplication;


import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFrag extends DialogFragment {
    ListView lv;
    MyDatabase myDatabase;
    Cursor cursor;
    String name,mobile;
    SimpleCursorAdapter simpleCursorAdapter;


    public DialogFrag() {
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
        myDatabase.close();//before super
        super.onDestroy();

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setIcon(R.drawable.search_image);
        builder.setTitle("Details of Student");

        Bundle bundle = getArguments();
        name = bundle.getString("name");
        mobile = bundle.getString("mobile");
        Toast.makeText(getActivity(), ""+name, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(), ""+mobile, Toast.LENGTH_SHORT).show();
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog, null);

      lv = (ListView) v.findViewById(R.id.listview2);

        if (name!=null) {
            cursor = myDatabase.queryStudentname(name);

            simpleCursorAdapter = new SimpleCursorAdapter(getActivity(), R.layout.row1, cursor,
                    new String[]{"sno", "sname", "semail", "ssub", "sdes", "smobile", "stime"},
                    new int[]{R.id.textview1, R.id.textview2, R.id.textview3, R.id.textview4, R.id.textview5, R.id.textview6,R.id.textview7});
            lv.setAdapter(simpleCursorAdapter);
        }

        else if (mobile!=null){

            cursor = myDatabase.queryStudentmobile(mobile);
            simpleCursorAdapter = new SimpleCursorAdapter(getActivity(), R.layout.row1, cursor,
                    new String[]{"sno", "sname", "semail", "ssub", "sdes", "smobile", "stime"},
                    new int[]{R.id.textview1, R.id.textview2, R.id.textview3, R.id.textview4, R.id.textview5, R.id.textview6,R.id.textview7});
            lv.setAdapter(simpleCursorAdapter);
        }
        builder.setView(v);

            builder.setPositiveButton("sms", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity m = (MainActivity) getActivity();
                    m.smssend();
                    Toast.makeText(getActivity(), "send sms", Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("Email", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.emailsend();

                }
            });
            d = builder.create();
            return d;

        }

    }
