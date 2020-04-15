package io.demo.springdatajpademo.repository.custom;

import io.demo.springdatajpademo.dto.MainDto;

import java.util.List;

public interface MainRepository {
    List<MainDto> findAllDto();
}
