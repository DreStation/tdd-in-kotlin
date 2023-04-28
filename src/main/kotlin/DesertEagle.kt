class DesertEagle {
    private var magazine = 7

    fun shoot(triggerPulls: Int): Int {
        // If firing more than 7 times
        if (magazine < triggerPulls || triggerPulls < 1)
            magazine = 0
        else
            magazine -= triggerPulls
        return magazine
    }
}
