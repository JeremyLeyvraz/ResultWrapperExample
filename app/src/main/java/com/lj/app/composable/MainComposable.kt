package com.lj.app.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.lj.app.common.DisplayLoaderComposable

/**
 * Main composable to display the list of [Media].
 */
@Composable
fun MainComposable(viewModel: MainViewModel) {
    val context = LocalContext.current
    val mediaList = viewModel.mediaList

    /**
     * The `LaunchedEffect` is designed to start work on composition and recompose when key
     * parameters change. When you rotate the screen, your activity is destroyed and recreated,
     * leading to recomposition and hence triggering the `LaunchedEffect`.
     */
    LaunchedEffect("init") {
        viewModel.loadMediaList()
    }

    if(viewModel.isLoading) {
        DisplayLoaderComposable()
    } else if (viewModel.isError) {
        DisplayErrorComposable(viewModel.errorState)
    } else {
        DisplayMediaListComposable(mediaList, context)
    }
}
