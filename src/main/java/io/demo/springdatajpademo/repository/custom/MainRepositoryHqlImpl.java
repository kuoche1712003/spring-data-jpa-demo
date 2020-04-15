package io.demo.springdatajpademo.repository.custom;

import io.demo.springdatajpademo.dto.MainDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository("MainHql")
@RequiredArgsConstructor
public class MainRepositoryHqlImpl implements MainRepository{
    private final EntityManager em;

    @Override
    public List<MainDto> findAllDto() {
        List<MainDto> data = em.createQuery("select new io.demo.springdatajpademo.dto.MainDto(m.id, m.name, n.name) from Main m inner join Department n on m.departmentId = n.id", MainDto.class)
                .getResultList();

        return data;
    }
}
