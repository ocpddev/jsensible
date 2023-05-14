package dev.ocpd.jsensible.java.internal

import com.tngtech.archunit.base.DescribedPredicate
import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.core.domain.JavaClass.Predicates.assignableTo
import com.tngtech.archunit.lang.ArchCondition
import com.tngtech.archunit.lang.conditions.ArchConditions.dependOnClassesThat
import dev.ocpd.jsensible.internal.JavaClassPredicates.anyOf

/**
 * Legacy IO file API usage condition.
 */
internal object LegacyIoFile {

    /**
     * Matches legacy IO file API access.
     *
     * Note: many of them can be subclassed, thus this checks the assignability instead.
     */
    internal fun useLegacyIoFile(): ArchCondition<JavaClass> =
        dependOnClassesThat(
            assignableTo(
                legacyIoFileClasses()
            )
        ).`as`("use legacy IO file API")

    /**
     * Define legacy IO file API classes.
     */
    private fun legacyIoFileClasses(): DescribedPredicate<JavaClass> =
        anyOf(
            java.io.File::class.java,
            java.io.RandomAccessFile::class.java,
            java.io.FileInputStream::class.java,
            java.io.FileOutputStream::class.java,
            java.io.FileReader::class.java,
            java.io.FileWriter::class.java
        ).`as`("legacy IO file API classes")
}
