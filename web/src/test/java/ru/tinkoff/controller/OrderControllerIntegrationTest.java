package ru.tinkoff.controller;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)

public class OrderControllerIntegrationTest extends TestCase {
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testGetLastOrder() throws Exception {
        ResponseEntity<String> entity = restTemplate.exchange("http://localhost:8080/orders?id=1", HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {
                });
        String actualJson = entity.getBody();
        String expectedJson = "{\"applicationId";

        assertTrue(actualJson.startsWith(expectedJson));
    }
}