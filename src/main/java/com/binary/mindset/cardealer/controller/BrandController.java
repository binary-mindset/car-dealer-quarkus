package com.binary.mindset.cardealer.controller;

import com.binary.mindset.cardealer.BrandsApi;
import com.binary.mindset.cardealer.mapper.BrandMapper;
import com.binary.mindset.cardealer.model.BrandDto;
import com.binary.mindset.cardealer.model.BrandRequest;
import com.binary.mindset.cardealer.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@RestController
public class BrandController implements BrandsApi {

    private final BrandService brandService;
    private final BrandMapper brandMapper;

    @Autowired
    public BrandController(final BrandService brandService,
                           final BrandMapper brandMapper) {
        this.brandService = brandService;
        this.brandMapper = brandMapper;
    }

    @Override
    public Response createBrand(BrandRequest brandRequest) {
        BrandDto brandDto = brandService.createBrand(brandMapper.toBrandDto(brandRequest));
        return Response.created(UriBuilder.fromPath("/brands/" + brandDto.getId()).build())
                .entity(brandMapper.toBrandResponse(brandDto))
                .build();
    }

    @Override
    public Response deleteBrand(Integer brandId) {
        brandService.deleteBrand(brandId);
        return Response.noContent().build();
    }

    @Override
    public Response getBrand(Integer brandId) {
        return Response.ok()
                .entity(brandMapper.toBrandResponse(brandService.getBrand(brandId)))
                .build();
    }

    @Override
    public Response getBrands() {
        List<BrandDto> brandDtos = brandService.getBrands();
        return Response.ok()
                .entity(brandMapper.toBrandResponseAsList(brandDtos))
                .build();
    }
}