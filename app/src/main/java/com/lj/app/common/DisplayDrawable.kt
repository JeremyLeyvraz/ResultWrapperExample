package com.lj.app.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

/**
 * Display the resource [drawable].
 */
@Composable
fun DisplayDrawable(@DrawableRes drawable: Int) {
    val image = painterResource(drawable)
    Image(
        painter = image,
        contentDescription = drawable.toString(),
        modifier = Modifier.fillMaxSize(.5f),
        contentScale = ContentScale.Fit
    )
}