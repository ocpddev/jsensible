package dev.ocpd.jsensible.rules.spring;

@SuppressWarnings("unused")
public class NoJakartaTransactionOnMethod {

    public static class Compliant {

        @org.springframework.transaction.annotation.Transactional
        public void compliant() {}
    }

    public static class NonCompliant {

        @jakarta.transaction.Transactional
        public void nonCompliant() {}
    }
}
