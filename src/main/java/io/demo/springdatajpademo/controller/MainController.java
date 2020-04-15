package io.demo.springdatajpademo.controller;

import io.demo.springdatajpademo.dto.MainDto;
import io.demo.springdatajpademo.repository.MainRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    private final MainRepository mainRepository;
    private final io.demo.springdatajpademo.repository.custom.MainRepository criteriaRepository;
    private final io.demo.springdatajpademo.repository.custom.MainRepository hqlRepository;

    public MainController(
            MainRepository mainRepository,
            @Qualifier("MainCriteria")
            io.demo.springdatajpademo.repository.custom.MainRepository criteriaRepository,
            @Qualifier("MainHql")
            io.demo.springdatajpademo.repository.custom.MainRepository hqlRepository){
        this.mainRepository = mainRepository;
        this.criteriaRepository = criteriaRepository;
        this.hqlRepository = hqlRepository;
    }

    @GetMapping("/jpql")
    public @ResponseBody List<MainDto> findAllJpql(){
        return mainRepository.findAllDto();
    }

    @GetMapping("/criteria")
    public @ResponseBody List<MainDto> findAllCriteria(){
        return criteriaRepository.findAllDto();
    }

    @GetMapping("/hql")
    public @ResponseBody List<MainDto> findAllHql(){
        return hqlRepository.findAllDto();
    }
}
