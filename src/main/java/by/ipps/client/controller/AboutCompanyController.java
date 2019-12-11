package by.ipps.client.controller;

import by.ipps.client.entity.Company;
import by.ipps.client.resttemplate.AboutCompanyRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AboutCompanyController {

    private final AboutCompanyRestTemplate aboutCompanyRestTemplate;

    public AboutCompanyController(AboutCompanyRestTemplate aboutCompanyRestTemplate) {
        this.aboutCompanyRestTemplate = aboutCompanyRestTemplate;
    }

    @GetMapping(value = "/aboutCompany")
    @ResponseBody
    public ResponseEntity<Company> getCompanyWithActualInfo() {
        return aboutCompanyRestTemplate.getActualInfo();
    }

}
