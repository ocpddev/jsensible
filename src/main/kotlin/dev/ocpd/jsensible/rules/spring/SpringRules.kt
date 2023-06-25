package dev.ocpd.jsensible.rules.spring

import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMethods

/**
 * Contains rules that are applicable to Spring ecosystem (Spring Framework, Spring Boot, etc.).
 */
object SpringRules {

    fun all() = listOf(
        noJakartaTransactionOnClass(),
        noJakartaTransactionOnMethod()
    )

    /**
     * The [org.springframework.transaction.annotation.Transactional] should be preferred in a Spring application,
     * and it provides more functionality compared to the [jakarta.transaction.Transactional] annotation.
     *
     * Solution: Replace [jakarta.transaction.Transactional] with [org.springframework.transaction.annotation.Transactional].
     */
    fun noJakartaTransactionOnClass() =
        noClasses().should().beAnnotatedWith("jakarta.transaction.Transactional")
            .because("in Spring application, it is recommended to use [org.springframework.transaction.annotation.Transactional] instead")

    /**
     * The [org.springframework.transaction.annotation.Transactional] should be preferred in a Spring application,
     * and it provides more functionality compared to the [jakarta.transaction.Transactional] annotation.
     *
     * Solution: Replace [jakarta.transaction.Transactional] with [org.springframework.transaction.annotation.Transactional].
     */
    fun noJakartaTransactionOnMethod() =
        noMethods().should().beAnnotatedWith("jakarta.transaction.Transactional")
            .because("in Spring application, it is recommended to use [org.springframework.transaction.annotation.Transactional] instead")
}
