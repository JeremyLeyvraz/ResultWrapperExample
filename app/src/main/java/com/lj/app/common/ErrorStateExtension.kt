package com.lj.app.common

import com.lj.domain.enumeration.ErrorState
import com.lj.app.R

/**
 * Map [ErrorState] to corresponding [R.drawable] resource ID.
 */
fun ErrorState.toDrawable() =
    when(this) {
        ErrorState.NO_DATA_FOUND -> R.drawable.cloud_ff7
        ErrorState.TIMEOUT -> R.drawable.rabbit
        ErrorState.UNKNOWN -> R.drawable.apple
    }

/**
 * Map [ErrorState] to corresponding [R.string] resource ID.
 */
fun ErrorState.toStringResource() =
    when(this) {
        ErrorState.NO_DATA_FOUND -> R.string.error_nodata_message
        ErrorState.TIMEOUT -> R.string.error_timeout_message
        ErrorState.UNKNOWN -> R.string.error_unknown_message
    }
