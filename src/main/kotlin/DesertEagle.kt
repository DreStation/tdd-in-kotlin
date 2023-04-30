class DesertEagle(var rounds: Int = 7, var isSafetyActive: Boolean = true) {
    fun fire(triggerPulls: Int, watermelon: Watermelon? = null) {
        if (isSafetyActive) throw IllegalArgumentException("Cannot fire when safety is active")

        if (triggerPulls in Int.MIN_VALUE..0) throw IllegalArgumentException("Cannot fire less than once")
        else {
            for (i in 1..triggerPulls) {
                if (rounds > 0) --rounds
            }
        }

        // Determine if watermelon has exploded from being shot. It only takes one .50 AE bullet to explode one.
        if (watermelon == null) println("Fired $triggerPulls round(s)")
        else {
            watermelon.hasExploded = true
            println("Fired $triggerPulls round(s) into the watermelon. The watermelon has exploded.")
        }
    }
}