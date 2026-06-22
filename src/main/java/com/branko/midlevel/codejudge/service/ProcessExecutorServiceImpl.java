package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.ExecutionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessExecutorServiceImpl implements ProcessExecutorService {

    @Override
    public ExecutionResult run(List<String> command, Path dir, String input) {
        try {
            Process process = new ProcessBuilder(command)
                    .directory(dir.toFile())
                    .redirectErrorStream(true)
                    .start();

            process.getOutputStream().write(input.getBytes());
            process.getOutputStream().close();

            String output = new String(process.getInputStream().readAllBytes());

            return new ExecutionResult(process.exitValue(), output);

        } catch (Exception e) {
            return new ExecutionResult(-1, "");
        }
    }
}
