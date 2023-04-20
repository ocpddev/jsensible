package dev.ocpd.jsensible.java.internal

import com.tngtech.archunit.base.DescribedPredicate
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.core.domain.JavaClass.Predicates.assignableTo
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.conditions.ArchConditions.dependOnClassesThat
import dev.ocpd.jsensible.internal.JavaClassPredicates.anyOf
import java.text.DateFormat
import java.util.*

/**
 * Legacy date/time API usage condition.
 */
internal object LegacyDateTime {

    /**
     * Matches legacy date/time API classes.
     *
     * Note: many of them can be subclassed, thus this checks the assignability instead.
     */
    internal fun useLegacyDateTime(): ArchCondition<JavaClass> =
        dependOnClassesThat(
            assignableTo(
                legacyDateTimeClasses()
            )
        ).`as`("use legacy date/time API")

    /**
     * Defines legacy date/time API classes.
     */
    private fun legacyDateTimeClasses(): DescribedPredicate<JavaClass> =
        anyOf(
            Date::class.java,
            Calendar::class.java,
            DateFormat::class.java,
            TimeZone::class.java
        )
}