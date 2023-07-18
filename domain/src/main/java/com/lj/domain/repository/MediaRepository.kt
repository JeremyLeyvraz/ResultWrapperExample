package com.lj.domain.repository

import com.lj.domain.model.ResultState
import com.lj.domain.model.Media

/**
 * Media repository interface.
 */
interface MediaRepository {
    /**
     * Get the list of all [Media].
     * Return a [ResultState] that contains the list or an error.
     */
    suspend fun getMediaList(): ResultState<List<Media>>
}