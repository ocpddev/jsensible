package dev.ocpd.jsensible.arch

import com.tngtech.archunit.core.importer.ClassFileImporter
import dev.ocpd.jsensible.repo.UseJetbrainsNullableRepo
import dev.ocpd.jsensible.repo.UseSpringNullableRepo
import dev.ocpd.jsensible.rules.spring.SpringRules
import org.junit.jupiter.api.Test

class JpaRulesArchTest {

    @Test
    fun `use spring nullable annotation`() {
        val classes = ClassFileImporter().importClasses(UseSpringNullableRepo::class.java)
        SpringRules
            .onlyUseSpringNullableAnnotation()
            .check(classes);
    }

    @Test
    fun `use jetbrains nullable annotation`() {
        val classes = ClassFileImporter().importClasses(UseJetbrainsNullableRepo::class.java)
        SpringRules
            .onlyUseSpringNullableAnnotation()
            .check(classes)
    }
}
