package com.jcostamagna.blockchainapi.framework;

import com.jcostamagna.blockchainapi.adapters.ports.ExternalClient;
import com.jcostamagna.blockchainapi.usecases.GatewayResources;
import java.io.IOException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.stereotype.Component;

@Component
public class ExternalClientBlockchainGET<T> implements ExternalClient<T> {

  @Override
  public T resolve(GatewayResources gatewayResources, ResponseInterpreter<T> responseInterpreter) {
    try (CloseableHttpClient client = HttpClients.createDefault()) {

      HttpGet request = new HttpGet(gatewayResources.getUrlPath());

      return client.execute(
          request,
          httpResponse -> responseInterpreter.interpret(httpResponse.getEntity().getContent()));

    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }
}
