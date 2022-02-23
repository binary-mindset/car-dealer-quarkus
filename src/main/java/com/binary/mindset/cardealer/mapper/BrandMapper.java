package com.binary.mindset.cardealer.mapper;

import com.binary.mindset.cardealer.model.BrandDto;
import com.binary.mindset.cardealer.model.BrandRequest;
import com.binary.mindset.cardealer.model.BrandResponse;
import com.binary.mindset.cardealer.repository.entity.Brand;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface BrandMapper {

    BrandDto toBrandDto(BrandRequest brandRequest);

    Brand toBrand(BrandDto brandDto);

    BrandDto toBrandDto(Brand brand);

    BrandResponse toBrandResponse(BrandDto brandDto);

    List<BrandDto> toBrandDtoAsList(List<Brand> brandEntities);

    List<BrandResponse> toBrandResponseAsList(List<BrandDto> brandDtos);
}