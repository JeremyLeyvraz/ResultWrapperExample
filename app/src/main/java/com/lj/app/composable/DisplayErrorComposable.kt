package com.lj.app.composable

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.lj.domain.enumeration.ErrorState
import com.lj.app.common.DisplayDrawable
import com.lj.app.common.toDrawable
import com.lj.app.common.toStringResource

/**
 * Display an [ErrorState].
 */
@Composable
fun DisplayErrorComposable(error: ErrorState?) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            DisplayErrorState(error)
        }
    }
}

/**
 * Display an [ErrorState].
 */
@Composable
private fun DisplayErrorState(error: ErrorState?) {
    error?.let {
        DisplayDrawableWithText(drawable = error.toDrawable(), stringResource = error.toStringResource())
    } ?: run {
        DisplayDrawableWithText(drawable = ErrorState.UNKNOWN.toDrawable(), stringResource = ErrorState.UNKNOWN.toStringResource())
    }
}

/**
 * Display [drawable] and text of resource [stringResource].
 */
@Composable
private fun DisplayDrawableWithText(@DrawableRes drawable: Int, @StringRes stringResource: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize() // Fills the maximum width, not height
            .padding(16.dp), // Optional, adds some padding around
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DisplayDrawable(drawable)
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = stringResource(id = stringResource), fontStyle = FontStyle.Italic)
    }
}