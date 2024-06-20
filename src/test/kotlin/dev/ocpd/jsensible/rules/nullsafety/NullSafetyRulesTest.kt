package dev.ocpd.jsensible.rules.nullsafety

import dev.ocpd.jsensible.testPackageRule
import org.junit.jupiter.api.Test

class NullSafetyRulesTest {

    @Test
    fun nonNullByDefault() {
        testPackageRule("dev.ocpd.jsensible.rules.nullsafety.nonnullbydefault", NullSafetyRules.nonNullByDefault())
    }
}
