package by.ipps.client.controller;

import by.ipps.client.resttemplate.ContactRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactRestTemplate contactRestTemplate;

    public ContactController(ContactRestTemplate contactRestTemplate) {
        this.contactRestTemplate = contactRestTemplate;
    }

    @CrossOrigin
    @GetMapping
    @ResponseBody
    public ResponseEntity getAllContact(){
        return contactRestTemplate.getActualInfo();
    }

}
