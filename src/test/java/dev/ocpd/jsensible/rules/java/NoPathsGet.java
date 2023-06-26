package dev.ocpd.jsensible.rules.java;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("unused")
public class NoPathsGet {

    public static class Compliant {

        public Path compliant1() {
            return Path.of("/test");
        }

        public Path compliant2() {
            return Path.of("/test1", "test2");
        }

        public Path compliant3() {
            return Path.of(URI.create("test"));
        }
    }

    public static class NonCompliant1 {

        public Path nonCompliant() {
            return Paths.get("/test");
        }
    }

    public static class NonCompliant2 {

        public Path nonCompliant() {
            return Paths.get("/test1", "/test2");
        }
    }

    public static class NonCompliant3 {

        public Path nonCompliant() {
            return Paths.get(URI.create("/test"));
        }
    }
}
