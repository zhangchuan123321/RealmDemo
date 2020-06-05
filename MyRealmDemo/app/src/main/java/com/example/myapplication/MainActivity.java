package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private Realm mRealm;
    private Realm.Transaction bgRealm;
    private int Number=0;
    private String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRealm=Realm.getDefaultInstance();


    }
    public void InsertData(View v){
        Number++;
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                WordSunmaryUser wordSunmaryUser=realm.createObject(WordSunmaryUser.class);
                wordSunmaryUser.setWords("名字"+Number);
//                SynpnymList.add("姓名"+Number);
                wordSunmaryUser.setSynonym("姓名"+Number);
                Log.d(TAG,"inser data success");

            }
        });
    }
    public void ModifyData(View v){
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                WordSunmaryUser wordSunmaryUser=realm.where(WordSunmaryUser.class)
                        .equalTo("words","名字2")
                        .findFirst();
                if(wordSunmaryUser!=null){
                    wordSunmaryUser.setWords("张三");
                    Log.d(TAG,"modify data success");
                }
            }
        });
    }
    public void RecarchData(View v){
        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
             long time=   System.currentTimeMillis();
                RealmResults<WordSunmaryUser>  wordSunmaryUser=realm.where(WordSunmaryUser.class)
                        .findAll();
                Log.d(TAG,"查询耗时："+(System.currentTimeMillis()-time)+"ms");
                for(int i=0;i<wordSunmaryUser.size();i++){
                    WordSunmaryUser wordUser=wordSunmaryUser.get(i);
                    Log.d(TAG,"词汇："+wordUser.getWords()+wordUser.getSynonym().toString());
                }
                Log.d(TAG,"查询耗时2："+(System.currentTimeMillis()-time)+"ms");

//                wordSunmaryUser.
//                Iterator iterator=wordSunmaryUser.iterator();
//                while (iterator.hasNext()){
//                    iterator.toString();
//
//                }

            }
        });
    }
    public void DeleteData(View v){

        mRealm.executeTransactionAsync(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {
        final  RealmResults<WordSunmaryUser>  wordSunmaryList=realm.where(WordSunmaryUser.class)
                        .findAll();
                if(wordSunmaryList.size()>0){
                    wordSunmaryList.get(0).deleteFromRealm();
                    Log.d(TAG,"detele data success");
                }
            }
        });
    }

}