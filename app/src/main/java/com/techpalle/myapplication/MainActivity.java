package com.techpalle.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    public void passNameSearch(String name){
        DialogFrag dialogFrag = new DialogFrag();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        dialogFrag.setArguments(bundle);
        dialogFrag.show(getSupportFragmentManager(), null);
    }

    public void passMobileSearch(String mobile){
        DialogFrag dialogFrag = new DialogFrag();
        Bundle bundle = new Bundle();
        bundle.putString("mobile", mobile);
        dialogFrag.setArguments(bundle);
       dialogFrag.show(getSupportFragmentManager(), null);

    }
 public void  clicksearch(){
     FragSearchpage fragSix=new FragSearchpage();
     FragmentManager fm=getSupportFragmentManager();
     FragmentTransaction fragmentTransaction=fm.beginTransaction();
     fragmentTransaction.replace(R.id.container1,fragSix);
     fragmentTransaction.addToBackStack(null);
     fragmentTransaction.commit();
 }
    public void loadlistview(){
        FragListview fragListview=new FragListview();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fm.beginTransaction();
        fragmentTransaction.replace(R.id.container1,fragListview);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void loadstudentdetails(){
        FragDetailspage f5=new FragDetailspage();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1,f5);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public  void registerbuttonclicked(){
        Registerpage f4=new Registerpage();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1, f4);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public  void clickloginbutton(){
        FragLoginpage f2=new FragLoginpage();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1, f2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void clickhomebutton(){
        FragHomepage f3=new FragHomepage();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1, f3);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void smssend(){
        FragEmail fragEmail=new FragEmail();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.container1,fragEmail);
        ft.addToBackStack(null);
        ft.commit();

    }
    public void emailsend(){
        FragSearchpage fragSix=new FragSearchpage();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.container1,fragSix);
        ft.addToBackStack(null);
        ft.commit();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomepage f1 = new welcomepage();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container1, f1);
        ft.commit();
    }

    public void passData(String s) {

    }
}
