package com.example.djamel.tp602_12_2018;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements fragment3.fragment3listner,fragment2.fragment2listner{
     private LinearLayout fragmentE1, fragmentE2, fragmentE3  ;
    TextView textView1 ,textView2, textView3;
     protected static final String THUMBNAIL_IDS = "thumbNailIDs";
    protected static   String TEST = "";
    GridFragment animalFrag ,humansFrag ;
    fragmentPlant plantFrag;
    Bundle args;
private static boolean bool=false;
    private ArrayList<Integer> mThumbIdshuman = new ArrayList<Integer>(
            Arrays.asList(R.drawable.imag04, R.drawable.imag05,
                    R.drawable.imag06 ));

    private ArrayList<Integer> mThumbIdsAnimals = new ArrayList<Integer>(
            Arrays.asList(R.drawable.sample_1,
                    R.drawable.sample_3, R.drawable.sample_4,
                    R.drawable.sample_5, R.drawable.sample_6,
                    R.drawable.sample_0));
    private static FragmentManager mFragmentManager;
    FragmentTransaction transaction;
    public static TextView Elemant3;
    fragment1 f1;
    fragment2 f2;
    fragment3 f3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         fragmentE1 = (LinearLayout) findViewById(R.id.fragment_E1);
         fragmentE2 = (LinearLayout) findViewById(R.id.fragment_E2);
         fragmentE3 = (LinearLayout) findViewById(R.id.fragment_E3);

    f1=new fragment1();
    f2=new fragment2();
    f3=new fragment3();


    humansFrag = new GridFragment();
    args = new Bundle();
    args.putIntegerArrayList(THUMBNAIL_IDS, mThumbIdshuman);
    humansFrag.setArguments(args);

    animalFrag = new GridFragment();
    args = new Bundle();
    args.putIntegerArrayList(THUMBNAIL_IDS, mThumbIdsAnimals);
    animalFrag.setArguments(args);

    plantFrag=new fragmentPlant();

    textView1=(TextView)   findViewById(R.id.textViewF3_1);
    textView2=(TextView) findViewById(R.id.textViewF3_2);
    textView3=(TextView) findViewById(R.id.textViewF3_3);

    fragmentE1.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        if (!bool){
    mFragmentManager = getSupportFragmentManager();
    transaction  = mFragmentManager.beginTransaction();
    transaction.add(fragmentE1.getId(),f1);
    transaction.add(fragmentE2.getId(),f2);
    transaction.add(fragmentE3.getId(),f3);
    transaction.add(fragmentE3.getId(),humansFrag);
    transaction.add(fragmentE3.getId(),animalFrag);
    transaction.add(fragmentE3.getId(),plantFrag);

    transaction.hide(f2);
    transaction.hide(f3);
    transaction.hide(humansFrag);
    transaction.hide(animalFrag);
    transaction.hide(plantFrag);

    transaction.commit();
    bool=true;
}




    }


    public void addfragment(View view) {

        fragmentE1.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        fragmentE2.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mFragmentManager = getSupportFragmentManager();
        transaction  = mFragmentManager.beginTransaction();
        transaction.show(f2);
        transaction.commit();


    }

    public void addfragment3(View view) {
        fragmentE2.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        fragmentE3.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mFragmentManager = getSupportFragmentManager();
        transaction  = mFragmentManager.beginTransaction();
        transaction.show(f3);
        transaction.commit();
    }



    @Override
    public void updatedata2(int s) {
       int i= f2.updateText(s);

        fragmentE2.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        fragmentE3.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mFragmentManager = getSupportFragmentManager();
        transaction  = mFragmentManager.beginTransaction();

        switch (i){

            case 1:
                transaction.hide(animalFrag);
                transaction.hide(plantFrag);
                transaction.show(humansFrag);
                transaction.commit();
                break;
            case 2:
                transaction.hide(plantFrag);
                transaction.hide(humansFrag);
                transaction.show(animalFrag);
                transaction.commit();
                break;
            case 3:
                transaction.hide(humansFrag);
                transaction.hide(animalFrag);
                transaction.show(plantFrag);
                transaction.commit();
                break;
        }

    }
    @Override
    public void updatedata3(int s) {
        f3.updateText(s);
    }
   /* public void updatfragment3(View view) {
        switch (view.getId()){

            case R.id.Elemant1:{ Toast.makeText(this,"Elemant1",Toast.LENGTH_LONG).show();
          //f3.updateText("E11\nE12");
          //  Elemant3.setText();
            }
            case R.id.Elemant2:{ Toast.makeText(this,"Elemant2",Toast.LENGTH_LONG).show();
            //Elemant3.setText("E21\nE22\nE23");
            }
             case R.id.Elemant3:{ Toast.makeText(this,"Elemant3",Toast.LENGTH_LONG).show();
           //  Elemant3.setText("E31\nE32");
             }

        }
    }*/
}