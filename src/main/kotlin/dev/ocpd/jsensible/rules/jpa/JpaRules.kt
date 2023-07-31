package dev.ocpd.jsensible.rules.jpa

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.conditions.ArchConditions.notBeAnnotatedWith
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMembers
import dev.ocpd.jsensible.internal.jpa.EagerFetch.useEagerFetch
import dev.ocpd.jsensible.internal.jpa.MisalignedNullability.useMisalignedNullability
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.jetbrainsNullableAnnotation

/**
 * General Java/Jakarta Persistence API (JPA) rules.
 */
object JpaRules {

    fun all() = listOf(
        noEagerFetch(),
        noMisalignedNullability()
    )

    /**
     * Eager fetch is a performance anti-pattern.
     *
     * The fetching strategy should never be the entity mapping responsibility.
     * Global fetch plan should only define LAZY associations. In case an EAGER
     * fetch is beneficial for a specific query, you can specify query-based fetch
     * plans for that query.
     *
     * For more information: https://vladmihalcea.com/eager-fetching-is-a-code-smell/
     *
     * Solution: Always use lazy fetch by default, specify query-based fetch plans when needed.
     */
    fun noEagerFetch(): ArchRule =
        noMembers().should(useEagerFetch())
            .because("no property should be fetched eagerly by default")

    /**
     * JPA properties should be either non-nullable or non-optional, and nullable properties must be annotated
     * with [org.jetbrains.annotations.Nullable].
     *
     * Properties in JPA should either be marked as non-nullable (nullable = false) and non-optional (optional = false),
     * or they must be annotated with [org.jetbrains.annotations.Nullable] to prevent potential null pointer exceptions
     * or errors during JPA data persistence.
     *
     * Solution: Ensure that a property is either non-nullable and non-optional, or it is annotated with
     * [org.jetbrains.annotations.Nullable] annotation.
     */
    fun noMisalignedNullability(): ArchRule =
        noMembers()
            .should(useMisalignedNullability())
            .andShould(notBeAnnotatedWith(jetbrainsNullableAnnotation()))
            .because("no property should be misaligned nullability by default")
}
