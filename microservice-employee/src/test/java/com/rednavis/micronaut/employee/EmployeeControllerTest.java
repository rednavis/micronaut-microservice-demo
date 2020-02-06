package com.rednavis.micronaut.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class EmployeeControllerTest {

  @Inject
  @Client("/")
  RxHttpClient client;

  @Test
  public void testEmployee() {
    HttpRequest<String> request = HttpRequest.GET("/employee/1");
    String body = client.toBlocking().retrieve(request);

    assertNotNull(body);
    assertEquals("{\"id\":1,\"name\":\"Alexey\",\"age\":31}", body);
  }
}