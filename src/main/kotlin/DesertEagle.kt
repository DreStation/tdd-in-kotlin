class DesertEagle {
    var magazine = 7
    var isSafetyActive = true

    fun shoot(triggerPulls: Int): Int {
        // Don't shoot unless safety is deactivated
        if (isSafetyActive) throw IllegalArgumentException("Cannot shoot when safety is active")

        magazine = when (triggerPulls) {
            in Int.MIN_VALUE..0 -> 7 // Can't shoot 0 or negative times, do nothing
            in 1..6 -> --magazine // Normal shooting 💥🔫
            else -> 0 // Mag emptied from shooting more than 6 times
        }
        return magazine

        /*
        // If firing more than 7 times, empty mag
        if (triggerPulls > magazine)
            magazine = 0

        // If 0 or negative input, do nothing
        else if (triggerPulls < 1)
            return magazine

        else
            magazine -= triggerPulls
        return magazine*/
    }
}
