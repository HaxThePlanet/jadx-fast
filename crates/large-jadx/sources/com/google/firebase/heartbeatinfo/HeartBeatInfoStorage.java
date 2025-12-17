package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
class HeartBeatInfoStorage {

    private static final SimpleDateFormat FORMATTER = null;
    private static final String GLOBAL = "fire-global";
    private static final int HEART_BEAT_COUNT_LIMIT = 200;
    private static final String HEART_BEAT_COUNT_TAG = "fire-count";
    private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
    private static final String STORAGE_PREFERENCES_NAME = "FirebaseAppHeartBeatStorage";
    private static com.google.firebase.heartbeatinfo.HeartBeatInfoStorage instance;
    private final SharedPreferences heartBeatSharedPreferences;
    private final SharedPreferences sharedPreferences;
    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy z");
        HeartBeatInfoStorage.FORMATTER = simpleDateFormat;
    }

    private HeartBeatInfoStorage(Context context) {
        super();
        final int i = 0;
        this.sharedPreferences = context.getSharedPreferences("FirebaseAppHeartBeat", i);
        this.heartBeatSharedPreferences = context.getSharedPreferences("FirebaseAppHeartBeatStorage", i);
    }

    HeartBeatInfoStorage(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        super();
        this.sharedPreferences = sharedPreferences;
        this.heartBeatSharedPreferences = sharedPreferences2;
    }

    private void cleanUpStoredHeartBeats() {
        long long;
        Iterator iterator;
        Long valueOf;
        boolean next;
        long l;
        final String str = "fire-count";
        long = this.sharedPreferences.getLong(str, 0);
        ArrayList arrayList = new ArrayList();
        iterator = this.heartBeatSharedPreferences.getAll().entrySet().iterator();
        synchronized (this) {
            try {
                for (Map.Entry next4 : iterator) {
                    arrayList.add(Long.valueOf(Long.parseLong((String)next4.getKey())));
                }
                arrayList.add(Long.valueOf(Long.parseLong((String)(Map.Entry)iterator.next().getKey())));
                Collections.sort(arrayList);
                Iterator iterator2 = arrayList.iterator();
                for (Long next3 : iterator2) {
                    this.heartBeatSharedPreferences.edit().remove(String.valueOf(next3)).apply();
                    long -= l;
                    this.sharedPreferences.edit().putLong("fire-count", long).apply();
                }
                this.heartBeatSharedPreferences.edit().remove(String.valueOf((Long)iterator2.next())).apply();
                long -= l;
                this.sharedPreferences.edit().putLong("fire-count", long).apply();
                if (Long.compare(long, i2) <= 0) {
                } else {
                }
                throw th;
            }
        }
    }

    static com.google.firebase.heartbeatinfo.HeartBeatInfoStorage getInstance(Context context) {
        com.google.firebase.heartbeatinfo.HeartBeatInfoStorage heartBeatInfoStorage;
        final Class<com.google.firebase.heartbeatinfo.HeartBeatInfoStorage> obj = HeartBeatInfoStorage.class;
        synchronized (obj) {
            heartBeatInfoStorage = new HeartBeatInfoStorage(context);
            HeartBeatInfoStorage.instance = heartBeatInfoStorage;
            return HeartBeatInfoStorage.instance;
        }
    }

    static boolean isSameDateUtc(long l, long l2) {
        Date date = new Date(l, l2);
        Date obj1 = new Date(obj3, obj4);
        final SimpleDateFormat obj2 = HeartBeatInfoStorage.FORMATTER;
        return obj1 ^= 1;
    }

    void clearStoredHeartBeats() {
        this.heartBeatSharedPreferences.edit().clear().apply();
        this.sharedPreferences.edit().remove("fire-count").apply();
        return;
        synchronized (this) {
            this.heartBeatSharedPreferences.edit().clear().apply();
            this.sharedPreferences.edit().remove("fire-count").apply();
        }
    }

    int getHeartBeatCount() {
        return (int)long;
    }

    long getLastGlobalHeartBeat() {
        return this.sharedPreferences.getLong("fire-global", -1);
        synchronized (this) {
            return this.sharedPreferences.getLong("fire-global", -1);
        }
    }

    List<com.google.firebase.heartbeatinfo.SdkHeartBeatResult> getStoredHeartBeats(boolean z) {
        com.google.firebase.heartbeatinfo.SdkHeartBeatResult create;
        long long;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.heartBeatSharedPreferences.getAll().entrySet().iterator();
        synchronized (this) {
            try {
                for (Map.Entry next2 : iterator) {
                    arrayList.add(SdkHeartBeatResult.create((String)next2.getValue(), Long.parseLong((String)next2.getKey())));
                }
                Object next2 = iterator.next();
                arrayList.add(SdkHeartBeatResult.create((String)next2.getValue(), Long.parseLong((String)(Map.Entry)next2.getKey())));
                Collections.sort(arrayList);
                if (z != null) {
                }
                clearStoredHeartBeats();
                return arrayList;
                throw z;
            }
        }
    }

    boolean shouldSendGlobalHeartBeat(long l) {
        return shouldSendSdkHeartBeat("fire-global", l);
        synchronized (this) {
            return shouldSendSdkHeartBeat("fire-global", l);
        }
    }

    boolean shouldSendSdkHeartBeat(String string, long l2) {
        final int i = 1;
        synchronized (this) {
            try {
                if (HeartBeatInfoStorage.isSameDateUtc(this.sharedPreferences.getLong(string, -1), obj3) != null) {
                }
                this.sharedPreferences.edit().putLong(string, l2).apply();
                return i;
                return 0;
                this.sharedPreferences.edit().putLong(string, l2).apply();
                return i;
                throw string;
            }
        }
    }

    void storeHeartBeatInformation(String string, long l2) {
        final String str = "fire-count";
        this.heartBeatSharedPreferences.edit().putString(String.valueOf(l2), string).apply();
        long += i3;
        this.sharedPreferences.edit().putLong("fire-count", i).apply();
        synchronized (this) {
            try {
                cleanUpStoredHeartBeats();
                throw string;
            }
        }
    }

    void updateGlobalHeartBeat(long l) {
        this.sharedPreferences.edit().putLong("fire-global", l).apply();
        return;
        synchronized (this) {
            this.sharedPreferences.edit().putLong("fire-global", l).apply();
        }
    }
}
