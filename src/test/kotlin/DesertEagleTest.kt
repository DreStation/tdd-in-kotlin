import org.junit.jupiter.api.Test;
import kotlin.test.assertEquals

class DesertEagleTest {
    @Test
    fun testShootOnce() {
        val de = DesertEagle()
        val result = de.shoot(1)
        assertEquals(6, result)
    }

    @Test
    fun testShootUntilEmpty() {
        val de = DesertEagle()
        val result = de.shoot(7)
        assertEquals(0, result)
    }

    @Test
    fun testShootWhileEmpty() {
        val de = DesertEagle()
        val result = de.shoot(14)
        assertEquals(0, result)
    }

    @Test
    fun testShootNegativeInt() {
        val de = DesertEagle()
        val result = de.shoot(-1)
        assertEquals(0, result)
    }
}
