package dev.ocpd.jsensible.rules.java;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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

        public Date nonCompliant() {
            return new Date();
        }
    }

    public static class NonCompliant2 {

        public Calendar nonCompliant() {
            return Calendar.getInstance();
        }
    }

    public static class NonCompliant3 {

        public DateFormat nonCompliant() {
            return DateFormat.getInstance();
        }
    }

    public static class NonCompliant4 {

        public TimeZone nonCompliant() {
            return TimeZone.getDefault();
        }
    }
}
