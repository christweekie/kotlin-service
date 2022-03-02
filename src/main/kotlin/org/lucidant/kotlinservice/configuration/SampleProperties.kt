package org.lucidant.kotlinservice.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("sample")
data class SampleProperties(var title: String)
