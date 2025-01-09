//TODO: done myself so idk
package de.unibayreuth.se.taskboard.api.mapper;

import de.unibayreuth.se.taskboard.api.dtos.UserDto;
import de.unibayreuth.se.taskboard.business.domain.User;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;


@Mapper(componentModel = "spring")
@ConditionalOnMissingBean
@NoArgsConstructor
public abstract class UserDtoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "name", source = "name")
    public abstract UserDto fromBusiness(User source);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "name", source = "name")
    public abstract User toBusiness(UserDto source);
}
