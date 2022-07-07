package com.example.restapitestbyspock.sample

import org.mockito.MockedStatic
import org.mockito.Mockito
import spock.lang.Specification

class PublicAndPrivateStaticTest extends Specification {

    PublicAndPrivateStatic publicAndPrivateStatic = new PublicAndPrivateStatic()

    def "Testing private static member"(){
        expect:
        publicAndPrivateStatic.privateStaticMember == "private static member"
    }

    def "Testing private static method"(){
        expect:
        publicAndPrivateStatic.privateStaticMethod() == "private static method"
    }

    def "Mocking private static method"(){
        setup:
        MockedStatic<PublicAndPrivateStatic> mockedStatic = Mockito.mockStatic(PublicAndPrivateStatic.class)
        mockedStatic.when(PublicAndPrivateStatic.privateStaticMethod()).thenReturn("mock of private static method")

        expect:
        PublicAndPrivateStatic.privateStaticMethod() == "mock of private static method"

        cleanup:
        mockedStatic.close()
    }

}
