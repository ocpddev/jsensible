package dev.ocpd.jsensible.rules.spring;

import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unused")
public class NoNullableMisuseInRepositories {

    public interface Compliant extends JpaRepository<Object, Long> {

        @org.springframework.lang.Nullable
        Object findBy(String test);

        Object findObjectBy(@org.springframework.lang.Nullable String test);
    }

    public interface NonCompliant1 extends JpaRepository<Object, Long> {

        @jakarta.annotation.Nullable
        Object findBy(String test);

        Object findObjectBy(@jakarta.annotation.Nullable String test);
    }

    public interface NonCompliant2 extends JpaRepository<Object, Long> {

        @org.jetbrains.annotations.Nullable
        Object findBy(String test);

        Object findObjectBy(@org.jetbrains.annotations.Nullable String test);
    }
}
