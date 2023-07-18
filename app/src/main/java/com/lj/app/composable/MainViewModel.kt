package com.lj.app.composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lj.domain.enumeration.ErrorState
import com.lj.domain.model.ResultState
import com.lj.domain.repository.MediaRepository
import com.lj.domain.model.Media
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View model to load all media and manage state: loading, error or no error.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MediaRepository
) : ViewModel() {

    /**
     * List of [Media].
     * Private set to not allow the modification outside of this class.
     */
    var mediaList by mutableStateOf(emptyList<Media>())
        private set

    /**
     * [ErrorState] when [loadMediaList] failed, null by default.
     * Private set to not allow the modification outside of this class.
     */
    var errorState by mutableStateOf<ErrorState?>(null)
        private set

    /**
     * Loading state: false by default.
     * Private set to not allow the modification outside of this class.
     */
    var isLoading by mutableStateOf(false)
        private set

    /**
     * True if there is an error, false otherwise.
     * False by default.
     */
    val isError: Boolean
        get() = errorState != null

    /**
     * Load all [Media].
     */
    fun loadMediaList() {
        viewModelScope.launch {
            if (!isLoading) {
                isLoading = true
                val result = repository.getMediaList()
                if(result.isSuccess) {
                    mediaList = (result as ResultState.Success).data
                    errorState = null
                } else {
                    updateError(result as ResultState.Failure)
                }
                isLoading = false
            }
        }
    }

    /**
     * Update error state.
     */
    private fun updateError(error: ResultState.Failure) {
        errorState = error.error
    }
}
