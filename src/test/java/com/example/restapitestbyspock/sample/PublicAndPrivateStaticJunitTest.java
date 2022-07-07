package com.example.restapitestbyspock.sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublicAndPrivateStaticJunitTest {

    @Test
    void publicMethod() {
        PublicAndPrivateStatic publicAndPrivateStatic = new PublicAndPrivateStatic();
        assertEquals("public method", publicAndPrivateStatic.publicMethod());
    }
}
