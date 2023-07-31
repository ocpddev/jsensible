package dev.ocpd.jsensible.rules.jpa

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMembers
import dev.ocpd.jsensible.internal.jpa.EagerFetch.useEagerFetch
import dev.ocpd.jsensible.internal.jpa.MisalignedNullability.haveMisalignedNullability

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
     * fetch is beneficial for a specific query, query-based fetch plans can be
     * specified for that query.
     *
     * For more information: https://vladmihalcea.com/eager-fetching-is-a-code-smell/
     *
     * Solution: Always use lazy fetch by default, specify query-based fetch plans when needed.
     */
    fun noEagerFetch(): ArchRule =
        noMembers().should(useEagerFetch())
            .because("no property should be fetched eagerly by default")

    /**
     * JPA properties in both the database and the code should have aligned nullabilities.
     *
     * To avoid potential NPE when implementing business logic, the nullability of the
     * JPA property in the code should match the nullability of the column in the database.
     *
     * Solution: Annotate the JPA property with the appropriate nullability annotation.
     */
    fun noMisalignedNullability(): ArchRule =
        noMembers()
            .should(haveMisalignedNullability())
            .because("JPA properties in both the database and the code should have aligned nullabilities")
}
