package com.agan.contoroller;

import com.agan.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KafkaController {

    @Autowired
    private KafkaSender sender;

    @PostMapping("/send")
    public Object send(@RequestBody Map<String, String> map) {
        sender.send(map.get("name"));
        return "success";
    }
}
