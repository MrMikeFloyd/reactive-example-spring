package de.maik.reactiverestclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveRestClientApplication

fun main(args: Array<String>) {
	runApplication<ReactiveRestClientApplication>(*args)
}
