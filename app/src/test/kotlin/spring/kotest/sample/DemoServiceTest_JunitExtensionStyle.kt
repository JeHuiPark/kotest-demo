package spring.kotest.sample

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.CapturingSlot
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.extension.ExtendWith

@Suppress("ClassName")
@ExtendWith(MockKExtension::class)
class DemoServiceTest_JunitExtensionStyle : BehaviorSpec() {

    @RelaxedMockK
    lateinit var printService: PrintService

    @InjectMockKs
    lateinit var demoService: DemoService

    init {
        MockKAnnotations.init(this)

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
    }
}
