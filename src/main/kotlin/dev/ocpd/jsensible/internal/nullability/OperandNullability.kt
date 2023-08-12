package dev.ocpd.jsensible.internal.nullability

import com.tngtech.archunit.base.DescribedPredicate.describe
import com.tngtech.archunit.core.domain.JavaMethod
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.ArchCondition.from
import dev.ocpd.jsensible.internal.nullability.NullabilityAnnotations.nullableAnnotations

/**
 * Conditions for operand nullability.
 */
internal object OperandNullability {

    /**
     * Matches if the method accepts a nullable operand.
     */
    internal fun acceptNullableOperand(): ArchCondition<JavaMethod> =
        from(describe("accept null values as operand") { method ->
            // ignore if not having exactly one parameter
            val operand = method.parameters.singleOrNull() ?: return@describe true
            operand.isAnnotatedWith(nullableAnnotations())
        })
}
