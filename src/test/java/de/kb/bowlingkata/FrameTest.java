package de.kb.bowlingkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrameTest {



    @Test
    void getFrameTypeOfStrike() {
        Frame strike = new Frame(10,FrameType.NORMAL);
        assertEquals(FrameType.STRIKE, strike.getFrameType());
    }
    @Test
    void getFrameTypeOfStrikeAfterStrike() {
        Frame strikeAfterStrike = new Frame(10,FrameType.STRIKE);
        assertEquals(FrameType.STRIKE_AFTER_STRIKE, strikeAfterStrike.getFrameType());
    }
    @Test
    void getFrameTypeOfSpare() {
        Frame spare = new Frame(3,7,FrameType.NORMAL);
        assertEquals(FrameType.SPARE, spare.getFrameType());
    }
    @Test
    void getFrameTypeOfNormalThrow() {
        Frame normal = new Frame(3,3,FrameType.NORMAL);
        assertEquals(FrameType.NORMAL, normal.getFrameType());
    }


    @Test
    void calculateScoreOfStrike() {
        Frame strike = new Frame(10,FrameType.NORMAL);
        assertEquals(10,strike.calculateScore());
    }
    @Test
    void calculateScoreOfStrikeAfterStrike() {
        Frame strikeAfterstrike = new Frame(10,FrameType.STRIKE);
        assertEquals(20,strikeAfterstrike.calculateScore());
    }

    @Test
    void calculateScoreOfStrikeAfterStrikeCreatedByString() {
        Frame strikeAfterstrike = BowlingGameService.createFrameFromString("X", FrameType.STRIKE);
        assertEquals(20,strikeAfterstrike.calculateScore());
    }

    @Test
    void calculateScoreOfStrikeAfterStrikeAfterStrike() {
        Frame strikeAfterstrike = new Frame(10,FrameType.STRIKE_AFTER_STRIKE);
        assertEquals(30,strikeAfterstrike.calculateScore());
    }

    @Test
    void calculateScoreOfStrikeAfterStrikeAfterStrikeCreatedByString() {
        Frame strikeAfterstrike = BowlingGameService.createFrameFromString("X", FrameType.STRIKE_AFTER_STRIKE);
        assertEquals(30,strikeAfterstrike.calculateScore());
    }


    @Test
    void calculateScoreOfSpare() {
        Frame spare = new Frame(3,7,FrameType.NORMAL);
        assertEquals(10,spare.calculateScore());
    }


        @Test
    void calculateScoreOfNormalThrow() {
        Frame normal = new Frame(3,3,FrameType.NORMAL);
        assertEquals(6,normal.calculateScore());
    }

    @Test
    void calculateScoreOfSpareAfterSpare() {
        Frame spare = new Frame(3,7,FrameType.SPARE);
        assertEquals(13,spare.calculateScore());
    }

    @Test
    void calculateScoreOfSpareAfterStrike() {
        Frame spare = new Frame(3,7,FrameType.STRIKE);
        assertEquals(20,spare.calculateScore());
    }

    @Test
    void calculateScoreOfSpareAndNormalThrow() {
        Frame spareAndNormal = BowlingGameService.createFrameFromString("2/4");
        assertEquals(FrameType.SPARE, spareAndNormal.getFrameType());
        assertEquals(14,spareAndNormal.calculateScore());
    }
    @Test
    void calculateScoreOfSpareAndStrike() {
        Frame spareAndNormal = BowlingGameService.createFrameFromString("2/X");
        assertEquals(FrameType.SPARE, spareAndNormal.getFrameType());
        assertEquals(20,spareAndNormal.calculateScore());
    }
    @Test
    void calculateScoreOfStrikeAndStrikeAndStrike() {
        Frame spareAndNormal = BowlingGameService.createFrameFromString("XXX");
        assertEquals(FrameType.STRIKE, spareAndNormal.getFrameType());
        assertEquals(30,spareAndNormal.calculateScore());
    }
    @Test
    void calculateScoreOfStrikeAndStrikeAndStrikeAfterStrike() {
        Frame spareAndNormal = BowlingGameService.createFrameFromString("XXX", FrameType.STRIKE);
        assertEquals(FrameType.STRIKE_AFTER_STRIKE, spareAndNormal.getFrameType());
        assertEquals(50,spareAndNormal.calculateScore());
    }
    @Test
    void calculateScoreOfStrikeAndStrikeAndStrikeAfterStrikeAfterStrike() {
        Frame spareAndNormal = BowlingGameService.createFrameFromString("XXX", FrameType.STRIKE_AFTER_STRIKE);
        assertEquals(FrameType.STRIKE_AFTER_STRIKE, spareAndNormal.getFrameType());
        assertEquals(60,spareAndNormal.calculateScore());
    }
    @Test
    void calculateScoreOfStrikeAndSpareAfterStrikeAfterStrike() {
        Frame spareAndNormal = BowlingGameService.createFrameFromString("X3/", FrameType.STRIKE_AFTER_STRIKE);
        assertEquals(FrameType.STRIKE_AFTER_STRIKE, spareAndNormal.getFrameType());
        assertEquals(43,spareAndNormal.calculateScore());
    }




}