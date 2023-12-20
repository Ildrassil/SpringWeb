package de.neuefische.springweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor

public class Message {
    private String name;
    private String message;
    private String id;


}
