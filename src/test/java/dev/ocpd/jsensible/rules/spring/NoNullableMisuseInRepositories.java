package dev.ocpd.jsensible.rules.spring;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unused")
public class NoNullableMisuseInRepositories {

    @Entity
    public static class EntityCompliant {

        @Id
        private Long id;

        private String test1;

        private String test2;

        public Long getId() {
            return id;
        }

        public String getTest1() {
            return test1;
        }

        public String getTest2() {
            return test2;
        }
    }

    public interface CompliantRepo extends JpaRepository<EntityCompliant, Long> {

        @org.springframework.lang.Nullable
        EntityCompliant findByTest1(String test1);

        EntityCompliant findByTest2(@org.springframework.lang.Nullable String test2);
    }

    @Entity
    public static class EntityNonCompliant1 {

        @Id
        private Long id;

        private String test1;

        private String test2;

        public Long getId() {
            return id;
        }

        public String getTest1() {
            return test1;
        }

        public String getTest2() {
            return test2;
        }
    }

    public interface NonCompliantRepo1 extends JpaRepository<EntityNonCompliant1, Long> {

        @jakarta.annotation.Nullable
        EntityNonCompliant1 findByTest1(String test1);

        EntityNonCompliant1 findByTest2(@jakarta.annotation.Nullable String test2);
    }

    @Entity
    public static class EntityNonCompliant2 {

        @Id
        private Long id;

        private String test1;

        private String test2;

        public Long getId() {
            return id;
        }

        public String getTest1() {
            return test1;
        }

        public String getTest2() {
            return test2;
        }
    }

    public interface NonCompliantRepo2 extends JpaRepository<EntityNonCompliant2, Long> {

        @org.jetbrains.annotations.Nullable
        EntityNonCompliant2 findByTest1(String test1);

        EntityNonCompliant2 findByTest2(@org.jetbrains.annotations.Nullable String test2);
    }
}
