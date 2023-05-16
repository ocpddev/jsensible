package dev.ocpd.jsensible.rules.nullsafety

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.all
import dev.ocpd.jsensible.internal.Transformers.javaPackages
import dev.ocpd.jsensible.internal.nullability.NonNullByDefault.beNonNullByDefault

/**
 * Contains rules to enforce null safety.
 */
object NullSafetyRules {

    fun all() = listOf(nonNullByDefault())

    /**
     * The most efficient way to ensure null-safety is to establish a convention that
     * all packages should be non-null by default.
     *
     * Solution: Mark all packages as non-null by default. This can be done using
     * `org.springframework.lang.NonNullApi` if you have Spring in your dependencies.
     */
    fun nonNullByDefault(): ArchRule =
        all(javaPackages()).should(beNonNullByDefault())
            .because("null safety should be enforced for all packages")
}
