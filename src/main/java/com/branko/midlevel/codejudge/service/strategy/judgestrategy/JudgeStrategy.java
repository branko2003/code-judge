package com.branko.midlevel.codejudge.service.strategy.judgestrategy;

import java.nio.file.Path;
import java.util.List;

public interface JudgeStrategy {

    String getStrategyName();

    Path createFile(Path dir, String sourceCode);

    List<String> compileCommand(Path file);

    List<String> runCommand(Path file);
}
