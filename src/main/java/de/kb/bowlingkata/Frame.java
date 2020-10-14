package de.kb.bowlingkata;

public class Frame {

    int firstThrow;
    int secondThrow;
    int extraThrow;
    FrameType frameTypeOfFormerFrame;


    public Frame(int firstThrow, int secondThrow, FrameType frameTypeOfFormerFrame) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
        this.frameTypeOfFormerFrame = frameTypeOfFormerFrame;
    }

    public Frame(int firstThrow, FrameType frameTypeOfFormerFrame) {
        this.firstThrow = firstThrow;
        this.frameTypeOfFormerFrame = frameTypeOfFormerFrame;
    }

    public Frame(int firstThrow, int secondThrow, int extraThrow, FrameType frameTypeOfFormerFrame) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
        this.extraThrow = extraThrow;
        this.frameTypeOfFormerFrame = frameTypeOfFormerFrame;
    }

    public int calculateScore() {
        int score = 0;

        if(extraThrow!=0){
            if(this.getFrameType().equals(FrameType.STRIKE) || this.getFrameType().equals(FrameType.STRIKE_AFTER_STRIKE)){
                score = firstThrow + (secondThrow + extraThrow) ;
            }
            if(this.getFrameType().equals(FrameType.SPARE)){

                score = firstThrow + secondThrow +( extraThrow) ;
            }
        }else{
            if (this.getFrameType().equals(FrameType.NORMAL) || this.getFrameType().equals(FrameType.SPARE)) {
                score = firstThrow + secondThrow;

            } else {
                score = 10;
            }
        }

        if (frameTypeOfFormerFrame.equals(FrameType.STRIKE_AFTER_STRIKE) || frameTypeOfFormerFrame.equals(FrameType.STRIKE)) {
            score += firstThrow + secondThrow;
        }

        if (frameTypeOfFormerFrame.equals(FrameType.SPARE) || frameTypeOfFormerFrame.equals(FrameType.STRIKE_AFTER_STRIKE)) {
            score += firstThrow;
        }


        return score;


    }

    public FrameType getFrameType() {
        if (firstThrow == 10) {
            if (frameTypeOfFormerFrame.equals(FrameType.STRIKE) || frameTypeOfFormerFrame.equals(FrameType.STRIKE_AFTER_STRIKE)) {
                return FrameType.STRIKE_AFTER_STRIKE;
            }
            return FrameType.STRIKE;
        }
        if (firstThrow + secondThrow == 10) {
            return FrameType.SPARE;
        }
        return FrameType.NORMAL;
    }


}

enum FrameType {
    NORMAL,
    STRIKE,
    STRIKE_AFTER_STRIKE,
    SPARE
}