package spring.kotest.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Service

@SpringBootApplication
class Application

data class DemoModel(
    val stringProperty: String,
    val intProperty: Int,
    val booleanProperty: Boolean,
)

@Service
class DemoService(val printService: PrintService) {

    fun execute(demoModel: DemoModel) {
        printService.print(demoModel)
    }
}

@Service
class PrintService {

    fun print(demoModel: DemoModel) {
        println("received model = $demoModel")
    }
}
