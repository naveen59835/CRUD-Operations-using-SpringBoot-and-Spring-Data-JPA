/*
 * Author : Naveen Kumar
 * Date : 25-01-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.service;

import com.niit.model.Music;
import com.niit.repo.MusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService{
    MusicRepo musicRepo;
    @Autowired
    public MusicServiceImpl(MusicRepo musicRepo){
        this.musicRepo = musicRepo;
    }
    @Override
    public Music addMusic(Music music) {
        return musicRepo.save(music);
    }

    @Override
    public Music getMusicById(int trackId) {
        return musicRepo.findById(trackId).get();
    }

    @Override
    public List<Music> getMusicByArtist(String artistName) {
        return musicRepo.findByartistName(artistName);
    }

    @Override
    public boolean deleteMusicById(int trackId) {
        if(musicRepo.findById(trackId).isPresent()){
            Music music = musicRepo.findById(trackId).get();
            musicRepo.delete(music);
            return true;

        }
        return false;
    }

    @Override
    public Music updateMusic(Music music, int trackId) {
        if(musicRepo.findById(trackId).isPresent()){
    Music music1=musicRepo.findById(trackId).get();
    if(music1.getArtistName()!=null){
        music1.setArtistName(music.getArtistName());

    }
    if(music1.getTrackName()!=null){
        music1.setTrackName(music.getTrackName());
    }
    return musicRepo.save(music1);
        }
        return null;
    }

    @Override
    public List<Music> getAllMusic() {
        return musicRepo.findAll();
    }
}
