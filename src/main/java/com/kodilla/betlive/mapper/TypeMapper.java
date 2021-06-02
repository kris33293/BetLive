package com.kodilla.betlive.mapper;

import com.kodilla.betlive.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TypeMapper {

    public TypeDto mapToTypeDto(final Type type) {
        TypeDto typeDto = new TypeDto(
                type.getTypeId(),
                type.getHomeTeam(),
                type.getAwayTeam(),
                type.getEventDate(),
                type.getOdd(),
                type.getYourType(),
                type.getBetslips(),
                type.getTickets());
        return typeDto;
    }

    public Type mapToType(final TypeDto typeDto) {
        Type type = new Type();
        type.setTypeId(typeDto.getTypeId());
        type.setAwayTeam(typeDto.getAwayTeam());
        type.setEventDate(typeDto.getEventDate());
        type.setHomeTeam(typeDto.getHomeTeam());
        type.setBetslips(typeDto.getBetslips());
        type.setYourType(typeDto.getYourType());
        return type;
    }

    public List<TypeDto> maptoTypeDtoList(final List<Type> typeList) {
        return typeList.stream()
                .map(this::mapToTypeDto)
                .collect(Collectors.toList());
    }

    public List<Type> maptoTypeList(final List<TypeDto> typeList) {
        return typeList.stream()
                .map(this::mapToType)
                .collect(Collectors.toList());
    }

}
