package com.branko.midlevel.codejudge.dto.other;

import com.branko.midlevel.codejudge.repository.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ContestDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private User creator;
}
