package by.ipps.client.controller;

import by.ipps.client.resttemplate.ContactRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactRestTemplate contactRestTemplate;

    public ContactController(ContactRestTemplate contactRestTemplate) {
        this.contactRestTemplate = contactRestTemplate;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> getAllContact(){
        return contactRestTemplate.getActualInfo();
    }

}
