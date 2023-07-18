package com.lj.data.repository

import com.lj.domain.enumeration.ErrorState
import com.lj.domain.model.ResultState
import com.lj.domain.model.Media
import com.lj.domain.repository.MediaRepository
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * Implementation of [MediaRepository].
 */
internal class MediaRepositoryImpl: MediaRepository {

    /**
     * For test only: delay to simulate a long request.
     * Used to see the loader.
     */
    private val delayInSecond = 3000L

    /**
     * Get the list of all [Media].
     * Return a [ResultState] that contains the list or an error.
     */
    override suspend fun getMediaList(): ResultState<List<Media>> {
        // Simulate a long call
        delay(delayInSecond)
        // Generate an error, or null (no error)
        val errorOrNull = generateErrorOrNull()
        return errorOrNull?.let {
            ResultState.Failure(it)
        } ?: run {
            ResultState.Success(listOf(Media("toto"), Media("titi")))
        }
    }

    /**
     * Generate a random error state or null.
     * Null means no error.
     */
    private fun generateErrorOrNull(): ErrorState? {
        val chance = Random.nextInt(100)
        return if (chance < 25) {
            null
        } else {
            val errorStates = ErrorState.values()
            errorStates[Random.nextInt(errorStates.size)]
        }
    }
}