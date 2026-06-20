package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class AddUsersToContestRequest {

    @NotNull
    private Long contestId;

    private List<String> adminList;

    @NotEmpty
    private List<String> participantList;
}
