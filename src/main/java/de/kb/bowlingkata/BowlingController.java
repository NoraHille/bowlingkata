package de.kb.bowlingkata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BowlingController {


    @GetMapping("/test")
    String testMethod() {
        return "Hello";
    }

    @PostMapping("/bowling")
    ScoreData testMethod(@RequestBody BowlingData bowlingInput) {

        BowlingGame game = new BowlingGame(bowlingInput.bowlingString);
        return new ScoreData(game.calculateScore());

    }
}
