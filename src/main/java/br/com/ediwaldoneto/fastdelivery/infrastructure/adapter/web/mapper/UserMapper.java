package br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;
import br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.request.UserRequest;
import br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.response.UserResponse;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User toDomain(UserRequest request);

	UserResponse toResponse(User user);

}
