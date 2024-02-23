package com.andresponce.polimusicservice.repositories

import com.andresponce.polimusicservice.entities.Song
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SongsRepository : JpaRepository<Song, Int> {
}