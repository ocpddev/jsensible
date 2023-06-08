package dev.ocpd.jsensible.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class UseSpringNullable {

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
        UseSpringNullable useSpringNullable = (UseSpringNullable) o;
        return Objects.equals(id, useSpringNullable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
