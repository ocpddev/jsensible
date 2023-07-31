package dev.ocpd.jsensible.rules.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class NoMisalignedNullability {

    public static class Compliant {

        @ManyToOne(optional = false)
        private String test1;

        @Nullable
        @ManyToOne
        private String test2;

        @OneToOne(optional = false)
        private String test3;

        @Nullable
        @OneToOne
        private String test4;

        @Column(nullable = false)
        private String test5;

        @Nullable
        @Column
        private String test6;
    }

    public static class NonCompliant1 {

        @ManyToOne
        private String test;
    }

    public static class NonCompliant2 {

        @OneToOne
        private String test;
    }

    public static class NonCompliant3 {

        @Column
        private String test;
    }
}
