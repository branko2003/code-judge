package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class AddUsersToContestRequest {

    @NotNull(message = "{contestId.notnull}")
    private Long contestId;

    @NotEmpty(message = "{userlist.notempty}")
    private List<String> userList;
}
