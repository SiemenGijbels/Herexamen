package com.gijbelssiemen.herexamen.ArtistClasses;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gijbelssiemen.herexamen.MainActivity;
import com.gijbelssiemen.herexamen.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.lang.ref.WeakReference;

/**
 * Created by siemengijbels on 8/11/16.
 */

public class Pruikduif extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pruikduif);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.argb(255, 64, 64, 64));
        getSupportActionBar().setTitle("PRUIKDUIF");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.pruikduif, options);

        ImageView i = (ImageView) findViewById(R.id.imageView);

        loadBitmap(R.drawable.pruikduif, i);

        TextView t = (TextView) findViewById(R.id.textView);
        t.setText(R.string.pruikduif_description);

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        youTubePlayerFragment.initialize("AIzaSyDIpA426pZrQyR7EbK6hLAxZ1Z0B_o-FzU", new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {
                    player.cueVideo("BfZjtKZyZ0A");
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                // TODO Auto-generated method stub

            }
        });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.youtube_view, youTubePlayerFragment).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if(height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            // Calculate the largest inSampleSize value that is a power of 2
            //and keeps both height and width larger than the requested height
            //and width.
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {

        private final WeakReference<ImageView> imageViewReference;
        private int data = 0;
        private Activity activity;

        public BitmapWorkerTask(ImageView imageView,Activity activity)
        {
            // Use a WeakReference to ensure the ImageView can be garbage collected
            imageViewReference = new WeakReference<>(imageView);
            this.activity = activity;
        }
        // Decode image in background.
        @Override
        protected Bitmap doInBackground(Integer ...params){
            data = params[0];
            return Pruikduif.decodeSampledBitmapFromResource(activity.getResources(), data, 400, 400);
        }
        // Once complete, see if ImageView is still around and set bitmap.
        @Override
        protected void onPostExecute(Bitmap bitmap){
            if(bitmap != null){
                final ImageView imageView = imageViewReference.get();
                if(imageView != null){
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds  =  true;
        BitmapFactory.decodeResource(res, resId, options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds  =  false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public void loadBitmap(int resId, ImageView imageView){
        BitmapWorkerTask task = new BitmapWorkerTask(imageView, this);
        task.execute(resId);
    }
}