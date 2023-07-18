package com.lj.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.lj.app.composable.MainComposable
import com.lj.app.composable.MainViewModel
import com.lj.app.ui.theme.Exercise1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            Exercise1Theme {
                Scaffold(
                    topBar = { AppBarWithRefreshButton(action = { viewModel.loadMediaList() }) }
                ) {
                    /**
                     * Display all media.
                     */
                    MainComposable(viewModel)
                }
            }
        }
    }
}

@Composable
fun AppBarWithRefreshButton(action: () -> Unit) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name), color = Color.White) },
        actions = {
            IconButton(onClick = { action() }) {
                Icon(Icons.Filled.Refresh, contentDescription = null)
            }
        }
    )
}
