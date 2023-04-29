import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.function.Executable
import kotlin.test.assertEquals

class DesertEagleTest {
    @Test
    fun `Ensure exception is thrown when safety is active`() {
        val de = DesertEagle()
        val exception = assertThrows<IllegalArgumentException> { de.fire(1) }
        assertEquals("Cannot fire when safety is active", exception.message)
    }

    @Test
    fun `Fire once and have 6 rounds remaining`() {
        val de = DesertEagle()
        de.isSafetyActive = false
        de.fire(1)
        assertEquals(6, de.rounds)
    }

    @Test
    fun `Fire all 7 rounds and have 0 rounds remaining`() {
        val de = DesertEagle()
        de.isSafetyActive = false
        de.fire(7)
        assertEquals(0, de.rounds)
    }

    @Test
    fun `Fire 7+ times and ensure rounds don't go negative`() {
        val de = DesertEagle()
        de.isSafetyActive = false
        de.fire(14)
        assertEquals(0, de.rounds)
    }

    @Test
    fun `Ensure exception is thrown when inputting 0 or negative ints`() {
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
