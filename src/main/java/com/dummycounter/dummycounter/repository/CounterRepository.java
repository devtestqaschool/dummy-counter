package com.dummycounter.dummycounter.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class CounterRepository
{
    @Value("${dummycounter.bug.incrementValue}")
    public int increment;
    @Value("${dummycounter.bug.initialValue}")
    public int initialValue;
    @Value("${dummycounter.bug.resetValue}")
    public int resetValue;
    @Value("${dummycounter.bug.canDelete}")
    public boolean canDelete;

    private final Map<String, Integer> counterNameToValue = new ConcurrentHashMap<>();
    
    public int increment(String name) {
        if(!counterNameToValue.containsKey(name)) {
            log.warn("Счетчик '{}' не существует. Попытка создать счетчик с именем '{}'...", name, name);
            create(name);
        }
        log.debug("Увеличение значения счетчика '{}' на {}", name, increment);
        Integer result = counterNameToValue.merge(name, increment, Integer::sum);
        log.debug("Новое значение счетчика '{}' это {}", name, result);
        return result;
    }

    public int create(String name) {
        log.debug("Создание нового счетчика '{}' с начальным значением {}", name, initialValue);
        counterNameToValue.put(name, initialValue);
        log.debug("Счетчик '{}' был создан", name);
        return initialValue;
    }

    public int reset(String name) {
        log.debug("Сброс счетчика '{}'. Его новое значение {}", name, resetValue);
        counterNameToValue.put(name, resetValue);
        log.debug("Счетчик '{}' был сброшен", name);
        return initialValue;
    }

    public int delete(String name) {
        if(canDelete)
        {
            log.debug("Удаление счетчика '{}'", name);
            counterNameToValue.remove(name);
            log.debug("Счетчик '{}' был удален", name);
        } else {
            log.error("Счетчик '{}' не может быть удален", name);
        }
        return initialValue;
    }

    public int get(String name) {
        Integer result = counterNameToValue.getOrDefault(name, initialValue);
        log.debug("Полученное значение для счетчика '{}' это {}", name, result);
        return result;
    }

    public Map<String, Integer> getAllCounters() {
        return new HashMap<>(counterNameToValue);
    }
}
