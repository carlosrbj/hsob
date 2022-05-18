package com.hsob.model.forum;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TopicDTO {
    private String title;
    private String message;
    private LocalDateTime dateOfCreate;

    public TopicDTO(Topic topic){
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.dateOfCreate = topic.getDateOfCreate();
    }

    public static List<TopicDTO> converter(List<Topic> topics){
        return topics.stream().map(TopicDTO::new).collect(Collectors.toList());
    }
}
