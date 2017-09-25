package com.example.aniruddh.eatburp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by hp on 16-09-2017.
 */

public class contentFragment extends Fragment {

    ImageView cafe1Button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content, container, false);

        cafe1Button = (ImageView) view.findViewById(R.id.person_photo1);
        cafe1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.person_photo1:
                        Intent intent1 = new Intent(getActivity(), CafeOne.class);
                        startActivity(intent1);//Edited here
                        break;


                }
            }
        });

        return view;
    }
}
