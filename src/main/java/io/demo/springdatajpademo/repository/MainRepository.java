package io.demo.springdatajpademo.repository;

import io.demo.springdatajpademo.dto.MainDto;
import io.demo.springdatajpademo.entity.Main;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepository extends JpaRepository<Main, String> {

    //可以直接寫JPQL
    @Query("select new io.demo.springdatajpademo.dto.MainDto(m.id, m.name, n.name) from Main m inner join Department n on m.departmentId = n.id")
    List<MainDto> findAllDto();
}
