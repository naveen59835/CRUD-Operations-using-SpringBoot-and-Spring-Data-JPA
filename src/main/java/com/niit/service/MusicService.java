package com.niit.service;

import com.niit.model.Music;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MusicService {
    public Music addMusic (Music music);
    public Music getMusicById (int trackId);
    public List <Music> getMusicByArtist (String artistName);
    public boolean deleteMusicById (int trackId);
    public Music updateMusic (Music music, int trackId);
    public List<Music> getAllMusic();


}
