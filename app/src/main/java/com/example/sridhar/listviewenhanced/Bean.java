/**
 * Created by Sridhar on 8/11/2015.
 */
package com.example.sridhar.listviewenhanced;

public class
        Bean {

    private String name;
    private int icon_id;
    private double ratings;
    private String genre;
    private String[] cast;


    public Bean(String name, int icon_id, double ratings, String genre, String[] cast) {
        this.name = name;
        this.icon_id = icon_id;
        this.ratings = ratings;
        this.genre = genre;
        this.cast = cast;
    }

    public String getName() {
        return name;
    }

    public int getIcon_id() {
        return icon_id;
    }

    public double getRatings() {
        return ratings;
    }

    public String getGenre() {
        return genre;
    }

    public String[] getCast() {
        return cast;
    }
}
