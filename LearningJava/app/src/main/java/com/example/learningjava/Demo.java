package com.example.learningjava;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
//        Enemy enemy = new Enemy("Harshit", 10, 3);
//        enemy.showInfo();
//
//        enemy.takeDamage(3);
//        enemy.takeDamage(3);
//        enemy.takeDamage(3);
//        enemy.takeDamage(3);
//        enemy.showInfo();
//        Troll troll = new Troll("Aryan", 10, 3);
//        troll.showInfo();
        VampyreKing vk = new VampyreKing("Klaus");
        vk.showInfo();
        vk.takeDamage(4);
    }
}