package com.example

import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.time.LocalDateTime

data class ApiResponse(val message: String, val timestamp: String)

fun main() {
    embeddedServer(Netty, port = 5000, host = "0.0.0.0") {
        install(ContentNegotiation) {
            gson()
        }
        routing {
            get("/") {
                call.respond(
                    ApiResponse(
                        message = "Hello from Cloud Computing Lab 3 Kotlin Microservice!",
                        timestamp = LocalDateTime.now().toString()
                    )
                )
            }
        }
    }.start(wait = true)
}
