package de.kb.bowlingkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {

    @Test
    void createFrameFromStringWhenItsAStrike() {
        Frame strike = BowlingGame.createFrameFromString("X");
        assertEquals(FrameType.STRIKE, strike.getFrameType());

    }

       @Test
    void createFrameFromStringWhenItsASpare() {
        Frame spare = BowlingGame.createFrameFromString("5/");
        assertEquals(FrameType.SPARE, spare.getFrameType());

    }
    @Test
    void createFrameFromStringWhenItsANormalThrow() {
        Frame normal = BowlingGame.createFrameFromString("53");
        assertEquals(FrameType.NORMAL, normal.getFrameType());

    }

    @Test
    void createFrameFromStringWhenItsASpareAndStrike() {
        Frame spareAndStrike = BowlingGame.createFrameFromString("5/X");
        assertEquals(5,spareAndStrike.firstThrow);
        assertEquals(5,spareAndStrike.secondThrow);
        assertEquals(10,spareAndStrike.extraThrow);

    }
    @Test
    void createFrameFromStringWhenItsASpareAndNormal() {
        Frame spareAndStrike = BowlingGame.createFrameFromString("5/3");
        assertEquals(5,spareAndStrike.firstThrow);
        assertEquals(5,spareAndStrike.secondThrow);
        assertEquals(3,spareAndStrike.extraThrow);

    }

    @Test
    void createFrameFromStringWhenItsAStrikeAndNormal() {
        Frame spareAndStrike = BowlingGame.createFrameFromString("X34");
        assertEquals(10,spareAndStrike.firstThrow);
        assertEquals(3,spareAndStrike.secondThrow);
        assertEquals(4,spareAndStrike.extraThrow);

    }

    @Test
    void createFrameFromStringWhenItsAStrikeAndStrikeAndStrike() {
        Frame spareAndStrike = BowlingGame.createFrameFromString("XXX");
        assertEquals(10,spareAndStrike.firstThrow);
        assertEquals(10,spareAndStrike.secondThrow);
        assertEquals(10,spareAndStrike.extraThrow);

    }

    @Test
    void createFrameFromStringWhenItsAStrikeAndSpare() {
        Frame spareAndStrike = BowlingGame.createFrameFromString("X3/");
        assertEquals(10,spareAndStrike.firstThrow);
        assertEquals(3,spareAndStrike.secondThrow);
        assertEquals(7,spareAndStrike.extraThrow);

    }

    @Test
    void createFrameWithStrikeAsFormerFrame(){
        Frame normal = BowlingGame.createFrameFromString("53", FrameType.STRIKE);
        assertEquals(FrameType.STRIKE, normal.frameTypeOfFormerFrame);
    }


    @Test
    void calculateScoreOfPerfectGame() {
        BowlingGame perfect = new BowlingGame("X X X X X X X X X X X X");
        assertEquals(300, perfect.calculateScore());
    }
    @Test
    void testConcatenation() {
        BowlingGame perfectWith12 = new BowlingGame("X X X X X X X X X X X X");
        BowlingGame perfectWith10 = new BowlingGame("X X X X X X X X X XXX");
        assertEquals(perfectWith10.calculateScore(), perfectWith12.calculateScore());

    }

    @Test
    void calculateScoreOfAllSpareGame() {
        BowlingGame perfect = new BowlingGame("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");
        assertEquals(150, perfect.calculateScore());
    }
    @Test
    void calculateScoreOfAllNormalGame() {
        BowlingGame perfect = new BowlingGame("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-");
        assertEquals(90, perfect.calculateScore());
    }
    @Test
    void calculateScoreOfAllNormalGameWithDifferentFrames() {
        BowlingGame perfect = new BowlingGame("9- 9- 9- 3- 9- 9- 9- 9- 5- 9-");
        assertEquals(80, perfect.calculateScore());
    }
    @Test
    void calculateScoreOfGameWithOneStrike() {
        BowlingGame perfect = new BowlingGame("9- 9- 9- 3- 9- X 9- 9- 5- 9-");
        assertEquals(90, perfect.calculateScore());
    }
    @Test
    void calculateScoreOfTestGame() {
        BowlingGame perfect = new BowlingGame("14 45 6/ 5/ X 01 7/ 6/ X 2/6");
        assertEquals(133, perfect.calculateScore());
    }
}