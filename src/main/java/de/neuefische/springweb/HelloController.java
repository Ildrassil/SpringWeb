package de.neuefische.springweb;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
   private List<Message> messages = new ArrayList<>();



   public ResponseEntity<List<Message>> stockMessage() {
       messages.add (new Message("Johnny", "Wo ist Johnny?", "1"));
       messages.add (new Message("Johnny2", "Johnny hat sich mein Kugelschreiber in den ***** gesteckt!", "2"));
       messages.add (new Message("Johnny3", "Johnny hat schon wieder mein Bier getrunken.", "3"));
       return ResponseEntity.ok(messages);

   }

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
    public ResponseEntity<?> createMessageList(@RequestBody String name, String message, String id){
        Message msg = new Message(name,message,id);
        messages.add(msg);
        return ResponseEntity.ok("Message added Successfully");
    }

    @GetMapping("/message/getAll")
    public List<Message> getAllMessages(){
        messages.add (new Message("Johnny", "Wo ist Johnny?", "1"));
        messages.add (new Message("Johnny2", "Johnny hat sich mein Kugelschreiber in den ***** gesteckt!", "2"));
        messages.add (new Message("Johnny3", "Johnny hat schon wieder mein Bier getrunken.", "3"));
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
