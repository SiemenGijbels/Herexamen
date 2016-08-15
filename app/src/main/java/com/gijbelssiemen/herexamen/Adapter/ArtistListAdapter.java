package com.gijbelssiemen.herexamen.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gijbelssiemen.herexamen.R;

import java.util.ArrayList;

/**
 * Created by siemengijbels on 8/12/16.
 */

public class ArtistListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> artists;
    private final Integer[] imageId;
    public ArtistListAdapter(Activity context,
                             ArrayList<String> artists, Integer[] imageId) {
        super(context, R.layout.list_item_artists, artists);
        this.context = context;
        this.artists = artists;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item_artists, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txtNaam);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(artists.get(position));

        imageView.setImageResource(imageId[position]);
        return rowView;
    }

}