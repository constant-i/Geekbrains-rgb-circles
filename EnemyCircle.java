package com.hfad.rgbcircles;

import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {
    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 110;
    public static final int ENEMY_COLOR = Color.BLUE;
    public static final int FOOD_COLOR = Color.rgb(0,255,0); // Color.GREEN;
    public static final int RANDOM_SPEED = 10;
    private int dx;
    private int dy;


    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;

    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 1 + random.nextInt(RANDOM_SPEED);
        int dy = 1 + random.nextInt(RANDOM_SPEED);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle enemyCircle = new EnemyCircle(x, y, radius, dx, dy);
        return enemyCircle;
    }

    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (IsSmallerThen(mainCircle)){
            setColor(FOOD_COLOR);
        } else {
            setColor(ENEMY_COLOR);
        }
    }

    private boolean IsSmallerThen(SimpleCircle circle) {
        if (radius < circle.radius) {
            return true;
        }
        return false;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
    }
}
