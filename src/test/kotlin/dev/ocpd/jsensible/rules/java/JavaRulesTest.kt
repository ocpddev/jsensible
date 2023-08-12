package dev.ocpd.jsensible.rules.java

import dev.ocpd.jsensible.testRule
import org.junit.jupiter.api.Test

class JavaRulesTest {

    @Test
    fun noLegacyIoFile() = testRule<NoLegacyIoFile>(JavaRules.noLegacyIoFile)

    @Test
    fun equalsShouldAcceptNull() = testRule<EqualsShouldAcceptNull>(JavaRules.equalsShouldAcceptNull)
}
