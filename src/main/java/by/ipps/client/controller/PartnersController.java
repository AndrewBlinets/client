package by.ipps.client.controller;

import by.ipps.client.entity.Partners;
import by.ipps.client.resttemplate.PartnersRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/partners")
public class PartnersController {

    private PartnersRestTemplate partnersRestTemplate;

    public PartnersController(PartnersRestTemplate partnersRestTemplate) {
        this.partnersRestTemplate = partnersRestTemplate;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Partners>> getAllContact(){
        return partnersRestTemplate.getActualInfo();
    }

}
