package org.lucidant.kotlinservice

import org.lucidant.kotlinservice.configuration.SampleProperties
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(SampleProperties::class)
class KotlinServiceApplication

fun main(args: Array<String>) {
    runApplication<KotlinServiceApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
