package de.kb.bowlingkata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BowlingController {
    private final BowlingGameService bowlingGameService;

    @Autowired
    public BowlingController(BowlingGameService bowlingGameService) {
        this.bowlingGameService = bowlingGameService;
    }

    @GetMapping("/test")
    String testMethod() {
        return "Hello";
    }

    @PostMapping("/bowling")
    ScoreData testMethod(@RequestBody BowlingData bowlingInput) {
        return new ScoreData(bowlingGameService.calculateScore(bowlingInput.bowlingString));

    }
}
