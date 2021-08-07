package models;

import java.util.ArrayList;

public class Hero {
    private String mName;
    private int mAge;
    private String mSpecialPower;
    public String mWeakness;

    public static ArrayList<Hero> mInstances = new ArrayList<Hero>();

    public Hero(String name, int age, String specialPower, String weakness) {
        this.mName = name;
        this.mAge = age;
        this.mSpecialPower = specialPower;
        this.mWeakness = weakness;
        mInstances.add(this);
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge = mAge;
    }

    public String getSpecialPower() {
        return mSpecialPower;
    }

    public void setSpecialPower(String mSpecialPower) {
        this.mSpecialPower = mSpecialPower;
    }

    public String getWeakness() {
        return mWeakness;
    }

    public void setWeakness(String mWeakness) {
        this.mWeakness = mWeakness;
    }

    public static ArrayList<Hero> getAll() {
        return mInstances;
    }
}