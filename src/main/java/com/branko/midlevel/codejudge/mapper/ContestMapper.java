package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.ContestDto;
import com.branko.midlevel.codejudge.dto.request.CreateContestRequest;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContestMapper {

    ContestDto contestDtoFromMapContest(Contest contest);

    Contest contestFromMapCreateContestRequest(CreateContestRequest request);
}
