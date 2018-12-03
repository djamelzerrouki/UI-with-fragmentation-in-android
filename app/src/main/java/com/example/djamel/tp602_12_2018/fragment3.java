package com.example.djamel.tp602_12_2018;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class fragment3 extends Fragment {
 fragment3listner listner;
     public interface fragment3listner{
        void updatedata3(int s);
    }

    TextView textView1 ,textView2, textView3;
    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment3_layout,container,false);
          textView1=(TextView) v.findViewById(R.id.textViewF3_1);
        textView2=(TextView) v.findViewById(R.id.textViewF3_2);
        textView3=(TextView) v.findViewById(R.id.textViewF3_3);

        return v;
    }

    public int updateText(int i){
        switch (i){
            case 1:
                textView1.setText("E"+i+"e1");
                textView2.setText("E"+i+"e2");

                textView3.setVisibility(View.INVISIBLE);
                break;
            case 2:
                textView1.setText("E"+i+"e1");
                textView2.setText("E"+i+"e2");
                textView3.setVisibility(View.VISIBLE);
                textView3.setText("E"+i+"e3");


                break;
            case 3:
                textView1.setText("E"+i+"e1");
                textView2.setText("E"+i+"e2");
                textView3.setVisibility(View.INVISIBLE);

                break;
        }
         return i;
    }


    public void showText(String text){

        textView1.setText(text);
        textView2.setText(text);
        textView3.setText(text);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof fragment2.fragment2listner) listner= (fragment3listner) context;
        else throw new RuntimeException(context.toString()+" implement fragment2listner");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listner=null;
    }
}
