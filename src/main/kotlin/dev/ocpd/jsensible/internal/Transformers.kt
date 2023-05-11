package dev.ocpd.jsensible.internal

import com.tngtech.archunit.core.domain.JavaClass
import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.domain.JavaPackage
import com.tngtech.archunit.lang.AbstractClassesTransformer

internal object Transformers {

    internal fun packages() = object : AbstractClassesTransformer<JavaPackage>("java packages") {
        override fun doTransform(collection: JavaClasses): Iterable<JavaPackage> {
            return collection.mapTo(mutableSetOf(), JavaClass::getPackage)
        }
    }
}
