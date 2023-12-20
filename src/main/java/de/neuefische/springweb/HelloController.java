package de.neuefische.springweb;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    } @GetMapping("/hello/John")
    public String helloJohn(){
        return "Hello John";
    }

    @PostMapping("/hello")
    public String sayHelloTo(@RequestBody Product product){
        return "Hello: " + product;
    }

    @GetMapping("/hello/{id}")
    public String getProductById(@PathVariable String id){
        return "Product: "+id;
    }
}
