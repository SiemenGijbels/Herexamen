package com.gijbelssiemen.herexamen;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

/**
 * Created by siemengijbels on 8/15/16.
 */

public class SplashScreen extends Activity {

    VideoView vidHolder;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        try
        {
            vidHolder = new VideoView(this);
            setContentView(vidHolder);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splashscreen);
            vidHolder.setVideoURI(video);
            vidHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                public void onCompletion(MediaPlayer mp) {
                    jump();
                }});
            vidHolder.start();

        } catch(Exception ex) {
            jump();
        }
    }

    private void jump()
    {
        if(isFinishing())
            return;
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
}
