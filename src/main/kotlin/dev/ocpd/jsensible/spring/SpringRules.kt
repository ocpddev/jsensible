package dev.ocpd.jsensible.spring

import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMethods

/**
 * Contains rules that are applicable to Spring ecosystem (Spring Framework, Spring Boot, etc.).
 */
object SpringRules {

    fun all() = listOf(
        noJavaxTransactionOnClass(),
        noJavaxTransactionOnMethod()
    )

    /**
     * The [org.springframework.transaction.annotation.Transactional] should be preferred in a Spring application,
     * and it provides more functionality compared to the [javax.transaction.Transactional] annotation.
     *
     * Solution: Replace [javax.transaction.Transactional] with [org.springframework.transaction.annotation.Transactional].
     */
    fun noJavaxTransactionOnClass() =
        noClasses().should().beAnnotatedWith("javax.transaction.Transactional")
            .because("in Spring application, it is recommended to use [org.springframework.transaction.annotation.Transactional] instead")

    /**
     * The [org.springframework.transaction.annotation.Transactional] should be preferred in a Spring application,
     * and it provides more functionality compared to the [javax.transaction.Transactional] annotation.
     *
     * Solution: Replace [javax.transaction.Transactional] with [org.springframework.transaction.annotation.Transactional].
     */
    fun noJavaxTransactionOnMethod() =
        noMethods().should().beAnnotatedWith("javax.transaction.Transactional")
            .because("in Spring application, it is recommended to use [org.springframework.transaction.annotation.Transactional] instead")
}
