package com.binary.mindset.cardealer.repository;

import com.binary.mindset.cardealer.repository.entity.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Integer> {

    List<Brand> findAll();
}
