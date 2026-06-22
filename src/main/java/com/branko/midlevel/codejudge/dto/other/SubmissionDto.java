package com.branko.midlevel.codejudge.dto.other;

import com.branko.midlevel.codejudge.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionDto {

    private Long id;
    private UserDto user;
    private Long contestProblemId;
    private String sourceCode;
    private String language;
    private Long total;
    private Long passed;
}
