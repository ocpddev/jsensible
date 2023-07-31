package dev.ocpd.jsensible.internal.spring

import com.tngtech.archunit.base.DescribedPredicate.not
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.conditions.ArchConditions.dependOnClassesThat
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.nullableAnnotationClasses
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.springNullableAnnotationClass

/**
 * Not use spring nullable conditions.
 */
internal object NonSpringNullable {

    /**
     * Matches not spring nullable.
     */
    internal fun useNonSpringNullable(): ArchCondition<JavaClass> =
        dependOnClassesThat(
            nullableAnnotationClasses()
                .and(not(springNullableAnnotationClass()))
        ).`as`("use non-spring [Nullable] annotations")
}
