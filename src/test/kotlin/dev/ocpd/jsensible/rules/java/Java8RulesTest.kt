package dev.ocpd.jsensible.rules.java

import dev.ocpd.jsensible.testRule
import org.junit.jupiter.api.Test

class Java8RulesTest {

    @Test
    fun noLegacyDateTime() = testRule<NoLegacyDateTime>(Java8Rules.noLegacyDateTime())
}
