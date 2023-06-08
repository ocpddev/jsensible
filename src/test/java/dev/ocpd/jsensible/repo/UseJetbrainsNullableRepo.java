package dev.ocpd.jsensible.repo;

import dev.ocpd.jsensible.domain.UseJetbrainsNullable;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UseJetbrainsNullableRepo extends JpaRepository<UseJetbrainsNullable, Long>,
    JpaSpecificationExecutor<UseJetbrainsNullable> {

    @Nullable
    UseJetbrainsNullable findByName(String name);
}
