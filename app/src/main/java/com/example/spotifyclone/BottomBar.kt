package com.example.spotifyclone

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.ui.Alignment

@Composable
fun BottomBar(
    currentSong: SongData,
    onPlayPause: () -> Unit,
    nextSong: () -> Unit,
    previousSong: () -> Unit
) {
    BottomAppBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ){
            IconButton(onClick = previousSong) {
                Icon(Icons.Filled.SkipPrevious, contentDescription = "Skip Previous")
            }
            IconButton(onClick = onPlayPause) {
                Icon(Icons.Filled.PlayArrow, contentDescription = "Play")
            }
            IconButton(onClick =  nextSong ) {
                Icon(Icons.Filled.SkipNext, contentDescription = "Skip Next")
            }
        }

    }
}
