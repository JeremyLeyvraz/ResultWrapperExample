package com.lj.app.composable

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lj.domain.model.Media

/**
 * Display the [mediaList].
 */
@Composable
fun DisplayMediaListComposable(mediaList: List<Media>, context: Context) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .fillMaxSize()
    ) {
        val isTablet = maxWidth > 720.dp
        if (isTablet) {
            DisplayMediaListForTablet(mediaList, context)
        } else {
            DisplayMediaListForPhone(mediaList, context)
        }
    }
}

/**
 * Display the [mediaList] on a tablet.
 */
@Composable
private fun DisplayMediaListForTablet(mediaList: List<Media>, context: Context) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        content = {
            items(mediaList) { media ->
                MediaCard(media, context)
            }
        }
    )
}

/**
 * Display the [mediaList] on a phone.
 */
@Composable
private fun DisplayMediaListForPhone(mediaList: List<Media>, context: Context) {
    LazyColumn {
        items(mediaList) { media ->
            MediaCard(media, context)
        }
    }
}