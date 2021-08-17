package org.lucidant.kotlinservice

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HowToKotlin {

    @Test
    fun `get a name`() {
        assertThat(parseName("Chris Faulkner").firstName).isEqualTo("Chris")
    }

}

// Classes are so cheap
data class Name(val firstName: String, val lastName: String)

fun parseName(name: String) : Name {
    val space = name.indexOf(' ')
    return Name(name.substring(0, space), name.substring(space + 1))
}
