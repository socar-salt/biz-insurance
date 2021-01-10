package kr.co.socarcorp.insurance.batch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["kr.co.socarcorp.insurance"])
class BatchApplication

fun main(args: Array<String>) {
    runApplication<BatchApplication>(*args)
}
