package com.hsob.controller;

import com.hsob.model.forum.Course;
import com.hsob.model.forum.Topic;
import com.hsob.model.forum.TopicDTO;
import com.hsob.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicsController {

    @Autowired
    protected ForumService forumService;

    @GetMapping("/list")
    public List<TopicDTO> topicList(){
        Topic topic = new Topic("Duvida 1", "Primeira Duvida", new Course("Spring", "Programação"));
        Topic topic2 = new Topic("Duvida 2", "Segunda Duvida", new Course("Spring", "Programação"));

        return TopicDTO.converter(Arrays.asList(topic, topic2));
    }


}
