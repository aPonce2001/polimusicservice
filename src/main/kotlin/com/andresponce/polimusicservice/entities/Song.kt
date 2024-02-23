package com.andresponce.polimusicservice.entities

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "TBL_SONG", schema = "dbo")
open class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SONG", nullable = false)
    open var id: Int? = null

    @Size(max = 50)
    @NotNull
    @Column(name = "SONG_NAME", nullable = false, length = 50)
    open var songName: String? = null

    @Size(max = 255)
    @NotNull
    @Column(name = "SONG_PATH", nullable = false)
    open var songPath: String? = null

    @Column(name = "PLAYS")
    open var plays: Int? = null
}