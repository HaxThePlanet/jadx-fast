package com.googlecode.mp4parser.h;

import android.util.Log;

/* compiled from: AndroidLogger.java */
/* loaded from: classes2.dex */
public class a extends f {

    String a;
    public a(String str) {
        super();
        this.a = str;
    }

    @Override // com.googlecode.mp4parser.h.f
    public void b(String str) {
        String str4 = String.valueOf(this.a);
        StringBuilder stringBuilder = new StringBuilder(str4);
        String str5 = ":";
        str6 = str4 + str5 + str;
        Log.d("isoparser", str6);
    }

    @Override // com.googlecode.mp4parser.h.f
    public void c(String str) {
        String str4 = String.valueOf(this.a);
        StringBuilder stringBuilder = new StringBuilder(str4);
        String str5 = ":";
        str6 = str4 + str5 + str;
        Log.e("isoparser", str6);
    }

    @Override // com.googlecode.mp4parser.h.f
    public void d(String str) {
        String str4 = String.valueOf(this.a);
        StringBuilder stringBuilder = new StringBuilder(str4);
        String str5 = ":";
        str6 = str4 + str5 + str;
        Log.w("isoparser", str6);
    }
}
