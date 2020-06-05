package com.example.myapplication;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
//        RealmConfiguration config=new RealmConfiguration.Builder().build();
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("my_one_realm.realm") //文件名
                .schemaVersion(0) //版本号
                .build();
        Realm.setDefaultConfiguration(config);

    }
}
