package com.sean.serializer;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*
 * 传入任何类型，都序列化为String
 */

public class MyStringRedisSerializer implements RedisSerializer<Object> {
    private final Charset charset;

    public MyStringRedisSerializer() {
        this(StandardCharsets.UTF_8);
    }

    public MyStringRedisSerializer(Charset charset) {
        Assert.notNull(charset, "Charset must not be null!");
        this.charset = charset;
    }

    @Override
    public String deserialize(byte[] bytes) {
        return (bytes == null ? null : new String(bytes, charset));
    }

    @Override
    public byte[] serialize(Object object) {
    	// 传入为空，则返回空
        if (object == null) {
            return new byte[0];
        }
        if(object instanceof String){
        	// String类型，则直接转换
            return object.toString().getBytes(charset);
        }else {
        	// 非String类型，则JSON转换
            String string = JSON.toJSONString(object);
            return string.getBytes(charset);
        }
    }

}
