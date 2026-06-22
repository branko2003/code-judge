package com.branko.midlevel.codejudge.service.strategy.judgestrategy;

import com.branko.midlevel.codejudge.constant.JudgeLanguageStrategyName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JudgeStrategyPython implements JudgeStrategy {

    @Override
    public String getStrategyName() {
        return JudgeLanguageStrategyName.PYTHON.get();
    }

    @Override
    public Path createFile(Path dir, String sourceCode) {
        Path file = dir.resolve("main.py");
        try {
            Files.writeString(file, sourceCode);
        } catch (Exception ignored) {
        }
        return file;
    }

    @Override
    public List<String> compileCommand(Path file) {
        return null;
    }

    @Override
    public List<String> runCommand(Path file) {
        return List.of("python", file.toString());
    }
}
