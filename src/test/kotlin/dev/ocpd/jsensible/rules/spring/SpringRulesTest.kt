package dev.ocpd.jsensible.rules.spring

import dev.ocpd.jsensible.testRule
import org.junit.jupiter.api.Test

class SpringRulesTest {

    @Test
    fun noJakartaTransactionOnClass() = testRule<NoJakartaTransactionOnClass>(SpringRules.noJakartaTransactionOnClass())

    @Test
    fun noJakartaTransactionOnMethod() =
        testRule<NoJakartaTransactionOnMethod>(SpringRules.noJakartaTransactionOnMethod())

    @Test
    fun noNullableMisuseInRepositories() =
        testRule<NoNullableMisuseInRepositories>(SpringRules.noNullableMisuseInRepositories())
}
