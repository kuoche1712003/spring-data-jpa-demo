package io.demo.springdatajpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainDto {
    private String id;
    private String name;
    private String departmentName;
}
