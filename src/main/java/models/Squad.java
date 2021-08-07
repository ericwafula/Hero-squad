package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
//    private Hero mHero;
    private String mName;
    private String mCause;

    private static ArrayList<Squad> mInstances = new ArrayList<Squad>();
    private List<Hero> mHeroes = new ArrayList<Hero>();

    public Squad(String name, String cause) {
        this.mName = name;
        this.mCause = cause;
        mInstances.add(this);
    }

    public List<Hero> getHeroes(){
        return this.mHeroes;
    }

    public void setHeroes(Hero hero){
        this.mHeroes.add(hero);
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

//    public void setHero(Hero hero){
//        this.mHero = hero;
//    }

    public void setName(String name){
        this.mName = name;
    }

    public void setCause(String cause){
        this.mCause = cause;
    }


}
