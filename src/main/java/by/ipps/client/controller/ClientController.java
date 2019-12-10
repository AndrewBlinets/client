package by.ipps.client.controller;

import by.ipps.client.custom.CustomPage;
import by.ipps.client.dto.NewsDtoFull;
import by.ipps.client.dto.PageNewsDto;
import by.ipps.client.entity.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class ClientController {

//    private static final String URL_DB = "http://localhost:8082/dao/";
private static final String URL_DB = "http://192.168.1.125:8080/dao/";
    private RestTemplate restTemplate;

    public ClientController() {
        restTemplate = new RestTemplate();
    }

    @CrossOrigin
    @GetMapping(value = "/project/{id}")
    @ResponseBody
    public ResponseEntity<ProjectFull> getProjectByid(
            @PathVariable long id,
            @RequestParam(value = "language", required = false, defaultValue = "ru") String language) {
        String url = URL_DB + "project/client/" + id;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("language", language);
        return restTemplate.getForEntity(builder.toUriString(), ProjectFull.class);
    }

    @CrossOrigin
    @GetMapping(value = "/project")
    @ResponseBody
    public ResponseEntity<CustomPage<ProjectShort>> getProject(
            @RequestParam(value = "page", required = false, defaultValue = "0") long page,
            @RequestParam(value = "size", required = false, defaultValue = "0") int size,
            @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
            @RequestParam(value = "language", required = false, defaultValue = "ru") String language) {
        String url = URL_DB + "project/client";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("page", String.valueOf(page))
                .queryParam("size", String.valueOf(size))
                .queryParam("sort", sort)
                .queryParam("language", language);
        final ParameterizedTypeReference<CustomPage<ProjectShort>> responseType =
                new ParameterizedTypeReference<CustomPage<ProjectShort>>() {
                };
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
    }

    @CrossOrigin
    @GetMapping(value = "/news/{id}")
    @ResponseBody
    public ResponseEntity<NewsDtoFull> getNewsByid(
            @PathVariable long id,
            @RequestParam(value = "language", required = false, defaultValue = "ru") String language) {
        String url = URL_DB + "news/client/" + id;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("language", language);
        return restTemplate.getForEntity(builder.toUriString(), NewsDtoFull.class);
    }

    @CrossOrigin
    @GetMapping(value = "/news")
    @ResponseBody
    public ResponseEntity<PageNewsDto> getNews(
            @RequestParam(value = "page", required = false, defaultValue = "0") long page,
            @RequestParam(value = "size", required = false, defaultValue = "0") int size,
            @RequestParam(value = "sort", required = false, defaultValue = "") String sort,
            @RequestParam(value = "language", required = false, defaultValue = "ru") String language) {
        String url = URL_DB + "news/client";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("page", String.valueOf(page))
                .queryParam("size", String.valueOf(size))
                .queryParam("sort", sort)
                .queryParam("language", language);
        final ParameterizedTypeReference<PageNewsDto> responseType =
                new ParameterizedTypeReference<PageNewsDto>() {
                };
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
    }

    @CrossOrigin
    @GetMapping(value = "/vacancy/{id}")
    @ResponseBody
    public ResponseEntity<Vacancy> getVacancyById(@PathVariable long id) {
        String url = URL_DB + "vacancy/" + id;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        ResponseEntity<Vacancy> result = restTemplate.getForEntity(builder.toUriString(), Vacancy.class);
        return new ResponseEntity<>(result.getStatusCode() == HttpStatus.OK ? result.getBody() : null,
                result.getStatusCode());
    }

    @CrossOrigin
    @GetMapping(value = "/vacancies")
    @ResponseBody
    public ResponseEntity<CustomPage<Vacancy>> getVacancies(
            @RequestParam(value = "page", required = false, defaultValue = "0") long page,
            @RequestParam(value = "size", required = false, defaultValue = "0") int size,
            @RequestParam(value = "sort", required = false, defaultValue = "") String sort) {
        String url = URL_DB + "vacancy";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("page", String.valueOf(page))
                .queryParam("size", String.valueOf(size))
                .queryParam("sort", sort);
        final ParameterizedTypeReference<CustomPage<Vacancy>> responseType =
                new ParameterizedTypeReference<CustomPage<Vacancy>>() {
                };
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
    }

    @CrossOrigin
    @GetMapping(value = "/image/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> getImageById(@PathVariable long id, HttpServletResponse response) throws IOException {
        String url = URL_DB + "file/" + id;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        try {
            ResponseEntity<byte[]> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
                    byte[].class);
            response.setContentType(result.getHeaders().getContentType().toString());
            response.setHeader("Content-Disposition", result.getHeaders().getContentDisposition().toString());
            response.getOutputStream().write(result.getBody());
            return new ResponseEntity(HttpStatus.OK);
        } catch (org.springframework.web.client.HttpClientErrorException exception) {
            return new ResponseEntity(HttpStatus.valueOf(exception.getStatusCode().value()));
        } catch (NullPointerException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/aboutCompany")
    @ResponseBody
    public ResponseEntity getCompanyWithActualInfo() {
        String url = URL_DB + "company";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        try {
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Company.class);
        } catch (org.springframework.web.client.HttpClientErrorException exception) {
            return new ResponseEntity(HttpStatus.valueOf(exception.getStatusCode().value()));
        }
    }

    @CrossOrigin
    @GetMapping(value = "/contact")
    @ResponseBody
    public ResponseEntity getContact() {
        String url = URL_DB + "contact";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        try {
            final ParameterizedTypeReference<CustomPage<Contact>> responseType =
                    new ParameterizedTypeReference<CustomPage<Contact>>() {
                    };
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
        } catch (org.springframework.web.client.HttpClientErrorException exception) {
            return new ResponseEntity(HttpStatus.valueOf(exception.getStatusCode().value()));
        }
    }

    @CrossOrigin
    @GetMapping(value = "/partners")
    @ResponseBody
    public ResponseEntity getPartners() {
        String url = URL_DB + "partners";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        try {
            final ParameterizedTypeReference<CustomPage<Partners>> responseType =
                    new ParameterizedTypeReference<CustomPage<Partners>>() {
                    };
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, responseType);
        } catch (org.springframework.web.client.HttpClientErrorException exception) {
            return new ResponseEntity(HttpStatus.valueOf(exception.getStatusCode().value()));
        }
    }

}
