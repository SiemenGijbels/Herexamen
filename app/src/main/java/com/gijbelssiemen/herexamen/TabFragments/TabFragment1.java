package com.gijbelssiemen.herexamen.TabFragments;

/**
 * Created by siemengijbels on 8/11/16.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

import com.gijbelssiemen.herexamen.ArtistClasses.AsaMoto;
import com.gijbelssiemen.herexamen.ArtistClasses.Bea1991;
import com.gijbelssiemen.herexamen.ArtistClasses.Easter;
import com.gijbelssiemen.herexamen.ArtistClasses.He4rtbroken;
import com.gijbelssiemen.herexamen.ArtistClasses.Kablam;
import com.gijbelssiemen.herexamen.ArtistClasses.Le1f;
import com.gijbelssiemen.herexamen.ArtistClasses.Pruikduif;
import com.gijbelssiemen.herexamen.ArtistClasses.Sheniqua;
import com.gijbelssiemen.herexamen.ArtistClasses.Syracuse;
import com.gijbelssiemen.herexamen.R;


public class TabFragment1 extends Fragment {

    View rootView;

    ListView listView;
//    DatabaseHelper db;
//    Artist artist;
//
//    Integer[] imageId = {
//            R.drawable.asa_moto,
//            R.drawable.bea1991,
//            R.drawable.easter,
//            R.drawable.he4rtbroken,
//            R.drawable.kablam,
//            R.drawable.le1f,
//            R.drawable.pruikduif,
//            R.drawable.sheniqua,
//            R.drawable.syracuse
//    };
//
//    ArrayList<String> artists;


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        db = new DatabaseHelper(getActivity());
//        artist = new Artist();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.tab_fragment_1, container, false);
//        db.deleteArtist(artist);
//        addArtists();

        listView = (ListView) rootView.findViewById(R.id.list_view);

        String[] artistArray = new String[]{"ASA MOTO", "BEA1991", "EASTER", "HE4RTBROKEN DJ\'S", "KABLAM", "LE1F", "PRUIKDUIF", "SHENIQUA WORLD TOUR", "SYRACUSE"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, artistArray);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

//                long ids = parent.getItemIdAtPosition(position);
//                int artistId = (int) ids;
//                Log.d("ID", Long.toString(ids));

                if (position == 0) {
                    Intent myIntent = new Intent(getActivity(), AsaMoto.class);
                    startActivity(myIntent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(getActivity(), Bea1991.class);
                    startActivity(myIntent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(getActivity(), Easter.class);
                    startActivity(myIntent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(getActivity(), He4rtbroken.class);
                    startActivity(myIntent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(getActivity(), Kablam.class);
                    startActivity(myIntent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(getActivity(), Le1f.class);
                    startActivity(myIntent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                if (position == 6) {
                    Intent myIntent = new Intent(getActivity(), Pruikduif.class);
                    startActivity(myIntent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                if (position == 7) {
                    Intent myIntent = new Intent(getActivity(), Sheniqua.class);
                    startActivity(myIntent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }

                if (position == 8) {
                    Intent myIntent = new Intent(getActivity(), Syracuse.class);
                    startActivity(myIntent);
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });

        return rootView;
    }

//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        addArtistsToList();
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                long ids = parent.getItemIdAtPosition(position);
//                int artistId = (int) ids;
//                Log.d("ID", Long.toString(ids));
//                Intent artistInfo = new Intent(getActivity(), ArtistInfoActivity.class);
//                artistInfo.putExtra("Naam", db.getArtist(artistId + 1).getNaam());
//                artistInfo.putExtra("Beschrijving", db.getArtist(artistId + 1).getBeschrijving());
//                artistInfo.putExtra("Image", db.getArtist(artistId + 1).getImage());
//                startActivity(artistInfo);
//            }
//        });
//    }
//
//    private void addArtists() {
//        Log.d("Insert: ", "Inserting ..");
//        db.addArtist(new Artist("ASA MOTO", R.string.asa_moto_description, R.drawable.asa_moto));
//        db.addArtist(new Artist("BEA1991", R.string.bea1991_description, R.drawable.bea1991));
//        db.addArtist(new Artist("EASTER", R.string.easter_description, R.drawable.easter));
//        db.addArtist(new Artist("HE4RTBROKEN", R.string.he4rtbroken_description, R.drawable.he4rtbroken));
//        db.addArtist(new Artist("KABLAM", R.string.kablam_description, R.drawable.kablam));
//        db.addArtist(new Artist("LE1F", R.string.le1f_description, R.drawable.le1f));
//        db.addArtist(new Artist("PRUIKDUIF", R.string.pruikduif_description, R.drawable.pruikduif));
//        db.addArtist(new Artist("SHENIQUA WORLD TOUR", R.string.sheniqua_world_tour_description, R.drawable.sheniqua));
//        db.addArtist(new Artist("SYRACUSE", R.string.syracuse_description, R.drawable.syracuse));
//    }
//
//    private void addArtistsToList() {
//        artists = new ArrayList<String>();
//        artists.add(db.getArtist(1).getNaam());
//        artists.add(db.getArtist(2).getNaam());
//        artists.add(db.getArtist(3).getNaam());
//        artists.add(db.getArtist(4).getNaam());
//        artists.add(db.getArtist(5).getNaam());
//        artists.add(db.getArtist(6).getNaam());
//        artists.add(db.getArtist(7).getNaam());
//        artists.add(db.getArtist(8).getNaam());
//        artists.add(db.getArtist(9).getNaam());
//
//        ArtistListAdapter adapter = new ArtistListAdapter(getActivity(), artists, imageId);
//        listView = (ListView) rootView.findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
//    }
}
