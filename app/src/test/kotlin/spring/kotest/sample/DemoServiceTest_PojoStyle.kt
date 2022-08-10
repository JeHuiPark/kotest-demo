package spring.kotest.sample

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.CapturingSlot
import io.mockk.mockk
import io.mockk.verify

@Suppress("ClassName")
class DemoServiceTest_PojoStyle : BehaviorSpec({

    val printService = mockk<PrintService>(
        relaxed = true // https://mockk.io/#relaxed-mock
    )
    val demoService = DemoService(printService)

    // simple behavior test
    given("a demoModel") {
        val given = DemoModel(
            stringProperty = "str",
            intProperty = 1,
            booleanProperty = true,
        )
        `when`("always") {
            demoService.execute(given)
            then("request to PrintService to print demoModel - verify with only behavior") {
                verify(exactly = 1) { printService.print(any()) }
            }

            then("request to PrintService to print demoModel - verify with argument match") {
                verify(exactly = 1) { printService.print(eq(given)) }
            }

            then("request to PrintService to print demoModel - verify with argument capture") {
                val captureSlot = CapturingSlot<DemoModel>()
                verify(exactly = 1) { printService.print(capture(captureSlot)) }
                captureSlot.captured shouldBe given
            }
        }
    }
})
