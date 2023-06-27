package dev.ocpd.jsensible.rules.spring

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMethods
import dev.ocpd.jsensible.internal.spring.NonSpringNullable.useNonSpringNullable

/**
 * Contains rules that are applicable to Spring ecosystem (Spring Framework, Spring Boot, etc.).
 */
object SpringRules {

    fun all() = listOf(
        noJakartaTransactionOnClass(),
        noJakartaTransactionOnMethod(),
        noNullableMisuseInRepositories()
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

    /**
     * Spring Data Repositories only support their own [org.springframework.lang.Nullable] annotation.
     *
     * Spring Data Repositories only support the usage of their own [org.springframework.lang.Nullable] annotation.
     * Misuses could lead to runtime errors when invoking repository methods.
     *
     * Solution: Use the [org.springframework.lang.Nullable] annotation.
     */
    fun noNullableMisuseInRepositories(): ArchRule =
        noClasses()
            .that().areAssignableTo("org.springframework.data.repository.Repository")
            .should(useNonSpringNullable())
            .because("in Spring Data Repositories, it only support the [org.springframework.lang.Nullable] annotation")
}
