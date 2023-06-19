package dev.ocpd.jsensible.rules.java

import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import java.net.URI
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

/**
 * Contains rules that are applicable to Java 11 and later.
 */
object Java11Rules {

    fun all() = listOf(
        noOptionalGet(),
        noPathsGet()
    )

    /**
     * The [Optional.get] method is deprecated by JDK:
     *
     * > The preferred alternative to this method is [Optional.orElseThrow].
     *
     * Solution: Replace [Optional.get] with [Optional.orElseThrow].
     */
    fun noOptionalGet(): ArchRule =
        noClasses().should().callMethod(Optional::class.java, "get")
            .`as`("call [Optional.get]")
            .because("JDK recommends [Optional.orElseThrow] as the preferred alternative")

    /**
     * The [Paths.get] method is deprecated by JDK:
     *
     * > It is recommended to obtain a [Path] via the [Path.of] methods instead
     * of via the [Paths.get] methods defined in this class as this class may
     * be deprecated in a future release.
     *
     * Solution: Replace [Paths.get] with [Path.of].
     */
    fun noPathsGet(): ArchRule =
        noClasses()
            .should().callMethod(Paths::class.java, "get", String::class.java, Array<String>::class.java)
            .orShould().callMethod(Paths::class.java, "get", URI::class.java)
            .`as`("call [Paths.get]")
            .because("JDK recommends to obtain a [Path] via the [Path.of] methods instead")
}
