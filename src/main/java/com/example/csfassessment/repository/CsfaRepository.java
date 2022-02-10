package com.example.csfassessment.repository;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Repository
public class CsfaRepository {
    private final Logger logger = LoggerFactory.getLogger("CsfaRepository.class");
    private final RedisTemplate<String, String> template;

    public CsfaRepository(RedisTemplate<String, String> template) {
        this.template = template;
    }
//saving to redis template
/*    public String save(String id, Book book) {
        logger.info("the saved json obj is {}", book.toJson().toString());
        template.opsForValue().set(id, book.toJson().toString(), 10L, TimeUnit.MINUTES);
        return id;
    }

    public Optional<Book> get(String id) {
        String store = template.opsForValue().get(id);
        if (store == null) {
            return Optional.empty();
        }
        try (InputStream is = new ByteArrayInputStream(store.getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonObject data = reader.readObject();
            return Optional.of(Book.createWithDetails(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private String normalize(String k) {
        return k.trim().toLowerCase();
    }*/

}
