package dev.ocpd.jsensible.internal.nullability

import com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.metaAnnotatedWith
import dev.ocpd.jsensible.internal.JavaPackageCondition
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.nonNullAnnotations

/**
 * Conditions for enforcing non-null by default.
 */
internal object NonNullByDefault {

    internal fun beNonNullByDefault() = JavaPackageCondition(
        metaAnnotatedWith(nonNullAnnotations()).`as`("marked as non-null by default"),
        "be non-null by default"
    ) { description, satisfied ->
        if (satisfied) "is $description" else "is not $description"
    }
}
