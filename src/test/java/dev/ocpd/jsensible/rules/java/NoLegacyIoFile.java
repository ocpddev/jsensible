package dev.ocpd.jsensible.rules.java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings("unused")
public class NoLegacyIoFile {

    public static class Compliant {

        public Path compliant1() throws IOException {
            return Files.createFile(Path.of("test.txt"));
        }

        public Path compliant2() {
            return Path.of("test.txt");
        }
    }

    public static class NonCompliant1 {

        public File nonCompliant() throws IOException {
            return File.createTempFile("test", ".txt");
        }
    }

    public static class NonCompliant2 {

        public RandomAccessFile nonCompliant() throws FileNotFoundException {
            return new RandomAccessFile("test.txt", "r");
        }
    }

    public static class NonCompliant3 {

        public FileInputStream nonCompliant() throws FileNotFoundException {
            return new FileInputStream("test.txt");
        }
    }

    public static class NonCompliant4 {

        public FileOutputStream nonCompliant() throws FileNotFoundException {
            return new FileOutputStream("test.txt");
        }
    }

    public static class NonCompliant5 {

        public FileReader nonCompliant() throws FileNotFoundException {
            return new FileReader("test.txt");
        }
    }

    public static class NonCompliant6 {

        public FileWriter nonCompliant() throws IOException {
            return new FileWriter("test.txt");
        }
    }
}
