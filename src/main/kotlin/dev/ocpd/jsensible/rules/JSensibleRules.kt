package dev.ocpd.jsensible.rules

import dev.ocpd.jsensible.rules.java.JavaRules
import dev.ocpd.jsensible.rules.jpa.JpaRules
import dev.ocpd.jsensible.rules.nullsafety.NullSafetyRules
import dev.ocpd.jsensible.rules.spring.SpringRules

object JSensibleRules {

    fun all() = listOf(
        JavaRules.all(),
        JpaRules.all(),
        NullSafetyRules.all(),
        SpringRules.all()
    ).flatten()
}
