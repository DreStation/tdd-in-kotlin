class DesertEagle(var bullets: Int = 7, var isSafetyActive: Boolean = true) {
    fun fire(triggerPulls: Int) {
        if (isSafetyActive) throw IllegalArgumentException("Cannot fire when safety is active")

        if (triggerPulls in Int.MIN_VALUE..0) throw IllegalArgumentException("Cannot fire less than once")
        else {
            for (i in 1..triggerPulls) {
                if (bullets > 0) {
                    --bullets
                }
            }
            bullets
        }
    }
}