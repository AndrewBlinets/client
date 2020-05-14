package by.ipps.client.resttemplate;

import by.ipps.client.entity.Contact;
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
public class ContactRestTemplate {

//    protected static final String URL_SERVER = "http://192.168.1.125:8080/dao/contact";
//    protected static final String URL_SERVER = "http://localhost:8082/dao/contact/all";
    protected static final String URL_SERVER = "http://localhost:8080/dao/contact/all";

    protected final RestTemplate restTemplate;

    public ContactRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<List<Contact>> getActualInfo() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER);
        try {
            final ParameterizedTypeReference<List<Contact>> responseType =
                    new ParameterizedTypeReference<List<Contact>>() {};
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
        } catch (org.springframework.web.client.HttpClientErrorException exception) {
            log.info("getContact");
            log.info(URL_SERVER);
            log.error(exception.getStatusCode() + " " + exception.getStatusText());
            return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
        }
    }

}
