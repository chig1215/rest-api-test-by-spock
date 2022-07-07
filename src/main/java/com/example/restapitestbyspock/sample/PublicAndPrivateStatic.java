package com.example.restapitestbyspock.sample;

public class PublicAndPrivateStatic {
    private static final String privateStaticMember = "private static member";

    private static String privateStaticMethod() {
        return "private static method";
    }

    public String publicMethod() {
        return "public method";
    }

}
