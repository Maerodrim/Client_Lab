package com.example.Client.repository;

import com.example.Client.dto.DoubleResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "DoubleResponse")
public interface  DoubleResponceRepository extends CrudRepository<DoubleResponse, Long> {
}
