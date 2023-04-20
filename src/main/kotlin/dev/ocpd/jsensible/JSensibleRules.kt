package dev.ocpd.jsensible

import dev.ocpd.jsensible.java.JavaRules
import dev.ocpd.jsensible.jpa.JpaRules
import dev.ocpd.jsensible.spring.SpringRules

object JSensibleRules {

    fun all() = listOf(
        JavaRules.all(),
        JpaRules.all(),
        SpringRules.all()
    ).flatten()
}
