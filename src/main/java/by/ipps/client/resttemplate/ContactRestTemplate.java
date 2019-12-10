package by.ipps.client.resttemplate;

import by.ipps.client.entity.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ContactRestTemplate {

    protected static final String URL_SERVER = "http://192.168.1.125:8080/dao/contact";

    protected final RestTemplate restTemplate;

    public ContactRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Object> getActualInfo() {
        return restTemplate.getForEntity( URL_SERVER ,
                Object.class, Object.class );
    }

}
