package de.kb.bowlingkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameServiceTest {

    private BowlingGameService bowlingGameService;

    @BeforeEach
    void setUp() {
        bowlingGameService = new BowlingGameService();
    }

    @Test
    void createFrameFromStringWhenItsAStrike() {
        Frame strike = BowlingGameService.createFrameFromString("X");
        assertEquals(FrameType.STRIKE, strike.getFrameType());

    }

       @Test
    void createFrameFromStringWhenItsASpare() {
        Frame spare = BowlingGameService.createFrameFromString("5/");
        assertEquals(FrameType.SPARE, spare.getFrameType());

    }
    @Test
    void createFrameFromStringWhenItsANormalThrow() {
        Frame normal = BowlingGameService.createFrameFromString("53");
        assertEquals(FrameType.NORMAL, normal.getFrameType());

    }

    @Test
    void createFrameFromStringWhenItsASpareAndStrike() {
        Frame spareAndStrike = BowlingGameService.createFrameFromString("5/X");
        assertEquals(5,spareAndStrike.firstThrow);
        assertEquals(5,spareAndStrike.secondThrow);
        assertEquals(10,spareAndStrike.extraThrow);

    }
    @Test
    void createFrameFromStringWhenItsASpareAndNormal() {
        Frame spareAndStrike = BowlingGameService.createFrameFromString("5/3");
        assertEquals(5,spareAndStrike.firstThrow);
        assertEquals(5,spareAndStrike.secondThrow);
        assertEquals(3,spareAndStrike.extraThrow);

    }

    @Test
    void createFrameFromStringWhenItsAStrikeAndNormal() {
        Frame spareAndStrike = BowlingGameService.createFrameFromString("X34");
        assertEquals(10,spareAndStrike.firstThrow);
        assertEquals(3,spareAndStrike.secondThrow);
        assertEquals(4,spareAndStrike.extraThrow);

    }

    @Test
    void createFrameFromStringWhenItsAStrikeAndStrikeAndStrike() {
        Frame spareAndStrike = BowlingGameService.createFrameFromString("XXX");
        assertEquals(10,spareAndStrike.firstThrow);
        assertEquals(10,spareAndStrike.secondThrow);
        assertEquals(10,spareAndStrike.extraThrow);

    }

    @Test
    void createFrameFromStringWhenItsAStrikeAndSpare() {
        Frame spareAndStrike = BowlingGameService.createFrameFromString("X3/");
        assertEquals(10,spareAndStrike.firstThrow);
        assertEquals(3,spareAndStrike.secondThrow);
        assertEquals(7,spareAndStrike.extraThrow);

    }

    @Test
    void createFrameWithStrikeAsFormerFrame(){
        Frame normal = BowlingGameService.createFrameFromString("53", FrameType.STRIKE);
        assertEquals(FrameType.STRIKE, normal.frameTypeOfFormerFrame);
    }


    @Test
    void calculateScoreOfPerfectGame() {
        assertEquals(300, bowlingGameService.calculateScore("X X X X X X X X X X X X"));
    }
    @Test
    void testConcatenation() {
        BowlingGameService perfectWith12 = new BowlingGameService();
        BowlingGameService perfectWith10 = new BowlingGameService();
        assertEquals(perfectWith10.calculateScore("X X X X X X X X X X X X"), perfectWith12.calculateScore("X X X X X X X X X XXX"));

    }

    @Test
    void calculateScoreOfAllSpareGame() {
        BowlingGameService perfect = new BowlingGameService();
        assertEquals(150, perfect.calculateScore("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5"));
    }
    @Test
    void calculateScoreOfAllNormalGame() {
        BowlingGameService perfect = new BowlingGameService();
        assertEquals(90, perfect.calculateScore("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"));
    }
    @Test
    void calculateScoreOfAllNormalGameWithDifferentFrames() {
        BowlingGameService perfect = new BowlingGameService();
        assertEquals(80, perfect.calculateScore("9- 9- 9- 3- 9- 9- 9- 9- 5- 9-"));
    }
    @Test
    void calculateScoreOfGameWithOneStrike() {
        BowlingGameService perfect = new BowlingGameService();
        assertEquals(90, perfect.calculateScore("9- 9- 9- 3- 9- X 9- 9- 5- 9-"));
    }
    @Test
    void calculateScoreOfTestGame() {
        BowlingGameService perfect = new BowlingGameService();
        assertEquals(133, perfect.calculateScore("14 45 6/ 5/ X 01 7/ 6/ X 2/6"));
    }
}