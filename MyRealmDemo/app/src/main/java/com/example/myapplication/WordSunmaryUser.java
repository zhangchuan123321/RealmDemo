package com.example.myapplication;

import java.util.List;

import io.realm.RealmObject;

public class WordSunmaryUser extends RealmObject {
    /**
     * id : 1
     * words :
     * synonym : ["",""]
     */

    private int id;
    private String words;
    private String synonym;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }
//    @PrimaryKey
//    private  long id;
//    @Ignore
//    private String eid;
}
