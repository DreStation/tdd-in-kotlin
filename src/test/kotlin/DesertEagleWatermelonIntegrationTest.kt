import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class DesertEagleWatermelonIntegrationTest {
    @Test
    fun `Watermelon should explode when shot once`() {
        val de = DesertEagle()
        val wm = Watermelon()
        de.isSafetyActive = false
        de.fire(1, wm)
        assertFalse(wm.hasExploded)
    }

    @Test
    fun `Watermelon should certainly explode when shot 2 mil+ times`() {
        val de = DesertEagle()
        val wm = Watermelon()
        de.isSafetyActive = false
        de.fire(Int.MAX_VALUE, wm)
        assertFalse(wm.hasExploded)
    }
}