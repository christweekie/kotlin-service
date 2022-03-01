package org.lucidant.kotlinservice

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinServiceApplication

fun main(args: Array<String>) {
    runApplication<KotlinServiceApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
