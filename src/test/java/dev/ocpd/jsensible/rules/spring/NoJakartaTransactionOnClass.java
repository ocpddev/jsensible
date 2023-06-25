package dev.ocpd.jsensible.rules.spring;

@SuppressWarnings("unused")
public class NoJakartaTransactionOnClass {

    @org.springframework.transaction.annotation.Transactional
    public static class Compliant {}

    @jakarta.transaction.Transactional
    public static class NonCompliant {}
}
