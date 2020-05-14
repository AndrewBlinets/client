package by.ipps.client.controller;

import by.ipps.client.entity.Contact;
import by.ipps.client.resttemplate.ContactRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Contact>> getAllContact(){
        return contactRestTemplate.getActualInfo();
    }

}
