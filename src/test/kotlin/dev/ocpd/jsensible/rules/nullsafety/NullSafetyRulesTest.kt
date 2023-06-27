package dev.ocpd.jsensible.rules.nullsafety

import com.tngtech.archunit.core.importer.ClassFileImporter
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NullSafetyRulesTest {

    @Test
    fun nonNullByDefault() {

        val compliantClasses =
            ClassFileImporter().importPackages("dev.ocpd.jsensible.rules.nullsafety.nonnullbydefault.compliant")
        NullSafetyRules.nonNullByDefault().check(compliantClasses)

        val nonCompliantClasses =
            ClassFileImporter().importPackages("dev.ocpd.jsensible.rules.nullsafety.nonnullbydefault.noncompliant")
        assertThrows<AssertionError> { NullSafetyRules.nonNullByDefault().check(nonCompliantClasses) }
    }
}
