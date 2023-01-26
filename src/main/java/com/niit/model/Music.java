/*
 * Author : Naveen Kumar
 * Date : 25-01-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Music {
    @Id
    int trackId;
    String trackName;
    String trackComments;
    int trackRating;
    String artistName;

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackComments() {
        return trackComments;
    }

    public void setTrackComments(String trackComments) {
        this.trackComments = trackComments;
    }

    public int getTrackRating() {
        return trackRating;
    }

    public void setTrackRating(int trackRating) {
        this.trackRating = trackRating;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Music() {
    }

    @Override
    public String toString() {
        return "Music{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", trackComments='" + trackComments + '\'' +
                ", trackRating=" + trackRating +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}
