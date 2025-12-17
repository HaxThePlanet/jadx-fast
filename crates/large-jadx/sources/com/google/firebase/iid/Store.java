package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.a;
import d.e.a;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class Store {

    final Context context;
    final SharedPreferences store;
    private final Map<String, Long> subtypeCreationTimes;

    static class Token {

        private static final long REFRESH_PERIOD_MILLIS;
        final String appVersion;
        final long timestamp;
        final String token;
        static {
            Store.Token.REFRESH_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(7);
        }

        private Token(String string, String string2, long l3) {
            super();
            this.token = string;
            this.appVersion = string2;
            this.timestamp = l3;
        }

        static String encode(String string, String string2, long l3) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", string);
                jSONObject.put("appVersion", string2);
                jSONObject.put("timestamp", l3);
                return jSONObject.toString();
                string = String.valueOf(string);
                string2 = String.valueOf(string);
                string2 = string2.length();
                string2 += 24;
                l3 = new StringBuilder(string2);
                string2 = "Failed to encode token: ";
                l3.append(string2);
                l3.append(string);
                string = l3.toString();
                string2 = "FirebaseInstanceId";
                Log.w(string2, string);
                string = null;
                return string;
            }
        }

        static String getTokenOrNull(com.google.firebase.iid.Store.Token store$Token) {
            if (token == null) {
                return null;
            }
            return token.token;
        }

        static com.google.firebase.iid.Store.Token parse(String string) {
            final int i = 0;
            if (TextUtils.isEmpty(string)) {
                return i;
            }
            if (string.startsWith("{")) {
                JSONObject jSONObject = new JSONObject(string);
                Store.Token obj6 = new Store.Token(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"), obj5);
                return obj6;
            }
            Store.Token token = new Store.Token(string, i, 0, obj3);
            return token;
        }

        boolean needsRefresh(String string) {
            int appVersion;
            boolean obj7;
            if (Long.compare(currentTimeMillis, i) <= 0 && !string.equals(this.appVersion)) {
                if (!string.equals(this.appVersion)) {
                }
                return 0;
            }
            return 1;
        }
    }
    public Store(Context context) {
        super();
        a aVar = new a();
        this.subtypeCreationTimes = aVar;
        this.context = context;
        this.store = context.getSharedPreferences("com.google.android.gms.appid", 0);
        checkForRestore("com.google.android.gms.appid-no-backup");
    }

    private void checkForRestore(String string) {
        boolean newFile;
        File file;
        file = new File(a.j(this.context), "com.google.android.gms.appid-no-backup");
        if (file.exists() != null) {
        }
        if (file.createNewFile() != null && !isEmpty()) {
            if (!isEmpty()) {
                Log.i("FirebaseInstanceId", "App restored, clearing state");
                deleteAll();
            }
        }
    }

    static String createSubtypeInfoKey(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(obj2 += 6);
        stringBuilder.append(string);
        stringBuilder.append("|S|cre");
        return stringBuilder.toString();
    }

    private String createTokenKey(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder(i2 += length3);
        stringBuilder.append(string);
        stringBuilder.append("|T|");
        stringBuilder.append(string2);
        stringBuilder.append("|");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    private long getCreationTimeFromSharedPreferences(String string) {
        String obj3 = this.store.getString(Store.createSubtypeInfoKey(string, "cre"), 0);
        if (obj3 != null) {
            return Long.parseLong(obj3);
        }
        return 0;
    }

    private long writeCreationTimeToSharedPreferences(String string) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = "cre";
        if (!this.store.contains(Store.createSubtypeInfoKey(string, str))) {
            SharedPreferences.Editor edit = this.store.edit();
            edit.putString(Store.createSubtypeInfoKey(string, str), String.valueOf(currentTimeMillis));
            edit.commit();
            return currentTimeMillis;
        }
        return getCreationTimeFromSharedPreferences(string);
    }

    public void deleteAll() {
        this.subtypeCreationTimes.clear();
        this.store.edit().clear().commit();
        return;
        synchronized (this) {
            this.subtypeCreationTimes.clear();
            this.store.edit().clear().commit();
        }
    }

    public void deleteToken(String string, String string2, String string3) {
        SharedPreferences.Editor obj2 = this.store.edit();
        obj2.remove(createTokenKey(string, string2, string3));
        obj2.commit();
        return;
        synchronized (this) {
            obj2 = this.store.edit();
            obj2.remove(createTokenKey(string, string2, string3));
            obj2.commit();
        }
    }

    public long getCreationTime(String string) {
        Object obj = this.subtypeCreationTimes.get(string);
        synchronized (this) {
            try {
                return (Long)obj.longValue();
                return getCreationTimeFromSharedPreferences(string);
                throw string;
            }
        }
    }

    public com.google.firebase.iid.Store.Token getToken(String string, String string2, String string3) {
        return Store.Token.parse(this.store.getString(createTokenKey(string, string2, string3), 0));
        synchronized (this) {
            return Store.Token.parse(this.store.getString(createTokenKey(string, string2, string3), 0));
        }
    }

    public boolean isEmpty() {
        return this.store.getAll().isEmpty();
        synchronized (this) {
            return this.store.getAll().isEmpty();
        }
    }

    public void saveToken(String string, String string2, String string3, String string4, String string5) {
        final String obj6 = Store.Token.encode(string4, string5, System.currentTimeMillis());
        synchronized (this) {
            try {
                SharedPreferences.Editor obj7 = this.store.edit();
                obj7.putString(createTokenKey(string, string2, string3), obj6);
                obj7.commit();
                throw string;
            }
        }
    }

    public long setCreationTime(String string) {
        final long creationTimeToSharedPreferences = writeCreationTimeToSharedPreferences(string);
        this.subtypeCreationTimes.put(string, Long.valueOf(creationTimeToSharedPreferences));
        return creationTimeToSharedPreferences;
        synchronized (this) {
            creationTimeToSharedPreferences = writeCreationTimeToSharedPreferences(string);
            this.subtypeCreationTimes.put(string, Long.valueOf(creationTimeToSharedPreferences));
            return creationTimeToSharedPreferences;
        }
    }
}
