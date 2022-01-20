package me.banto.tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.banto.tp.model.Metrics;
import me.banto.tp.repository.MetricsRepository;

/**
 * Contrôleur de pages web
 * @author Antoine BALIEU
 */
@Controller
public class WebController {
    @Autowired
    private MetricsRepository metricsRepository;
    
    @GetMapping("/")
    public String index(Model model) {
        Metrics metrics = metricsRepository.get();
        model.addAttribute("counter", metrics.getCounter());

        return "index";
    }

    @PostMapping("/")
    public String edit(Model model, @RequestParam String action) {
        Metrics metrics = metricsRepository.get();

        model.addAttribute("counter", action.equalsIgnoreCase("increase") ? metrics.increaseCounter() : 
                                      action.equalsIgnoreCase("decrease") ? metrics.decreaseCounter() : metrics.getCounter());

        metricsRepository.save(metrics);

        return "redirect:/";
    }
}
