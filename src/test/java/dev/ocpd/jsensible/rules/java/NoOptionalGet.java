package dev.ocpd.jsensible.rules.java;

import java.util.Optional;

@SuppressWarnings("unused")
public class NoOptionalGet {

    public static class Compliant {

        public String compliant() {
            return Optional.of("test").orElseThrow();
        }
    }

    public static class NonCompliant {

        public String nonCompliant() {
            return Optional.of("test").get();
        }
    }
}
