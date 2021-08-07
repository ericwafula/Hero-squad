package models;

import java.util.ArrayList;

public class Squad {
    private Hero mHero;
    private String mName;
    private String mCause;
    private int mMaxSize;
    private static ArrayList<Squad> mInstances = new ArrayList<Squad>();

    public Squad(Hero hero, String name, String cause) {
        this.mHero = hero;
        this.mName = name;
        this.mCause = cause;
        mInstances.add(this);
        this.mMaxSize = 20;
    }

    public Hero getHero(){
        return this.mHero;
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

    public void setHero(Hero hero){
        this.mHero = hero;
    }

    public void setName(String name){
        this.mName = name;
    }

    public void setCause(String cause){
        this.mCause = cause;
    }
}
