package models;

import java.util.ArrayList;

public class Squad {
    private Hero mHero;
    private String mName;
    private String mCause;
    private int mMaxSize;
    private ArrayList<Squad> mInstances = new ArrayList<Squad>();

    public Squad(Hero hero, String name, String cause) {
        this.mHero = hero;
        this.mName = name;
        this.mCause = cause;
        mInstances.add(this);
        this.mMaxSize = 20;
    }
}
