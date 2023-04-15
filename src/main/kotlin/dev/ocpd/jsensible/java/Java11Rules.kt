package dev.ocpd.jsensible.java

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import java.util.*

/**
 * Contains rules that are applicable to Java 11 and later.
 */
object Java11Rules {

    fun all() = listOf(
        noOptionGet()
    )

    /**
     * The [Optional.get] method is deprecated by JDK:
     *
     * > The preferred alternative to this method is [Optional.orElseThrow].
     *
     * Solution: Replace [Optional.get] with [Optional.orElseThrow].
     */
    fun noOptionGet(): ArchRule =
        noClasses().should().callMethod(Optional::class.java, "get")
            .`as`("call [Optional.get]")
            .because("JDK recommends [Optional.orElseThrow] as the preferred alternative")
}
