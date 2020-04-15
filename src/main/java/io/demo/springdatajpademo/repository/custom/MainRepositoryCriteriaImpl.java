package io.demo.springdatajpademo.repository.custom;

import io.demo.springdatajpademo.dto.MainDto;
import io.demo.springdatajpademo.entity.Department;
import io.demo.springdatajpademo.entity.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository("MainCriteria")
@RequiredArgsConstructor
public class MainRepositoryCriteriaImpl implements MainRepository {
    private final EntityManager em;

    @Override
    public List<MainDto> findAllDto() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MainDto> cq = cb.createQuery(MainDto.class);

        //criteria 對於沒有兩個沒有關聯的entity沒辦法使用fetch join
        //只能用cross join 在下where達到類似的效果但效能很差
        Root<Main> main = cq.from(Main.class);
        Root<Department> department = cq.from(Department.class);
        Predicate equal = cb.equal(main.get("departmentId"), department.get("id"));
        cq.where(equal);
        cq.select(
                cb.construct(
                    MainDto.class,
                    main.get("id"),
                    main.get("name"),
                    department.get("name")
                )
        );
        TypedQuery<MainDto> q = em.createQuery(cq);
        return q.getResultList();
    }
}
