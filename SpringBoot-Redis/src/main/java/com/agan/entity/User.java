package com.agan.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

@Data
@Accessors(chain = true)
public class User extends JdkSerializationRedisSerializer {

    private Integer id;
    private String name;
}
