package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import com.branko.midlevel.codejudge.dto.request.CreateProblemRequest;
import com.branko.midlevel.codejudge.repository.entity.Problem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProblemMapper {

    ProblemDto problemDtoFromMapProblem(Problem problem);

    Problem problemFromMapCreateProblemRequest(CreateProblemRequest request);
}
