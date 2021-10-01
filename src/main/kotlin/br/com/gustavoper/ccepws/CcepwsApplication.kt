package br.com.gustavoper.ccepws

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CcepwsApplication

fun main(args: Array<String>) {
	SpringApplication.run(CcepwsApplication::class.java, *args)
}
