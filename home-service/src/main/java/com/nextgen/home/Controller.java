package com.nextgen.home;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hview")
public class Controller {

    @RequestMapping("/home")
    public ResponseEntity<String> getHome() {
        return ResponseEntity.ok("Home Page");
    }

    @RequestMapping("/")
    public ResponseEntity<String> gtHome() {
        return ResponseEntity.ok("Hom Page");
    }

    @RequestMapping("/demo")
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("Hom Page");
    }

}
