package com.wildcodeschool.springHibernateJPA.repositories;

import com.wildcodeschool.springHibernateJPA.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
