package dev.ocpd.jsensible.rules.java

import dev.ocpd.jsensible.testRule
import org.junit.jupiter.api.Test

class Java11RulesTest {

    @Test
    fun noOptionalGet() = testRule<NoOptionalGet>(Java11Rules.noOptionalGet())

    @Test
    fun noPathsGet() = testRule<NoPathsGet>(Java11Rules.noPathsGet())
}
