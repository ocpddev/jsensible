package dev.ocpd.jsensible.rules.java;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class EqualsShouldAcceptNull {

    public static class Compliant1 {

        public boolean equals(@Nullable Object o) {
            return this == o;
        }
    }

    public static class NonCompliant1 {

        @SuppressWarnings("RedundantMethodOverride")
        public boolean equals(Object o) {
            return this == o;
        }
    }
}
