package by.ipps.client.controller;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin
@Slf4j
public class TestController {

  @GetMapping
  public ResponseEntity<HttpStatus> test(HttpServletRequest request){
    log.info(request.getRemoteAddr());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
