package demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class ExtensionFunctions {

    @GetMapping("/uuid-of/{word}")
    fun generateUuidOfWord(@PathVariable word: String) {
        applyAction(word) { s: String -> println(s.uuid()) }
    }

    private fun applyAction(word: String, function: (String) -> Unit) {
        function(word)
    }
}

fun String.uuid() = UUID.nameUUIDFromBytes(this.encodeToByteArray()).toString()
