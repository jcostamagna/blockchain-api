package com.jcostamagna.blockchainapi.framework;

import com.jcostamagna.blockchainapi.adapters.exceptions.ClientExeption;
import com.jcostamagna.blockchainapi.adapters.ports.ExternalClient;
import com.jcostamagna.blockchainapi.usecases.GatewayResources;
import java.io.IOException;
import lombok.extern.java.Log;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Log
public class ExternalClientBlockchainGET<T> implements ExternalClient<T> {

  @Override
  public T resolve(GatewayResources gatewayResources, ResponseInterpreter<T> responseInterpreter) {
    try (CloseableHttpClient client = HttpClients.createDefault()) {

      HttpGet request = new HttpGet(gatewayResources.getUrlPath());

      return client.execute(
          request,
          httpResponse -> {
            log.info(String.format("Client GET: %s", httpResponse.toString()));

            if (httpResponse.getCode() != HttpStatus.SC_OK) {
              throw new ClientExeption(httpResponse.toString());
            }

            return responseInterpreter.interpret(httpResponse.getEntity().getContent());
          });

    } catch (IOException e) {
      throw new ClientExeption(e.toString());
    }
  }
}
