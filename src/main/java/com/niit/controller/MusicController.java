/*
 * Author : Naveen Kumar
 * Date : 25-01-2023
 * Created With : IntelliJ IDEA Community Edition
 */

package com.niit.controller;

import com.niit.model.Music;
import com.niit.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MusicController {
    MusicService musicService;
    @Autowired
    public MusicController(MusicService musicService){
        this.musicService = musicService;
    }

    @GetMapping("/demo")
    public String get(){
        return "hello";
    }
    @PostMapping("/music")
    public ResponseEntity<?> addMusic(@RequestBody Music music){
        Music newMusic = musicService.addMusic(music);
        if(newMusic != null){
            return new ResponseEntity<Music>(newMusic, HttpStatus.CREATED);

        }else{
            return new ResponseEntity<String>("Error Occured", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allmusic")
    public ResponseEntity<?> getAllMusic(){
        List<Music> allMusic=musicService.getAllMusic();
        if(allMusic.size()>0){
            return new ResponseEntity<List<Music>>(allMusic, HttpStatus.OK);

        }else{
            return new ResponseEntity<String>("error occured", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/music/{trackId}")
    public ResponseEntity<?> getMusicById(@PathVariable int trackId){
        Music music=musicService.getMusicById(trackId);
        if(music!=null){
            return new ResponseEntity<Music>(music,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("no song found", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/musics/{artistName}")
    public ResponseEntity<?> getMusicByArtistName(@PathVariable String artistName){
List<Music> allMusic=musicService.getMusicByArtist(artistName);
if(allMusic.size()>0){
    return new ResponseEntity<List<Music>>(allMusic,HttpStatus.ACCEPTED);

}else{
    return new ResponseEntity<String>("No Music found", HttpStatus.NOT_FOUND);
}
    }
    @DeleteMapping("/track/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId){
        if(musicService.deleteMusicById(trackId)){
            return new ResponseEntity<String>("Music deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Error Occured",HttpStatus.FAILED_DEPENDENCY);
        }
    }
    @PutMapping("/musictrack/{trackId}")
    public ResponseEntity<?> updateMusic(@RequestBody Music newmusic , @PathVariable int trackId){
        Music updateMusic = musicService.updateMusic(newmusic,trackId);
        if(updateMusic != null){
            return new ResponseEntity<Music>(updateMusic,HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Error Occured",HttpStatus.FAILED_DEPENDENCY);
        }
    }

}
