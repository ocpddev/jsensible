package dev.ocpd.jsensible.internal

import com.tngtech.archunit.junit.ArchTests

internal inline fun <reified T> include(): ArchTests = ArchTests.`in`(T::class.java)
