package org.lucidant.kotlinservice.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("sample")
data class SampleProperties(var title: String)
