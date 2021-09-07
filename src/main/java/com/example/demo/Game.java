package com.example.demo;

/**
 * Exercise Implement the rest of the code neccessary
 */
public class Game {

    private int currentRoll =0;

    //Man har 21 runder totalt å kaste på, og 2 kast per runde.

    //Spare = 10 pins in 2 tries
    //Spare bonus = number of pins knocked down by the next roll.

    //Strike = All 10 pins knocked down on first try
    //Strike bonus: value of two next balls rolled

    private int [] rolls = new int[21];

    void roll(int pins) {

        rolls[currentRoll++] = pins;
    }

    int score() {

        int score = 0;
        int frameIndex = 0;

        for(int frame = 0; frame < 10; frame++){

            if(isStrike(frameIndex)){

                score += 10 + strikeBonus(frameIndex);
                frameIndex++;

            }else if(isSpare(frameIndex)) {

                // score blir 10 + antall poeng i runden etter
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;

            }else{

            score += sumOfBallsInFrame(frameIndex);
            frameIndex += 2;

            }

        }
        return score;
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex){
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }



}
