package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
//    private Hero mHero;
    private String mName;
    private String mCause;
    private int mMaxSize;
    private static boolean mHeroExists;
    private static ArrayList<Squad> mInstances = new ArrayList<Squad>();
    private static ArrayList<Hero> mHeroes = new ArrayList<Hero>();

    public Squad(String name, String cause) {
        this.mName = name;
        this.mCause = cause;
        this.mMaxSize = 5;
        mHeroExists = false;
        mInstances.add(this);
    }

    public List<Hero> getHeroes(){
        return mHeroes;
    }

    public void setHeroes(Hero hero){
        mHeroes.add(hero);
    }

    public boolean doesHeroExist(Hero hero){
        int counter = 0;
        for (Hero mHero : mHeroes) {
            if (mHero.getName().equals(hero.getName())) {
                counter++;
            }
        }

        return counter != 1;
    }

    public String getName(){
        return this.mName;
    }

    public String getmCause(){
        return this.mCause;
    }

    public static ArrayList<Squad> getAll(){
        return mInstances;
    }

    public boolean checkForMaximumMembers(){
        return mHeroes.size() <= this.mMaxSize;
    }

    public void setName(String name){
        this.mName = name;
    }

    public void setCause(String cause){
        this.mCause = cause;
    }


}
