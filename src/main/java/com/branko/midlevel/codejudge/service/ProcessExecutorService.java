package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.ExecutionResult;

import java.nio.file.Path;
import java.util.List;

public interface ProcessExecutorService {

    ExecutionResult run(List<String> command, Path dir, String input);
}
