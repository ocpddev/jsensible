package dev.ocpd.jsensible

import com.tngtech.archunit.lang.CompositeArchRule
import dev.ocpd.jsensible.rules.JSensibleRules

object JSensible {
    fun all() = CompositeArchRule.of(
        JSensibleRules.all()
    ).`as`("JSensible Rules")
}
