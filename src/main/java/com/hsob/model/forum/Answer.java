package com.hsob.model.forum;

import com.hsob.model.forum.Topic;
import com.hsob.model.users.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collation = "answer")
@Getter
@Setter
public class Answer {
    private String message;
    private Topic topic;
    private LocalDateTime dateOfCreate;
    private User author;
    private Boolean solution;

    public void setDateOfCreate(LocalDateTime dateOfCreate) {
        this.dateOfCreate = LocalDateTime.now();
    }

}
