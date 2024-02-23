package com.andresponce.polimusicservice.webservices

import com.andresponce.polimusicservice.entities.Song
import com.andresponce.polimusicservice.repositories.SongsRepository
import jakarta.jws.WebMethod
import jakarta.jws.WebService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@WebService
@Component
class SongsWebService {

    @Autowired
    private lateinit var songsRepository: SongsRepository

    @WebMethod
    fun getAllSongs(): List<Song> {
        return songsRepository.findAll()
    }

    @WebMethod
    fun getSongById(id: Int): Song? {
        return songsRepository.findById(id).orElse(null);
    }

    @WebMethod
    fun createSong(song: Song): Song {
        return songsRepository.save(song)
    }

    @WebMethod
    fun updateSong(song: Song): Song? {
        val newSong = songsRepository.findById(song.id!!).orElse(null) ?: return null
        newSong.songName = song.songName
        newSong.songPath = song.songPath
        newSong.plays = song.plays
        return songsRepository.save(song)
    }

    @WebMethod
    fun deleteSong(id: Int): Boolean {
        val song = songsRepository.findById(id).orElse(null) ?: return false
        songsRepository.delete(song)
        return true
    }
}