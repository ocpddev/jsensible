package dev.ocpd.jsensible.jpa

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMembers
import dev.ocpd.jsensible.jpa.internal.EagerFetch.useEagerFetch

/**
 * General Java/Jakarta Persistence API (JPA) rules.
 */
object JpaRules {

    fun all() = listOf(
        noEagerFetch()
    )

    fun noEagerFetch(): ArchRule =
        noMembers().should(useEagerFetch())
            .`as`("use eager fetch")
            .because("no property should be fetched eagerly by default")
}
