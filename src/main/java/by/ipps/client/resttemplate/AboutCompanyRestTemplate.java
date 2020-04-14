package by.ipps.client.resttemplate;

import by.ipps.client.entity.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class AboutCompanyRestTemplate {
    protected static final String URL_SERVER = "http://192.168.1.125:8080/dao/company";
//    protected static final String URL_SERVER = "http://localhost:8082/dao/company";

    protected final RestTemplate restTemplate;

    public AboutCompanyRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Company> getActualInfo() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER);
        try {
            final ParameterizedTypeReference<Company> responseType =
                    new ParameterizedTypeReference<Company>() {
                    };
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
        } catch (org.springframework.web.client.HttpClientErrorException exception) {
            log.info("getInfoAboutCompany");
            log.info(URL_SERVER);
            log.error(exception.getStatusCode() + " " + exception.getStatusText());
            return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
        }
    }
}
