import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class DesertEagleWatermelonIntegrationTest {
    @Test
    fun `Watermelon is not intact when shot once`() {
        val de = DesertEagle()
        val wm = Watermelon()
        de.isSafetyActive = false
        de.fire(1, wm)
        assertFalse(wm.isIntact)
    }
}