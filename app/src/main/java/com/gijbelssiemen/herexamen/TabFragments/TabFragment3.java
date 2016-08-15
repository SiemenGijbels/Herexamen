package com.gijbelssiemen.herexamen.TabFragments;

/**
 * Created by siemengijbels on 8/11/16.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gijbelssiemen.herexamen.ImageTools.TouchImageView;
import com.gijbelssiemen.herexamen.ImageTools.TouchImageView.OnTouchImageViewListener;
import com.gijbelssiemen.herexamen.R;


public class TabFragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab_fragment_3, container, false);

        TouchImageView image = (TouchImageView) rootView.findViewById(R.id.imageView);

        image.setOnTouchImageViewListener(new OnTouchImageViewListener() {

            @Override
            public void onMove() {
            }
        });

        Button button = (Button) rootView.findViewById(R.id.mapsButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<51.066885>,<3.733770>?q=<51.066885>,<3.733770>(019 (Different Class))"));
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }
}
