package dev.ocpd.jsensible.internal

import com.tngtech.archunit.base.DescribedPredicate
import com.tngtech.archunit.core.domain.JavaPackage
import com.tngtech.archunit.core.domain.properties.HasSourceCodeLocation
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.ArchCondition.ConditionByPredicate.EventDescriber
import com.tngtech.archunit.lang.ConditionEvents
import com.tngtech.archunit.lang.SimpleConditionEvent

/**
 * An [ArchCondition] for [JavaPackage]s
 *
 * This is due to the [JavaPackage] does not implement [HasSourceCodeLocation] interface,
 * and many built-in fluent-APIs require having [HasSourceCodeLocation] to be implemented.
 */
internal class JavaPackageCondition(
    private val predicate: DescribedPredicate<in JavaPackage>,
    description: String = predicate.description,
    private val eventDescriber: EventDescriber
) : ArchCondition<JavaPackage>(
    description
) {
    override fun check(item: JavaPackage, events: ConditionEvents) {
        val satisfied = predicate.test(item)
        val message = "${item.description} ${eventDescriber.describe(predicate.description, satisfied)}"
        events.add(SimpleConditionEvent(item, predicate.test(item), message))
    }

    override fun `as`(description: String, vararg args: Any?) =
        JavaPackageCondition(predicate, description.format(*args), eventDescriber)
}
