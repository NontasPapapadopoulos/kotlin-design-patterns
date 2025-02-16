package org.example

import java.time.Clock
import java.util.*


fun interface Logger {
    fun log(message: String)
}

val consoleLogger = Logger { println(it)  }


fun Logger.withUniqueId() = Logger { log("${UUID.randomUUID()} $it") }
fun Logger.withThreadName() = Logger { log("$it (on ${Thread.currentThread().name} thread)") }
fun Logger.withDateTime(calendar: Calendar = Calendar.getInstance()) = Logger { log("[${calendar.time}] $it") }


enum class Level {

}



fun main() {

    val logger = consoleLogger
        .withDateTime()
        .withThreadName()
        .withUniqueId()

    logger.log("Kotlin rocks!!")

}