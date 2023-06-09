package dev.ocpd.jsensible.internal.spring

import com.tngtech.archunit.base.DescribedPredicate.not
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.core.domain.JavaClass.Predicates.assignableTo
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.conditions.ArchConditions.dependOnClassesThat
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.nullableAnnotations
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.springNullableAnnotation

/**
 * Not use spring nullable conditions.
 */
internal object NotSpringNullable {

    /**
     * Matches not spring nullable.
     */
    internal fun notUseSpringNullable(): ArchCondition<JavaClass> =
        dependOnClassesThat(
            assignableTo(
                nullableAnnotations()
                    .and(not(springNullableAnnotation()))
            )
        ).`as`("not use spring nullable")
}
