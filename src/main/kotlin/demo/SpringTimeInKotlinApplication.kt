package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringTimeInKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringTimeInKotlinApplication>(*args)
}
