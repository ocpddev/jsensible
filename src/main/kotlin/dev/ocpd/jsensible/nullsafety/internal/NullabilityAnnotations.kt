package dev.ocpd.jsensible.nullsafety.internal

import com.tngtech.archunit.base.DescribedPredicate
import com.tngtech.archunit.core.domain.JavaAnnotation
import com.tngtech.archunit.core.domain.properties.HasType.Predicates.rawType
import dev.ocpd.jsensible.internal.JavaClassPredicates.anyOf

/**
 * Predicates for nullability annotations.
 */
internal object NullabilityAnnotations {

    internal fun nullableAnnotations(): DescribedPredicate<JavaAnnotation<*>> = rawType(
        anyOf(
            "org.jetbrains.annotations.Nullable",
            "javax.annotation.Nullable",
            "org.springframework.lang.Nullable"
        )
    ).forSubtype()

    internal fun nonNullAnnotations(): DescribedPredicate<JavaAnnotation<*>> = rawType(
        anyOf(
            "org.jetbrains.annotations.NotNull",
            "javax.annotation.Nonnull",
            "org.springframework.lang.NonNull"
        )
    ).forSubtype()
}
