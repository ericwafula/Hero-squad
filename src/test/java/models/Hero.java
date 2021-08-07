package models;

public class Hero {
    private String mName;
    private int mAge;
    private String mSpecialPower;
    public String mWeakness;
    public Hero(String name, int age, String specialPower, String weakness) {
        this.mName = name;
        this.mAge = age;
        this.mSpecialPower = specialPower;
        this.mWeakness = weakness;
    }
}
