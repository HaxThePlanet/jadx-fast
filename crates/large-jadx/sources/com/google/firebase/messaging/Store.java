package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.a;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class Store {

    final SharedPreferences store;

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
                string = string.toString();
                string2 = "Failed to encode token: ";
                string = string2.concat(string);
                string2 = "FirebaseMessaging";
                Log.w(string2, string);
                string = null;
                return string;
            }
        }

        static com.google.firebase.messaging.Store.Token parse(String string) {
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
        this.store = context.getSharedPreferences("com.google.android.gms.appid", 0);
        checkForRestore(context, "com.google.android.gms.appid-no-backup");
    }

    private void checkForRestore(Context context, String string2) {
        File file;
        boolean obj3;
        file = new File(a.j(context), "com.google.android.gms.appid-no-backup");
        if (file.exists() != null) {
        }
        if (file.createNewFile() != null && !isEmpty()) {
            if (!isEmpty()) {
                Log.i("FirebaseMessaging", "App restored, clearing state");
                deleteAll();
            }
        }
    }

    private String createTokenKey(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(string);
        stringBuilder.append("|T|");
        stringBuilder.append(string2);
        stringBuilder.append("|*");
        return stringBuilder.toString();
    }

    public void deleteAll() {
        this.store.edit().clear().commit();
        return;
        synchronized (this) {
            this.store.edit().clear().commit();
        }
    }

    public void deleteToken(String string, String string2) {
        SharedPreferences.Editor obj2 = this.store.edit();
        obj2.remove(createTokenKey(string, string2));
        obj2.commit();
        return;
        synchronized (this) {
            obj2 = this.store.edit();
            obj2.remove(createTokenKey(string, string2));
            obj2.commit();
        }
    }

    public com.google.firebase.messaging.Store.Token getToken(String string, String string2) {
        return Store.Token.parse(this.store.getString(createTokenKey(string, string2), 0));
        synchronized (this) {
            return Store.Token.parse(this.store.getString(createTokenKey(string, string2), 0));
        }
    }

    public boolean isEmpty() {
        return this.store.getAll().isEmpty();
        synchronized (this) {
            return this.store.getAll().isEmpty();
        }
    }

    public void saveToken(String string, String string2, String string3, String string4) {
        final String obj5 = Store.Token.encode(string3, string4, System.currentTimeMillis());
        synchronized (this) {
            try {
                SharedPreferences.Editor obj6 = this.store.edit();
                obj6.putString(createTokenKey(string, string2), obj5);
                obj6.commit();
                throw string;
            }
        }
    }
}
