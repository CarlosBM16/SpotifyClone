package com.example.spotifyclone

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.spotifyclone.ui.theme.SpotifyCloneTheme
class MainActivity : ComponentActivity() {
    var mediaPlayer : MediaPlayer? = null
    var songIndex = 0
    val file = R.raw.iftos
    val songList = mutableListOf(
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "Imaginations from the Other Side", "Blind Guardian", file),
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "I'm Alive", "Blind Guardian", file),
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "A Past and Future Secret", "Blind Guardian", file),
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "The Script for My Requiem", "Blind Guardian", file),
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "Terminal Exile", "Blind Guardian", file),
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "Lord of the Rings", "Blind Guardian", file),
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "Welcome to Dying", "Blind Guardian", file),
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "Somewhere Far Beyond", "Blind Guardian", file),
        SongData(ImageData(R.drawable.igtos, "Imaginations from the Other Side"), "Imaginations from the Other Side (Reprise)", "Blind Guardian", file)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mediaPlayer = MediaPlayer()

        setContent {
            SongList(
                lista = songList,
                mediaPlayer = mediaPlayer ,
                playSong = { file -> playSong(file)})
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
}