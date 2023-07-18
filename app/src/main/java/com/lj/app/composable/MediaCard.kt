package com.lj.app.composable

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lj.domain.model.Media

/**
 * Display the [Media] [media].
 */
@Composable
fun MediaCard(media: Media, context: Context) {
    Card(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .height(80.dp)
            .clickable {
                Toast
                    .makeText(context, media.title, Toast.LENGTH_LONG)
                    .show()
            },
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.LightGray,
    ) {
        Column(modifier = Modifier.padding(8.dp))
        {
            Text(text = media.title)
        }
    }
}