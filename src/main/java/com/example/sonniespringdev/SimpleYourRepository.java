package com.example.sonniespringdev;

import com.example.sonniespringdev.springDataCommon.YourRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class SimpleYourRepository<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID>
        implements YourRepository<T, ID> {

    private EntityManager entityManager;

    public SimpleYourRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }

    //내가 framework보다 더 빠른 findAll()을 만들 수 있다고 생각하면 overriding 받아서 내가 직접 만들면 된다
    @Override
    public List<T> findAll() {
        return super.findAll();
    }
}
