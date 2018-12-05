package com.cloud.store.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author squirrel
 * @date 2018-12-05
 */
@Data
public class Person {
    @Id
    private Long id;

    private String name;

    private Integer age;
}
