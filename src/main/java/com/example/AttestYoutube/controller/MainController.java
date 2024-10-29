package com.example.AttestYoutube.controller;

import com.example.AttestYoutube.domain.Message;
import com.example.AttestYoutube.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main") // Обрабатывает GET на корневом пути
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main") // Обрабатывает POST на корневом пути
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {

        logger.info("Добавлено сообщение: {}, тег: {}", text, tag);

        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main"; // Перенаправление на основной шаблон
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        logger.info("найдены по тегу: {}", filter);

        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }
            model.put("messages", messages);

        return "main";
    }
}
