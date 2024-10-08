package com.shreeya.rest.webservices.restful_web_services.repository;

import com.shreeya.rest.webservices.restful_web_services.Model.todoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoJpaRepository extends JpaRepository<todoModel, Long> {
List<todoModel> findByUsername(String username);
}
