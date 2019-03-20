package com.android4dev.navigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by makn on 03-05-2016.
 *
 */
public class PorscheFragment  extends Fragment {

    String name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        name = savedInstanceState.getString("name");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //This corresponds to the onCreate that we have in our
        //normal activities
        View view = inflater.inflate(R.layout.porschefragment,container,false);
        view.findViewById(R.id.myButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO ...
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("name",name);
        super.onSaveInstanceState(outState);
    }
}
