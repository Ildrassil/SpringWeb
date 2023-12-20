package de.neuefische.springweb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
   private List<Message> messages = new ArrayList<>();





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

@PostMapping("/messageCreate")
    public ResponseEntity<?> createMessageList(@RequestBody Message message){

        messages.add(message);
        return ResponseEntity.ok("Message added Successfully" + message.toString());
    }

    @GetMapping("/message/getAll")
    public List<Message> getAllMessages(){

        return messages;

    }
    @DeleteMapping("/messages/{id}")
    public ResponseEntity<String> deleteMessageById(@PathVariable String id){
       messages.add(new Message("Johnny", "Wo ist Johnny?", "1"));
        boolean removed = messages.removeIf(message -> message.getId().equals(id));
           if(removed == true){
               return ResponseEntity.ok("Message deleted Successfully");
           }
           else {
               throw new RuntimeException("No Message found under this ID");
           }
    }

}
