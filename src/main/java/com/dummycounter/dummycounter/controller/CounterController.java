package com.dummycounter.dummycounter.controller;

import com.dummycounter.dummycounter.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CounterController
{
    private final CounterService counterService;

    @GetMapping("/")
    public String getCounterPage(Model model) {
        Map<String, Integer> allCounters = counterService.getAllCounters();
        model.addAttribute("allCounters", allCounters);
        return "index";
    }

    @PostMapping("/count")
    public String count(@RequestParam("counterName") String counterName) {
        counterService.count(counterName);
        return "redirect:/";
    }

    @PostMapping("/create")
    public String create(@RequestParam("counterName") String counterName) {
        counterService.create(counterName);
        return "redirect:/";
    }

    @PostMapping("/reset")
    public String reset(@RequestParam("counterName") String counterName) {
        counterService.reset(counterName);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("counterName") String counterName) {
        counterService.delete(counterName);
        return "redirect:/";
    }
}
