package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.ContestProblemDto;
import com.branko.midlevel.codejudge.dto.other.ContestProblemWithContest;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import com.branko.midlevel.codejudge.repository.entity.ContestProblem;
import com.branko.midlevel.codejudge.repository.entity.Problem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContestProblemMapper {

    @Mapping(target = "problemId", expression = "java(contestProblem.getProblem().getId())")
    @Mapping(target = "contestId", expression = "java(contestProblem.getContest().getId())")
    ContestProblemDto contestProblemDtoFromMapContestProblem(ContestProblem contestProblem);

    @Mapping(source = "contest", target = "contest")
    ContestProblemWithContest contestProblemWithContestFromMapContestProblem(ContestProblem contestProblem);

    List<ContestProblemDto> contestProblemDtoListFromMapContestProblemList(List<ContestProblem> contestProblem);

    default ContestProblem contestProblemFromMapcontestIdAndProblemId(Long contestId, Long problemId) {
        ContestProblem contestProblem = new ContestProblem();
        Contest contest = new Contest();
        contest.setId(contestId);
        Problem problem = new Problem();
        problem.setId(problemId);
        contestProblem.setContest(contest);
        contestProblem.setProblem(problem);
        return contestProblem;
    }
}
