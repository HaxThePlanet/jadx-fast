package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public class wl {

    final String a;
    final com.google.android.gms.internal.firebase-auth-api.pm b;
    public wl(String string, com.google.android.gms.internal.firebase-auth-api.pm pm2) {
        super();
        this.a = string;
        this.b = pm2;
    }

    final String a(String string, String string2) {
        final String str = this.a;
        StringBuilder stringBuilder = new StringBuilder(i2 += length3);
        stringBuilder.append(str);
        stringBuilder.append(string);
        stringBuilder.append("?key=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}
