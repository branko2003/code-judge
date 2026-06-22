package com.branko.midlevel.codejudge.service.strategy.judgestrategy;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class JudgeStrategyFactory {
    private Map<String, JudgeStrategy> strategies;

    public JudgeStrategyFactory(Set<JudgeStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public JudgeStrategy findStrategy(String nameStrategy) {
        return strategies.get(nameStrategy);
    }

    private void createStrategy(Set<JudgeStrategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach(strategy -> strategies.put(strategy.getStrategyName(), strategy));
    }

}
