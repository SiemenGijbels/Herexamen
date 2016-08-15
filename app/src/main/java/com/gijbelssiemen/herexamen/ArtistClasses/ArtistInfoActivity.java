package com.gijbelssiemen.herexamen.ArtistClasses;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gijbelssiemen.herexamen.R;

/**
 * Created by siemengijbels on 8/12/16.
 */

public class ArtistInfoActivity extends FragmentActivity {
    String naam;
    int beschrijving;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_info);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        naam = getIntent().getExtras().getString("naam");
        beschrijving = getIntent().getExtras().getInt("beschrijving");
        image = getIntent().getExtras().getInt("image");

        setTextFromActivity();
    }

    public void setTextFromActivity(){
        ImageView afbeelding = (ImageView) findViewById((R.id.img));
        TextView description = (TextView) findViewById(R.id.description);

        description.setText(beschrijving);
        afbeelding.setImageResource(image);
    }
}
