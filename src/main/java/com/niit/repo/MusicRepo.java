package com.niit.repo;

import com.niit.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepo extends JpaRepository <Music,Integer> {
  List <Music> findByartistName (String artistName);

}
