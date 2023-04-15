package dev.ocpd.jsensible

import com.tngtech.archunit.lang.CompositeArchRule

object JSensible {
    fun all() = CompositeArchRule.of(
        JSensibleRules.all()
    )
}
