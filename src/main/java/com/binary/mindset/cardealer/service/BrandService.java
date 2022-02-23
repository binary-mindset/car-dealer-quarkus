package com.binary.mindset.cardealer.service;

import com.binary.mindset.cardealer.model.BrandDto;

import java.util.List;

public interface BrandService {

    BrandDto createBrand(BrandDto brand);

    List<BrandDto> getBrands();

    BrandDto getBrand(Integer brandId);

    void deleteBrand(Integer brandId);
}