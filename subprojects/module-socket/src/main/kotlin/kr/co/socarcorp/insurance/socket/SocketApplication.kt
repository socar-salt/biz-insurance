package kr.co.socarcorp.insurance.socket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["kr.co.socarcorp.insurance"])
class SocketApplication

fun main(args: Array<String>) {
    runApplication<SocketApplication>(*args)
}
