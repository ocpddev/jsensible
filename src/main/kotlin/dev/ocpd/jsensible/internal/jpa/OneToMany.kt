package dev.ocpd.jsensible.internal.jpa

import com.tngtech.archunit.core.domain.JavaMember
import com.tngtech.archunit.core.domain.properties.HasType.Predicates.rawType
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.conditions.ArchConditions.beAnnotatedWith
import dev.ocpd.jsensible.internal.JavaClassPredicates.anyOf

/**
 * One-to-many association usage condition.
 */
internal object OneToMany {

    /**
     * Matches one-to-many association usage.
     */
    internal fun useOneToMany(): ArchCondition<in JavaMember> =
        beAnnotatedWith(
            oneToManyAnnotations()
        ).`as`("use one-to-many association")

    private fun oneToManyAnnotations() = rawType(
        anyOf(
            "javax.persistence.OneToMany",
            "jakarta.persistence.OneToMany"
        )
    )
}
