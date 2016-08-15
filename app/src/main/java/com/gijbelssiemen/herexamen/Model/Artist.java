package com.gijbelssiemen.herexamen.Model;

/**
 * Created by siemengijbels on 8/12/16.
 */

public class Artist {
    private int artistId;
    private String naam;
    private int beschrijving;
    private int image;


    public Artist(int artistId, String naam, int beschrijving, int image) {
        this.artistId = artistId;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.image = image;
    }

    public Artist(String naam, int beschrijving, int image) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.image = image;
    }

    public Artist() {

    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(int beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return artistId + ", " + naam + ", " + beschrijving;
    }
}
