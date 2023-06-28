package dev.ocpd.jsensible

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.ArchRule
import org.junit.jupiter.api.assertThrows

inline fun <reified T> testRule(rule: ArchRule) {
    T::class.java.declaredClasses.forEach { clazz ->
        val classes = ClassFileImporter().importClasses(clazz)
        if (clazz.simpleName.startsWith("Compliant")) {
            rule.check(classes)
        } else if (clazz.simpleName.startsWith("NonCompliant")) {
            assertThrows<AssertionError> {
                rule.check(classes)
            }
        }
    }
}

fun testPackageRule(packageName: String, rule: ArchRule) {
    ClassFileImporter().importPackages(packageName).getPackage(packageName).subpackages
        .map {
            val importPackages = ClassFileImporter().importPackages(it.name)
            if (it.relativeName.startsWith("compliant")) {
                rule.check(importPackages)
            } else if (it.relativeName.startsWith("noncompliant")) {
                assertThrows<AssertionError> {
                    rule.check(importPackages)
                }
            }
        }
}
