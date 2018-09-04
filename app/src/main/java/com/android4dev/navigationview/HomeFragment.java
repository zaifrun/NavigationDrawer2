package com.android4dev.navigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by makn on 03-05-2016.
 *
 */
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //This corresponds to the onCreate that we have in our
        //normal activities
        return inflater.inflate(R.layout.homefragment,container,false);
    }
}
