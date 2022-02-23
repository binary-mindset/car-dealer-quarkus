package com.binary.mindset.cardealer.service.impl;

import com.binary.mindset.cardealer.exception.ServiceException;
import com.binary.mindset.cardealer.mapper.BrandMapper;
import com.binary.mindset.cardealer.model.BrandDto;
import com.binary.mindset.cardealer.repository.BrandRepository;
import com.binary.mindset.cardealer.repository.entity.Brand;
import com.binary.mindset.cardealer.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Autowired
    public BrandServiceImpl(final BrandMapper brandMapper,
                            final BrandRepository brandRepository) {
        this.brandMapper = brandMapper;
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandDto createBrand(BrandDto brandDto) {
        Brand brand = brandRepository.save(brandMapper.toBrand(brandDto));
        return brandMapper.toBrandDto(brand);
    }

    @Override
    public List<BrandDto> getBrands() {
        return brandMapper.toBrandDtoAsList(brandRepository.findAll());
    }

    @Override
    public BrandDto getBrand(Integer brandId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "No brand was found with id " + brandId));
        return brandMapper.toBrandDto(brand);
    }

    @Override
    public void deleteBrand(Integer brandId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new ServiceException(HttpStatus.NOT_FOUND, "No brand was found with id " + brandId));
        brandRepository.delete(brand);
    }
}