package com.cloud.store.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 类名称:Person
 * 类描述:测试实体类
 * @author squirrel
 * @date 2018-12-05
 */
@Data
@Document(collection = "person")
public class Person {
    @Id
    private Long id;

    private String name;

    private Integer age;
}
