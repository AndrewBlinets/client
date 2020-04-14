package by.ipps.client.resttemplate;

import by.ipps.client.entity.Partners;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
@Slf4j
public class PartnersRestTemplate {

    protected static final String URL_SERVER = "http://192.168.1.125:8080/dao/partners/all";
//    protected static final String URL_SERVER = "http://localhost:8082/dao/partners/all";

    protected final RestTemplate restTemplate;

    public PartnersRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<List<Partners>> getActualInfo() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER);
        try {
            final ParameterizedTypeReference<List<Partners>> responseType =
                    new ParameterizedTypeReference<List<Partners>>() {
                    };
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
        } catch (org.springframework.web.client.HttpClientErrorException exception) {
            log.info("getPartners");
            log.info(URL_SERVER);
            log.error(exception.getStatusCode() + " " + exception.getStatusText());
            return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
        }
    }

}
