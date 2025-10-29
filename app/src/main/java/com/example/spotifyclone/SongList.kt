package com.example.spotifyclone

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource

@Composable
fun SongList(
    lista: List<SongData>,
    mediaPlayer: MediaPlayer?,
    playSong: (Int) -> Unit,
    pauseOrResume: () -> Unit,
    songIndex : Int,
    nextSong: () -> Unit,
    previousSong: () -> Unit,
    isPlaying : Boolean
) {
    Scaffold(
        bottomBar = {
            BottomBar(
                lista[songIndex],
                pauseOrResume,
                nextSong,
                previousSong,
                isPlaying
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .background(colorResource(R.color.bgColor))
                .padding(paddingValues)
        ) {
            LazyColumn {
                items(lista.indices.toList()) { index ->
                    val song = lista[index]
                    SongCard(
                        songData = song,
                        onClick = {
                            playSong(index)
                        },
                        mediaPlayer = mediaPlayer,
                        isSelected = songIndex == index
                    )
                }
            }
        }
    }
}
