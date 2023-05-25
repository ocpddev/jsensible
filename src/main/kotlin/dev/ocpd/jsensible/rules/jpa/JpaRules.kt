package dev.ocpd.jsensible.rules.jpa

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMembers
import dev.ocpd.jsensible.internal.jpa.EagerFetch.useEagerFetch
import dev.ocpd.jsensible.internal.jpa.NotSpringNullable.noUseSpringNullable

/**
 * General Java/Jakarta Persistence API (JPA) rules.
 */
object JpaRules {

    fun all() = listOf(
        noEagerFetch(),
        useSpringNullableAnnotation()
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
            .`as`("use eager fetch")
            .because("no property should be fetched eagerly by default")

    /**
     * only support the [org.springframework.lang.Nullable] annotation
     *
     * Spring Data Repositories only support the usage of their own
     * [org.springframework.lang.Nullable] annotation. Misuses could
     * lead to runtime errors when invoking repository methods.
     *
     * Solution: Use the [org.springframework.lang.Nullable] annotation.
     */
    fun useSpringNullableAnnotation(): ArchRule =
        noClasses()
            .that().areAssignableTo("org.springframework.data.repository.Repository")
            .should(noUseSpringNullable())
            .because("only support the [org.springframework.lang.Nullable] annotation]")
}
