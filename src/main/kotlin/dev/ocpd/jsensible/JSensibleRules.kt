package dev.ocpd.jsensible

import dev.ocpd.jsensible.java.JavaRules
import dev.ocpd.jsensible.jpa.JpaRules

object JSensibleRules {

    fun all() = listOf(
        JavaRules.all(),
        JpaRules.all()
    ).flatten()
}
