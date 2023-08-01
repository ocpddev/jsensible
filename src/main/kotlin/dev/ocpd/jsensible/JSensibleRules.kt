package dev.ocpd.jsensible

import com.tngtech.archunit.junit.ArchTest
import dev.ocpd.jsensible.internal.include
import dev.ocpd.jsensible.rules.java.JavaRules
import dev.ocpd.jsensible.rules.jpa.JpaRules
import dev.ocpd.jsensible.rules.nullsafe.NullSafeRules
import dev.ocpd.jsensible.rules.spring.SpringRules

object JSensibleRules {

    @ArchTest
    val java = include<JavaRules>()

    @ArchTest
    val nullSafe = include<NullSafeRules>()

    @ArchTest
    val spring = include<SpringRules>()

    @ArchTest
    val jpa = include<JpaRules>()
}
