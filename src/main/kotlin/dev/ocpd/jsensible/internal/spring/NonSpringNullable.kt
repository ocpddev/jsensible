package dev.ocpd.jsensible.internal.spring

import com.tngtech.archunit.base.DescribedPredicate.not
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.conditions.ArchConditions.dependOnClassesThat
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.nullableAnnotations
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.springNullableAnnotation

/**
 * Not use spring nullable conditions.
 */
internal object NonSpringNullable {

    /**
     * Matches not spring nullable.
     */
    internal fun useNonSpringNullable(): ArchCondition<JavaClass> =
        dependOnClassesThat(
            nullableAnnotations()
                .and(not(springNullableAnnotation()))
        ).`as`("use non-spring [Nullable] annotations")
}
