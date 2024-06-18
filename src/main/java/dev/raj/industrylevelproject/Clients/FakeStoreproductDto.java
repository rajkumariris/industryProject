package dev.raj.industrylevelproject.Clients;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
@RedisHash("Product")
@Getter
@Setter
public class FakeStoreproductDto implements Serializable {
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
