package com.example.learningjava;

import java.util.ArrayList;

public class Player {
    private String handleName;
    private int lives;
    private int level;
    private int score;
    private Weapon weapon;
    private ArrayList<Loot> inventry;

    public Player(String handleName, int level) {
        this.handleName = handleName;
        this.level = level;
        this.lives = 3;
        this.score = 0;
        setDefaultWeapon();
        inventry = new ArrayList<>();
    }

    public Player(String handle){
        this(handle, 1);
    }

    public Player(){
        this("UnknownName");
    }

    private void setDefaultWeapon(){
        this.weapon = new Weapon("Sword", 10, 20);
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ArrayList<Loot> getInventry() {
        return inventry;
    }

//    public void setInventry(ArrayList<Loot> inventry) {
//        this.inventry = inventry;
//    }

    public void showInventry(){
        for(Loot items: inventry){
            System.out.println(items.getName());
        }
    }

    public void pickUpLoot(Loot newLoot){
        inventry.add(newLoot);
    }

    public boolean dropLoot(Loot loot){
        if(this.inventry.contains(loot)){
            inventry.remove(loot);
            return true;
        }
        else{
            return false;
        }
    }
}
