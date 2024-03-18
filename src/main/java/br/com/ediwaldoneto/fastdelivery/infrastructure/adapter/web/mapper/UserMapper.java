package br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;
import br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.request.UserRequest;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User toDomain(UserRequest request);

	UserRequest toRequest(User user);

}
