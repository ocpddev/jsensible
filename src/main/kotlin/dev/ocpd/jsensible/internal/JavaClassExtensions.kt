package dev.ocpd.jsensible.internal

import com.tngtech.archunit.core.domain.JavaClass

internal fun JavaClass.isKotlin() = isAnnotatedWith("kotlin.Metadata")
