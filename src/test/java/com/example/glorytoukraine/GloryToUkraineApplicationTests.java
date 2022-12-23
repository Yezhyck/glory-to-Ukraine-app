package com.example.glorytoukraine;

import com.example.glorytoukraine.controller.GloryToUkraineController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GloryToUkraineApplicationTests {

    @Autowired
    private GloryToUkraineController gloryToUkraineController;

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertThat(gloryToUkraineController).isNotNull();
    }

    @Test
    void gloryToUkraine_Should_ReturnToUkraineMessage_When_GloryIsRequested() {
        String endPoint = "glory";
        String expectedResponse = "to Ukraine";

        assertThat(restTemplate.getForObject(constructUrl(endPoint), String.class)).contains(expectedResponse);
    }

    private String constructUrl(String endPoint) {
        return "http://localhost:" + port + "/" + endPoint;
    }
}
