package com.hsob.model.forum;

import com.hsob.model.forum.Course;
import com.hsob.model.users.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collation = "topic")
@Getter
@Setter
public class Topic {
    private String title;
    private String message;
    private LocalDateTime dateOfCreate = LocalDateTime.now();
    private StatusTopic statusTopic =StatusTopic.NAO_RESPONDIDO;
    private User author;
    private Course course;
    private List<Answer> answers = new ArrayList<>();

    public Topic(String title, String message, Course course){
        this.title = title;
        this.message = message;
        this.course = course;
    }
}
