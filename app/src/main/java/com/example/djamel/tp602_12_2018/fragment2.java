package com.example.djamel.tp602_12_2018;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragment2 extends Fragment {
    fragment2listner listner;
  private   TextView textElment1,textElment2,textElment3;
    public interface fragment2listner{
        void updatedata2(int i);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment2_layout,container,false);
          textElment1=(TextView) v.findViewById(R.id.Elemant1);
          textElment2=(TextView) v.findViewById(R.id.Elemant2);
          textElment3=(TextView) v.findViewById(R.id.Elemant3);
          textElment1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  listner.updatedata2(1);
               }
          });
        textElment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.updatedata2(2);

            }
        });
        textElment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.updatedata2(3);

            }
        });


        return v;
    }
    public int updateText(int i){
     return i;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof fragment2listner) listner= (fragment2listner) context;
else throw new RuntimeException(context.toString()+" implement fragment2listner");

    }

    @Override
    public void onDetach() {
        super.onDetach();
    listner=null;
    }
}
