package de.kb.bowlingkata;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    List<Frame> frames;


    public BowlingGame(String individualFramesAsString) {
        frames = new ArrayList<>();
        String[] framesArrayDivided = individualFramesAsString.split(" ");

            String[] individualFramesAsArray = new String[10];
            for (int i = 0; i <framesArrayDivided.length ; i++) {
                if(i<10){
                    individualFramesAsArray[i] = framesArrayDivided[i];
                }
                else{
                    individualFramesAsArray[9]+=framesArrayDivided[i];

                }
            }

        for (int i = 0; i < individualFramesAsArray.length; i++) {
            if (i==0) {
                frames.add(0, createFrameFromString(individualFramesAsArray[0]));
            }
            else{

                frames.add(i, createFrameFromString(individualFramesAsArray[i], frames.get(i - 1).getFrameType()));
            }


        }
    }

    public int calculateScore() {
        int score = 0;
        for (Frame frame : frames
        ) {
            score += frame.calculateScore();
        }

        return score;
    }

    public static Frame createFrameFromString(String frameAsString) {
        return createFrameFromString(frameAsString, FrameType.NORMAL);

    }

    public static Frame createFrameFromString(String frameAsString, FrameType frameTypeOfFormerFrame) {


        int firstThrow = 0;
        int secondThrow = 0;
        int extraThrow = 0;


        frameAsString = frameAsString.replace('-', '0');


        if (frameAsString.startsWith("X")) {
            firstThrow = 10;
        } else {
            firstThrow = Integer.parseInt(frameAsString.substring(0, 1));
        }
        if (frameAsString.length() >= 2) {
            if (frameAsString.substring(1, 2).equals("/")) {

                secondThrow = 10 - firstThrow;

            } else {
                if(frameAsString.substring(1, 2).equals("X")){
                    secondThrow=10;
                }
                else{

                    secondThrow = Integer.parseInt(frameAsString.substring(1, 2));
                }
            }
        }

        if (frameAsString.length() == 3) {

            if (frameAsString.endsWith("X")) {
                extraThrow = 10;
            } else {
                if (frameAsString.endsWith("/")) {
                    extraThrow = 10-secondThrow;
                } else {
                    extraThrow = Integer.parseInt(frameAsString.substring(2, 3));
                }
            }
        }


        return new Frame(firstThrow, secondThrow, extraThrow, frameTypeOfFormerFrame);
    }


}
