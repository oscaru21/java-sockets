
package com.dsu.JSoapClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfiguration {

  //./mvnw compile
  //./mvnw spring-boot:run
  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this package must match the package in the <generatePackage> specified in
    // pom.xml
    marshaller.setContextPath("com.dsu.JSoapClient.wsdl");
    return marshaller;
  }

  @Bean
  public OrderClient countryClient(Jaxb2Marshaller marshaller) {
    OrderClient client = new OrderClient();
    //client.setDefaultUri("http://localhost:8080/ws");
    client.setDefaultUri("http://localhost:8080/orders/ordersservice?wsdl");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }

}
