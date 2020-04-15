package io.demo.springdatajpademo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Department {
    @Id
    private String id;
    private String name;
}
