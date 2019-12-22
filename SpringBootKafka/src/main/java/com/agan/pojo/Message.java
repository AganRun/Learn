package com.agan.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Message {

    private String id;
    private String name;
    private LocalDateTime sendTime;

}
