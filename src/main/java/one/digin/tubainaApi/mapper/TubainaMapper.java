package one.digin.tubainaApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import one.digin.tubainaApi.dto.TubainaDTO;
import one.digin.tubainaApi.entity.Tubaina;

@Mapper
public interface TubainaMapper {

    TubainaMapper INSTANCE = Mappers.getMapper(TubainaMapper.class);

    Tubaina toModel(TubainaDTO tubainaDTO);

    TubainaDTO toDTO(Tubaina tubaina);
}
