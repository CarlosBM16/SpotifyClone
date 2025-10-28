package com.example.spotifyclone

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    var mediaPlayer : MediaPlayer? = null
    var songIndex by mutableIntStateOf(0)
    val songList = mutableListOf(
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "Imaginations From The Other Side", "Blind Guardian", R.raw.imaginations),
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "I'm Alive", "Blind Guardian", R.raw.imalive),
        SongData(ImageData(R.drawable.masterofpuppets, "Master of Puppets"), "Master Of Puppets", "Metallica", R.raw.masterofpuppets),
        SongData(ImageData(R.drawable.meliora, "Meliora"), "Square Hammer", "Ghost", R.raw.squarehammer),
        SongData(ImageData(R.drawable.rustinpeace, "Rust in Peace"), "Hangar 18", "Megadeth", R.raw.hangar18),
        SongData(ImageData(R.drawable.paranoid, "Paranoid"), "War Pigs", "Black Sabbath", R.raw.warpigs),
        SongData(ImageData(R.drawable.reigninblood, "Reign in Blood"), "Angel Of Death", "Slayer", R.raw.angelofdeath),
        SongData(ImageData(R.drawable.blizzardofozz, "Blizzard of Ozz"), "Crazy Train", "Ozzy Osbourne", R.raw.crazytrain),
        SongData(ImageData(R.drawable.avengedsevenfold, "Avenged Sevenfold"), "A Little Piece Of Heaven", "Avenged Sevenfold", R.raw.alittlepieaceofheaven),
        SongData(ImageData(R.drawable.somewhereintime, "Somewhere in Time"), "Wasted Years", "Iron Maiden", R.raw.wastedyears)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mediaPlayer = MediaPlayer()

        setContent {
            SongList(
                lista = songList,
                mediaPlayer = mediaPlayer,
                playSong = { file -> playSong(file) },
                pauseOrResume = { pauseOrResume() },
                songIndex = songIndex,
                nextSong = { nextSong() },
                previousSong = { previousSong() }
            )
        }
    }
    fun playSong(index: Int) {
        songIndex = index
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            mediaPlayer = MediaPlayer.create(this, songList[songIndex].file)
            mediaPlayer?.start()
        }
    }

    fun pauseOrResume() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.pause()
            } else {
                it.start()
            }

        }
    }

    fun nextSong() {
        songIndex = (songIndex + 1) % songList.size
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            it.release()
        }
        mediaPlayer = MediaPlayer.create(this, songList[songIndex].file)
        mediaPlayer?.start()
    }

    fun previousSong() {
        songIndex = if ((songIndex - 1) < 0) {
            songList.size  - 1
        } else {
            songIndex - 1
        }

        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
            }
            it.release()
        }
        mediaPlayer = MediaPlayer.create(this, songList[songIndex].file)
        mediaPlayer?.start()
    }
}