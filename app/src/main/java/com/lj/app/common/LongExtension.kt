package com.lj.app.common

import java.util.concurrent.TimeUnit

/**
 * Convert a [Long] in millis to an [Int] in minutes.
 */
fun Long.toMinutes(): Int = TimeUnit.MILLISECONDS.toMinutes(this).toInt()