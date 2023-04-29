import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable
import kotlin.test.assertEquals

class DesertEagleTest {
    @Test
    @DisplayName("Ensure you can't shoot when safety is active")
    fun testShootWhenSafetyIsActive() {
        val de = DesertEagle()
        val exception = assertThrows<IllegalArgumentException> { de.shoot(1) }
        assertEquals("Cannot shoot when safety is active", exception.message)
    }

    @Test
    @DisplayName("Shoot once and have 6 bullets remaining")
    fun testShootOnce() {
        val de = DesertEagle()
        de.isSafetyActive = false
        val result = de.shoot(1)
        assertEquals(6, result)
    }

    @Test
    @DisplayName("Shoot 7 times and have 0 bullets remaining")
    fun testShootUntilEmpty() {
        val de = DesertEagle()
        de.isSafetyActive = false
        val result = de.shoot(7)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Shoot more than 7 times and ensure magazine isn't negative")
    fun testShootWhileEmpty() {
        val de = DesertEagle()
        de.isSafetyActive = false
        val result = de.shoot(14)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Ensure nothing happens when inputting 0 or negative ints")
    fun testShootWithNegativeInput() {
        val de = DesertEagle()
        de.isSafetyActive = false
        assertAll(
            Executable { assertEquals(7, de.shoot(0)) },
            Executable { assertEquals(7, de.shoot(-1)) }
        )
    }
}
