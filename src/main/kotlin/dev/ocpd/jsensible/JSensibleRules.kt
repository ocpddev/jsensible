package dev.ocpd.jsensible

import dev.ocpd.jsensible.java.JavaRules
import dev.ocpd.jsensible.jpa.JpaRules
import dev.ocpd.jsensible.nullsafety.NullSafetyRules
import dev.ocpd.jsensible.spring.SpringRules

object JSensibleRules {

    fun all() = listOf(
        JavaRules.all(),
        JpaRules.all(),
        NullSafetyRules.all(),
        SpringRules.all()
    ).flatten()
}
