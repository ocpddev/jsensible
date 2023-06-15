package dev.ocpd.jsensible.internal.java

import com.tngtech.archunit.core.domain.JavaMethod
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.ConditionEvents
import com.tngtech.archunit.lang.SimpleConditionEvent.violated

object ParameterIsNullable {

    /**
     * All parameters within the method should be annotated with @Nullable
     */
    fun parameterIsNullable(): ArchCondition<JavaMethod> =
        object : ArchCondition<JavaMethod>("parameters of equals method should be annotated with @Nullable") {
            override fun check(javaMethod: JavaMethod, events: ConditionEvents) {
                javaMethod.parameters
                    .filter { !it.isAnnotatedWith("org.jetbrains.annotations.Nullable") }
                    .forEach {
                        events.add(
                            violated(
                                javaMethod, it.description
                                        + " is not annotated with [org.jetbrains.annotations.Nullable]"
                            )
                        )
                    }
            }
        }
}
