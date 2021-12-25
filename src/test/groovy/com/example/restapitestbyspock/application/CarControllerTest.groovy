package com.example.restapitestbyspock.application


import com.example.restapitestbyspock.helper.test.MySQLContainerContextInitializer
import org.hamcrest.Matchers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(initializers = [MySQLContainerContextInitializer.class])
class CarControllerTest extends Specification {
    @Autowired
    MockMvc mockMvc

    @Unroll
    def "FindByPriceLessThanEqualOrderByPriceAsc HttpStatus"() {

        when:
        def result =
                mockMvc.perform(MockMvcRequestBuilders.get("/v1/cars/30000"))
                        .andReturn().getResponse()

        then:
        result.getStatus() == HttpStatus.OK.value
    }

    @Unroll
    def "FindByPriceLessThanEqualOrderByPriceAsc Data Pattern"() {

        expect:
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/cars/" + price))
                .andExpect(MockMvcResultMatchers.jsonPath("\$.*", Matchers.hasSize(size)))

        where:
        price   || size
        "50000" || 10
        "40000" || 10
        "30000" || 9
        "20000" || 5
        "15000" || 2
        "10000" || 0

    }

}
