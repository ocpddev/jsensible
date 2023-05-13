package dev.ocpd.jsensible.java

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.library.GeneralCodingRules
import dev.ocpd.jsensible.java.internal.LegacyIoFile.useLegacyIoFile

/**
 * Contains rules that are applicable to Java versions prior to Java 8.
 */
object JavaRules {

    fun all() = listOf(
        noStandardStreams(),
        noJavaUtilLogging(),
        noLegacyIoFile(),
        noGenericExceptions(),
        testsShouldResideInSamePackage(),
        noFieldInjection()
    ) + Java8Rules.all() + Java11Rules.all() + Java17Rules.all()

    /**
     * Directly accessing standard streams is generally considered as a bad practice:
     * - Write operations are synchronized and can lead to bottlenecks.
     * - It does not allow any external configuration.
     *
     * Solution: Use a proper logging utility instead.
     */
    fun noStandardStreams(): ArchRule =
        GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS
            .because("proper logging utility should be used instead")

    /**
     * In Java ecosystem, using a logging facade is the most idiomatic way to log messages.
     *
     * Solution: Use a logging facade (e.g. SLF4J) instead.
     */
    fun noJavaUtilLogging(): ArchRule =
        GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING
            .because("proper logging facade should be used instead")

    /**
     * The [java.io.File] has many drawbacks and should not be used.
     *
     * For more information: https://www.baeldung.com/java-path-vs-file
     *
     * Solution: Use [java.nio.file.Path] and [java.nio.file.Files] instead.
     */
    fun noLegacyIoFile(): ArchRule =
        noClasses().should(useLegacyIoFile())
            .because("[java.io.File] has many drawbacks and should not be used, use [java.nio.file.Files] instead")

    /**
     * Generic exception provides very little information about the actual problem.
     *
     * Solution: Use or create a more specific exception instead. Just within JDK itself,
     * you already have a few alternatives to choose:
     * - [IllegalArgumentException]
     * - [IllegalStateException]
     * - [UnsupportedOperationException]
     */
    fun noGenericExceptions(): ArchRule =
        GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS
            .because("generic exception provides very little information about the actual problem")

    /**
     * As a general convention, test classes should reside in the same package as implementation.
     * This is a good practice because it allows to access package-private members.
     * It also allows to use package-private classes as test fixtures.
     *
     * Solution: Move test classes to the same package as implementation.
     */
    fun testsShouldResideInSamePackage(): ArchRule =
        GeneralCodingRules.testClassesShouldResideInTheSamePackageAsImplementation()
            .because("it allows to access package-private members and use package-private classes as test fixtures")

    /**
     * Field injection is considered harmful:
     * - It makes the code harder to test.
     * - It hides dependencies behind private fields.
     * - It makes violating the single responsibility principle easy.
     * - Does not allow immutability.
     *
     * See https://stackoverflow.com/q/39890849 for detailed explanations.
     *
     * Solution: Use constructor injection instead.
     */
    fun noFieldInjection(): ArchRule =
        GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION
            .because("field injection is considered harmful and should be avoided, use constructor injection instead")
}
