package dev.ocpd.jsensible.rules.java

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import com.tngtech.archunit.library.GeneralCodingRules
import dev.ocpd.jsensible.internal.java.LegacyDateTime.useLegacyDateTime
import java.text.DateFormat
import java.util.*

/**
 * Contains rules that are applicable to Java 8 and later.
 */
object Java8Rules {

    fun all() = listOf(
        noJodaTime(),
        noLegacyDateTime()
    )

    /**
     * JodaTime is a legacy library that is no longer maintained.
     *
     * Solution: Use the [java.time] API provided by JDK 8 instead.
     */
    fun noJodaTime(): ArchRule =
        GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME
            .because("modern Java projects should use the Java 8 [java.time] API instead")

    /**
     * [Date], [Calendar], [DateFormat], and [TimeZone] are legacy date/time
     * API that should be avoided in modern Java projects.
     *
     * For more information: https://dev.java/learn/date-time/legacy-code/
     *
     * Solution: Use the [java.time] API provided by JDK 8 instead.
     */
    fun noLegacyDateTime(): ArchRule =
        noClasses().should(useLegacyDateTime())
            .because("modern Java projects should use the Java 8 [java.time] API instead")
}
