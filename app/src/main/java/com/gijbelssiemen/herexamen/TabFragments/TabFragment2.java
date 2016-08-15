package com.gijbelssiemen.herexamen.TabFragments;

/**
 * Created by siemengijbels on 8/11/16.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gijbelssiemen.herexamen.ImageTools.TouchImageView;
import com.gijbelssiemen.herexamen.R;

public class TabFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_2, container, false);

        TouchImageView image = (TouchImageView) rootView.findViewById(R.id.imageView);

        image.setOnTouchImageViewListener(new TouchImageView.OnTouchImageViewListener() {

            @Override
            public void onMove() {
            }
        });

        return rootView;

    }
}
