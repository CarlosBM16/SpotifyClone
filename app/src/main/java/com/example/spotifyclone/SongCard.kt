package com.example.spotifyclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spotifyclone.ui.theme.SpotifyCloneTheme

@Composable
fun SongCard(
    songData : SongData,
    onClick: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.bgColor)
        ),
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(songData.imageData.imageUrl),
                contentDescription = songData.imageData.contentDescription,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))

            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = songData.title,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.textColor)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = songData.group,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SongCardPreview() {
    val songTest = SongData(ImageData(R.drawable.igtos, "IFtOS"), "Imaginations from the Other Side", "Blind Guardian")
    SongCard(songTest, {})
}