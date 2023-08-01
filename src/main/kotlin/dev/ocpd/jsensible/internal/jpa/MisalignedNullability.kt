package dev.ocpd.jsensible.internal.jpa

import com.tngtech.archunit.base.DescribedPredicate.describe
import com.tngtech.archunit.core.domain.JavaMember
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.conditions.ArchConditions.be
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.nullableAnnotations
import kotlin.jvm.optionals.getOrNull

/**
 * Misaligned nullability declaration condition.
 */
object MisalignedNullability {

    /**
     * Matches misaligned nullability declaration.
     */
    internal fun haveMisalignedNullability(): ArchCondition<in JavaMember> {
        return be(describe("have misaligned nullability") { member ->
            val jpaNullability = member.jpaNullability() ?: return@describe false
            jpaNullability != member.javaNullability()
        })
    }

    private fun JavaMember.jpaNullability(): Boolean? =
        annotations.firstOrNull { it.type.name in nullableJpaAnnotations }
            ?.run {
                this["nullable"].getOrNull() as? Boolean
                    ?: this["optional"].getOrNull() as? Boolean
            }

    private fun JavaMember.javaNullability(): Boolean =
        isAnnotatedWith(nullableAnnotations())

    private val nullableJpaAnnotations = setOf(
        "jakarta.persistence.ManyToOne",
        "jakarta.persistence.OneToOne",
        "jakarta.persistence.Column"
    )
}
