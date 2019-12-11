package by.ipps.client.controller;

import by.ipps.client.resttemplate.ImageRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageController {

    private ImageRestTemplate imageRestTemplate;

    public ImageController(ImageRestTemplate imageRestTemplate) {
        this.imageRestTemplate = imageRestTemplate;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> getImageById(@PathVariable long id, HttpServletResponse response) {
        return imageRestTemplate.getById(id, response);
    }

}
