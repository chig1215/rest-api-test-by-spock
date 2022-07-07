package com.example.restapitestbyspock.sample

import org.mockito.MockedStatic
import org.mockito.Mockito
import spock.lang.Specification

class PrivateStaticTest extends Specification {

    def "Testing private static member"(){
        setup:
        PrivateStatic privateStatic = new PrivateStatic()

        expect:
        privateStatic.privateStaticMember == "private static member"
    }

    def "Testing private static method"(){
        setup:
        PrivateStatic privateStatic = new PrivateStatic()

        expect:
        privateStatic.privateStaticMethod() == "private static method"
    }

    def "Mocking private static method"(){
        setup:
        MockedStatic<PrivateStatic> mockedStatic = Mockito.mockStatic(PrivateStatic.class)
        mockedStatic.when(PrivateStatic.privateStaticMethod()).thenReturn("mock of private static method")

        expect:
        PrivateStatic.privateStaticMethod() == "mock of private static method"

        cleanup:
        mockedStatic.close()
    }

}
