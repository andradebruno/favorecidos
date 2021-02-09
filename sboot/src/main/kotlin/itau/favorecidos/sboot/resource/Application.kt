package itau.favorecidos.sboot.resource

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["itau.favorecidos"])
@EntityScan(basePackages =  ["itau.favorecidos"])
class FavorecidosApplication

fun main(args: Array<String>) {
    runApplication<FavorecidosApplication>(*args)
}
