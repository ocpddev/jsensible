package dev.ocpd.jsensible

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.lang.FailureReport
import dev.ocpd.jsensible.rules.JSensibleRules

object JSensible {

    /**
     * JSensible Rules
     */
    fun check(javaClasses: JavaClasses) {
        val toList = JSensibleRules.all()
            .map {
                // When checking, it is possible that no classes have been passed to the rule at all, or that no classes
                // passed to the rule matched the `that()` clause. So we should use `ArchRule.allowEmptyShould(true)`.
                it.allowEmptyShould(true).evaluate(javaClasses).failureReport
            }
            .filterNot(FailureReport::isEmpty)
            .toList()
        if (toList.isNotEmpty()) throw AssertionError(toList.joinToString(separator = "\n\n", postfix = "\n"))
    }
}
