package dev.ocpd.jsensible.arch

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import dev.ocpd.jsensible.rules.jpa.JpaRules

@AnalyzeClasses(
    packages = ["dev.ocpd.jsensible"]
)
class JpaRulesArchTest {

    @ArchTest
    fun `only use spring nullable annotation`(classes: JavaClasses) {
        JpaRules
            .onlyUseSpringNullableAnnotation()
            .check(classes)
    }

}