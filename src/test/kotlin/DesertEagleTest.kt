import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable
import kotlin.test.assertEquals

class DesertEagleTest {
    @Test
    @DisplayName("Ensure you can't fire when safety is active")
    fun testFireWhenSafetyIsActive() {
        val de = DesertEagle()
        val exception = assertThrows<IllegalArgumentException> { de.fire(1) }
        assertEquals("Cannot fire when safety is active", exception.message)
    }

    @Test
    @DisplayName("Fire once and have 6 bullets remaining")
    fun testFireOnce() {
        val de = DesertEagle()
        de.isSafetyActive = false
        de.fire(1)
        assertEquals(6, de.bullets)
    }

    @Test
    @DisplayName("Fire 7 times and have 0 bullets remaining")
    fun testFireUntilEmpty() {
        val de = DesertEagle()
        de.isSafetyActive = false
        de.fire(7)
        assertEquals(0, de.bullets)
    }

    @Test
    @DisplayName("Fire more than 7 times and ensure bullets don't go negative")
    fun testFireWhileEmpty() {
        val de = DesertEagle()
        de.isSafetyActive = false
        de.fire(14)
        assertEquals(0, de.bullets)
    }

    @Test
    @DisplayName("Ensure nothing happens when inputting 0 or negative ints")
    fun testFireWithNegativeInput() {
        val de = DesertEagle()
        de.isSafetyActive = false
        assertAll(Executable {
            val exception = assertThrows<IllegalArgumentException> { de.fire(0) }
            assertEquals("Cannot fire less than once", exception.message)
        }, Executable {
            val exception = assertThrows<IllegalArgumentException> { de.fire(-1) }
            assertEquals("Cannot fire less than once", exception.message)
        })
    }
}
