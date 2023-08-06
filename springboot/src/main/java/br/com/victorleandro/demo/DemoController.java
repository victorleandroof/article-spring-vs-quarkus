package br.com.victorleandro.demo;

import com.github.javafaker.Faker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {


    @GetMapping("/demo")
    public ResponseEntity<List<DemoResponse>> findAll() {
        List<DemoResponse> demoResponsesList = this.generateList();
        return ResponseEntity.ok(demoResponsesList);
    }

    private List<DemoResponse> generateList() {
        Faker faker = new Faker();
        List<DemoResponse> demoList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            demoList.add(new DemoResponse(faker.name().fullName()));
        }
        return demoList;
    }
}
