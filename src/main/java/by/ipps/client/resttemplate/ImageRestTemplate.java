package by.ipps.client.resttemplate;

import by.ipps.client.entity.FileManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@Component
@Slf4j
public class ImageRestTemplate {
    protected static final String URL_SERVER = "http://192.168.1.125:8080/dao/file";

    protected final RestTemplate restTemplate;

    public ImageRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<HttpStatus> getById(long id, HttpServletResponse response) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/" + id);
        try {
            ResponseEntity<FileManager> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
                    FileManager.class);
            response.setContentType(result.getBody().getFileMine());
            response.setHeader("Content-Disposition", "attachment; filename=" + result.getBody().getFileName());
            byte[] array = Files.readAllBytes(
                    Paths.get(result.getBody().getPath() + File.separator + result.getBody().getFileName()));
            response.getOutputStream().write(array);
            return new ResponseEntity(HttpStatus.OK);
        } catch (org.springframework.web.client.HttpClientErrorException exception) {
            log.info("getImageByID " + id);
            log.info(URL_SERVER);
            log.error(exception.getStatusCode() + " " + exception.getStatusText());
            return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
        } catch (Exception e) {
            log.info("getImageByID");
            log.info(URL_SERVER);
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<HttpStatus> getByIdRelize(long id, HttpServletResponse response) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_SERVER + "/" + id);
        try {
            ResponseEntity<FileManager> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
                    FileManager.class);
            response.setContentType(result.getBody().getFileMine());
            response.setHeader("Content-Disposition", "attachment; filename=" + result.getBody().getFileName());
            String nameFile = result.getBody().getFileName().split("\\.")[0] + "-resize." + result.getBody().getFileName().split("\\.")[1];
            byte[] array = Files.readAllBytes(
                    Paths.get(result.getBody().getPath() + File.separator + nameFile));
            response.getOutputStream().write(array);
            return new ResponseEntity(HttpStatus.OK);
        } catch (org.springframework.web.client.HttpClientErrorException exception) {
            log.info("getImageByID " + id);
            log.info(URL_SERVER);
            log.error(exception.getStatusCode() + " " + exception.getStatusText());
            return new ResponseEntity<>(HttpStatus.valueOf(exception.getStatusCode().value()));
        } catch (Exception e) {
            log.info("getImageByID");
            log.info(URL_SERVER);
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
