package com.dummycounter.dummycounter.service;

import com.dummycounter.dummycounter.repository.CounterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CounterService
{
    private final CounterRepository counterRepository;

    public List<Integer> makeIncrementsForAndGetIncrementedValues(String name, int amount) {
        List<Integer> result = new ArrayList<>();

        log.info("Приложение собирается увеличить значение счетчика '{}' {} раз(а)", name, amount);

        int initialValue = counterRepository.get(name);

        log.info("Начальное значение счетчика '{}' это {}", name, initialValue);

        for (int i = 0; i < amount; i++)
        {
            result.add(counterRepository.increment(name));
        }

        log.info("Значения через которые прошел счетчик '{}' это {}", name, result);

        return result;
    }

    public int count(String name) {
        log.info("Приложение собирается увеличить значение счетчика '{}' {} раз(а)", name, 1);

        int initialValue = counterRepository.get(name);

        log.info("Начальное значение счетчика '{}' это {}", name, initialValue);

        int increment = counterRepository.increment(name);

        log.info("Значения через которые прошел счетчик '{}' это [{}]", name, increment);

        return increment;
    }

    public int create(String name) {
        return counterRepository.create(name);
    }

    public int reset(String name) {
        return counterRepository.reset(name);
    }

    public int delete(String name) {
        return counterRepository.delete(name);
    }

    public Map<String, Integer> getAllCounters() {
        return new LinkedHashMap<>(counterRepository.getAllCounters());
    }
}
