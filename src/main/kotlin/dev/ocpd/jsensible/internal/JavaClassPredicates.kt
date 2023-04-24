package dev.ocpd.jsensible.internal

import com.tngtech.archunit.base.DescribedPredicate
import com.tngtech.archunit.base.DescribedPredicate.describe
import com.tngtech.archunit.core.domain.Formatters.formatNamesOf
import com.tngtech.archunit.core.domain.JavaClass

/**
 * Helper predicates that ArchUnit did not provide.
 */
internal object JavaClassPredicates {
    internal fun anyOf(vararg classes: Class<*>): DescribedPredicate<JavaClass> =
        describe("any of ${formatNamesOf(*classes)}") { clz: JavaClass ->
            classes.any(clz::isEquivalentTo)
        }

    internal fun anyOf(vararg classes: String): DescribedPredicate<JavaClass> =
        describe("any of ${classes.contentToString()}") { clz: JavaClass ->
            classes.contains(clz.name)
        }
}
