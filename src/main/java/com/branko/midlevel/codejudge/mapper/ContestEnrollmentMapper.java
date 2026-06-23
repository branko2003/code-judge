package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.ContestEnrollmentDto;
import com.branko.midlevel.codejudge.repository.entity.ContestEnrollment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContestEnrollmentMapper {

    ContestEnrollmentDto contestEnrollemntDtoFromMapcontestEnrollemnt(ContestEnrollment contestEnrollment);

    List<ContestEnrollmentDto> contestEnrollemntListFromMapContestEnrollemntList(List<ContestEnrollment> contestEnrollment);
}
