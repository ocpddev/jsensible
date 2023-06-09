package dev.ocpd.jsensible.repo;

import dev.ocpd.jsensible.domain.UseSpringNullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UseSpringNullableRepo extends JpaRepository<UseSpringNullable, Long> {

    @Nullable
    UseSpringNullableRepo findByName(String name);
}
