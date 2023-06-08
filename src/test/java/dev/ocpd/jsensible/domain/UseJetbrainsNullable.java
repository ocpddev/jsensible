package dev.ocpd.jsensible.domain;

import jakarta.persistence.*;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

@Entity
public class UseJetbrainsNullable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String type;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UseJetbrainsNullable useJetbrainsNullable = (UseJetbrainsNullable) o;
        return Objects.equals(id, useJetbrainsNullable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
