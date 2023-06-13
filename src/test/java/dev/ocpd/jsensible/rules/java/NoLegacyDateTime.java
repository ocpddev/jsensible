package dev.ocpd.jsensible.rules.java;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("unused")
public class NoLegacyDateTime {

    public static class Compliant {

        public LocalDate compliant1() {
            return LocalDate.now();
        }

        public Instant compliant2() {
            return Instant.now();
        }
    }

    public static class NonCompliant1 {

        public java.util.Date nonCompliant() {
            return new Date();
        }
    }

    public static class NonCompliant2 {

        public java.util.Calendar nonCompliant() {
            return Calendar.getInstance();
        }
    }
}
