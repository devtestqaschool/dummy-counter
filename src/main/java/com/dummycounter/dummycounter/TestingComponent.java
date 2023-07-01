package com.dummycounter.dummycounter;

import com.dummycounter.dummycounter.repository.CounterRepository;
import com.dummycounter.dummycounter.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestingComponent implements CommandLineRunner
{
    private final CounterRepository counterRepository;
    private final CounterService counterService;

    @Override
    public void run(String... args)
    {
        counterService.create("Счетчик домов");
        counterService.create("Счетчик самолетов");
        counterService.create("Счетчик кораблей");
        counterService.create("Счетчик людей");
        counterService.create("Счетчик машин");
        counterService.create("Счетчик собак");
    }
}
