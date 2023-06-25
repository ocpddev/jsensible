package dev.ocpd.jsensible.rules.jpa

import dev.ocpd.jsensible.testRule
import org.junit.jupiter.api.Test

class JpaRulesTest {

    @Test
    fun noEagerFetch() = testRule<NoEagerFetch>(JpaRules.noEagerFetch())
}
