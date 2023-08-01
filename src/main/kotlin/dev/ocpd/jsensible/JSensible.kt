package dev.ocpd.jsensible

import dev.ocpd.jsensible.internal.include

object JSensible {
    fun default() = include<JSensibleRules>()
}
