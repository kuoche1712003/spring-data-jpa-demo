package io.demo.springdatajpademo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Main {
    @Id
    private String id;
    private String name;
    private String departmentId;
}
