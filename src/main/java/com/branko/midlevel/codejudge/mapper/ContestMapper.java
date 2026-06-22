package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.constant.ContestStatusEnum;
import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.request.CreateContestRequest;
import com.branko.midlevel.codejudge.dto.request.UpdateContestRequest;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import org.mapstruct.*;

@Mapper(componentModel = "spring", imports = {ContestStatusEnum.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ContestMapper {

    ContestDto contestDtoFromMapContest(Contest contest);

    @Mapping(target = "status", expression = "java(ContestStatusEnum.PENDING.get())")
    Contest contestFromMapCreateContestRequest(CreateContestRequest request);

    @Condition
    default boolean isNotBlank(String value) {
        return value != null && !value.isBlank();
    }

    void updateContestFromRequest(UpdateContestRequest request, @MappingTarget Contest contest);
}
