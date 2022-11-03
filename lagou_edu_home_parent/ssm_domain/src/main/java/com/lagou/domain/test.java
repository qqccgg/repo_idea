package com.lagou.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class test {

    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "domain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
