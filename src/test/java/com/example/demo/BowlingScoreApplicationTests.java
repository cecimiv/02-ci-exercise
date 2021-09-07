package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BowlingScoreApplicationTests {


    private Game game;

    @BeforeEach
    public void init(){
        game = new Game();

    }

    @Test
    void testGutterBall() {
        int times = 20;
        int pins = 0;
        roll(times, pins);
        Assert.assertEquals(game.score(), 0);
    }

    @Test
    void testStrike(){
        int times = 20;
        int pins = 1;
        roll(times, pins);
        Assert.assertEquals(game.score(), 20);
    }

    @Test
    void testSpare(){
        game.roll(5);
        game.roll(5);
        game.roll(3);
        roll(17, 0);
        Assert.assertEquals(game.score(), 16);

    }

    @Test
    void testOneStrike(){
        game.roll(10);
        game.roll(3);
        game.roll(4);
        roll(16, 0);
        Assert.assertEquals(game.score(), 24);
    }

    private void roll(int times, int pins){
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }

}


