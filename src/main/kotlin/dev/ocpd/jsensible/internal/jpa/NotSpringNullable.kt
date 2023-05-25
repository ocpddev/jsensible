package dev.ocpd.jsensible.internal.jpa

import com.tngtech.archunit.base.DescribedPredicate.not
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.core.domain.JavaClass.Predicates.assignableTo
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.conditions.ArchConditions.dependOnClassesThat
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.nullableClasses
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.springNullableClasses

/**
 * No use spring nullable conditions.
 */
internal object NotSpringNullable {

    /**
     * Matches not spring nullable.
     */
    internal fun noUseSpringNullable(): ArchCondition<in JavaClass> =
        dependOnClassesThat(
            assignableTo(
                nullableClasses()
                    .and(not(springNullableClasses()))
            )
        ).`as`("no use spring nullable")
}