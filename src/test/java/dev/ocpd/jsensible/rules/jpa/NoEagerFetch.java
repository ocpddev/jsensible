package dev.ocpd.jsensible.rules.jpa;

import jakarta.persistence.*;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.ManyToAny;

@SuppressWarnings("unused")
public class NoEagerFetch {

    public static class Compliant {

        @OneToMany
        private String test1;

        @ManyToMany
        private String test2;

        @ElementCollection
        private String test3;

        @ManyToOne(fetch = FetchType.LAZY)
        private String test4;

        @OneToOne(fetch = FetchType.LAZY)
        private String test5;

        @Any(fetch = FetchType.LAZY)
        private String test6;

        @ManyToAny(fetch = FetchType.LAZY)
        private String test7;
    }

    public static class NonCompliant1 {

        @OneToMany(fetch = FetchType.EAGER)
        private String test;
    }

    public static class NonCompliant2 {

        @ManyToMany(fetch = FetchType.EAGER)
        private String test;
    }

    public static class NonCompliant3 {

        @ElementCollection(fetch = FetchType.EAGER)
        private String test;
    }

    public static class NonCompliant4 {

        @ManyToOne
        private String test;
    }

    public static class NonCompliant5 {

        @OneToOne
        private String test;
    }

    public static class NonCompliant6 {

        @Any
        private String test;
    }

    public static class NonCompliant7 {

        @ManyToAny
        private String test;
    }
}
