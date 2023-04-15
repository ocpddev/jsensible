package dev.ocpd.jsensible.java

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.library.GeneralCodingRules

/**
 * Contains rules that are applicable to Java versions prior to Java 8.
 */
object JavaRules {

    fun all() = listOf(
        noStandardStreams(),
        noJavaUtilLogging(),
        noGenericExceptions()
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

    /*
     * TODO:
     *  - No [java.lang.System.exit]
     *  - No [java.lang.Thread.*] controls
     *  - No [Collectors.toList] calls
     *  - Test class should reside in the same package
     *  - package-info.java must present
     */
}
