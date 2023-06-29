package dev.ocpd.jsensible.internal.jpa

import com.tngtech.archunit.base.DescribedPredicate
import com.tngtech.archunit.base.DescribedPredicate.describe
import com.tngtech.archunit.core.domain.JavaAnnotation
import com.tngtech.archunit.core.domain.JavaMember
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.conditions.ArchConditions.beAnnotatedWith

/**
 * Nullable or optional usage condition.
 */
object NullableOrOptional {

    /**
     * Matches nullable or optional usage.
     */
    internal fun useNullableOrOptional(): ArchCondition<in JavaMember> =
        beAnnotatedWith(
            associationWithNullableOrOptional()
        ).`as`("use nullable or optional")

    /**
     * Check if the annotation is a JPA association annotation and configured
     * to nullable or optional.
     */
    private fun associationWithNullableOrOptional(): DescribedPredicate<JavaAnnotation<*>> {
        val associationAnnotations = associationAnnotations()
        return describe("nullable or optional annotation") { annotation: JavaAnnotation<*> ->
            if (annotation.type.name !in associationAnnotations) return@describe false

            val value =
                if (annotation.type.name == "jakarta.persistence.Column") annotation["nullable"].orElse(null)
                else annotation["optional"].orElse(null)

            value is Boolean && value == true
        }
    }

    private fun associationAnnotations() = setOf(
        "jakarta.persistence.ManyToOne",
        "jakarta.persistence.OneToOne",
        "org.hibernate.annotations.Any",
        "jakarta.persistence.Column"
    )
}
