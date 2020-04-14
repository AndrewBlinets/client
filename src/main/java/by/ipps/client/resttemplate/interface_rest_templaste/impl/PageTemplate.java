package by.ipps.client.resttemplate.interface_rest_templaste.impl;

import by.ipps.client.entity.Page;
import by.ipps.client.resttemplate.base.AbstractBaseEntityRestTemplate;
import by.ipps.client.resttemplate.interface_rest_templaste.PageRestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class PageTemplate extends AbstractBaseEntityRestTemplate<Page> implements PageRestTemplate {
  private static final String LANGUAGE = "language";

  @Override
  public ResponseEntity<Page> findById(
      Long id, String url, String language, String section, String department) {
    try {
      UriComponentsBuilder builder =
          UriComponentsBuilder.fromHttpUrl(URL_SERVER + url + "/client/" + id);
      builder.queryParam(LANGUAGE, language);
      return restTemplate.exchange(
          builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<Page>() {});
    } catch (org.springframework.web.client.HttpClientErrorException exception) {
      log.info("findByid");
      log.info(url + "/" + id);
      return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
    }
  }
}
